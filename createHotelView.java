import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class createHotelView extends JFrame {
    private JTextField nameField;
    private JTextField standardRoomField;
    private JTextField deluxeRoomField;
    private JTextField executiveRoomField;
    private JButton createButton;
    private JButton backButton;

    public createHotelView() {
        super("Create Hotel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        // Initialize components
        JLabel guiLabel = new JLabel("Create Hotel", JLabel.CENTER);
        guiLabel.setFont(new Font(guiLabel.getFont().getName(), guiLabel.getFont().getStyle(), 36));
        guiLabel.setBounds(200, 50, 400, 50);
        add(guiLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 22));
        nameLabel.setBounds(90, 150, 200, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(350, 150, 300, 35);
        add(nameField);

        JLabel standardLabel = new JLabel("No. Standard Rooms:");
        standardLabel.setFont(new Font(standardLabel.getFont().getName(), standardLabel.getFont().getStyle(), 22));
        standardLabel.setBounds(90, 200, 300, 30);
        add(standardLabel);

        standardRoomField = new JTextField();
        standardRoomField.setBounds(350, 200, 300, 35);
        add(standardRoomField);

        JLabel deluxeLabel = new JLabel("No. Deluxe Rooms:");
        deluxeLabel.setFont(new Font(deluxeLabel.getFont().getName(), deluxeLabel.getFont().getStyle(), 22));
        deluxeLabel.setBounds(90, 250, 300, 30);
        add(deluxeLabel);

        deluxeRoomField = new JTextField();
        deluxeRoomField.setBounds(350, 250, 300, 35);
        add(deluxeRoomField);

        JLabel executiveLabel = new JLabel("No. Executive Rooms:");
        executiveLabel.setFont(new Font(executiveLabel.getFont().getName(), executiveLabel.getFont().getStyle(), 22));
        executiveLabel.setBounds(90, 300, 300, 30);
        add(executiveLabel);

        executiveRoomField = new JTextField();
        executiveRoomField.setBounds(350, 300, 300, 35);
        add(executiveRoomField);

        createButton = new JButton("Create");
        createButton.setBounds(330, 400, 150, 50);
        createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(createButton);

        backButton = new JButton("Back");
        backButton.setBounds(680, 500, 100, 50);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(backButton);

        setVisible(true);
    }

    public String getHotelName() {
        return nameField.getText();
    }

    public int getStandardRooms() {
        return Integer.parseInt(standardRoomField.getText());
    }

    public int getDeluxeRooms() {
        return Integer.parseInt(deluxeRoomField.getText());
    }

    public int getExecutiveRooms() {
        return Integer.parseInt(executiveRoomField.getText());
    }

    public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
