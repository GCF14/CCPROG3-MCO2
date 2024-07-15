package prog_mco2;
import java.util.Scanner;
import java.util.ArrayList;

/**Display class that displays the menu and other information that will help the user pick an option.
 */
public class Display {
    private Scanner sc;

    /** Constructor for Display
     * Preconditions: none
     * Postconditions: Scanner object is initialized
     */
    public Display() {
        sc = new Scanner(System.in);
    }

    /** Displays the menu for the user to pick an option
     * Preconditions: User will input an integer
     * Postconditions: Returns an integer from 1-5, which is the input of the user
     * @return input (The input of the user)
     */
    public int displayMenu() {
        int input;
        do {
            System.out.println("Hotel Reservation System");
            System.out.println("[1] Create Hotel");
            System.out.println("[2] View Hotel Information");
            System.out.println("[3] Manage Hotel");
            System.out.println("[4] Simulate Booking");
            System.out.println("[5] Exit");
            System.out.print("Input: ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer (since nextInt() does not get the new line)
        } while (input < 1 || input > 5);
        return input;
    }

    /** Displays all the available hotels for the user to choose from
     * Preconditions: User will input an integer
     * Postconditions: Returns an integer which represents the index of the hotel chosen by the user
     * @param hotels - ArrayList of hotels which contains all the hotels
     * @return index (The index of the hotel chosen by the user)
     */
    public int enterHotelName(ArrayList<Hotel> hotels) {
        int index = 0;
        if (hotels.size() == 0) {
            System.out.println("No current hotels.");
        }
        else {
            System.out.println("Choose a hotel:");
            for (int i = 0; i < hotels.size(); i++) {
                System.out.printf("[%d] %s\n", i+1, hotels.get(i).getName());
            }
            do {
                System.out.print("Input: ");
                index = sc.nextInt();
                sc.nextLine(); // input buffer
            } while (index < 1 || index > hotels.size());
        }
        
        return index - 1;
    }

    /** Displays the two options regarding the hotel information
     * Preconditions: Hotel object is initialized
     * Postconditions: Returns an integer from 1-2, which is the level of information the user wants to view
     * @return input (Type int, the level of information of the hotel that the user wants to view)
     */
    public int viewHotelMenu() {
        int input;
        do {
            System.out.println("[1] View high level information");
            System.out.println("[2] View low level information");
            System.out.print("Input: ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer
        } while (input < 1 || input > 2);
        return input;
    }

    /** Displays the menu for the user to manage the hotel
     * Preconditions: User will input an integer
     * Postconditions: Returns an integer from 1-6, which is the choice of the user
     * @return input (Type int, the choice of the user)
     */
    public int manageHotelMenu() {
        int input;
        do {
            System.out.println("[1] Change the name of a hotel");
            System.out.println("[2] Add room(s)");
            System.out.println("[3] Remove room(s)");
            System.out.println("[4] Update base room price");
            System.out.println("[5] Remove reservation");
            System.out.println("[6] Remove hotel");
            System.out.println("[7] Modify date price");

            System.out.print("Input: ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer
        } while(input < 1 || input > 7);
        return input;
    }

    /** Displays the menu for the user to pick which reservation to see
     * Preconditions: User will input an integer
     * Postconditions: Returns an integer from 1-2, which is the choice of the user
     * @param h - Instance of hotel
     * @return input (Type int, the choice of the user which will serve as an index)
     */
    public int reservationMenu(Hotel h) {
        int input;
        int input2;

        if (h.getReservations().isEmpty()) { // No reservations for the hotel
            System.out.println("No reservations for this hotel.\n");
            return -1;
        }
        else {
            System.out.printf("Choose Reservation to view\n");
            for (int i = 0; i < h.getNumOfReservations(); i++) {
                System.out.printf("[%d]\tCustomer name: %s\n", i+1, h.getReservations().get(i).getGuestName());
                System.out.printf("\tCheck-in date: Day %d\t Check-out date: Day %d\n", h.getReservations().get(i).getCheckInDate(), h.getReservations().get(i).getCheckOutDate());
                System.out.printf("\tRoom number: %d\n", h.getReservations().get(i).getRoomNumber());
            
            }

        
            
            do {
                System.out.print("Input reservation: ");
                input = sc.nextInt();
                sc.nextLine(); // input buffer
            } while (input < 1 || input > h.getNumOfReservations());

            input2 = confirm();
            while(input2 == 2){
                System.out.print("Input reservation: ");
                input = sc.nextInt();
                sc.nextLine(); // input buffer
                input2 = confirm();
            }
        }


        return input - 1;

    }

    /** Displays the availability of a room for a specific day
     * Preconditions: Instance of hotel is initialized and room number is an integer
     * Postconditions: Information of the hotel is displayed
     * @param h - Instance of Hotel
     * @param roomNumber - The room number of the room
     */
    //Displays the availability of a specific rooms for the month
    public void displayAvailability(Hotel h, int roomNumber) {
        int i = 0;

        for(i = 0; i < 31; i++){
            if (h.isRoomBookedOnDay(roomNumber, i + 1)) {
                System.out.printf("\tDay %d: Booked\n", i + 1);
            } else {
                System.out.printf("\tDay %d: Available\n", i + 1);
            }
        }
    }

    
    /** Displays the confirmation menu for the user to confirm or cancel an action
     * Preconditions: User will input an integer
     * Postconditions: Returns an integer from 1-2, which is the choice of the user
     * @return input (Type int, the choice of the user)
     */
    public int confirm(){
        int input;
        do {
            System.out.printf("[1] Confirm\n");
            System.out.printf("[2] Cancel\n");
            System.out.print("Input: ");
            input = sc.nextInt();
            sc.nextLine(); // input buffer
        } while (input < 1 || input > 2);
        System.out.println();
        return input;
    }


    
}
    
        

