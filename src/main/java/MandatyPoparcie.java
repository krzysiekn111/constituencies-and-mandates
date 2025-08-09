public class MandatyPoparcie {
    public static void main(String[] args) {
        Constituency constituency = new Constituency(0, 12);
        ConstituencyResult cr = new ConstituencyResult(constituency);
        cr.fillPartyList();
        cr.putResults();
//        cr.putRandomResults(new Double[] {61.0});
        cr.delegateMandates();
//        cr.printResults();
        cr.printMandateCost();


    }
}
