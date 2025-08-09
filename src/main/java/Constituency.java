
public class Constituency {
    private long id;
    private long mandatesToTake;


    public long getMandatesToTake() {
        return mandatesToTake;
    }

    public void setMandatesToTake(long mandatesToTake) {
        this.mandatesToTake = mandatesToTake;
    }

    public Constituency(long id, long mandatesToTake) {
        this.id = id;
        this.mandatesToTake = mandatesToTake;
    }

}
