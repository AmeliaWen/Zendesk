import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ZenDeskApp {

    private static final String singleTicket = "https://zccamelia.zendesk.com/api/v2/tickets/";
    private static final String token = "cuiwen423@gmail.com:dwj9-A@G+sxNPDp";

    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                try {
                    System.out.println("Ticket Listing Options\n - 1. Displayall: Display ticket list \n - 2. Display,{ticketid} : Display Ticket information \n - 3. Quit: Exit Application\n - 4. Help");
                    System.out.println("Please enter an option");
                    String line = scanner.nextLine();
                    int a = Integer.parseInt(line);
                    switch (a) {
                        case 1:
                            queryAllTickets();
                            break;
                        case 2:
                            System.out.println("Enter Ticket ID");
                            String tid = scanner.nextLine();
                            queryTicketById(tid);
                            break;
                        case 3:
                            System.out.println("Exit Application");
                            return;
                        default:
                            System.out.println("invalid option. Please enter 1/2/3/4");
                    }
                } catch (Exception e){
                    System.out.println("Exception occurred!");
                }
            }
        } catch (Exception e){
            System.out.println("Exception occurred!");
        }
    }

    private static void parseJson(JSONObject jsonObject){
        while (jsonObject != null){
            boolean hasNext = false, hasPrev = false;
            if ((boolean)((JSONObject)jsonObject.get("meta")).get("has_more")){
                System.out.println("enter NEXT for next page");
                hasNext = true;
            }
            if (((JSONObject)jsonObject.get("links")).get("prev") != null){
                System.out.println("enter PREV for previous page");
                hasPrev = true;
            }
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (hasNext && line.toLowerCase().contains("next")){
                jsonObject = queryTickForEachPage(((JSONObject)jsonObject.get("links")).get("next").toString(), false);
            } else if (hasPrev && line.toLowerCase().contains("prev")) {
                jsonObject = queryTickForEachPage(((JSONObject)jsonObject.get("links")).get("prev").toString(), false);
            } else if (line.toLowerCase().contains("exit")){
                System.out.println("Going back to original console ...");
                return;
            } else {
                System.out.println("Please enter valid character");
            }
        }
    }

    private static void queryTicketById(String tid) {
        if (tid == null) {
            System.out.println("Please enter valid ID");
            return;
        }
        int id = Integer.parseInt(tid);
        String ticket = singleTicket + id+".json";
        String[] commands = {"curl", ticket, "-v", "-u", token};
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
            System.out.println(json);
            JSONObject ticketInfo = (JSONObject) json.get("ticket");
            if (ticketInfo == null){
                System.out.println("NO Ticket Information found!");
                return;
            }
            displayTicket(ticketInfo);
        } catch (IOException e) {
            System.out.println("Unable to query Zendesk API");
        } catch (ParseException e) {
            System.out.println("Unable to parse response from Zendesk");
        }
    }

    private static void displayTicket(JSONObject ticket){
        if (ticket == null) {
            System.out.println("Empty Ticket");
            return;
        }
        // ticket format:
        // subject; created_at; description; type; id; url; priority; recipient; status; is_public
        String[] useful_params = new String[]{"id", "subject", "created_at", "type", "updated_at", "priority", "url", "recipient", "status"};
        StringBuilder result = new StringBuilder("TICKET info: ");
        for (String data : useful_params){
            result.append(data).append(": ");
            result.append(ticket.get(data) == null ? "EMPTY" : ticket.get(data).toString());
            result.append(", ");
        }
        System.out.println(result.toString());
    }

    private static JSONObject queryTickForEachPage(String page, boolean first){
        String[] commands = {"curl", page, "-v", "-u", token};
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
            System.out.println(json);
            if (json == null){
                System.out.println("No response acquired");
                return null;
            }
            // display tickets
            if (json.get("tickets") != null){
                for (Object object : (JSONArray)json.get("tickets")){
                    JSONObject ticket = (JSONObject)object;
                    if (ticket != null){
                        displayTicket(ticket);
                    }
                }
            }
            if (first){
                parseJson(json);
            }
            return json;
        } catch (IOException e) {
            System.out.println("Unable to query Zendesk API");
        } catch (ParseException e) {
            System.out.println("Unable to parse response from Zendesk");
        }
        return null;
    }

    private static void queryAllTickets() {
        String query = singleTicket + "?page[size]=25";
        queryTickForEachPage(query, true);
    }
}