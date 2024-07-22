package prog_mco2;

import java.util.ArrayList;

public class manageHotelModel {
    private ArrayList<Hotel> hotels;

    public manageHotelModel() {

    }

    public manageHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    public ArrayList<Hotel> getHotels() {
        return this.hotels;
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

    public int removeRooms(Hotel hotel, int roomType, int rooms) {
        int ctr = 0;
        boolean found;
        int x = hotel.getRooms().getTotal();
        while (x > 1 && rooms > 0) { 
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
            }
        }
        switch(roomType) {
            case 1:
                hotel.getRooms().setStandard(-ctr);
                break;
            case 2:
                hotel.getRooms().setDeluxe(-ctr);
                break;
            case 3:
                hotel.getRooms().setExecutive(-ctr);
        }

        return ctr;
    }
    
    /** Changes the price of the room
     * Preconditions: Instance of Hotel is initialized
     * Postconditions: The price of the room is changed
     * @param h - Instance of Hotel
     * @param newPrice - New price to be set
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

    public void removeReservation(Hotel hotel, int index) {
        hotel.removeReservation(index);
    }

    public void removeHotel(ArrayList<Hotel> hotels, int index) {
        hotels.remove(index);
    }

    public void modifyDatePriceModifier(Hotel hotel, int day, float percentage) {
        hotel.setDatePriceModifier(day, percentage);
    }
    
}
