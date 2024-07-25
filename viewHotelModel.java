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

    public int isDayBooked(Hotel h, int day) { // returns number of reservations in one day
        int ctr = 0;
        for (int i = 0; i < h.getNumOfReservations(); i++) {
            if (day >= h.getReservations().get(i).getCheckInDate() && day < h.getReservations().get(i).getCheckOutDate()){
                ctr++;  
            }
                
        }
        return ctr;
    }

    public String getAvailabilityInfo(Hotel h, int roomNumber) {
        StringBuilder availabilityInfo = new StringBuilder();
    
        for (int i = 0; i < 31; i++) {
            if (h.isRoomBookedOnDay(roomNumber, i + 1)) {
                availabilityInfo.append(String.format("Day %d: Booked\n", i + 1));
            } else {
                availabilityInfo.append(String.format("Day %d: Available\n", i + 1));
            }
        }
    
        return availabilityInfo.toString();
    }
    

}
