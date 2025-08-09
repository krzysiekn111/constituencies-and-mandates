import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConstituencyResult {
    private Constituency constituency;
    private double votesToTake = 100;
    private List<PartyResult> list = new ArrayList<>();
    private Random random = new Random();


    public ConstituencyResult(Constituency constituency) {
        this.constituency = constituency;
    }


    void fillPartyList() {
        list.add(new PartyResult(Party.AA));
        list.add(new PartyResult(Party.BB));
        list.add(new PartyResult(Party.CC));
        list.add(new PartyResult(Party.DD));
        list.add(new PartyResult(Party.EE));
        list.add(new PartyResult(Party.FF));
    }

    void putResults(Double [] results) {
        for (int i = 0; i < 6; i++) { // the method sets support starting from 'AA' to 'BB' and so on
            if (results.length>i) {
                list.get(i).setResult(results[i]);
                list.get(i).setFinalResult(results[i]);
                votesToTake-=results[i];

            } else {
                Double randomResult = randomResult();
                list.get(i).setResult(randomResult);
                list.get(i).setFinalResult(randomResult);
            }
        }
    }

    void putResults() {
        for (int i = 0; i < 6; i++) {
            Double randomResult = randomResult();
            list.get(i).setResult(randomResult);
            list.get(i).setFinalResult(randomResult);
        }
    }
    void delegateMandates() {
        long mandatesToTake = constituency.getMandatesToTake();
        while (mandatesToTake>0) {
            sortPartyList();
            list.get(0).increaseMandates();
            list.get(0).setFinalResult(
                    list.get(0).getResult()/(1+list.get(0).getMandates()));
            mandatesToTake--;
        }
    }

    private double randomResult() {
        double votes = Double.parseDouble(String.valueOf(random.nextDouble(votesToTake/4,votesToTake/1.5))
                .concat("000").substring(0,3)); // I don't want variable 'votes' value to be like 10+ digits long
        votesToTake -= votes;
        return votes;
    }
    void printResults() {
        finalSortPartyList();
        list.stream().forEach(PartyResult::trimResult);
        list.stream().forEach(System.out::println);
    }

    /**
     * sortPartyList() is intended for method delegeteMandates()
     * to indicate white committee has largest support after last
     * turn of delegating mandates
     */
    private void sortPartyList() {
        list = list.stream().sorted(
                (o2, o1)-> o1.getFinalResult().compareTo(o2.getFinalResult())
        ).collect(Collectors.toList());
    }

    /**
     * finalSortPartyList() is intended to sort the list
     * for the purpose of printing them.
     */
    private void finalSortPartyList() {
        list = list.stream().sorted(
                (o2, o1)-> o1.getResult().compareTo(o2.getResult())
        ).collect(Collectors.toList());
    }
    public void printMandateCost() {
        list.stream().forEach(PartyResult::showMandateCost);
    }

}
