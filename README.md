# Intern Coding Challenge -- Zendesk Ticket Viewer

## Usage Instruction

### Installation 
1. git clone https://github.com/AmeliaWen/Zendesk.git
2. cd into the ZendeskCC directory 
3. To run the application
* ./gradlew build
* ./gradlew run 

### Usage 
This program supports three types of commands:

Ticket Listing Options
1. Displayall : Display ticket list 
2. Display,{ticketid} : Display Ticket information 
3. Quit : Exit Application

User input 1/2/3 for each option, the program will keep prompting out instructions if the user input invalid character.

#### Option 1 : Display all tickets
The program lists the first 25 tickets from my own ticket list 
- If there are more than 25 tickets, type "next" to go to next page 
- type "prev" will bring the user back to prev page 
- type "exit" will terminate the display and return to the ticket listing option page 
- Otherwise, the program will alarm the user to input valid characters. 

#### Option 2 : Display ticket info
This option displays individual ticket details, it will ask for a ticket id after, then try to find the ticket info for this id. 

#### Option 3 : Exit Application
This option will terminate the program. 

### Ticket format 
This ticket output contains the following information: 
- ticket id 
- subject
- created time
- ticket type
- updated time
- priority
- url
- recipient
- status
Note : It will output "EMPTY" if no information of the parameters described above for each ticket. 

### Testing
JUnit is used for testing execution and coverage. 
Result: 
![image](https://user-images.githubusercontent.com/46387405/143618457-001d8273-a8c6-40f1-ba9f-f4a7c8be4e27.png)
Note: the lines and methods missed contains user defined operations including "NEXT", "PREV" and listing options read from command line input. 

### Example Run 
![image](https://user-images.githubusercontent.com/46387405/143618699-9eb4d5f7-2ccb-4a57-a2f7-5a27803e91ba.png)

Figure1: example run for option 1 

![image](https://user-images.githubusercontent.com/46387405/143618716-c4b3e978-3fba-416f-a3ff-9111ce3dff81.png)

Figure2: Navigation to next page 

![image](https://user-images.githubusercontent.com/46387405/143618733-c93d76c1-0b0c-4037-bb51-43157b430c88.png)

Figure3: Navigation to previous page 

![image](https://user-images.githubusercontent.com/46387405/143618749-28c523e4-a74b-49de-a1b7-2b27410a051e.png)

Figure4: Exit option 1 

![image](https://user-images.githubusercontent.com/46387405/143618903-b09f487e-dd17-4fd1-978c-f3929c45be62.png)

Figure5: List existing ticket information 

![image](https://user-images.githubusercontent.com/46387405/143618915-db643edc-4daa-4f28-889d-33ee6a4e2f91.png)

Figure6: List non-existing ticket information 

![image](https://user-images.githubusercontent.com/46387405/143618790-33761bb1-e1c0-43c9-a2bd-3ecc83ff4633.png)

Figure7: Exit the application 
