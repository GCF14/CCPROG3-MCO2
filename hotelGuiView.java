import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class hotelGuiView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JTextField nameField;
    private JTextField standardRoomField;
    private JTextField deluxeRoomField;
    private JTextField executiveRoomField;
    private JButton createButton;


    // Declare buttons at class level
    private JButton highLevelButton;
    private JButton lowLevelButton;
    private JButton backToViewHotelFromHighLevel;
    private JButton backToViewHotelFromLowLevel;

    private JButton createHotelButton;
    private JButton viewInfoButton;
    private JButton manageButton;
    private JButton bookingButton;
    private JButton backButton;
    private JButton backButton2;
    private JButton backButton3;
    private JButton backButton4;

    private JPanel highLevelPanel;

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
        createHotelModel model = new createHotelModel(); // Create model instance
        hotelController controller = new hotelController(this, model);
        viewHotelController viewController = new viewHotelController(this, model);
        createHotelController createHotel = new createHotelController(this, model);
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

        createHotelButton = new JButton("Create Hotel");
        createHotelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        createHotelButton.setFont(buttonFont);
        createHotelButton.setBounds(275, 150, 275, 60);
        homePanel.add(createHotelButton);

        viewInfoButton = new JButton("View Hotel Information");
        viewInfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewInfoButton.setFont(buttonFont);
        viewInfoButton.setBounds(275, 230, 275, 60);
        homePanel.add(viewInfoButton);

        manageButton = new JButton("Manage Hotel");
        manageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        manageButton.setFont(buttonFont);
        manageButton.setBounds(275, 310, 275, 60);
        homePanel.add(manageButton);

        bookingButton = new JButton("Simulate Booking");
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

        backButton2 = new JButton("Back");
        backButton2.setBounds(680, 500, 100, 50); // Center the Back button
        backButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton2.setFont(new Font("Arial", Font.BOLD, 16));
        viewHotelPanel.add(backButton2);

        mainPanel.add(viewHotelPanel, "viewHotel");


        // High Level Information Panel
        highLevelPanel = new JPanel(null);
        highLevelPanel.setSize(900, 700);
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
        JLabel manageHotelTitle = new JLabel("Manage Hotel", JLabel.CENTER);
        manageHotelTitle.setFont(new Font(manageHotelTitle.getFont().getName(), manageHotelTitle.getFont().getStyle(), 36));
        manageHotelTitle.setBounds(200, 50, 400, 50);
        manageHotelPanel.add(manageHotelTitle);

        backButton3 = new JButton("Back");
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

        backButton4 = new JButton("Back");
        Font buttonFont4 = new Font("Arial", Font.BOLD, 16);
        backButton4.setBounds(680, 500, 100, 50);
        backButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton4.setFont(buttonFont4);
        simulateBookingPanel.add(backButton4);

        mainPanel.add(simulateBookingPanel, "simulateBooking");


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

    public void addCreateHotelButtonListener(ActionListener listener) {
        createHotelButton.addActionListener(listener);
    }

    public void addViewInfoButtonListener(ActionListener listener) {
        viewInfoButton.addActionListener(listener);
    }

    public void addManageButtonListener(ActionListener listener) {
        manageButton.addActionListener(listener);
    }

    public void addBookingButtonListener(ActionListener listener) {
        bookingButton.addActionListener(listener);
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

    // Add methods to register the back button listeners
    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addBackButtonListener2(ActionListener listener) {
        backButton2.addActionListener(listener);
    }

    public void addBackButtonListener3(ActionListener listener) {
        backButton3.addActionListener(listener);
    }

    public void addBackButtonListener4(ActionListener listener) {
        backButton4.addActionListener(listener);
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

    //Displays and asks user to pick hotel from list of hotels
    public Hotel getHotelOptions(ArrayList<Hotel> hotels) {
        if (hotels.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hotels available.");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    getCardLayout().show(getMainPanel(), "home");
                }
            });
            return null;
        }
    
        String[] options = new String[hotels.size()];
        for (int i = 0; i < hotels.size(); i++) {
            options[i] = hotels.get(i).getName();
        }
    
        int result = JOptionPane.showOptionDialog(this, "Choose a hotel", "Hotel Options",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    
        if (result != -1) {
            return hotels.get(result); // Return the Hotel object based on selected index
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    getCardLayout().show(getMainPanel(), "viewHotel");
                }
            });
            return null;
        }


    }


    public JPanel getHighLevelPanel(){
        return highLevelPanel;
        
    }

    /*
     * If we have time lets add pictures of the standard, deluxe, and executive rooms
     */
    public void displayHighLevelInfo(Hotel hotel) {
        if (hotel != null) {
            highLevelPanel.removeAll();
    
            // Title label
            JLabel highLevelLabel = new JLabel("High Level Information", JLabel.CENTER);
            highLevelLabel.setBounds(0, 20, 800, 50); // Adjust bounds to span full width
            highLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
            highLevelPanel.add(highLevelLabel);
    
            // Hotel name label
            JLabel nameLabel = new JLabel(hotel.getName(), JLabel.CENTER);
            Font nameLabelFont = new Font("Arial", Font.BOLD, 40); // Larger font size for hotel name
            nameLabel.setFont(nameLabelFont);
            nameLabel.setBounds(0, 80, 800, 60); // Increased height to ensure full text visibility
            highLevelPanel.add(nameLabel);
    
            // Room details labels
            Font detailFont = new Font("Arial", Font.PLAIN, 24); // Larger font size for other labels
    
            JLabel totalRoomsLabel = new JLabel("Number of rooms: " + hotel.getRooms().getTotal());
            totalRoomsLabel.setFont(detailFont);
            totalRoomsLabel.setBounds(200, 140, 400, 40); // Increased height
            highLevelPanel.add(totalRoomsLabel);
    
            JLabel standardLabel = new JLabel("Standard: " + hotel.getRooms().getStandard());
            standardLabel.setFont(detailFont);
            standardLabel.setBounds(200, 180, 400, 40); // Increased height
            highLevelPanel.add(standardLabel);
    
            JLabel deluxeLabel = new JLabel("Deluxe: " + hotel.getRooms().getDeluxe());
            deluxeLabel.setFont(detailFont);
            deluxeLabel.setBounds(200, 220, 400, 40); // Increased height
            highLevelPanel.add(deluxeLabel);
    
            JLabel executiveLabel = new JLabel("Executive: " + hotel.getRooms().getExecutive());
            executiveLabel.setFont(detailFont);
            executiveLabel.setBounds(200, 260, 400, 40); // Increased height
            highLevelPanel.add(executiveLabel);
    
            // Price per night label
            JLabel priceLabel = new JLabel("Price per night", JLabel.CENTER);
            Font priceLabelFont = new Font("Arial", Font.BOLD, 30); // Larger font size for price label
            priceLabel.setFont(priceLabelFont);
            priceLabel.setBounds(200, 290, 400, 60); // Increased height
            highLevelPanel.add(priceLabel);
    
            JLabel standardPriceLabel = new JLabel("Standard: " + hotel.getRoomPrice());
            standardPriceLabel.setFont(detailFont);
            standardPriceLabel.setBounds(200, 340, 400, 40); // Increased height
            highLevelPanel.add(standardPriceLabel);
    
            JLabel deluxePriceLabel = new JLabel("Deluxe: " + hotel.getDeluxePrice());
            deluxePriceLabel.setFont(detailFont);
            deluxePriceLabel.setBounds(200, 380, 400, 40); // Increased height
            highLevelPanel.add(deluxePriceLabel);
    
            JLabel executivePriceLabel = new JLabel("Executive: " + hotel.getExecutivePrice());
            executivePriceLabel.setFont(detailFont);
            executivePriceLabel.setBounds(200, 420, 400, 40); // Increased height
            highLevelPanel.add(executivePriceLabel);
    
            JLabel earningsLabel = new JLabel("Estimate earnings for the month: " + hotel.getTotalEarnings());
            earningsLabel.setFont(detailFont);
            earningsLabel.setBounds(200, 460, 400, 40); // Increased height
            highLevelPanel.add(earningsLabel);
    
            // Back button
            highLevelPanel.add(backToViewHotelFromHighLevel);
    
            highLevelPanel.revalidate();
            highLevelPanel.repaint();
    
            getCardLayout().show(getMainPanel(), "highLevel");
        }
    }

    
    

    public void displayLowLevelInfo(Hotel hotel) {
        if (hotel != null) {
            highLevelPanel.removeAll();
            JLabel highLevelLabel = new JLabel("High Level Information", JLabel.CENTER);
            highLevelLabel.setBounds(200, 50, 400, 50);
            highLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
            highLevelPanel.add(highLevelLabel);

            JLabel nameLabel = new JLabel("Name of hotel: " + hotel.getName());
            nameLabel.setBounds(200, 120, 400, 30);
            highLevelPanel.add(nameLabel);

            JLabel totalRoomsLabel = new JLabel("Number of rooms: " + hotel.getRooms().getTotal());
            totalRoomsLabel.setBounds(200, 160, 400, 30);
            highLevelPanel.add(totalRoomsLabel);

            JLabel standardLabel = new JLabel("\tStandard: " + hotel.getRooms().getStandard());
            standardLabel.setBounds(200, 200, 400, 30);
            highLevelPanel.add(standardLabel);

            JLabel deluxeLabel = new JLabel("\tDeluxe: " + hotel.getRooms().getDeluxe());
            deluxeLabel.setBounds(200, 240, 400, 30);
            highLevelPanel.add(deluxeLabel);

            JLabel executiveLabel = new JLabel("\tExecutive: " + hotel.getRooms().getExecutive());
            executiveLabel.setBounds(200, 280, 400, 30);
            highLevelPanel.add(executiveLabel);

            JLabel priceLabel = new JLabel("Price per night:");
            priceLabel.setBounds(200, 320, 400, 30);
            highLevelPanel.add(priceLabel);

            JLabel standardPriceLabel = new JLabel("\tStandard: " + hotel.getRoomPrice());
            standardPriceLabel.setBounds(200, 360, 400, 30);
            highLevelPanel.add(standardPriceLabel);

            JLabel deluxePriceLabel = new JLabel("\tDeluxe: " + hotel.getDeluxePrice());
            deluxePriceLabel.setBounds(200, 400, 400, 30);
            highLevelPanel.add(deluxePriceLabel);

            JLabel executivePriceLabel = new JLabel("\tExecutive: " + hotel.getExecutivePrice());
            executivePriceLabel.setBounds(200, 440, 400, 30);
            highLevelPanel.add(executivePriceLabel);

            JLabel earningsLabel = new JLabel("Estimate earnings for the month: " + hotel.getTotalEarnings());
            earningsLabel.setBounds(200, 480, 400, 30);
            highLevelPanel.add(earningsLabel);

            highLevelPanel.add(backToViewHotelFromHighLevel);

            highLevelPanel.revalidate();
            highLevelPanel.repaint();

            getCardLayout().show(getMainPanel(), "highLevel");
        }
    }

    public JButton getBackButton2(){
        return backButton2;
    }
    
    public void setHotelName(String name) {
        nameField.setText(name);
    }
    
    public void setStandardRooms(int rooms) {
        standardRoomField.setText(String.valueOf(rooms));
    }
    
    public void setDeluxeRooms(int rooms) {
        deluxeRoomField.setText(String.valueOf(rooms));
    }
    
    public void setExecutiveRooms(int rooms) {
        executiveRoomField.setText(String.valueOf(rooms));
    }

    public void clearHotelFields() {
        setHotelName("");
        setStandardRooms(0);
        setDeluxeRooms(0);
        setExecutiveRooms(0);
    }
    
    

    

}
