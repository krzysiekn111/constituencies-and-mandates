public class ConstituenciesAndMandates {
    public static void main(String[] args) {
        Constituency constituency = new Constituency(12);
        ConstituencyResult cr = new ConstituencyResult(constituency);
        cr.putResults();
//        cr.putResults(new Double[] {61.0});
//        cr.printResults();
//        cr.printMandateCost();

        MockElection me = new MockElection();
        me.createConstituencyResults(13,2, new Double[]{44.3,52.1});
        me.createConstituencyResults(9,6);
        me.getConstituencyResults().stream().forEach(ConstituencyResult::printResults);


    }
}
