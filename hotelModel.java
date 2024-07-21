import java.util.ArrayList;


public class hotelModel {

    private static ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    public void initializeRooms(Rooms rooms, int standard, int deluxe, int executive) {
        rooms.setStandard(standard);
        rooms.setDeluxe(deluxe);
        rooms.setExecutive(executive);
        rooms.setRoomNames();

    }

    public Hotel createHotel(String name, int standardRooms, int deluxeRooms, int executiveRooms, hotelGuiView gui) {
        manageHotel manager = new manageHotel();

        if (manager.findHotel(hotels, name) != -1) {
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

    

    


}
