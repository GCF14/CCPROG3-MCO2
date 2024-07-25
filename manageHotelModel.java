// package prog_mco2;

import java.util.ArrayList;

public class manageHotelModel {
    private ArrayList<Hotel> hotels;
    private String selectedHotel;

    public manageHotelModel(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
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

}
