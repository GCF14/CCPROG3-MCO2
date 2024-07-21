import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font; // Import Font class
import java.awt.Cursor;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewHotelView extends JFrame { // Extend JFrame
    public viewHotelView() {
        super("View Hotel Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel guiLabel= new JLabel("View Hotel Information", JLabel.CENTER);
        Font labelFont = new Font(guiLabel.getFont().getName(), guiLabel.getFont().getStyle(), 36);
        guiLabel.setFont(labelFont);
        guiLabel.setBounds(50, 50, 700, 50);
        add(guiLabel);


        JButton backButton = new JButton("Back");
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFont(buttonFont);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HotelGui();
                dispose();
            }
        });

        // Calculate button bounds for bottom-right positioning
        int buttonWidth = 100;
        int buttonHeight = 50;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int x = frameWidth - buttonWidth - 50; // 50 pixels margin from the right edge
        int y = frameHeight - buttonHeight - 50; // 50 pixels margin from the bottom edge
        backButton.setBounds(x, y, buttonWidth, buttonHeight);
        add(backButton);



        setVisible(true);
    }
}