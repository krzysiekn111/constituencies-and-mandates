
public class Constituency {
    private long mandatesToTake;
    private long id;


    public long getMandatesToTake() {
        return mandatesToTake;
    }

    public void setMandatesToTake(long mandatesToTake) {
        this.mandatesToTake = mandatesToTake;
    }

    public Constituency(long mandatesToTake, long id) {
        this.id = id;
        this.mandatesToTake = mandatesToTake;
    }
    public Constituency(long mandatesToTake) {
        this.mandatesToTake = mandatesToTake;
    }

}
