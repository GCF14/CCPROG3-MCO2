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

    /** Moves the room numbers of the reservations above a certain room number to account for removed/added rooms before it
     * @param h - Instance of Hotel that contains the reservations to edit
     * @param roomNum - Threshold for room numbers of reservations
     * @param ctr - Number of room numbers to move
     */
    public void setReservationRooms(Hotel h, int roomNum, int ctr) {
        for (int i = 0; i < h.getNumOfReservations(); i++) {
            if (h.getReservations().get(i).getRoomNumber() > roomNum)
                h.getReservations().get(i).setRoomNumber(h.getReservations().get(i).getRoomNumber() - ctr);
        }
    }
    
    /** Adds rooms to the hotel
     * Preconditions: hotels is an initialized ArrayList of Hotels
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
       switch (roomType) {
            case 0:
                setReservationRooms(hotel, hotel.getRooms().getStandard() - ctr, -ctr);
                break;  
            case 1:
                setReservationRooms(hotel, hotel.getRooms().getDeluxe() - ctr, -ctr);
                break;
            case 2:
                setReservationRooms(hotel, hotel.getRooms().getExecutive() - ctr, -ctr);
                break;
       }

       return ctr;
    }

    /**
     * Removes rooms from the hotel
     * Preconditions: hotel is initialized, roomType and rooms are valid integers
     * Postconditions: Rooms are removed from the hotel
     * @param hotel - the hotel to remove the rooms from
     * @param roomType - the type of room to remove
     * @param rooms - the number of rooms to remove
     * @return the number of rooms removed
     */
    public int removeRooms(Hotel hotel, int roomType, int rooms) {
        int ctr = 0;
        boolean found;
        int total = hotel.getRooms().getTotal();
        int numRooms = 0, firstRoom = 0, lastRoom = 0;
        
        switch (roomType) {
            case 0:
                firstRoom = 1;
                lastRoom = hotel.getRooms().getStandard();
                numRooms = hotel.getRooms().getStandard();
                break;
            case 1:
                firstRoom = hotel.getRooms().firstDeluxe();
                lastRoom = hotel.getRooms().lastDeluxe(); 
                numRooms = hotel.getRooms().getDeluxe();
                break; 
            case 2:
                firstRoom = hotel.getRooms().firstExecutive();
                lastRoom = hotel.getRooms().lastExecutive();
                numRooms = hotel.getRooms().getExecutive();
                break;
        }

        while (total > 1 && rooms > 0 && numRooms > 0 && lastRoom >= firstRoom) { 
            found = false;
            for (int i = 0; i < hotel.getNumOfReservations() && !found; i++) { // If a room has a reservation, skip the room
                if (hotel.getReservations().get(i).getRoomNumber() == lastRoom) { 
                    found = true;
                    lastRoom--;
                }
            }
            if (!found) {
                hotel.removeRoom(lastRoom);
                rooms--;
                ctr++;
                total--;
                lastRoom--;
                numRooms--;
                
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

        hotel.getRooms().resetRoomNames();

        switch (roomType) {
            case 0:
                setReservationRooms(hotel, hotel.getRooms().getStandard() + ctr, ctr);
                break;  
            case 1:
                setReservationRooms(hotel, hotel.getRooms().getDeluxe() + ctr, ctr);
                break;
            case 2:
                setReservationRooms(hotel, hotel.getRooms().getExecutive() + ctr, ctr);
                break;
        }
    
        return ctr;
    }

    /**
     * Changes the price of the hotel
     * Preconditions: hotel is initialized, newPrice is a float
     * Postconditions: Price is either changed or unchanged
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
     * Preconditions: hotel is initialized, index is within bounds
     * @param hotel - the hotel to remove the reservation from
     * @param index - the index of the reservation to remove
     */
    public void removeReservation(Hotel hotel, int index) {
        hotel.removeReservation(index);
    }

    /**
     * Removes a reservation from the hotel
     * Preconditions: hotels is an initialized ArrayList of Hotel, h is a Hotel within hotels
     * Postconditions: h is removed from hotels
     * @param hotels - the array list of hotels to remove the hotel from
     * @param h - the hotel to be removed
     */
    public void removeHotel(ArrayList<Hotel> hotels, Hotel h) {
        hotels.remove(h);
    }

    /**
     * Edits the check-in and check-out dates of a reservation
     * Preconditions: r is initialized, checkIn and checkOut are valid integers
     * Postconditions: Check-in and check-out date of reservation are edited
     * @param r - the reservation to be edited
     * @param checkIn - the new check-in date
     * @param checkOut - the new check-out date
     */
    public void editDates(Reservation r, int checkIn, int checkOut) {
        r.setCheckInDate(checkIn);
        r.setCheckOutDate(checkOut);
    }
    /**
     * Updates the total price of a reservation
     * Preconditions: h and r are initialized, roomPrice is a float
     * Postconditions: Total price of the reservation is edited
     * @param h - the hotel that the reservation is in
     * @param r - the reservation to be edited
     * @param roomPrice - the room price of the reservation
     */
    public void editTotalPrice(Hotel h, Reservation r, float roomPrice) {
        float totalPrice = 0;
        
        for (int i = r.getCheckInDate(); i < r.getCheckOutDate(); i++) {
            totalPrice += roomPrice * h.getDatePriceModifiers(i);
        }

        switch (r.getDiscountCode()) {
            case 1:
                totalPrice *= 0.9;
                break;
            case 2:
                if (r.getCheckOutDate() - r.getCheckInDate() >= 4)
                    totalPrice -= roomPrice;
                break;
            case 3:
                if (r.getCheckInDate() <= 15 && r.getCheckOutDate() > 15 || r.getCheckInDate() <= 30 && r.getCheckOutDate() > 30)
                    totalPrice *= 0.97;
                break;
        }

        r.setTotalPrice(totalPrice);
    }
    /** Checks if the days are booked in a hotel, not including a certain Reservation r
     * Preconditions: h is an instance of Hotel, r is an instance of Reservation, checkIn, checkOut, and room are integers
     * Postconditions: returns a boolean
     * @param h - Instance of Hotel
     * @param r - Instance of Reservation
     * @param checkIn - The check-in date
     * @param checkOut - The check-out date
     * @param room - The room number
     * @return boolean - True if the days are booked, false otherwise
     */
    public boolean isSameReservation(Hotel h, Reservation r, int checkIn, int checkOut, int room) {
        for (int i = 0; i < h.getReservations().size(); i++) {
            Reservation reservation = h.getReservations().get(i);
            if (reservation.getRoomNumber() == room) {
                // Check for overlap with existing reservation
                if (!(checkIn >= reservation.getCheckOutDate() || checkOut < reservation.getCheckInDate())) {
                    if (reservation != r)
                        return true;
                } 
                    
            }
        }
        return false;
    }
    /** Finds the first available room of a certain hotel during specific check-in and check-out dates.
     * Preconditions: h and r are initialized, r is in h, checkIn and checkOut are valid integers
     * Postconditions: Reservation r's check-in, check-out and total price will be edited if there is an available room, else nothing happens.
     * @param h - hotel to check the reservations
     * @param r - reservation to be edited
     * @param checkIn - new check-in date
     * @param checkOut - new check-out date
     * @return true if an available room was found, else returns false
     * 
     */
    public boolean findAvailableRoom(Hotel h, Reservation r, int checkIn, int checkOut) {
        int room, maxRoom;
        float roomPrice;
        int roomType = h.getRoomType(r.getRoomNumber());
        if (roomType == 0) { // Standard Room
            room = 1;
            maxRoom = h.getRooms().lastStandard();
            roomPrice = h.getRoomPrice();
        }
        else if (roomType == 1) { // Deluxe Room
            room = h.getRooms().firstDeluxe();
            maxRoom = h.getRooms().lastDeluxe();
            roomPrice = h.getDeluxePrice();
        }
        else { // Executive Room
            room = h.getRooms().firstExecutive();
            maxRoom = h.getRooms().lastExecutive();
            roomPrice = h.getExecutivePrice();
        }

        boolean bookedRoom = false;
        while(room <= maxRoom && !bookedRoom) {
            if (!isSameReservation(h, r, checkIn, checkOut, room)) {
                editDates(r, checkIn, checkOut);
                editTotalPrice(h, r, roomPrice);
                r.setRoomNumber(room);
                bookedRoom = true;
            }
            room++;
        }

        return bookedRoom;

    }
    /**
     * Edits the room type of a specific reservation if possible.
     * @param h - hotel that the reservation is in
     * @param roomType - room type of the reservation (0 - standard, 1 - deluxe, 2 - executive)
     * @param r - reservation to be edited
     * @return true if reservation was successfully edited, else returns false
     */
    public boolean editRoomType(Hotel h, int roomType, Reservation r) {
        boolean edit = false;
        int room, maxRoom;
        float roomPrice;
        switch(roomType) {
            case 0:
                room = 1;
                maxRoom = h.getRooms().lastStandard();
                roomPrice = h.getRoomPrice();
                break;
            case 1:
                room = h.getRooms().firstDeluxe();
                maxRoom = h.getRooms().lastDeluxe();
                roomPrice = h.getDeluxePrice();
                break;
            case 2:
                room = h.getRooms().firstExecutive();
                maxRoom = h.getRooms().lastExecutive();
                roomPrice = h.getExecutivePrice();
                break;
            default:
                room = -1;
                maxRoom = -1;
                roomPrice = -1;
                break;
        }
        while (room <= maxRoom && !edit) {
            if (!isSameReservation(h, r, r.getCheckInDate(), r.getCheckOutDate(), room)) {
                r.setRoomNumber(room);
                editTotalPrice(h, r, roomPrice);

                

                edit = true;
            }
            
            room++;
        }

        return edit;
    }

}
