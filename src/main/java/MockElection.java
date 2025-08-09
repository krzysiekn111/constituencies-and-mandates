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
}
