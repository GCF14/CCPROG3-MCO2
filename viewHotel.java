package prog_mco2;
import java.util.Scanner;

/**viewHotel class that displays the high level and low level information of the hotel.
 */
public class viewHotel {

    private Scanner sc;

    /** Constructor for viewHotel
     * Preconditions: none
     * Postconditions: Scanner object is initialized
     */
    public viewHotel() {
        sc = new Scanner(System.in);
    }

    /** Checks if a room is booked on a specific day
     * Preconditions: Hotel object is initialized and day is an integer
     * Postconditions: returns the number of reservations in one day
     * @param h - Instance of Hotel
     * @param day - The day to check if the room is booked
     * @return ctr (The number of reservations in one day)
     */
    public int isDayBooked(Hotel h, int day) { // returns number of reservations in one day
        int ctr = 0;
        for (int i = 0; i < h.getNumOfReservations(); i++) {
            if (day >= h.getReservations().get(i).getCheckInDate() && day < h.getReservations().get(i).getCheckOutDate()){
                ctr++;  
            }
                
        }
        return ctr;
    }

    /** Displays the high level information of the hotel
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: none
     * @param h - Instance of Hotel
     */
    public void highLevelInfo(Hotel h) {
        System.out.println();
        System.out.printf("Name of hotel: %s\n", h.getName());
        System.out.printf("Number of rooms: %d\n", h.getRooms().getTotal());
        System.out.printf("\tStandard: %d\n", h.getRooms().getStandard());
        System.out.printf("\tDeluxe: %d\n", h.getRooms().getDeluxe());
        System.out.printf("\tExecutive: %d\n", h.getRooms().getExecutive());
        System.out.printf("Price per night:\n");
        System.out.printf("\tStandard: %.2f\n", h.getRoomPrice());
        System.out.printf("\tDeluxe: %.2f\n", h.getDeluxePrice());
        System.out.printf("\tExecutive: %.2f\n", h.getExecutivePrice());
        System.out.printf("Estimate earnings for the month: %.2f\n", h.getTotalEarnings());
    }


    /** Displays the low level information of the hotel
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: none
     * @param h - Instance of Hotel
     */
    public void lowLevelInfo(Hotel h) { // fixed this for the diff types of rooms
        int input, day;
        float roomPrice;
        Display display = new Display();
        System.out.println();
         // for display Total number of available and booked rooms for a selected date
        do {
            System.out.printf("Enter day: ");
            day = sc.nextInt();
            if (day < 1 || day > 31){
                System.out.println("Invalid input");
            }
        } while (day < 1 || day > 31);
       
        System.out.printf("Number of booked rooms for the day: %d\n", isDayBooked(h, day));
        System.out.printf("Number of available rooms for the day: %d\n\n", h.getRooms().getTotal() - isDayBooked(h, day));
        
        
        //Information about a selected room
        do {
            System.out.printf("Enter a room number (1-%d): ", h.getRooms().getTotal());
            input = sc.nextInt();
            if (input < 1 || input > h.getRooms().getTotal()) {
                System.out.println("Invalid room number.");
            }
        } while (input < 1 || input > h.getRooms().getTotal());
        System.out.println();
        System.out.printf("Room name: %d\n", input);

        // Check for type of room
        if (input >= 1 && input <= h.getRooms().lastStandard())
            roomPrice = h.getRoomPrice();
        else if (input >= h.getRooms().firstDeluxe() && input <= h.getRooms().lastDeluxe())
            roomPrice = h.getDeluxePrice();
        else
            roomPrice = h.getExecutivePrice();

        System.out.printf("Room price: %.2f\n", roomPrice);
        if (!h.getReservations().isEmpty()) {
            display.displayAvailability(h, input);
        } else {
            System.out.println("No reservations for this room.\n");
        }
        System.out.println();

        int index = display.reservationMenu(h);

        if (index != -1) {
            System.out.printf("Room name: %d\n", h.getReservations().get(index).getRoomNumber());
            System.out.printf("Price per night in the room: %.2f\n", roomPrice);
            System.out.printf("Room's Guest information: \n");
            System.out.printf("Guest name: %s\n", h.getReservations().get(index).getGuestName());
            System.out.printf("Check-in Day: %d\n", h.getReservations().get(index).getCheckInDate());
            System.out.printf("Check-out Day: %d\n", h.getReservations().get(index).getCheckOutDate());
            System.out.printf("Total price for booking: %.2f\n", h.getReservations().get(index).getTotalPrice());
            System.out.println();
        }
    }
}
