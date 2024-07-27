// package prog_mco2;
import java.util.ArrayList;

/**Model class for managing hotels
 */
public class manageHotelModel {
    private ArrayList<Hotel> hotels;
    private String selectedHotel;

    /** Constructor for manageHotelModel
     * Preconditions: hotels is an ArrayList of Hotels
     * Postconditions: manageHotelModel object is initialized
     * @param hotels - ArrayList of hotels which contains all the hotels
     */
    public manageHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    /** Returns the list of hotels
     * Preconditions: hotels is an ArrayList of Hotels and instance hotels is initialized
     * Postconditions: returns an ArrayList of Hotels
     * @return hotels - ArrayList of hotels which contains all the hotels
     */
    public ArrayList<Hotel> getHotels() {
        return this.hotels;
    }

    /** Sets selectedHotel
     * Preconditions: hotels is an ArrayList of Hotels
     * Postconditions: The list of hotels is set
     * @param hotels - ArrayList of hotels which contains all the hotels
     */
    public void setSelectedHotel(String selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    /** Returns the selected hotel
     * Preconditions: selectedHotel is a String
     * Postconditions: returns a String
     * @return selectedHotel - The selected hotel
     */
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

    
    /** Adds rooms to the hotel
     * Preconditions: hotels is an ArrayList of Hotels
     * Postconditions: Rooms are added to the hotel
     * @param h - The hotel to be added
     * @param roomType - The type of room to add
     * @param rooms - The number of rooms to add
     * @return ctr (The number of rooms added)
     */
    public int addRooms(Hotel hotel, int roomType, int rooms) {
        int ctr = 0;
        while (rooms > 0 && hotel.getRooms().getTotal() < 50){   
            switch (roomType) {
               case 0:
                   hotel.getRooms().setStandard(hotel.getRooms().getStandard() + 1);
                   break;
               case 1:
                   hotel.getRooms().setDeluxe(hotel.getRooms().getDeluxe() + 1);
                   break;
               case 2:
                   hotel.getRooms().setExecutive(hotel.getRooms().getExecutive() + 1);
                   break;
           }
           rooms--;
           ctr++;
           hotel.getRooms().addRoomNames();
       }

       return ctr;
    }

    /**
     * Removes rooms from the hotel
     * @param hotel - the hotel to remove the rooms from
     * @param roomType - the type of room to remove
     * @param rooms - the number of rooms to remove
     * @return the number of rooms removed
     */
    public int removeRooms(Hotel hotel, int roomType, int rooms) {
        int ctr = 0;
        boolean found;
        int x = hotel.getRooms().getTotal();

        int y = 0;
        switch (roomType) {
            case 0:
                y = hotel.getRooms().getStandard();
                break;
            case 1:
                y = hotel.getRooms().getDeluxe();
                break;
            case 2:
                y = hotel.getRooms().getExecutive();
                break;
        }




        while (x > 1 && y > 0 && rooms > 0) { 
            found = false;
            for (int i = 0; i < hotel.getNumOfReservations() && !found; i++) { // If a room has a reservation, skip the room
                if (hotel.getReservations().get(i).getRoomNumber() == x) {
                    found = true;
                    x--;
                }
            }
            if (!found) {
                hotel.removeRoom(x);
                rooms--;
                ctr++;
                x--;
                y--;
            }
        }
        switch(roomType) {
            case 0:
                hotel.getRooms().setStandard(hotel.getRooms().getStandard() - ctr);
                
                break;
            case 1:
                hotel.getRooms().setDeluxe(hotel.getRooms().getDeluxe() - ctr);
                
                break;
            case 2:
                hotel.getRooms().setExecutive(hotel.getRooms().getExecutive() - ctr);
               
                break;
        }
    
        return ctr;
    }

    /**
     * Changes the price of the hotel
     * @param hotel - the hotel to change the price of
     * @param newPrice - the new price of the hotel
     * @return 1 if the price was changed, 0 if there are reservations, -1 if the price is invalid
     */
    public int newPrice(Hotel hotel, float newPrice) {
        if(hotel.getNumOfReservations() == 0 && newPrice >= 100) {
            hotel.setRoomPrice(newPrice);
            return 1;
        }
        else if (hotel.getNumOfReservations() != 0)
            return 0;
        else
            return -1;
    }

    /**
     * Removes a reservation from the hotel
     * @param hotel - the hotel to remove the reservation from
     * @param index - the index of the reservation to remove
     */
    public void removeReservation(Hotel hotel, int index) {
        hotel.removeReservation(index);
    }

}
