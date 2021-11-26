import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.*;

public class ZendeskAppTest {

    // Zendesk api
    private static final String singleTicket = "https://zccamelia.zendesk.com/api/v2/tickets/";

    /**
     * create one test ticket (for query one ticket info)
     * @return
     */
    public JSONObject createTestTicket(){
        String stringToParse = "{\n" +
                "  \"ticket\": {\n" +
                "    \"assignee_id\": 235323,\n" +
                "    \"collaborator_ids\": [\n" +
                "      35334,\n" +
                "      234\n" +
                "    ],\n" +
                "    \"created_at\": \"2009-07-20T22:55:29Z\",\n" +
                "    \"custom_fields\": [\n" +
                "      {\n" +
                "        \"id\": 27642,\n" +
                "        \"value\": \"745\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 27648,\n" +
                "        \"value\": \"yes\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"description\": \"The fire is very colorful.\",\n" +
                "    \"due_at\": null,\n" +
                "    \"external_id\": \"ahg35h3jh\",\n" +
                "    \"follower_ids\": [\n" +
                "      35334,\n" +
                "      234\n" +
                "    ],\n" +
                "    \"group_id\": 98738,\n" +
                "    \"has_incidents\": false,\n" +
                "    \"id\": 35436,\n" +
                "    \"organization_id\": 509974,\n" +
                "    \"priority\": \"high\",\n" +
                "    \"problem_id\": 9873764,\n" +
                "    \"raw_subject\": \"{{dc.printer_on_fire}}\",\n" +
                "    \"recipient\": \"support@company.com\",\n" +
                "    \"requester_id\": 20978392,\n" +
                "    \"satisfaction_rating\": {\n" +
                "      \"comment\": \"Great support!\",\n" +
                "      \"id\": 1234,\n" +
                "      \"score\": \"good\"\n" +
                "    },\n" +
                "    \"sharing_agreement_ids\": [\n" +
                "      84432\n" +
                "    ],\n" +
                "    \"status\": \"open\",\n" +
                "    \"subject\": \"Help, my printer is on fire!\",\n" +
                "    \"submitter_id\": 76872,\n" +
                "    \"tags\": [\n" +
                "      \"enterprise\",\n" +
                "      \"other_tag\"\n" +
                "    ],\n" +
                "    \"type\": \"incident\",\n" +
                "    \"updated_at\": \"2011-05-05T10:38:52Z\",\n" +
                "    \"url\": \"https://company.zendesk.com/api/v2/tickets/35436.json\",\n" +
                "    \"via\": {\n" +
                "      \"channel\": \"web\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(stringToParse);
            System.out.println(json);
            return json;
        } catch (ParseException e) {
            System.out.println("Wrong test case");
            return null;
        }
    }

    /**
     * create lists of tickets for testing purpose
     * @return
     */
    public JSONObject createTickets(){
        String stringToParse = "{\n" +
                "   \"tickets\":[\n" +
                "      {\n" +
                "         \"subject\":\"Sample ticket: Meet the ticket\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T20:42:29Z\",\n" +
                "         \"description\":\"Hi there,\\n\\nI\\u2019m sending an email because I\\u2019m having a problem setting up your new product. Can you help me troubleshoot?\\n\\nThanks,\\n The Customer\\n\\n\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":\"incident\",\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"sample_ticket\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T20:42:29Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":1,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"Sample ticket: Meet the ticket\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":\"normal\",\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/1.json\",\n" +
                "         \"tags\":[\n" +
                "            \"sample\",\n" +
                "            \"support\",\n" +
                "            \"zendesk\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":null,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1524137135722\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"velit eiusmod reprehenderit officia cupidatat\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:42Z\",\n" +
                "         \"description\":\"Aute ex sunt culpa ex ea esse sint cupidatat aliqua ex consequat sit reprehenderit. Velit labore proident quis culpa ad duis adipisicing laboris voluptate velit incididunt minim consequat nulla. Laboris adipisicing reprehenderit minim tempor officia ullamco occaecat ut laborum.\\n\\nAliquip velit adipisicing exercitation irure aliqua qui. Commodo eu laborum cillum nostrud eu. Mollit duis qui non ea deserunt est est et officia ut excepteur Lorem pariatur deserunt.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:42Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":2,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"velit eiusmod reprehenderit officia cupidatat\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/2.json\",\n" +
                "         \"tags\":[\n" +
                "            \"est\",\n" +
                "            \"incididunt\",\n" +
                "            \"nisi\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"excepteur laborum ex occaecat Lorem\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:42Z\",\n" +
                "         \"description\":\"Exercitation amet in laborum minim. Nulla et veniam laboris dolore fugiat aliqua et sit mollit. Dolor proident nulla mollit culpa in officia pariatur officia magna eu commodo duis.\\n\\nAliqua reprehenderit aute qui voluptate dolor deserunt enim aute tempor ad dolor fugiat. Mollit aliquip elit aliqua eiusmod. Ex et anim non exercitation consequat elit dolore excepteur. Aliqua reprehenderit non culpa sit consequat cupidatat elit.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:42Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":3,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"excepteur laborum ex occaecat Lorem\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/3.json\",\n" +
                "         \"tags\":[\n" +
                "            \"amet\",\n" +
                "            \"labore\",\n" +
                "            \"voluptate\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"ad sunt qui aute ullamco\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:43Z\",\n" +
                "         \"description\":\"Sunt incididunt officia proident elit anim ullamco reprehenderit ut. Aliqua sint amet aliquip cillum minim magna consequat excepteur fugiat exercitation est exercitation. Adipisicing occaecat nisi aliqua exercitation.\\n\\nAute Lorem aute tempor sunt mollit dolor in consequat non cillum irure reprehenderit. Nulla deserunt qui aliquip officia duis incididunt et est velit nulla irure in fugiat in. Deserunt proident est in dolore culpa mollit exercitation ea anim consequat incididunt. Mollit et occaecat ullamco ut id incididunt laboris occaecat qui.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:43Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":4,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"ad sunt qui aute ullamco\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/4.json\",\n" +
                "         \"tags\":[\n" +
                "            \"laborum\",\n" +
                "            \"mollit\",\n" +
                "            \"proident\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"aliquip mollit quis laborum incididunt\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:43Z\",\n" +
                "         \"description\":\"Pariatur voluptate laborum voluptate sunt ad magna exercitation nulla. In in Lorem minim dolor laboris reprehenderit ad Lorem. Cupidatat laborum qui mollit nostrud magna ullamco. Tempor nisi ex ipsum fugiat dolor proident qui consectetur anim sunt. Dolore consectetur in ex esse et aliqua fugiat enim Lorem ea Lorem incididunt. Non amet elit pariatur commodo labore officia esse anim. In do mollit commodo nulla ullamco culpa cillum incididunt.\\n\\nEt nostrud aute fugiat voluptate tempor ad labore in elit et sunt. Enim quis nulla eu ut sit. Pariatur irure officia occaecat non dolor est excepteur anim incididunt commodo ea cupidatat minim excepteur. Cillum proident tempor laborum amet est ipsum ipsum aliqua sit sunt reprehenderit fugiat aliqua ea.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:43Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":5,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"aliquip mollit quis laborum incididunt\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/5.json\",\n" +
                "         \"tags\":[\n" +
                "            \"consectetur\",\n" +
                "            \"mollit\",\n" +
                "            \"sit\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"nisi aliquip ipsum nostrud amet\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:44Z\",\n" +
                "         \"description\":\"Aute Lorem fugiat ad consectetur sint fugiat. Et qui ipsum in qui nostrud nulla qui et occaecat culpa ad occaecat. Aute mollit occaecat mollit proident nostrud non ea laboris adipisicing deserunt officia. Eiusmod sint fugiat veniam consectetur consequat exercitation esse est.\\n\\nVelit est ipsum labore aliquip quis mollit laborum in. Consectetur cillum proident ullamco exercitation pariatur. Incididunt consectetur tempor adipisicing esse minim mollit Lorem.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:44Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":6,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"nisi aliquip ipsum nostrud amet\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/6.json\",\n" +
                "         \"tags\":[\n" +
                "            \"cillum\",\n" +
                "            \"et\",\n" +
                "            \"occaecat\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"cillum quis nostrud labore amet\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:44Z\",\n" +
                "         \"description\":\"Deserunt officia ea fugiat dolor eu laboris esse reprehenderit deserunt dolore voluptate amet culpa. Proident ut mollit adipisicing occaecat Lorem do ut ex aute laboris fugiat minim dolor. In anim non nostrud adipisicing aliquip nisi laborum cupidatat officia. Sunt cillum sint anim elit culpa commodo amet excepteur consectetur veniam nulla ut. Officia ut ut sit incididunt cupidatat velit proident cupidatat voluptate eu ex.\\n\\nVelit nisi voluptate nulla reprehenderit officia consectetur dolor nostrud cillum duis. Dolore cupidatat eu veniam ut fugiat mollit ea. Reprehenderit nulla nisi cillum voluptate ex. Occaecat incididunt id mollit deserunt occaecat adipisicing ullamco ipsum. Minim ullamco adipisicing quis aliquip est ex sunt ea quis. Sint aute occaecat velit ipsum enim qui fugiat esse in officia excepteur irure. Enim eu dolore reprehenderit exercitation ullamco est nulla voluptate consectetur aliqua sit.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:44Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":7,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"cillum quis nostrud labore amet\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/7.json\",\n" +
                "         \"tags\":[\n" +
                "            \"ad\",\n" +
                "            \"et\",\n" +
                "            \"lorem\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"proident est nisi non irure\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:45Z\",\n" +
                "         \"description\":\"Aute mollit ex nulla id culpa nisi enim amet enim duis laborum in. Eiusmod ea quis tempor voluptate deserunt tempor amet fugiat esse ea. Anim sunt nisi laboris dolor. Est ullamco voluptate dolor magna elit eu. Laboris reprehenderit irure occaecat excepteur.\\n\\nDo nisi commodo dolor eiusmod eiusmod non eu occaecat sunt incididunt irure consectetur do. Exercitation occaecat culpa voluptate exercitation sit. In aute eu nulla anim reprehenderit velit. Eu deserunt aliquip aute Lorem consectetur mollit non esse veniam irure excepteur cupidatat excepteur officia. Velit id et mollit cupidatat cillum elit dolor fugiat pariatur. Deserunt non eu consectetur duis ex consectetur duis eu proident.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:45Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":8,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"proident est nisi non irure\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/8.json\",\n" +
                "         \"tags\":[\n" +
                "            \"aute\",\n" +
                "            \"consectetur\",\n" +
                "            \"sit\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"veniam ea eu minim aute\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:45Z\",\n" +
                "         \"description\":\"Ex non officia in ullamco veniam fugiat cupidatat id aute. Quis minim et quis laborum excepteur. Non officia quis tempor quis nisi et. Aliqua tempor voluptate nulla esse sint. Id nulla consequat sint eiusmod nisi.\\n\\nCupidatat anim magna qui aliquip. Anim deserunt sint incididunt labore aliquip. Reprehenderit magna deserunt reprehenderit irure Lorem nulla est officia cupidatat in. Dolore ullamco veniam proident consectetur amet ad nulla amet commodo enim occaecat. Sint fugiat dolor aliqua proident. Ex enim eu pariatur qui officia cupidatat adipisicing esse qui fugiat. Do mollit quis cillum quis qui occaecat labore.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:45Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":9,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"veniam ea eu minim aute\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/9.json\",\n" +
                "         \"tags\":[\n" +
                "            \"ad\",\n" +
                "            \"aute\",\n" +
                "            \"et\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"magna reprehenderit nisi est cillum\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:46Z\",\n" +
                "         \"description\":\"Sit sit consequat magna aliquip officia qui. Fugiat amet id dolor sint exercitation sit. Eiusmod ex eiusmod voluptate voluptate est amet non culpa minim enim minim. Eiusmod fugiat veniam duis eiusmod sint laborum ex amet occaecat.\\n\\nNostrud consequat officia tempor amet eu. Non adipisicing dolore amet minim id consequat labore irure in esse et aliqua pariatur. Aliquip aliqua id ipsum amet laboris exercitation sunt cillum est et est. Tempor amet qui do dolore fugiat ad id nulla ullamco dolore tempor irure deserunt magna. Ipsum voluptate aliquip ut ad in pariatur adipisicing occaecat ea excepteur Lorem enim exercitation. Lorem sunt officia voluptate pariatur labore esse nostrud ullamco irure sit. Voluptate exercitation do aliquip eu consectetur.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:46Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":10,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"magna reprehenderit nisi est cillum\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/10.json\",\n" +
                "         \"tags\":[\n" +
                "            \"aliquip\",\n" +
                "            \"magna\",\n" +
                "            \"non\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"quis veniam ad sunt non\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:47Z\",\n" +
                "         \"description\":\"Magna culpa velit duis nisi sint veniam nisi adipisicing aute. Eiusmod id cupidatat pariatur tempor esse do. Aliquip ipsum voluptate eiusmod mollit. Et ullamco consectetur tempor cillum sunt anim enim cillum reprehenderit cillum proident. Eu aliqua excepteur eiusmod non ullamco aliqua esse laboris ad commodo reprehenderit pariatur consequat est.\\n\\nVoluptate eiusmod officia culpa nulla culpa mollit reprehenderit cillum adipisicing sit consectetur in. Anim occaecat excepteur commodo officia aute voluptate excepteur do ut esse occaecat duis consequat. Sunt minim est in non exercitation ad minim ullamco dolore in enim mollit aliquip. Ut ex dolore proident Lorem ut dolor ex. Laboris elit in in mollit. Quis id minim ex ad qui velit.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:47Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":11,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"quis veniam ad sunt non\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/11.json\",\n" +
                "         \"tags\":[\n" +
                "            \"aliquip\",\n" +
                "            \"consequat\",\n" +
                "            \"magna\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"tempor aliquip sint dolore incididunt\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:47Z\",\n" +
                "         \"description\":\"Amet sint ea minim excepteur amet. Eiusmod duis ad ea ad aliquip occaecat ea voluptate sunt cillum duis aute. Esse in duis tempor et. Est duis nulla irure ullamco amet sit esse Lorem eu aliqua ullamco sunt. In sint dolore id eu ea.\\n\\nIrure proident nulla deserunt officia laboris culpa. Qui est adipisicing elit tempor cupidatat minim laborum ea est nostrud nulla mollit id dolore. Aute amet amet deserunt incididunt magna ipsum exercitation nostrud incididunt ea qui anim. Adipisicing irure commodo consectetur Lorem ad excepteur nulla eiusmod aliquip irure occaecat. Id sint fugiat proident Lorem est minim ea sint irure. Veniam sint ex minim duis est.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:47Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":12,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"tempor aliquip sint dolore incididunt\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/12.json\",\n" +
                "         \"tags\":[\n" +
                "            \"ad\",\n" +
                "            \"minim\",\n" +
                "            \"non\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"labore pariatur ut laboris laboris\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:48Z\",\n" +
                "         \"description\":\"Quis veniam consectetur ullamco aute incididunt eiusmod ut consectetur sunt laboris sint officia labore. Incididunt sit elit ipsum esse excepteur veniam Lorem excepteur amet amet tempor officia. Magna reprehenderit voluptate elit adipisicing consectetur laboris eu nisi ad excepteur adipisicing non duis proident.\\n\\nAliqua sunt ea dolor dolor elit occaecat. Aliqua reprehenderit commodo minim eu exercitation incididunt consectetur. Eiusmod anim ad adipisicing et ullamco id incididunt.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:48Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":13,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"labore pariatur ut laboris laboris\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/13.json\",\n" +
                "         \"tags\":[\n" +
                "            \"culpa\",\n" +
                "            \"dolor\",\n" +
                "            \"eiusmod\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"officia mollit aliqua eu nostrud\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:48Z\",\n" +
                "         \"description\":\"Fugiat magna dolor ipsum dolor ex qui commodo deserunt veniam aliqua qui ex. Consequat est duis velit eu id labore id dolor sint laboris. Minim nisi sint aliquip nisi cillum magna deserunt non cupidatat est. Exercitation ea pariatur ipsum non pariatur dolor velit laboris dolore irure reprehenderit ut.\\n\\nAmet et officia eiusmod adipisicing. Amet ut ut tempor cillum aliqua elit mollit mollit. Exercitation commodo culpa adipisicing aute voluptate consectetur ut est ea quis aliquip duis excepteur. Anim quis quis occaecat fugiat occaecat. Non et deserunt anim eu anim non laborum ex tempor. Tempor aute reprehenderit minim consequat elit minim. Aliqua in laboris culpa excepteur qui enim excepteur cillum commodo eiusmod eu enim do ullamco.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:48Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":14,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"officia mollit aliqua eu nostrud\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/14.json\",\n" +
                "         \"tags\":[\n" +
                "            \"cillum\",\n" +
                "            \"fugiat\",\n" +
                "            \"irure\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"do incididunt incididunt quis anim\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:49Z\",\n" +
                "         \"description\":\"Lorem sit mollit qui ad culpa do commodo ipsum. Labore elit cillum irure mollit est est cupidatat consectetur commodo laborum qui cupidatat. Ullamco minim veniam est laboris aliquip consectetur voluptate.\\n\\nSunt anim aute culpa mollit culpa veniam eiusmod sunt proident. Ea pariatur esse occaecat aute exercitation quis ut quis ullamco nisi exercitation non commodo. Voluptate mollit consequat velit veniam eiusmod culpa proident occaecat. Labore exercitation enim culpa eu labore proident exercitation ex culpa Lorem deserunt nulla nostrud.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:49Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":15,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"do incididunt incididunt quis anim\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/15.json\",\n" +
                "         \"tags\":[\n" +
                "            \"exercitation\",\n" +
                "            \"officia\",\n" +
                "            \"veniam\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"tempor magna anim ea id\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:49Z\",\n" +
                "         \"description\":\"Anim laborum deserunt cillum minim elit commodo sunt ullamco sint laborum exercitation sunt eiusmod commodo. Proident labore culpa anim elit culpa reprehenderit. Ullamco aute cillum dolor sit quis ullamco. Esse labore labore velit dolor. Velit voluptate proident amet incididunt cillum incididunt aliquip commodo quis officia.\\n\\nIrure non laborum in enim laborum dolore irure amet anim irure adipisicing. Ex culpa fugiat commodo quis sunt Lorem sit commodo ullamco pariatur sit proident. Enim esse voluptate labore consequat ipsum cupidatat elit anim nisi minim.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:49Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":16,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"tempor magna anim ea id\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/16.json\",\n" +
                "         \"tags\":[\n" +
                "            \"id\",\n" +
                "            \"laborum\",\n" +
                "            \"reprehenderit\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"exercitation sit incididunt magna laboris\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:50Z\",\n" +
                "         \"description\":\"Qui magna exercitation labore occaecat dolor duis officia pariatur do amet nulla laboris ex. Amet qui laboris esse non quis. Eu anim ex sunt ut. Veniam nulla amet ea pariatur consequat elit fugiat nulla minim voluptate tempor sunt et sit. Esse exercitation officia aliqua labore eiusmod. Cillum duis veniam voluptate elit quis sunt commodo sunt. Nulla consectetur id laboris aute laborum culpa exercitation sit commodo.\\n\\nIn officia pariatur anim in consequat ex. Do magna labore esse elit sit est excepteur aliquip est sint. Nulla aute aliquip officia cillum tempor incididunt voluptate proident mollit dolore ullamco. Deserunt adipisicing cillum in ea Lorem elit.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:50Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":17,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"exercitation sit incididunt magna laboris\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/17.json\",\n" +
                "         \"tags\":[\n" +
                "            \"non\",\n" +
                "            \"proident\",\n" +
                "            \"tempor\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"laborum ea ut in cupidatat\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:50Z\",\n" +
                "         \"description\":\"Id commodo nisi velit irure et ad occaecat. Labore magna ex sint ut commodo ullamco et. Non aliqua aliquip et do irure. Consequat consectetur sit cupidatat est non laboris. Id pariatur ipsum aliqua sunt labore proident cillum occaecat mollit.\\n\\nNulla mollit anim ea culpa tempor id aliqua quis sit dolor esse ipsum. Adipisicing nisi irure mollit voluptate nisi ut laboris cillum velit qui. Incididunt excepteur sint magna eiusmod minim adipisicing consectetur consequat deserunt commodo et pariatur.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:50Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":18,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"laborum ea ut in cupidatat\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/18.json\",\n" +
                "         \"tags\":[\n" +
                "            \"commodo\",\n" +
                "            \"exercitation\",\n" +
                "            \"sunt\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"est fugiat labore pariatur esse\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:51Z\",\n" +
                "         \"description\":\"Tempor id commodo ut eu. Ipsum ut velit deserunt ad minim ullamco aliquip eu eiusmod veniam. Elit nostrud Lorem aute nisi commodo in aliquip elit nisi ea. Magna mollit incididunt consequat elit proident adipisicing et anim enim. Sint ipsum ullamco duis tempor nostrud veniam. Anim quis irure ullamco reprehenderit nostrud id reprehenderit anim. Nulla id do ullamco nisi.\\n\\nCommodo laborum excepteur ad ut ipsum fugiat tempor nostrud officia. Consequat non adipisicing et anim dolore magna aliquip cillum Lorem. Pariatur veniam do esse magna excepteur ex officia quis sit amet ut in et amet. Ipsum est dolore do consectetur ut mollit proident sit aute labore veniam nulla velit anim.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:51Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":19,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"est fugiat labore pariatur esse\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/19.json\",\n" +
                "         \"tags\":[\n" +
                "            \"dolore\",\n" +
                "            \"reprehenderit\",\n" +
                "            \"veniam\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"commodo sint laboris est et\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:52Z\",\n" +
                "         \"description\":\"Enim qui elit minim cillum qui nisi deserunt ex excepteur nulla ex sint ut adipisicing. Lorem labore nulla non id aliquip ex excepteur est excepteur. Eu reprehenderit culpa consequat voluptate ullamco aute consequat.\\n\\nReprehenderit laborum deserunt minim exercitation anim officia ullamco duis anim. Officia adipisicing cillum aliquip exercitation do. Deserunt velit aute excepteur sit elit consequat reprehenderit occaecat nostrud quis consectetur ut. Voluptate mollit reprehenderit veniam qui cillum duis commodo exercitation enim cupidatat sunt voluptate velit non. Id pariatur aliqua in ipsum anim culpa non consectetur occaecat ut. Ex ex adipisicing ut sint mollit nisi consequat aute excepteur.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:52Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":20,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"commodo sint laboris est et\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/20.json\",\n" +
                "         \"tags\":[\n" +
                "            \"excepteur\",\n" +
                "            \"sunt\",\n" +
                "            \"ut\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"laboris sint Lorem ex Lorem\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:52Z\",\n" +
                "         \"description\":\"Occaecat eu exercitation deserunt proident occaecat officia esse commodo aliqua pariatur dolor tempor sit. Nisi est eu excepteur ullamco in. Irure ut reprehenderit dolore tempor do laboris voluptate minim aliqua cupidatat.\\n\\nSint dolore veniam sit fugiat elit aute proident adipisicing laborum deserunt aliquip officia magna. Fugiat in nisi aliquip occaecat duis commodo id. Sit tempor voluptate ullamco labore nostrud enim enim tempor mollit reprehenderit tempor ea. Adipisicing ex ullamco nulla cillum excepteur incididunt aliquip mollit ullamco occaecat. In excepteur deserunt reprehenderit ut adipisicing ad. Adipisicing ea esse officia est. Cillum mollit dolore incididunt est qui adipisicing ea irure sint cillum nostrud ad.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:52Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":21,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"laboris sint Lorem ex Lorem\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/21.json\",\n" +
                "         \"tags\":[\n" +
                "            \"commodo\",\n" +
                "            \"duis\",\n" +
                "            \"minim\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"esse adipisicing consectetur sunt tempor\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:53Z\",\n" +
                "         \"description\":\"Anim occaecat nisi et velit fugiat tempor incididunt cillum nostrud ut sunt cupidatat ipsum. Tempor adipisicing elit consectetur culpa. Ad dolor velit consectetur tempor commodo est ipsum cillum incididunt esse ad ex velit. Proident eu esse eiusmod nulla mollit eu cupidatat consectetur consectetur exercitation reprehenderit laborum adipisicing do.\\n\\nLorem ad aliquip veniam nisi exercitation sit. Fugiat reprehenderit eu do officia commodo ea cillum et sunt laborum nostrud in. Dolore eu ad qui eu labore qui pariatur id. Et enim amet magna quis mollit qui. Esse laboris id voluptate do. Sunt mollit dolore proident fugiat minim mollit culpa esse minim sint ut consectetur occaecat. Incididunt culpa non nulla veniam ea laborum aliqua tempor nulla ea.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:53Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":22,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"esse adipisicing consectetur sunt tempor\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/22.json\",\n" +
                "         \"tags\":[\n" +
                "            \"consectetur\",\n" +
                "            \"nulla\",\n" +
                "            \"occaecat\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"sunt enim pariatur id id\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:53Z\",\n" +
                "         \"description\":\"Ut officia ut elit non velit nisi quis adipisicing consequat nostrud occaecat cillum. Do exercitation nulla officia consequat est velit eu id in et. Nulla culpa ullamco minim aliquip nisi ad ex. Qui aliquip ut esse ipsum magna do ipsum esse voluptate magna nisi sint ex. Laborum commodo culpa laboris quis incididunt. In enim dolore ad sunt aliquip nulla aliqua aute et amet ut veniam labore. Consectetur eiusmod et aliquip proident est Lorem proident nostrud esse eu consequat excepteur.\\n\\nExercitation duis labore irure deserunt reprehenderit do non. Incididunt dolore do nisi consectetur mollit anim in. Do dolor dolor amet enim et quis voluptate elit magna non laboris. Enim enim ea occaecat minim mollit velit id exercitation ea officia incididunt proident. Dolore fugiat esse Lorem amet consequat magna laborum fugiat. Id aliqua labore consequat laborum cillum fugiat incididunt non do ipsum.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:53Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":23,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"sunt enim pariatur id id\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/23.json\",\n" +
                "         \"tags\":[\n" +
                "            \"eu\",\n" +
                "            \"pariatur\",\n" +
                "            \"tempor\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"et ad ut enim labore\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:54Z\",\n" +
                "         \"description\":\"Consectetur dolore in minim anim reprehenderit do labore commodo officia ad ipsum amet quis ipsum. Amet ad dolor minim sint excepteur adipisicing exercitation elit. Non aliquip commodo voluptate sint veniam et ipsum magna occaecat do consequat incididunt magna do. Pariatur proident aliquip veniam dolore occaecat voluptate excepteur fugiat consequat in. Dolor ullamco ea cupidatat nostrud. Deserunt deserunt aliqua elit aute qui elit et in. Mollit cupidatat culpa officia ad qui deserunt tempor sint reprehenderit proident consectetur amet aliquip.\\n\\nAdipisicing sunt consequat labore ad ut elit anim minim esse Lorem non qui consequat. Dolore anim adipisicing ullamco nisi anim ipsum nulla magna proident nisi nulla ea. Ullamco duis nisi aliquip pariatur nulla ad occaecat.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:54Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":24,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"et ad ut enim labore\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/24.json\",\n" +
                "         \"tags\":[\n" +
                "            \"aliqua\",\n" +
                "            \"dolor\",\n" +
                "            \"officia\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      },\n" +
                "      {\n" +
                "         \"subject\":\"voluptate dolor deserunt ea deserunt\",\n" +
                "         \"email_cc_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"created_at\":\"2021-11-24T21:28:54Z\",\n" +
                "         \"description\":\"Consectetur eiusmod pariatur ullamco voluptate irure sunt magna cillum velit irure commodo culpa ipsum in. Nulla non exercitation dolor quis minim deserunt ad consequat officia ullamco irure consectetur anim mollit. Cupidatat exercitation cillum excepteur culpa consectetur ad adipisicing exercitation est amet ullamco id eiusmod tempor. Aliqua quis irure culpa tempor mollit veniam. Fugiat aliquip duis non sit id eu ea anim sit ea aliqua et dolor.\\n\\nCulpa culpa culpa id proident dolor magna ipsum dolor irure mollit proident culpa. Officia Lorem veniam dolor sit commodo id consequat ex qui enim veniam. Laboris velit excepteur sit sit anim nulla exercitation.\",\n" +
                "         \"external_id\":null,\n" +
                "         \"type\":null,\n" +
                "         \"via\":{\n" +
                "            \"channel\":\"api\",\n" +
                "            \"source\":{\n" +
                "               \"rel\":null,\n" +
                "               \"from\":{\n" +
                "                  \n" +
                "               },\n" +
                "               \"to\":{\n" +
                "                  \n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"allow_attachments\":true,\n" +
                "         \"updated_at\":\"2021-11-24T21:28:54Z\",\n" +
                "         \"problem_id\":null,\n" +
                "         \"follower_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"due_at\":null,\n" +
                "         \"id\":25,\n" +
                "         \"assignee_id\":1910382737025,\n" +
                "         \"raw_subject\":\"voluptate dolor deserunt ea deserunt\",\n" +
                "         \"forum_topic_id\":null,\n" +
                "         \"custom_fields\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"allow_channelback\":false,\n" +
                "         \"satisfaction_rating\":null,\n" +
                "         \"submitter_id\":1910382737025,\n" +
                "         \"priority\":null,\n" +
                "         \"collaborator_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"url\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets\\/25.json\",\n" +
                "         \"tags\":[\n" +
                "            \"do\",\n" +
                "            \"est\",\n" +
                "            \"labore\"\n" +
                "         ],\n" +
                "         \"brand_id\":1500002350562,\n" +
                "         \"ticket_form_id\":1500003393642,\n" +
                "         \"sharing_agreement_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"group_id\":4414070758551,\n" +
                "         \"organization_id\":1500630811622,\n" +
                "         \"followup_ids\":[\n" +
                "            \n" +
                "         ],\n" +
                "         \"recipient\":null,\n" +
                "         \"is_public\":true,\n" +
                "         \"has_incidents\":false,\n" +
                "         \"status\":\"open\",\n" +
                "         \"requester_id\":1910382737025\n" +
                "      }\n" +
                "   ],\n" +
                "   \"meta\":{\n" +
                "      \"after_cursor\":\"eyJvIjoibmljZV9pZCIsInYiOiJhUmtBQUFBQUFBQUEifQ==\",\n" +
                "      \"before_cursor\":\"eyJvIjoibmljZV9pZCIsInYiOiJhUUVBQUFBQUFBQUEifQ==\",\n" +
                "      \"has_more\":true\n" +
                "   },\n" +
                "   \"links\":{\n" +
                "      \"next\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets.json?page%5Bafter%5D=eyJvIjoibmljZV9pZCIsInYiOiJhUmtBQUFBQUFBQUEifQ%3D%3D&page%5Bsize%5D=25\",\n" +
                "      \"prev\":\"https:\\/\\/zccamelia.zendesk.com\\/api\\/v2\\/tickets.json?page%5Bbefore%5D=eyJvIjoibmljZV9pZCIsInYiOiJhUUVBQUFBQUFBQUEifQ%3D%3D&page%5Bsize%5D=25\"\n" +
                "   }\n" +
                "}";
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(stringToParse);
            System.out.println(json);
            return json;
        } catch (ParseException e) {
            System.out.println("Wrong test case");
            return null;
        }
    }

    @Test
    public void testDisplayTicket() {
        JSONObject object = createTestTicket();
        boolean result = ZendeskApp.displayTicket((JSONObject) object.get("ticket"));
        Assert.assertTrue(result);
    }

    @Test
    public void testDisplayEmptyTicket(){
        JSONObject object = new JSONObject();
        boolean result = ZendeskApp.displayTicket(object);
        Assert.assertTrue(result);
    }

    @Test
    public void testDisplayNULLTicket(){
        boolean result = ZendeskApp.displayTicket(null);
        Assert.assertFalse(result);
    }

    @Test
    public void testqueryNextPage(){
        JSONObject object = ZendeskApp.queryTickForEachPage(singleTicket + "?page[size]=25", false);
        String link = ((JSONObject)object.get("links")).get("next").toString();
        System.out.println("query next");
        JSONObject objectafter = ZendeskApp.queryTickForEachPage(link,false);
        Assert.assertEquals(50, ((JSONArray)object.get("tickets")).size() + ((JSONArray)objectafter.get("tickets")).size());
    }


    @Test
    public void testqueryPrevPage(){
        JSONObject object = ZendeskApp.queryTickForEachPage(singleTicket + "?page[size]=25", false);
        String link = ((JSONObject)object.get("links")).get("next").toString();
        System.out.println("query next");
        JSONObject objectafter = ZendeskApp.queryTickForEachPage(link, false);
        System.out.println("query original");
        link = ((JSONObject)objectafter.get("links")).get("prev").toString();
        JSONObject objectbefore = ZendeskApp.queryTickForEachPage(link,false);
        Assert.assertEquals(25, ((JSONArray)objectbefore.get("tickets")).size());
    }

    @Test
    public void testqueryInvalidPage(){
        String link = "Randomlink";
        JSONObject object = ZendeskApp.queryTickForEachPage(link, false);
        Assert.assertNull(object);
    }


    @Test
    public void testDisplayTickets(){
        JSONObject object = createTickets();
        boolean result = ZendeskApp.displayTickets(object);
        Assert.assertTrue(result);
    }


    @Test
    public void testqueryTicketByNonExistingId(){
       int id = ZendeskApp.queryTicketById(singleTicket, "0");
       Assert.assertEquals(id, -1);
    }

    @Test
    public void testqueryTicketByValidId(){
        int id = ZendeskApp.queryTicketById(singleTicket, "1");
        Assert.assertEquals(id, 1);
    }

    @Test
    public void testqueryNULLTicket(){
        int id = ZendeskApp.queryTicketById(singleTicket, null);
        Assert.assertEquals(id, -1);
    }

    @Test
    public void testqueryTicketException(){
        int id = ZendeskApp.queryTicketById("Randomstring", "0");
        Assert.assertEquals(id, -1);
    }
}
