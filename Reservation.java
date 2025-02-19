// package prog_mco2;


/**Reservation class that contains the guest name, check in date, check out date, room number, and total price of booking.
 */
public class Reservation {

    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private int roomNumber;
    private float totalPrice;
    private int discountCode;

    /** Constructor for Reservation
     * Preconditions: guestName is a String, checkInDate is an integer, checkOutDate is an integer, roomNumber is an integer
     * Postconditions: Reservation object is initialized
     * @param guestName - The name of the guest
     * @param checkInDate - The check in date of the guest
     * @param checkOutDate - The check out date of the guest
     * @param roomNumber - The room number of the guest
     * @param totalPrice - The total price of the booking
     * @param discountCode - Integer to represent a discount code
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, int roomNumber, float totalPrice, int discountCode) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNumber = roomNumber;
        this.totalPrice = totalPrice;
        this.discountCode = discountCode;
    }

    /** Returns the name of the guest
     * Preconditions: Reservation object is initialized
     * Postconditions: returns a String
     * @return guestName - The name of the guest
     */
    public String getGuestName() {
        return this.guestName;
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

    /** Returns the total price of the booking
     * Preconditions: Instance of Reservation is initialized
     * Postconditions: returns a float
     * @return totalPrice - The total price of the booking
     */
    public float getTotalPrice() {
        return this.totalPrice;
    }

    /** Returns the discount code of the booking
     * Preconditions: Instance of Reservation is initialized
     * Postconditions: returns an integer
     * @return discountCode - The discount code used in the booking
     */
    public int getDiscountCode() {
        return this.discountCode;
    }

    /**
     * Sets the name of the guest
     * @param  guestName - The name of the guest
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * Sets the check in date of the guest
     * @param checkInDate - The check in date of the guest
     */
    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * Sets the check out date of the guest
     * @param checkOutDate - The check out date of the guest
     */
    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * Sets the room number of the guest
     * @param roomNumber - The room number of the guest
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Sets the total price of the booking
     * @param totalPrice - The total price of the booking
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
