//package prog_mco2
import java.util.ArrayList;


/**
 * This class represents the model for creating and managing hotels.
 * It provides methods to initialize room details and help create new hotel instances.
 */
public class createHotelModel {

    private static ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    /**
     * Default constructor for the createHotelModel class.
     */
    public createHotelModel() {
    }


    /**
     * Initializes the room details for a given Rooms object.
     * 
     * @param rooms       the Rooms object to initialize
     * @param standard    the number of standard rooms
     * @param deluxe      the number of deluxe rooms
     * @param executive   the number of executive rooms
     */
    public void initializeRooms(Rooms rooms, int standard, int deluxe, int executive) {
        rooms.setStandard(standard);
        rooms.setDeluxe(deluxe);
        rooms.setExecutive(executive);
        rooms.setRoomNames();

    }

    /**
     * Creates a new Hotel object if it doesn't already exist and if the room numbers are valid.
     * 
     * @param name             the name of the hotel
     * @param standardRooms    the number of standard rooms
     * @param deluxeRooms      the number of deluxe rooms
     * @param executiveRooms   the number of executive rooms
     * @param gui              the GUI view to interact with for validation
     * @return                 the created Hotel instance, or null if the hotel already exists or the room numbers are invalid
     */
    public Hotel createHotel(String name, int standardRooms, int deluxeRooms, int executiveRooms, hotelGuiView gui) {
        manageHotelModel manager = new manageHotelModel(hotels);

        if (manager.findHotel(name) != -1) {
            // Hotel already exists
            return null;
        }
    
        if (!gui.validateRooms()) {
            // Invalid room numbers
            return null;
        }

        Hotel y = new Hotel(name);

        initializeRooms(y.getRooms(), standardRooms, deluxeRooms, executiveRooms);
        hotels.add(y);

        return y;
    }

    /**
     * Returns the list of hotels.
     * 
     * @return an ArrayList of Hotel objects
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    

    


}
