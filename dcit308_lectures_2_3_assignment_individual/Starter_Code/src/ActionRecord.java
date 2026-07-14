public class ActionRecord {
    public final String actionType; // ADMIT_NORMAL, ADMIT_URGENT, ADMIT_CORRECTION, SERVE
    public final Request request;

    public ActionRecord(String actionType, Request request) {
        this.actionType = actionType;
        this.request = request;
    }

    @Override
    public String toString() {
        return actionType + " -> " + request;
    }
}
