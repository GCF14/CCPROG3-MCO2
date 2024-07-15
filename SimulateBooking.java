// package prog_mco1;
import java.util.ArrayList;
import java.util.Scanner;

/**SimulateBooking class that allows the user to book a room in a hotel.
 */
public class SimulateBooking {
    private Scanner sc;

    /** Constructor for SimulateBooking
     * Preconditions: none
     * Postconditions: Scanner object is initialized
     */
    public SimulateBooking() {
        sc = new Scanner(System.in);
    }

    /** Checks if the room is already booked for the selected dates
     * Preconditions: h is an instance of Hotel, checkIn is an integer, checkOut is an integer, room is an integer
     * Postconditions: returns a boolean value
     * @param h - Instance of Hotel
     * @param checkIn - The check in date
     * @param checkOut - The check out date
     * @param room - The room number
     * @return true if the room is already booked, false otherwise
     */
    public boolean areDaysBooked(Hotel h, int checkIn, int checkOut, int room) {
        for (int i = 0; i < h.getReservations().size(); i++) {
            Reservation reservation = h.getReservations().get(i);
            if (reservation.getRoomNumber() == room) {
                // Check for overlap with existing reservation
                if (!(checkIn >= reservation.getCheckOutDate() || checkOut < reservation.getCheckInDate())) {
                    return true;
                } 
                    
            }
        }
        return false;
    }
        
    
    /** Books a room in a hotel
     * Preconditions: hotels is an ArrayList of Hotels and instance hotels is initialized
     * Postconditions: A room is booked in a hotel
     * @param hotels - ArrayList of hotels which contains all the hotels
     */
    public void booking(ArrayList<Hotel> hotels) {
        Display display = new Display();
        System.out.printf("Enter customer name: ");
        String customer = sc.nextLine();
        int hotelIndex = display.enterHotelName(hotels);
        
        if (hotelIndex >= 0) {
            int room = 1;
            int checkInDate;
            int checkOutDate;
        
            do {
                do {
                    System.out.printf("Enter check-in day: ");
                    checkInDate = sc.nextInt();
                    sc.nextLine(); //input buffer
                } while (checkInDate < 1 || checkInDate > 31);
                
                do {
                    System.out.printf("Enter check-out day: ");
                    checkOutDate = sc.nextInt();
                    sc.nextLine(); //input buffer
                } while (checkOutDate < 1 || checkOutDate > 31);
            } while (checkInDate >= checkOutDate);

            boolean bookedRoom = false; // check if room is already booked

            while(room <= hotels.get(hotelIndex).getRooms() && !bookedRoom) {
                
                if (!areDaysBooked(hotels.get(hotelIndex), checkInDate, checkOutDate, room)) {
                
                    Reservation newReservation = new Reservation(customer, checkInDate, checkOutDate, room);
    
                    hotels.get(hotelIndex).addReservation(newReservation);
                    System.out.println("Booking successful.\n");
                    bookedRoom = true;
                }
                room++; // continue to increment until find an empty room
                
            }

            if (!bookedRoom) {
                System.out.printf("No rooms available for the selected dates.\n\n");
            }
            
        } else {
            System.out.printf("No current hotels.\n");
        }
    }
    
    
}
