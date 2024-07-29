// package prog_mco2;
import java.util.ArrayList;
import java.util.Arrays;

/**Hotel class that contains the name of the hotel, number of rooms, room price, room names, and reservations.
 */
public class Hotel {
    private String name;
    private Rooms rooms;
    private float roomPrice;
    private ArrayList<Reservation> reservations;
    private float[] datePriceModifiers; //this will contain the price rate of the rooms imagine index as the date - 1 and the value is price rate
    
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
        this.datePriceModifiers = new float[31]; //31 days in a month so 31 price rates per night
        Arrays.fill(datePriceModifiers, 1.0f); // Initialize all days to 100% by default
    }

    /** returns the price modifier for a specific day
     * Preconditions: date is an integer
     * Postconditions: returns a float
     * @param date - The day to get the price modifier
     */
    public float getDatePriceModifiers(int date) {
        return datePriceModifiers[date - 1];
    }

    /** Sets the price modifier for a specific day
     * Preconditions: day is an integer, priceRate is a float
     * Postconditions: The price modifier for the specific day is set
     * @param day - The day to set the price modifier
     * @param priceRate - The price rate for the specific day
     */
    public void setDatePriceModifier(int day, float priceRate) {
        if (day >= 1 && day <= 31) {
            datePriceModifiers[day - 1] = priceRate; // Adjust index for day
        } else {
            System.out.println("Invalid day entered. Please enter a day between 1 and 31.");
        }
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

    /** Gets the price for the night in a standard room in the hotel
     * Preconditions: roomPrice is a float and hotel object is initialized
     * Postconditions: returns a float
     * @return roomPrice (The price of the room)
     */
    public float getRoomPrice() {
        return this.roomPrice;
    }

    /** Gets the price for the night in a deluxe room in the hotel
     * Preconditions: roomPrice is a float and hotel object is initialized
     * Postconditions: returns a float
     * @return roomPrice * 1.2 (The price of a deluxe room)
     */
    public float getDeluxePrice() {
        return this.roomPrice * 1.2f;
    }

    /** Gets the price for the night in an executive room in the hotel
     * Preconditions: roomPrice is a float and hotel object is initialized
     * Postconditions: returns a float
     * @return roomPrice * 1.35 (The price of an executive room)
     */
    public float getExecutivePrice() {
        return this.roomPrice * 1.35f;
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
    public boolean removeRoom(int roomNumber) {
        int removed = -1;
    
        if (this.getRooms().getTotal() > 1 && roomNumber > 0 && roomNumber <= this.getRooms().getTotal())
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

    /** Gets the room type of a room in the list of rooms in the hotel
     * Preconditions: Reservation r is initialized
     * Postconditions: returns an integer
     * @param r - The reservation to get the room type of
     * @return 0 if standard room, 1 if deluxe room, 2 if executive room
     */
    public int getRoomType(int room) {
        if (room >= 1 && room <= this.getRooms().lastStandard())
            return 0;
        else if (room >= this.getRooms().firstDeluxe() && room <= this.getRooms().lastDeluxe())
            return 1;
        else
            return 2;
    }

    /**
     * This method returns the total earnings of the hotel from all reservations.
     */
    public float getTotalEarnings() {
        float result = 0;
        for (int i = 0; i < this.reservations.size(); i++) {
            result += this.reservations.get(i).getTotalPrice();
        }
        return result;
    }

}
