import java.util.ArrayList;
import java.util.List;

public class MockElection {
    private List<ConstituencyResult> constituencyResults = new ArrayList<>();
    private Double [] results;


    public void createConstituencyResults(long mandatesToTake, long quantityOfConstituencies) {
        for (int i = 0; i < quantityOfConstituencies; i++) {
            Constituency c = new Constituency(mandatesToTake);
            ConstituencyResult cr = new ConstituencyResult(c);
            cr.putResults();
            constituencyResults.add(cr);
        }
    }
    public void createConstituencyResults(long mandatesToTake, long quantityOfConstituencies, Double [] results) {
        this.results = results;
        for (int i = 0; i < quantityOfConstituencies; i++) {
            Constituency c = new Constituency(mandatesToTake);
            ConstituencyResult cr = new ConstituencyResult(c);
            cr.putResults(results);
            constituencyResults.add(cr);
        }
    }

    public List<ConstituencyResult> getConstituencyResults() {
        return constituencyResults;
    }

    public String getMetaData(boolean averageSupport) {
        StringBuilder data = new StringBuilder();
        Long mandatesToTake = getMandatesToTake();
        if (averageSupport) {
            for (Double result : results) {
                double averageSupportNeededForAMandate = getAverageSupportNeededForAMandate(result);
                Long totalMandates = getTotalMandatesTaken(result);
                data.append("for support of value: " + result + "\n");
                data.append("and for the number of mandates = " +  mandatesToTake+ "\n");
                try {
                    data.append(
                            String.valueOf(
                                    averageSupportNeededForAMandate/totalMandates+"00"
                            ).substring(0,4)
                    );
                    data.append(" is needed to get one mandate on average");
                } catch (StringIndexOutOfBoundsException e) {
                    data.append("The support of " + result + " is to low to get even 1 mandate");
                }

                data.append("\n\n");
            }
        }
        return data.toString();

    }

    private double getAverageSupportNeededForAMandate(Double result) {
        return constituencyResults.stream().mapToDouble(
                a -> a.getList().stream().filter(b -> result.equals(b.getResult())).mapToDouble(b -> b.getResult()).sum()).sum();
    }

    private Long getTotalMandatesTaken(Double result) {
        return constituencyResults.stream().mapToLong(
                a->a.getList().stream().filter(c->result.equals(c.getResult())).mapToLong(b -> b.getMandates()).sum()).sum();
    }

    private Long getMandatesToTake() {
        return constituencyResults.stream().mapToLong(a->a.getConstituency().getMandatesToTake()).findAny().getAsLong();
    }
}
