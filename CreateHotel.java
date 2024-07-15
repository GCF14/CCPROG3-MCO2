package prog_mco2;
import java.util.Scanner;
/** CreateHotel class that initializes the hotel name, number of rooms, and room names.
 */
public class CreateHotel {
    private Scanner sc;

    /** Constructor for CreateHotel
     * Preconditions: none
     * Postconditions: Scanner object is initialized
     */
    public CreateHotel() {
        sc = new Scanner(System.in);
    }

    /** Initializes the name of the hotel
     * Preconditions: Input is a String
     * Postconditions: Returns the name of the hotel
     * @return input (The name of the hotel inputted by the user)
     */
    public String initializeName() {
        String input;
        System.out.print("Enter hotel name: ");
        input = sc.nextLine();
        return input;
    }

    /** Initializes the number of rooms in the hotel
     * Preconditions: Input is an integer
     * Postconditions: Returns and int which is the number of rooms in the hotel
     * @return input (The number of rooms in the hotel inputted by the user)
     */
    public void initializeRooms(Rooms rooms) {

        int input1, input2, input3;
        int total;
        do {
            System.out.print("Enter amount of standard rooms: ");
            input1 = sc.nextInt();
            sc.nextLine(); // input buffer
            System.out.print("Enter amount of deluxe rooms: ");
            input2 = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter amount of executive rooms: ");
            input3 = sc.nextInt();
            sc.nextLine();
            total = input1 + input2 + input3;

            if (total <= 0 || total > 50) {
                System.out.println("Invalid amount");
            }
        } while(total <= 0 || total > 50);

        rooms.setStandard(input1);
        rooms.setDeluxe(input2);
        rooms.setExecutive(input3);
        rooms.setRoomNames();

        /* Note:
         * Rooms 1 - input1 are standard
         * Rooms input1 - input2 are deluxe
         * Rooms input2 - input3 are executive
         */
    }

   
    
}
