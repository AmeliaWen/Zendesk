import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ZenDeskApp {




    public static void main(String[] args) throws IOException, ParseException {
        // curl https://{subdomain}.zendesk.com/api/v2/requests/search.json?query={search_string} \
        //  -v -u {email_address}/token:{api_token}
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                try {
                    System.out.println("Ticket Listing Options\n - 1. Displayall: Display ticket list \n - 2. Display,{ticketid} : Display Ticket information \n - 3. Quit: Exit Application\n - 4. Help");
                    System.out.println("Please enter an option");
                    String line = scanner.nextLine();
                    int a = Integer.valueOf(line);
                    //invalid option
                    if (a <= 0 || a > 4) {
                        System.out.println("invalid option. Please enter 1/2/3/4");
                        continue;
                    }
                    if (a == 1){
                        queryAllTickets();
                    }
                    else if (a == 2){
                        System.out.println("Enter Ticket  ID");
                        String tid = scanner.nextLine();
                        queryTicketById(tid);
                    }
                    else if (a == 3){
                        System.out.println("Exit Application");
                        break;
                    }
                    else {
                        System.out.println("- 1. Displayall: Display ticket list \n - 2. Display,{ticketid} : Display Ticket information \n - 3. Quit: Exit Application\n - 4. Help");
                        continue;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    private static void parseJson(JSONObject jsonObject){
        // ticket format:
        // subject; created_at; description; type; id; url; priority; recipient; status; is_public
        if (jsonObject.get("next_page") != null){
            String nextPage = (String) jsonObject.get("next_page");
            if (nextPage == null){

            }
        }

    }

    private static void queryTicketById(String tid) {

    }

    private static void queryAllTickets() {
        String[] commands = {"curl", "https://zccamelia.zendesk.com/api/v2/tickets.json", "-v", "-u", "cuiwen423@gmail.com:dwj9-A@G+sxNPDp"};
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commands);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            String response = "";
            while ((line = reader.readLine()) != null) {
                response += (line+"\n");
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            if (json == null){
                System.out.println("No response acquired");
                return;
            }
        } catch (IOException e) {
            System.out.println("Unable to query Zendesk API");
        } catch (ParseException e) {
            System.out.println("Unable to parse response from Zendesk");
        }
    }

}