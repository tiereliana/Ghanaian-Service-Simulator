import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GhanaServiceSimulator {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java GhanaServiceSimulator <path-to-requests.csv>");
            return;
        }

        // TODO 25: Replace these example values with values from your index-number rules.
        // Index number: 22032091 -> last two digits = 91
        //   last digit (units)      = 1
        //   second last digit (tens)= 9
        // Official rule table (Section 4 of the brief):
        //   normalCapacity     = 5 + last digit            = 5 + 1  = 6
        //   correctionCapacity = 4 + second last digit      = 4 + 9  = 13
        //   urgencyBonus       = last digit modulo 3        = 1 % 3  = 1
        //   minimumServiceSteps= 20 + second last digit      = 20 + 9 = 29  (see report: dataset has 35 admissions, more than the minimum)
        //   traceTableLength   = 10 + (last digit modulo 5) = 10 + 1 = 11  (used for the trace table in the report, not in code)
        int normalCapacity = 6;
        int correctionCapacity = 13;
        int urgencyBonus = 1;

        GhanaServiceCentre centre = new GhanaServiceCentre(normalCapacity, correctionCapacity, urgencyBonus);
        List<Request> requests = loadRequests(args[0]);

        for (Request r : requests) {
            centre.admitRequest(r);
        }

        System.out.println("--- SERVING REQUESTS ---");
        int step = 1;
        while (centre.getRemainingRequestCount() > 0) {
            Request served = centre.serveNextRequest();
            if (served == null) {
                System.out.println("No more requests to serve.");
                break;
            }
            System.out.println("Step " + step + ": served " + served);
            step++;
            // Optional test: call undo at one step and explain it in your report.
            // if (step == 5) centre.undoLastAction(); // Example: undo after step 4
        }

        centre.printReport();
    }

   private static List<Request> loadRequests(String path) throws Exception {

    List<Request> requests = new ArrayList<>();

    System.out.println("Reading file: " + path);

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

        String line = br.readLine(); // Skip header

        while ((line = br.readLine()) != null) {

            
            
            if (!line.trim().isEmpty()) {

                Request r = Request.fromCsv(line);
               
               


                requests.add(r);
            }
        }
    }

    System.out.println("Total requests loaded = " + requests.size());

    return requests;
}
}
