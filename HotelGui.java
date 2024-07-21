import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelGui extends JFrame {
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    
    public HotelGui() {
        super("Hotel Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(true);

        addComponents();
        setVisible(true);

        //This is for when HoteGui extends newFrame if ever which you think is better extend from JFrame or newFrame?
        // super("Hotel Reservation System");
        // addComponents();
        // addComponents()
        // setVisible(true);

    }

    private void addComponents() {
        JLabel title = new JLabel("Hotel Reservation System", JLabel.CENTER);
        Font titleFont = new Font(title.getFont().getName(), title.getFont().getStyle(), 36);
        title.setFont(titleFont);
        title.setBounds(50, 50, 700, 50);
        add(title);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        JButton createHotelButton = new JButton("Create Hotel");
        createHotelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createHotelButton.setFont(buttonFont);
        createHotelButton.setBounds(275, 150, 275, 60);
        add(createHotelButton);

        JButton viewInfoButton = new JButton("View Hotel Information");
        viewInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewInfoButton.setFont(buttonFont);
        viewInfoButton.setBounds(275, 150 + 60 + 20, 275, 60);
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

        createHotelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new createHotelView();
                dispose();
            }
        });

        viewInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new viewHotelView();
                dispose();
            }
        });

        manageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new manageHotelGui();
                dispose();
            }
        });

        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new simulateBookingView();
                dispose();
            }
        });
    }

}
