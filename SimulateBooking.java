// package prog_mco2;
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
    public void booking(ArrayList<Hotel> hotels) { // added the choosing of room types and assignment to rooms
        Display display = new Display();
        System.out.printf("Enter customer name: ");
        String customer = sc.nextLine();
        int hotelIndex = display.enterHotelName(hotels);
        int input;
        String code;
        
        if (hotelIndex >= 0) {
            int checkInDate, checkOutDate, roomType;
            float roomPrice;
        
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

            // Ask what type of room they want
            do {
                System.out.println("Enter room type:");
                System.out.println("[1] Standard");
                System.out.println("[2] Deluxe");
                System.out.println("[3] Executive");
                System.out.print("Input: ");
                roomType = sc.nextInt();
                sc.nextLine(); //input buffer
            } while (roomType < 1 || roomType > 3);
            boolean bookedRoom = false; // check if room is already booked

            
            /* 
             * I turned the while from while(room <= hotels.get(hotelIndex).getRooms()) && !bookedRoom) to 
             * while(room <= hotels.get(hotelIndex).getRooms().getTotal() && !bookedRoom)
             */
            /*
             * Still giving them first room available but keeping in mind the room types
             */
            int room, maxRoom;
            switch(roomType) {
                case 1:
                    room = 1;
                    maxRoom = hotels.get(hotelIndex).getRooms().lastStandard();
                    roomPrice = hotels.get(hotelIndex).getRoomPrice();
                    break;
                case 2:
                    room = hotels.get(hotelIndex).getRooms().firstDeluxe();
                    maxRoom = hotels.get(hotelIndex).getRooms().lastDeluxe();
                    roomPrice = hotels.get(hotelIndex).getDeluxePrice();
                    break;
                case 3:
                    room = hotels.get(hotelIndex).getRooms().firstExecutive();
                    maxRoom = hotels.get(hotelIndex).getRooms().lastExecutive();
                    roomPrice = hotels.get(hotelIndex).getExecutivePrice();
                    break;
                default:
                    room = -1;
                    maxRoom = -1;
                    roomPrice = -1;
                    break;
            }

            float totalPrice = 0;
            for(int i = checkInDate; i < checkOutDate; i++){
                totalPrice += roomPrice * hotels.get(hotelIndex).getDatePriceModifiers(i);
            }
            
            while(room <= maxRoom && !bookedRoom) {
                
                if (!areDaysBooked(hotels.get(hotelIndex), checkInDate, checkOutDate, room)) {
                    
                    // Ask if they want to input discount code
                    do {
                        System.out.println("Enter discount code?");
                        System.out.println("[1] Yes");
                        System.out.println("[2] No");
                        input = sc.nextInt();
                        sc.nextLine(); // input buffer
                    } while (input < 1 || input > 2);
                    // Asks for input of discount code
                    if (input == 1) {
                        System.out.print("Code: ");
                        code = sc.nextLine();
                        if (code.equals("I_WORK_HERE")) {
                            totalPrice *= 0.9;
                            System.out.println("10% discount applied.");
                        }
                        else if (code.equals("STAY4_GET1")) 
                            if (checkOutDate - checkInDate >= 4) { // If stay is >= 5 days
                                totalPrice -= roomPrice;
                                System.out.println("First day of reservation is given for free.");
                            }
                            else
                                System.out.println("Reservation is inelligible for discount code.");
                                
                        else if (code.equals("PAYDAY"))
                            if (checkInDate <= 15 && checkOutDate > 15 || checkInDate <= 30 && checkOutDate > 30) { // If stay contains day 15 / 30
                                totalPrice *= 0.93;
                                System.out.println("7% discount applied.");
                            }
                            else
                                System.out.println("Reservation is inelligible for discount code.");
                        else 
                            System.out.println("Discount Code not found.");              
                    }
                    Reservation newReservation = new Reservation(customer, checkInDate, checkOutDate, room, totalPrice);
                    hotels.get(hotelIndex).addReservation(newReservation);
                    System.out.println("Booking successful.\n");
                    bookedRoom = true;
                }
                room++; // continue to increment until find an empty room
                
            }

            if (!bookedRoom) {
                System.out.printf("No rooms available for the selected dates.\n\n");
            }
            
        } 
    }
    
    
}
