package prog_mco2;

import javax.swing.JFrame;

public class HotelGui extends JFrame {
    public HotelGui() {
        super("Hotel Reservation System"); //this will give the gui a name at the top when it opens
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it close when we press x
        setSize(800, 600); //this is the size of gui
        setLocationRelativeTo(null); // this centers the frame on the screen when we open the gui 
        setLayout(null); // Set layout to null (not recommended, consider using LayoutManagers)
        //I forgot what setLayout does better check up on that but make it null
        setResizable(true); // Makes us resize the frame to whatever

        setVisible(true); 
    }
}
