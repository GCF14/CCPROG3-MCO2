// package prog_mco2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;


public class HotelGui extends JFrame {
    public HotelGui() {
        super("Hotel Reservation System"); //this will give the gui a name at the top when it opens
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it close when we press x
        setSize(800, 600); //this is the size of gui
        setLocationRelativeTo(null); // this centers the frame on the screen when we open the gui 
        setLayout(null); // Set layout to null (not recommended, consider using LayoutManagers)
        //I forgot what setLayout does better check up on that but make it null
        setResizable(true); // Makes us resize the frame to whatever

        addComponents();
        setVisible(true); 
    }

    private void addComponents(){

        //this will be the section for the title
        JLabel title = new JLabel("Hotel Reservation System", JLabel.CENTER);
        Font titleFont = new Font(title.getFont().getName(), title.getFont().getStyle(), 36);
        title.setFont(titleFont);
        title.setBounds(50, 50, 700, 50);
        add(title);

       
        // Font for Buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        // Create and add buttons
        JButton createHotelButton = new JButton("Create Hotel");
        createHotelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createHotelButton.setFont(buttonFont);
        createHotelButton.setBounds(275, 150, 275, 60);
        add(createHotelButton);

        JButton viewInfoButton = new JButton("View Hotel Information");
        viewInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewInfoButton.setFont(buttonFont);
        viewInfoButton.setBounds(275, 150 + 60 + 20, 275, 60); // Increased gap
        add(viewInfoButton);

        JButton manageButton = new JButton("Manage Hotel");
        manageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        manageButton.setFont(buttonFont);
        manageButton.setBounds(275, 150 + 2 * (60 + 20), 275, 60);
        add(manageButton);

        JButton bookingButton = new JButton("Simulate Booking");
        bookingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookingButton.setFont(buttonFont);
        bookingButton.setBounds(275, 150 + 3 * (60 + 20), 275, 60);
        add(bookingButton);



    }
}
