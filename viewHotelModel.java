import java.util.ArrayList;

public class viewHotelModel {


    private ArrayList<Hotel> hotels; // Store the list of hotels

    // Constructor
    public viewHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    // Get the list of hotels
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

      // Find a specific hotel by name
      public Hotel getHotelByName(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return hotel;
            }
        }
        return null; // Return null if hotel not found
    }

}
