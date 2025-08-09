
public class Constituency {
    private long id;

    public long getMandatesToTake() {
        return mandatesToTake;
    }

    public void setMandatesToTake(long mandatesToTake) {
        this.mandatesToTake = mandatesToTake;
    }

    private long mandatesToTake;

    public Constituency(long id, long mandatesToTake) {
        this.id = id;
        this.mandatesToTake = mandatesToTake;
    }

}
