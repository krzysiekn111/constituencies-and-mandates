import java.util.ArrayList;
import java.util.List;

public class MockElection {
    private List<ConstituencyResult> constituencyResults = new ArrayList<>();


    public void createConstituencyResults(long mandatesToTake, long quantityOfConstituencies) {
        for (int i = 0; i < quantityOfConstituencies; i++) {
            Constituency c = new Constituency(mandatesToTake);
            ConstituencyResult cr = new ConstituencyResult(c);
            cr.putResults();
            constituencyResults.add(cr);
        }
    }
    public void createConstituencyResults(long mandatesToTake, long quantityOfConstituencies, Double [] results) {
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
        double averageSupportNeededForAMandate = 0.0;
        averageSupportNeededForAMandate = constituencyResults.stream().mapToDouble(
                a -> a.getList().stream().mapToDouble(b -> b.getResult()).sum()).sum();
        Integer totalMandates = constituencyResults.stream().mapToInt(
                a->a.getList().stream().mapToInt(v->v.getMandates()).sum()).sum();
        Double typedInSupport = constituencyResults.stream().mapToDouble(a->a.getList().get(0).getResult()).average().getAsDouble();
        Long mandatesToTake = constituencyResults.stream().mapToLong(a->a.getConstituency().getMandatesToTake()).findAny().getAsLong();
        if (averageSupport) {
            data.append("for support of value: " + typedInSupport + "\n");
            data.append("and for the number of mandates = " +  mandatesToTake+ "\n");
            data.append(String.valueOf(averageSupportNeededForAMandate/totalMandates).substring(0,5));
            data.append(" is needed to get one mandate on average");
        }
        return data.toString();

    }
}
