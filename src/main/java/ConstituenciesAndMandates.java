public class ConstituenciesAndMandates {
    public static void main(String[] args) {
        Constituency constituency = new Constituency(12);
        ConstituencyResult cr = new ConstituencyResult(constituency);
        cr.putResults();
//        cr.putResults(new Double[] {61.0});
//        cr.printResults();
//        cr.printMandateCost();

//        MockElection me = new MockElection();
//        me.createConstituencyResults(12,20, new Double[]{40.0});
//        System.out.println(me.getMetaData(true));
//        MockElection me1 = new MockElection();
//        me1.createConstituencyResults(12,20, new Double[]{50.0});
//        System.out.println(me1.getMetaData(true));

        for (int i = 0; i < 30; i++) {
            MockElection me = new MockElection();
            me.createConstituencyResults(12,20, new Double[]{(double) (38 - (1 * i))});
            System.out.println(me.getMetaData(true));
        }

    }
}
