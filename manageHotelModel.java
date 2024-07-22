// package prog_mco2;

import java.util.ArrayList;

public class manageHotelModel {
    private ArrayList<Hotel> hotels;
    private String selectedHotel;

    public manageHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }


    public manageHotelModel() {

    }

    public ArrayList<Hotel> getHotels() {
        return this.hotels;
    }

    public void setSelectedHotel(String selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    public String getSelectedHotel() {
        return this.selectedHotel;
    }

    /** Finds the index of the hotel in the ArrayList of hotels
     * Preconditions: h is an ArrayList of Hotels and name is a String
     * Postconditions: returns an integer
     * @param h - ArrayList of Hotels which contains all the hotels
     * @param name - The name of the hotel
     * @return i (The index of the hotel) or -1 if the hotel does not exist
     */
    public int findHotel(String name) {
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void changeHotelName(Hotel hotel, String name) {
        hotel.setName(name);
    }
    
}
