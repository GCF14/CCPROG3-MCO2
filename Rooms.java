// package prog_mco2;
import java.util.ArrayList;


/**Rooms class that contains the number of standard, deluxe, and executive rooms, and the room names.
 */
public class Rooms {
    private int standard;
    private int deluxe;
    private int executive;
    private ArrayList<Integer> roomNames;

    /** Constructor for Rooms 
     */
    public Rooms() {
        this.roomNames = new ArrayList<Integer>();
    }

    /** Returns the number of standard rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return standard - The number of standard rooms
     */
    public int getStandard() {
        return this.standard;
    }

    /** Returns the number of deluxe rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return deluxe - The number of deluxe rooms
     */
    public int getDeluxe() {
        return this.deluxe;
    }

    /** Returns the number of executive rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return executive - The number of executive rooms
     */
    public int getExecutive() {
        return this.executive;
    }

    /** Returns the list of room names
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an ArrayList of integers
     * @return roomNames - The list of room names
     */
    public ArrayList<Integer> getRoomNames() {
        return this.roomNames;
    }

    /** Sets the number of standard rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: The number of standard rooms is set
     * @param standard - The number of standard rooms
     */
    public void setStandard(int standard) {
        this.standard = standard;
    }

    /** Sets the number of deluxe rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: The number of deluxe rooms is set
     * @param deluxe - The number of deluxe rooms
     */
    public void setDeluxe(int deluxe) {
        this.deluxe = deluxe;
    }

    /** Sets the number of executive rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: The number of executive rooms is set
     * @param executive - The number of executive rooms
     */
    public void setExecutive(int executive) {
        this.executive = executive;  
    }

    /** Returns the total number of rooms
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return standard + deluxe + executive - The total number of rooms
     */
    public int getTotal() {
        return this.standard + this.deluxe + this.executive;
    }

    /** Sets the room names
     * Preconditions: Rooms object is initialized
     * Postconditions: The room names are set
     */
    public void setRoomNames() {
        for (int i = 0; i < this.getTotal(); i++)
            this.roomNames.add(i+1);
    }

    /** Adds a room name
     * Preconditions: Rooms object is initialized
     * Postconditions: A room name is added
     */
    public void addRoomNames() {
        this.roomNames.add(this.roomNames.size()+1);
    }
    /*
     * Added the following functions just cus theyre reused a lot
     * Just for the first/last rooms of the specific room types
     */

    /** Returns the last standard room
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return standard - The last standard room
     */
    public int lastStandard() {
        return this.standard;
    }

    /** Returns the first deluxe room
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return standard + 1 - The first deluxe room
     */
    public int firstDeluxe() {
        return this.standard + 1;
    }

    /** Returns the last deluxe room
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return standard + deluxe - The last deluxe room
     */
    public int lastDeluxe() {
        return this.standard + this.deluxe;
    }

    /** Returns the first executive room
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return lastDeluxe() + 1 - The first executive room
     */
    public int firstExecutive() {
        return this.lastDeluxe() + 1;
    }

    /** Returns the last executive room
     * Preconditions: Rooms object is initialized
     * Postconditions: returns an integer
     * @return lastDeluxe() + executive - The last executive room
     */
    public int lastExecutive() {
        return this.lastDeluxe() + this.executive;
    }

}
