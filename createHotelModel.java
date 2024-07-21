import java.util.ArrayList;

public class createHotelModel {
    public Hotel createHotel(String name, int standardRooms, int deluxeRooms, int executiveRooms) {
        Hotel hotel = new Hotel(name);
        manageHotel manager = new manageHotel();

        if(manager.findHotel(null, name))
        // Initialize rooms
        hotel.initializeRooms(hotel.getRooms(), standardRooms, deluxeRooms, executiveRooms);
        return hotel;
    }

    private void initializeRooms(ArrayList<Room> rooms, int standardRooms, int deluxeRooms, int executiveRooms) {
        for (int i = 0; i < standardRooms; i++) {
            rooms.add(new Room("Standard"));
        }
        for (int i = 0; i < deluxeRooms; i++) {
            rooms.add(new Room("Deluxe"));
        }
        for (int i = 0; i < executiveRooms; i++) {
            rooms.add(new Room("Executive"));
        }
    }
}
