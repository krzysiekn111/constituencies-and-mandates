import java.util.Arrays;

public class PartyResult {
    private Party party;
    private Double result = 0.0;
    private Double finalResult = 0.0;
    private Integer mandates = 0;

    private double[][] costOfMandate;

    public PartyResult(Party party) {
        this.party = party;
    }


    public Double getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(Double finalResult) {
        this.finalResult = finalResult;
    }


    public Integer getMandates() {
        return mandates;
    }

    public void setMandates(Integer mandates) {
        this.mandates = mandates;
    }

    public Double getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result = result;
    }

    public void increaseMandates() {
        this.mandates++;
    }

    public PartyResult trimResult() {
        this.result = Double.valueOf(String.valueOf(result).concat("000").substring(0,4));
        this.finalResult = Double.valueOf(String.valueOf(finalResult).concat("000").substring(0,4));
        return this;
    }

    private void calculateCostOfMandate() {
        // the cost is defined as a munber of votes (percent) which is left after Nth mandate is given
        costOfMandate = new double[mandates][1];
        for (int i = 0; i < mandates; i++) {
            this.costOfMandate[i][0]= Double.parseDouble((result/(i+2)+"0").substring(0,3));
        }
    }

    public void showMandateCost() { /** make it so input of true/false values determine the
        presence or absence of data */
        calculateCostOfMandate();
        System.out.println("Party: "+party+ ". "+ "Mandates: " +mandates+ ". result: " + result + ". cost: "
                + Arrays.deepToString(costOfMandate) + "\n Average mandate cost: " + String.valueOf(result/mandates+"00").substring(0,4));
    }


    @Override
    public String toString() {
        return "PartyResult{" +
                "party=" + party +
                ", result=" + result +
                ", finalResult=" + finalResult +
                ", mandates=" + mandates +
                '}';
    }
}
