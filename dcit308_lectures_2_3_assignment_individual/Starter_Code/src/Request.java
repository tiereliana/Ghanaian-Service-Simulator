public class Request {
    public final String requestId;
    public final int arrivalOrder;
    public final String location;
    public final String serviceType;
    public final int urgencyLevel;       // 1 = low, 5 = very urgent
    public final int estimatedMinutes;
    public final boolean needsCorrection;
    public final String notes;

    public Request(String requestId, int arrivalOrder, String location, String serviceType,
                   int urgencyLevel, int estimatedMinutes, boolean needsCorrection, String notes) {
        this.requestId = requestId;
        this.arrivalOrder = arrivalOrder;
        this.location = location;
        this.serviceType = serviceType;
        this.urgencyLevel = urgencyLevel;
        this.estimatedMinutes = estimatedMinutes;
        this.needsCorrection = needsCorrection;
        this.notes = notes;
    }

    public static Request fromCsv(String line) {
        String[] p = line.split(",", -1);
        return new Request(
                p[0].trim(),
                Integer.parseInt(p[1].trim()),
                p[2].trim(),
                p[3].trim(),
                Integer.parseInt(p[4].trim()),
                Integer.parseInt(p[5].trim()),
                Boolean.parseBoolean(p[6].trim()),
                p.length > 7 ? p[7].trim() : ""
        );
    }

    @Override
    public String toString() {
        return requestId + "[" + serviceType + ", U=" + urgencyLevel + ", T=" + estimatedMinutes + "]";
    }
}
