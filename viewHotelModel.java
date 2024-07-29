import java.util.ArrayList;

/**
 * This class represents the model for viewing hotels.
 */
public class viewHotelModel {


    private ArrayList<Hotel> hotels; // Store the list of hotels

    /**
     * Constructor for the viewHotelModel class
     * @param hotels - ArrayList of hotels which contains all the hotels
     */
    public viewHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * Returns the list of hotels
     * Preconditions: hotels is an ArrayList of Hotels and instance hotels is initialized
     * Postconditions: returns an ArrayList of Hotels
     * @return hotels - ArrayList of hotels which contains all the hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Checks the availability of a hotel on a specific day
     * Preconditions: h is an instance of Hotel and roomNumber is an integer
     * Postconditions: returns an integer
     * @param h - Instance of Hotel
     * @param day - The day to check
     * @return int - The number of reservations in one day
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

    /**
     * Gets the availability information of a room in a hotel
     * Preconditions: h is an instance of Hotel and roomNumber is an integer
     * Postconditions: returns a String
     * @param h - Instance of Hotel
     * @param roomNumber - The room number
     * @return String - The availability information of the room
     */
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
    /**
     * Gets the breakdown of prices per night and stores them into a float array
     * Precondition: h and r are both initialized instances
     * Postcondition: returns a float[]
     * @param h - Hotel of the reservation
     * @param r - Reservation to check the breakdown of prices
     * @return prices - a 1d float array containing the prices per night
     */
    public float[] getPriceBreakdown(Hotel h, Reservation r) {
        int size = r.getCheckOutDate() - r.getCheckInDate();
        float[] prices = new float[size];
        float roomPrice = 0;
        int roomType = h.getRoomType(r.getRoomNumber());
        int index;
        switch (roomType) {
            case 0:
                roomPrice = h.getRoomPrice();
                break;
            case 1:
                roomPrice = h.getDeluxePrice();
                break;
            case 2:
                roomPrice = h.getExecutivePrice();
                break;
        }
        switch (r.getDiscountCode()) {
            case -1:
                index = 0;
                for (int i = r.getCheckInDate(); i < r.getCheckOutDate(); i++) {
                    prices[index++] = h.getDatePriceModifiers(i) * roomPrice;
                }
                break;
            case 1:
                index = 0;
                for (int i = r.getCheckInDate(); i < r.getCheckOutDate(); i++) {
                    prices[index++] = h.getDatePriceModifiers(i) * roomPrice * 0.9f;
                }
                break;
            case 2:
                index = 0;
                prices[index++] = 0;
                for (int i = r.getCheckInDate() + 1; i < r.getCheckOutDate(); i++) {
                    prices[index++] = h.getDatePriceModifiers(i) * roomPrice;
                }
                break;
            case 3:
                index = 0;
                for (int i = r.getCheckInDate(); i < r.getCheckOutDate(); i++) {
                    prices[index++] = h.getDatePriceModifiers(i) * roomPrice * 0.93f;
                }
                break;
        }

        return prices;

    }
    

}
