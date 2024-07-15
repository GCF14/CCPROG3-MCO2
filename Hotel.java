package prog_mco2;
import java.util.ArrayList;

/**Hotel class that contains the name of the hotel, number of rooms, room price, room names, and reservations.
 */
public class Hotel {
    private String name;
    private Rooms rooms;
    private float roomPrice;
    private ArrayList<Reservation> reservations;
    
    /** Constructor for Hotel
     * Preconditions: name is a String, rooms is an integer
     * Postconditions: Hotel object is initialized
     * @param name - The name of the hotel
     * @param rooms - The number of rooms in the hotel
     */
    public Hotel(String name) {
        this.name = name;
        this.rooms = new Rooms();
        this.roomPrice = 1299.0f;
        this.reservations = new ArrayList<Reservation>();
    }


    /** Checks if a room is booked on a specific day
     * Preconditions: roomNumber is an integer, day is an integer
     * Postconditions: returns a boolean value
     * @param roomNumber - The room number of a hotel
     * @param day - The day to check if the room is booked
     * @return true if the room is booked on the specific day, false otherwise
     */
    public boolean isRoomBookedOnDay(int roomNumber, int day) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber && day >= reservation.getCheckInDate() && day < reservation.getCheckOutDate()) {
                return true;
            }
        }
        return false;
    }

    /** Returns the name of the hotel
     * Preconditions: Hotel object is initialized
     * Postconditions: returns a String
     * @return name - The name of the hotel
     */
    public String getName() {
        return this.name;
    }

    /** Sets a new name for the hotel
     * Preconditions: name is a String and hotel object is initialized
     * Postconditions: The name of the hotel is set
     * @param name - The new name of the hotel
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Returns the number of rooms in the hotel
     * Preconditions: Hotel object is initialized
     * Postconditions: returns an integer
     * @return rooms - The number of rooms in the hotel
     */
    public Rooms getRooms() {
        return this.rooms;
    }

    /** Gets the price for the night in a room in the hotel
     * Preconditions: roomPrice is a float and hotel object is initialized
     * Postconditions: returns a float
     * @return roomPrice (The price of the room)
     */
    public float getRoomPrice() {
        return roomPrice;
    }

    /** Sets a new price for the night in a room in the hotel
     * Preconditions: roomPrice is a float and hotel object is initialized
     * Postconditions: The price of the room is set
     * @param roomPrice - The new price of the room
     */
    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    /** Returns the list of reservations in the hotel
     * Preconditions: Hotel object is initialized to have a list of reservations
     * Postconditions: returns an ArrayList of Reservation 
     * @return reservations (The list of reservations in the hotel)
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /** Returns the number of reservations in the hotel
     * Preconditions: Hotel object is initialized to have a list of reservations
     * Postconditions: returns an integer
     * @return reservations.size() (The number of reservations in the hotel)
     */
    public int getNumOfReservations() {
        return this.reservations.size();
    }

    /** Adds a reservation to the list of reservations in the hotel
     * Preconditions: newReservation is an instance of Reservation and hotel object is initialized to have a list of reservations
     * Postconditions: The reservation is added to the list of reservations
     * @param newReservation - The new reservation to be added
     */
    public void addReservation(Reservation newReservation) {
        this.reservations.add(newReservation);
    }

    /** Removes a reservation from the list of reservations in the hotel
     * Preconditions: index is an integer and hotel object is initialized to have a list of reservations
     * Postconditions: The reservation is removed from the list of reservations
     * @param index - The index of the reservation to be removed
     */
    public void removeReservation(int index) {
        if (index >= 0)
            this.reservations.remove(index);
    }  

    /** Removes a room from the list of rooms in the hotel
     * Preconditions: roomNumber is an integer and hotel is initialized to have a list of rooms
     * Postconditions: The room is removed from the list of rooms
     * @param roomNumber - The room number of the room to be removed
     * @param h - Instance of Hotel
     * @return true if the room is removed, false otherwise
     */
    public boolean removeRoom(int roomNumber, Hotel h) {
        int removed = -1;

        if (h.getRooms().getTotal() > 1 && roomNumber > 0 && roomNumber <= h.getRooms().getTotal())
            removed = this.rooms.getRoomNames().remove(roomNumber - 1);
        if (removed == roomNumber) {
            return true;
        }
        else {
            return false;
        }
        
    }

    /** Gets the name of a room in the list of rooms in the hotel
     * Preconditions: index is an integer
     * Postconditions: returns an integer
     * @param index - The index of the room to get the name
     * @return roomName.get(index) (The name of the room) or -1 if index is out of bounds
     */
    public int getRoomName(int index) {
        if (index >= 0 && index < this.rooms.getTotal()) {
            return this.rooms.getRoomNames().get(index);
        } else {
            System.out.printf("Index out of bounds. Cannot get room name.\n");
            return -1;
        }
    }

    /** Gets the total number of nights spent in the hotel
     * Preconditions: Hotel object is initialized to have a list of reservations
     * Postconditions: returns an integer
     * @return totalNights (The total number of nights spent by each reservation in the hotel)
     */
    // public int getTotalNights() {
    //     int totalNights = 0;
    //     for (Reservation r : reservations) {
    //         totalNights += r.getNightSpent();
    //     }
    //     return totalNights;
    // }

    // Total nights spent in standard rooms
    public int getTotalStandard() {
        int total = 0;
        for (int i = 0; i < this.getNumOfReservations(); i++) {
            for (int j = 0; j < this.rooms.getStandard(); j++) {
                if (this.reservations.get(i).getRoomNumber() == this.rooms.getRoomNames().get(j))
                total += this.getReservations().get(i).getNightSpent();
            }
        }
        return total;
    }
    // Total nights spent in deluxe rooms
    public int getTotalDeluxe() {
        int total = 0;
        for (int i = 0; i < this.getNumOfReservations(); i++) {
            for (int j = this.rooms.getStandard(); j < this.rooms.getStandard() + this.rooms.getDeluxe(); j++) {
                if (this.reservations.get(i).getRoomNumber() == this.rooms.getRoomNames().get(j))
                total += this.getReservations().get(i).getNightSpent();
            }
        }
        return total;
    }
    // Total nights spent in executive rooms
    public int getTotalExecutive() {
        int total = 0;
        int temp = this.rooms.getStandard() + this.rooms.getDeluxe();
        for (int i = 0; i < this.getNumOfReservations(); i++) {
            for (int j = temp; j < temp + this.rooms.getExecutive(); j++) {
                if (this.reservations.get(i).getRoomNumber() == this.rooms.getRoomNames().get(j))
                    total += this.getReservations().get(i).getNightSpent();
            }
        }
        return total;
    }


}
