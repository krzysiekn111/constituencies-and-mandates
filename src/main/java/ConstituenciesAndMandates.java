public class ConstituenciesAndMandates {
    public static void main(String[] args) {
        Constituency constituency = new Constituency(12);
        ConstituencyResult cr = new ConstituencyResult(constituency);
        cr.putResults();
//        cr.putResults(new Double[] {61.0});
//        cr.printResults();
//        cr.printMandateCost();

        MockElection me = new MockElection();
        me.createConstituencyResults(9,2, new Double[]{60.0});
//        me.getConstituencyResults().stream().forEach(ConstituencyResult::printResults);
        System.out.println(me.getMetaData(true));

    }
}
