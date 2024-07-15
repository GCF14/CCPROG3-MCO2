package prog_mco2;
import java.util.ArrayList;
import java.util.Scanner;

/**Driver class that runs the program and contains the main method
 */
public class Driver {
    /** Main method that runs the program
     * Preconditions: none
     * Postconditions: Program runs
     * @param args - Command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        CreateHotel x = new CreateHotel();
        Display display = new Display();
        manageHotel manager = new manageHotel();
        viewHotel viewHotel = new viewHotel();
        SimulateBooking SimulateBooking = new SimulateBooking();
        Scanner sc = new Scanner(System.in);
        String name;
        int i, input, input2;


        do {
            input = display.displayMenu();
            switch (input) {
                case 1: // Create Hotel
                    System.out.println();
                    name = x.initializeName();
                    if (manager.findHotel(hotels, name) < 0) { // Checks if a hotel already has that name
                        Hotel y = new Hotel(name);
                        x.initializeRooms(y.getRooms());
                        hotels.add(y);
                    }
                    else {
                        System.out.println("Creation unsuccessful, hotel already exists");
                    }
                    System.out.println();

                    break;
                case 2: // View Hotel Information
                    System.out.println();
                    i = display.enterHotelName(hotels);
                    if (i >= 0) {
                        switch (display.viewHotelMenu()) {
                            case 1: // High level info
                                viewHotel.highLevelInfo(hotels.get(i));
                                System.out.println();
                                break;
                            case 2: // Low level info
                                viewHotel.lowLevelInfo(hotels.get(i));
                                System.out.println();
                                break; 
                        }
                    }
                    
                    break;
                case 3: // Manage Hotel
                    System.out.println();
                    input2 = display.manageHotelMenu();
                    switch(input2) {
                        case 1: // Change the name of the hotel
                            manager.setNameHotel(hotels); 
                            break;
                        case 2: // Add room(s)
                            i = display.enterHotelName(hotels);
                            if (i >= 0) 
                                manager.addRooms(hotels.get(i));
                            break;
                        case 3: // Remove room(s)
                            i = display.enterHotelName(hotels);
                            if (i >= 0) 
                                manager.removeRoom(hotels.get(i));
                            break;
                        case 4: // Update base room price
                            i = display.enterHotelName(hotels);
                            if (i >= 0)
                                manager.newPrice(hotels.get(i));
                            break;
                        case 5: // Remove reservation
                            i = display.enterHotelName(hotels);
                            if (i >= 0)
                                manager.removeReservation(hotels.get(i));
                            break;
                        case 6: // Remove hotel
                            manager.removeHotel(hotels);
                            break;
                    }
                    break;
                case 4: // Simulate Booking
                    System.out.println();
                    SimulateBooking.booking(hotels);
                    break;
            }        
        } while (input != 5);
        
        sc.close();
    }

}
