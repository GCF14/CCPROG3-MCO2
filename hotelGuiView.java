import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class hotelGuiView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JTextField nameField;
    private JTextField standardRoomField;
    private JTextField deluxeRoomField;
    private JTextField executiveRoomField;
    private JButton createButton;
    private JButton backButton;

    // Declare buttons at class level
    private JButton highLevelButton;
    private JButton lowLevelButton;
    private JButton backToViewHotelFromHighLevel;
    private JButton backToViewHotelFromLowLevel;

    public hotelGuiView() {
        super("Hotel Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addComponents();

        add(mainPanel);
        setVisible(true);

        // Initialize controllers with the view (this) and model
        createHotelController createController = new createHotelController(this, new hotelModel());
        viewHotelController viewController = new viewHotelController(this, new hotelModel());
    }

    private void addComponents() {
        // Home page portion
        JPanel homePanel = new JPanel(null);
        JLabel title = new JLabel("Hotel Reservation System", JLabel.CENTER);
        Font titleFont = new Font(title.getFont().getName(), title.getFont().getStyle(), 36);
        title.setFont(titleFont);
        title.setBounds(50, 50, 700, 50);
        homePanel.add(title);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        JButton createHotelButton = new JButton("Create Hotel");
        createHotelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createHotelButton.setFont(buttonFont);
        createHotelButton.setBounds(275, 150, 275, 60);
        homePanel.add(createHotelButton);

        JButton viewInfoButton = new JButton("View Hotel Information");
        viewInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewInfoButton.setFont(buttonFont);
        viewInfoButton.setBounds(275, 230, 275, 60);
        homePanel.add(viewInfoButton);

        JButton manageButton = new JButton("Manage Hotel");
        manageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        manageButton.setFont(buttonFont);
        manageButton.setBounds(275, 310, 275, 60);
        homePanel.add(manageButton);

        JButton bookingButton = new JButton("Simulate Booking");
        bookingButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookingButton.setFont(buttonFont);
        bookingButton.setBounds(275, 390, 275, 60);
        homePanel.add(bookingButton);

        mainPanel.add(homePanel, "home");

        // Create Hotel Portion
        JPanel createHotelPanel = new JPanel(null);
        JLabel createTitle = new JLabel("Create Hotel", JLabel.CENTER);
        createTitle.setFont(new Font(createTitle.getFont().getName(), createTitle.getFont().getStyle(), 36));
        createTitle.setBounds(200, 50, 400, 50);
        createHotelPanel.add(createTitle);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 22));
        nameLabel.setBounds(90, 150, 200, 30);
        createHotelPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(350, 150, 300, 35);
        createHotelPanel.add(nameField);

        JLabel standardLabel = new JLabel("No. Standard Rooms:");
        standardLabel.setFont(new Font(standardLabel.getFont().getName(), standardLabel.getFont().getStyle(), 22));
        standardLabel.setBounds(90, 200, 300, 30);
        createHotelPanel.add(standardLabel);

        standardRoomField = new JTextField();
        standardRoomField.setBounds(350, 200, 300, 35);
        createHotelPanel.add(standardRoomField);

        JLabel deluxeLabel = new JLabel("No. Deluxe Rooms:");
        deluxeLabel.setFont(new Font(deluxeLabel.getFont().getName(), deluxeLabel.getFont().getStyle(), 22));
        deluxeLabel.setBounds(90, 250, 300, 30);
        createHotelPanel.add(deluxeLabel);

        deluxeRoomField = new JTextField();
        deluxeRoomField.setBounds(350, 250, 300, 35);
        createHotelPanel.add(deluxeRoomField);

        JLabel executiveLabel = new JLabel("No. Executive Rooms:");
        executiveLabel.setFont(new Font(executiveLabel.getFont().getName(), executiveLabel.getFont().getStyle(), 22));
        executiveLabel.setBounds(90, 300, 300, 30);
        createHotelPanel.add(executiveLabel);

        executiveRoomField = new JTextField();
        executiveRoomField.setBounds(350, 300, 300, 35);
        createHotelPanel.add(executiveRoomField);

        createButton = new JButton("Create");
        createButton.setBounds(330, 400, 150, 50);
        createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createButton.setFont(new Font("Arial", Font.BOLD, 16));
        createHotelPanel.add(createButton);

        backButton = new JButton("Back");
        backButton.setBounds(680, 500, 100, 50);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        createHotelPanel.add(backButton);

        mainPanel.add(createHotelPanel, "createHotel");

        // View Hotel Portion
        JPanel viewHotelPanel = new JPanel(null);
        viewHotelPanel.setPreferredSize(new Dimension(800, 600)); // Optional: Set preferred size if needed

        JLabel viewHotelTitle = new JLabel("View Hotel Information", JLabel.CENTER);
        viewHotelTitle.setFont(new Font(viewHotelTitle.getFont().getName(), viewHotelTitle.getFont().getStyle(), 36));
        viewHotelTitle.setBounds(200, 50, 400, 50);
        viewHotelPanel.add(viewHotelTitle);

        // Define button dimensions
        int buttonWidth = 500;
        int buttonHeight = 70;

        // Calculate button positions
        int panelWidth = 800; // Assuming panel width is 800
        int buttonX = (panelWidth - buttonWidth) / 2; // Center horizontally

        // Initialize highLevelButton and lowLevelButton
        highLevelButton = new JButton("View High Level Information");
        highLevelButton.setBounds(buttonX, 200, buttonWidth, buttonHeight);
        highLevelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        highLevelButton.setFont(new Font("Arial", Font.BOLD, 30));
        viewHotelPanel.add(highLevelButton);

        lowLevelButton = new JButton("View Low Level Information");
        lowLevelButton.setBounds(buttonX, 300, buttonWidth, buttonHeight);
        lowLevelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lowLevelButton.setFont(new Font("Arial", Font.BOLD, 30));
        viewHotelPanel.add(lowLevelButton);

        JButton backButton2 = new JButton("Back");
        backButton2.setBounds(680, 500, 100, 50); // Center the Back button
        backButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton2.setFont(new Font("Arial", Font.BOLD, 16));
        viewHotelPanel.add(backButton2);

        mainPanel.add(viewHotelPanel, "viewHotel");


        // High Level Information Panel
        JPanel highLevelPanel = new JPanel(null);
        JLabel highLevelLabel = new JLabel("High Level Information", JLabel.CENTER);
        highLevelLabel.setBounds(200, 50, 400, 50); // Adjust the bounds as needed
        highLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
        highLevelPanel.add(highLevelLabel);

        backToViewHotelFromHighLevel = new JButton("Back");
        backToViewHotelFromHighLevel.setBounds(680, 500, 100, 50);
        backToViewHotelFromHighLevel.setFont(new Font("Arial", Font.BOLD, 16));
        highLevelPanel.add(backToViewHotelFromHighLevel);

        mainPanel.add(highLevelPanel, "highLevel");

        // Low Level Information Panel
        JPanel lowLevelPanel = new JPanel(null);
        JLabel lowLevelLabel = new JLabel("Low Level Information", JLabel.CENTER);
        lowLevelLabel.setBounds(200, 50, 400, 50); // Adjust the bounds as needed
        lowLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
        lowLevelPanel.add(lowLevelLabel);

        backToViewHotelFromLowLevel = new JButton("Back");
        backToViewHotelFromLowLevel.setBounds(680, 500, 100, 50);
        backToViewHotelFromLowLevel.setFont(new Font("Arial", Font.BOLD, 16));
        lowLevelPanel.add(backToViewHotelFromLowLevel);

        mainPanel.add(lowLevelPanel, "lowLevel");








        // Manage Hotel portion
        JPanel manageHotelPanel = new JPanel(null);
        JLabel manageHotelTitle = new JLabel("View Hotel Information", JLabel.CENTER);
        manageHotelTitle.setFont(new Font(manageHotelTitle.getFont().getName(), manageHotelTitle.getFont().getStyle(), 36));
        manageHotelTitle.setBounds(200, 50, 400, 50);
        manageHotelPanel.add(manageHotelTitle);

        JButton backButton3 = new JButton("Back");
        Font buttonFont3 = new Font("Arial", Font.BOLD, 16);
        backButton3.setBounds(680, 500, 100, 50);
        backButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton3.setFont(buttonFont3);
        manageHotelPanel.add(backButton3);

        mainPanel.add(manageHotelPanel, "manageHotel");

        // Simulate Booking Portion
        JPanel simulateBookingPanel = new JPanel(null);
        JLabel simulateBookingTitle = new JLabel("Simulate Booking", JLabel.CENTER);
        simulateBookingTitle.setFont(new Font(simulateBookingTitle.getFont().getName(), simulateBookingTitle.getFont().getStyle(), 36));
        simulateBookingTitle.setBounds(200, 50, 400, 50);
        simulateBookingPanel.add(simulateBookingTitle);

        JButton backButton4 = new JButton("Back");
        Font buttonFont4 = new Font("Arial", Font.BOLD, 16);
        backButton4.setBounds(680, 500, 100, 50);
        backButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton4.setFont(buttonFont4);
        simulateBookingPanel.add(backButton4);

        mainPanel.add(simulateBookingPanel, "simulateBooking");

        // Add action listener portions
        viewInfoButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "viewHotel");
            highLevelButton.setVisible(true); // Reset visibility when switching to viewHotel panel
            lowLevelButton.setVisible(true);  // Reset visibility when switching to viewHotel panel
            
        });
        createHotelButton.addActionListener(e -> cardLayout.show(mainPanel, "createHotel"));
        viewInfoButton.addActionListener(e -> cardLayout.show(mainPanel, "viewHotel"));
        manageButton.addActionListener(e -> cardLayout.show(mainPanel, "manageHotel"));
        bookingButton.addActionListener(e -> cardLayout.show(mainPanel, "simulateBooking"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        backButton2.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        backButton3.addActionListener(e -> cardLayout.show(mainPanel, "home"));
        backButton4.addActionListener(e -> cardLayout.show(mainPanel, "home"));
    }

    public boolean validateRooms() {
        try {
            int standard = Integer.parseInt(standardRoomField.getText());
            int deluxe = Integer.parseInt(deluxeRoomField.getText());
            int executive = Integer.parseInt(executiveRoomField.getText());
            int total = standard + deluxe + executive;

            if (total > 50) {
                JOptionPane.showMessageDialog(this, "Total number of rooms cannot exceed 50. Please enter again.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for all room types.");
            return false;
        }
    }

    public void addNewComponents() {
        // Get the viewHotelPanel
        JPanel viewHotelPanel = (JPanel) mainPanel.getComponent(2); // Assuming viewHotelPanel is at index 1

        JLabel nameLabel2 = new JLabel("Pick a hotel:");
        nameLabel2.setFont(new Font(nameLabel2.getFont().getName(), nameLabel2.getFont().getStyle(), 22));
        nameLabel2.setBounds(90, 150, 200, 30);
        viewHotelPanel.add(nameLabel2);

        
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

    public void addHighLevelButtonListener(ActionListener listener) {
        highLevelButton.addActionListener(listener);
    }

    public void addLowLevelButtonListener(ActionListener listener) {
        lowLevelButton.addActionListener(listener);
    }

    public JButton backToViewHotelFromLowLevel() {
        return backToViewHotelFromLowLevel;
    }
    
    public JButton backToViewHotelFromHighLevel() {
        return backToViewHotelFromHighLevel;
    }





    // Public getters for cardLayout and mainPanel
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getHighLevelButton() {
        return highLevelButton;
    }
    
    public JButton getLowLevelButton() {
        return lowLevelButton;
    }

    // Call this method from the controller when needed
    public void displayNewComponents() {
        addNewComponents();
    }
}
