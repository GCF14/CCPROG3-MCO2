// package prog_mco2;
import java.util.ArrayList;
public class Rooms {
    private int standard;
    private int deluxe;
    private int executive;
    private ArrayList<Integer> roomNames;
    public Rooms() {
        this.roomNames = new ArrayList<Integer>();
    }

    public int getStandard() {
        return this.standard;
    }
    public int getDeluxe() {
        return this.deluxe;
    }
    public int getExecutive() {
        return this.executive;
    }
    public ArrayList<Integer> getRoomNames() {
        return this.roomNames;
    }
    public void setStandard(int standard) {
        
            this.standard = standard;
        
        
    }
    public void setDeluxe(int deluxe) {
        
            this.deluxe = deluxe;
        
    }
    public void setExecutive(int executive) {

        
            this.executive = executive;
        
        
    }
    public int getTotal() {
        return this.standard + this.deluxe + this.executive;
    }
    public void setRoomNames() {
        for (int i = 0; i < this.getTotal(); i++)
            this.roomNames.add(i+1);
    }
    public void addRoomNames() {
        this.roomNames.add(this.roomNames.size()+1);
    }
    /*
     * Added the following functions just cus theyre reused a lot
     * Just for the first/last rooms of the specific room types
     */
    public int lastStandard() {
        return this.standard;
    }

    public int firstDeluxe() {
        return this.standard + 1;
    }

    public int lastDeluxe() {
        return this.standard + this.deluxe;
    }

    public int firstExecutive() {
        return this.lastDeluxe() + 1;
    }

    public int lastExecutive() {
        return this.lastDeluxe() + this.executive;
    }

}
