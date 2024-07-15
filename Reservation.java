package prog_mco2;
/**Reservation class that contains the guest name, check in date, check out date, and room number.
 */
public class Reservation {

    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private int roomNumber;

    /** Constructor for Reservation
     * Preconditions: guestName is a String, checkInDate is an integer, checkOutDate is an integer, roomNumber is an integer
     * Postconditions: Reservation object is initialized
     * @param guestName - The name of the guest
     * @param checkInDate - The check in date of the guest
     * @param checkOutDate - The check out date of the guest
     * @param roomNumber - The room number of the guest
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, int roomNumber) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNumber = roomNumber;
    }

    /** Returns the name of the guest
     * Preconditions: Reservation object is initialized
     * Postconditions: returns a String
     * @return guestName - The name of the guest
     */
    public String getGuestName() {
        return this.guestName;
    }

    /** Returns the number of nights spent by the guest
     * Preconditions: Instance of Reservation is initialized and checkOutDate and checkInDate are integers
     * Postconditions: returns an integer
     * @return checkOutDate - checkInDate (The number of nights spent by the guest)
     */
    public int getNightSpent(){ 
        return this.checkOutDate - this.checkInDate;
    }

    /** Returns the check in date of the guest
     * Preconditions: Instance of Reservation is initialized
     * Postconditions: returns an integer
     * @return checkInDate - The check in date of the guest
     */
    public int getCheckInDate() {
        return this.checkInDate;
    }

    /** Returns the check out date of the guest
     * Preconditions: Instance of Reservation is initialized
     * Postconditions: returns an integer
     * @return checkOutDate - The check out date of the guest
     */
    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    /** Returns the room number of the guest
     * Preconditions: Instance of Reservation is initialized
     * Postconditions: returns an integer
     * @return roomNumber - The room number of the guest
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }
}
