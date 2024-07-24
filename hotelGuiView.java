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
    private JButton backButton5;

    private JPanel highLevelPanel;




    //Manage Hotel portion
    private JButton changeName;
    private JPanel changePanel;
    private JTextField changeField;
    private JButton changeNewName;
    private JButton addRoom;
    private JPanel addPanel;
    private JTextField addField;
    private JButton addNewRooms;
    private JButton removeRoom;
    private JPanel removePanel;
    private JTextField removeField;
    private JButton removeNewRooms;
    private JPanel updatePricePanel;
    private JTextField updatePriceField;
    private JButton updatePrice;
    private JButton updateBaseRoomPrice;
    private JButton removeReservation;
    private JPanel reservationsPanel;
    private JPanel lowLevelPanel;


    //Simulate Booking portion
    private JTextField customerNameField;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton bookButton;

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
        manageHotelController manageHotel = new manageHotelController(this, model);
        SimulateBookingController simulateBooking = new SimulateBookingController(this, model);
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
        lowLevelPanel = new JPanel(null);
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

        changeName = new JButton("Change Hotel Name");
        changeName.setBounds(265, 150, 275, 60);  // Adjusted position and size
        changeName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeName.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.setLayout(null);  // Ensure null layout is set
        manageHotelPanel.add(changeName);

        addRoom = new JButton("Add Room(s)");
        addRoom.setBounds(265, 220, 275, 60);  // Adjusted position and size
        addRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addRoom.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(addRoom);

        // Initialization of manageHotelPanel with buttons
        mainPanel.add(manageHotelPanel, "manageHotel");

        removeRoom = new JButton("Remove Room(s)");
        removeRoom.setBounds(265, 290, 275, 60);
        removeRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeRoom.setFont(new Font("Arial", Font.BOLD, 20));

        manageHotelPanel.add(removeRoom);


        updateBaseRoomPrice = new JButton("Update Base Room Price");
        updateBaseRoomPrice.setBounds(265, 360, 275, 60);  // Adjusted position and size
        updateBaseRoomPrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBaseRoomPrice.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(updateBaseRoomPrice);

        removeReservation = new JButton("Remove Reservation");
        removeReservation.setBounds(265, 430, 275, 60);  // Adjusted position and size
        removeReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeReservation.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(removeReservation);




        // Initialization of changePanel with text field and label
        changePanel = new JPanel();
        changePanel.setLayout(null);  // Ensure null layout is set

        JLabel changeTitle = new JLabel("Change Hotel Name", JLabel.CENTER);
        changeTitle.setFont(new Font(changeTitle.getFont().getName(), changeTitle.getFont().getStyle(), 35));
        changeTitle.setBounds(200, 50, 400, 50);  // Adjusted position and size
        changePanel.add(changeTitle);

        JLabel changeLabel = new JLabel("New Name:");
        changeLabel.setFont(new Font(changeLabel.getFont().getName(), changeLabel.getFont().getStyle(), 25));
        changeLabel.setBounds(150, 200, 400, 30);  // Adjusted position and size
        changePanel.add(changeLabel);

        changeField = new JTextField();
        changeField.setBounds(300, 200, 200, 35);  // Adjusted position and size for proper fit
        changePanel.add(changeField);

        changeNewName = new JButton("Change Name");
        changeNewName.setBounds(300, 250, 200, 50);  // Added button for changing the name

        
        changeNewName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeNewName.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        changePanel.add(changeNewName);

        backButton5 = new JButton("Back");
        Font backButton5Font = new Font("Arial", Font.BOLD, 16);
        backButton5.setBounds(680, 500, 100, 50);
        backButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton5.setFont(backButton5Font);
        changePanel.add(backButton5);

        mainPanel.add(changePanel, "changePanel");

        addPanel = new JPanel();
        addPanel.setLayout(null);  // Ensure null layout is set for absolute positioning


        // Add Rooms label at the top center
        JLabel addPanelLabel = new JLabel("Add Rooms", JLabel.CENTER);
        addPanelLabel.setFont(new Font(addPanelLabel.getFont().getName(), addPanelLabel.getFont().getStyle(), 35));
        addPanelLabel.setBounds(200, 50, 400, 50); // Centered at the top
        addPanel.add(addPanelLabel);

        // Label for number of rooms to add
        JLabel addLabel = new JLabel("No. Rooms:");
        addLabel.setFont(new Font("Arial", Font.BOLD, 20));
        addLabel.setBounds(170, 200, 200, 30);
        addPanel.add(addLabel);

        // Text field for input
        addField = new JTextField();
        addField.setBounds(300, 200, 200, 35); 
        addPanel.add(addField);

        // Button to add new rooms
        addNewRooms = new JButton("Add Rooms");
        addNewRooms.setBounds(300, 250, 200, 50); // Adjusted to center the button
        addNewRooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addNewRooms.setFont(new Font("Arial", Font.BOLD, 20));
        addPanel.add(addNewRooms);

        // Add the panel to the main panel
        mainPanel.add(addPanel, "addPanel");

        removePanel = new JPanel();
        removePanel.setLayout(null);  // Ensure null layout is set for absolute positioning

        // Components for removePanel
        JLabel removePanelLabel = new JLabel("Remove Rooms", JLabel.CENTER);
        removePanelLabel.setFont(new Font(removePanelLabel.getFont().getName(), removePanelLabel.getFont().getStyle(), 35));
        removePanelLabel.setBounds(200, 50, 400, 50);
        removePanel.add(removePanelLabel);

        JLabel removeLabel = new JLabel("No. Rooms:");
        removeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        removeLabel.setBounds(170, 200, 200, 30);
        removePanel.add(removeLabel);

        removeField = new JTextField();
        removeField.setBounds(300, 200, 200, 35); 
        removePanel.add(removeField);

        removeNewRooms = new JButton("Remove Rooms");
        removeNewRooms.setBounds(300, 250, 200, 50); // Adjusted to center the button
        removeNewRooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeNewRooms.setFont(new Font("Arial", Font.BOLD, 20));
        removePanel.add(removeNewRooms);
        // Add the panel to the main panel
        mainPanel.add(removePanel, "removePanel");



        updatePricePanel = new JPanel();
        updatePricePanel.setLayout(null);  // Ensure null layout is set for absolute positioning

        // Components for removePanel
        JLabel updatePanelLabel = new JLabel("Update Base Room Price", JLabel.CENTER);
        updatePanelLabel.setFont(new Font(removePanelLabel.getFont().getName(), removePanelLabel.getFont().getStyle(), 35));
        updatePanelLabel.setBounds(200, 50, 400, 50);
        updatePricePanel.add(updatePanelLabel);

        JLabel updateLabel = new JLabel("New Room Price:");
        updateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        updateLabel.setBounds(120, 200, 200, 30);
        updatePricePanel.add(updateLabel);

        updatePriceField = new JTextField();
        updatePriceField.setBounds(300, 200, 200, 35); 
        updatePricePanel.add(updatePriceField);

        updatePrice = new JButton("Update Price");
        updatePrice.setBounds(300, 250, 200, 50); // Adjusted to center the button
        updatePrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updatePrice.setFont(new Font("Arial", Font.BOLD, 20));
        updatePricePanel.add(updatePrice);

        // Add the panel to the main panel
        mainPanel.add(updatePricePanel, "updatePricePanel");

        reservationsPanel = new JPanel();
        JLabel resTitle = new JLabel("Choose a reservation to remove");
        resTitle.setFont(new Font("Arial", Font.BOLD, 30));
        resTitle.setBounds(200, 50, 400, 50);
        mainPanel.add(reservationsPanel, "reservationsPanel");
        

        

        // Simulate Booking Portion
        JPanel simulateBookingPanel = new JPanel(null);
        JLabel simulateBookingTitle = new JLabel("Simulate Booking", JLabel.CENTER);
        simulateBookingTitle.setFont(new Font(simulateBookingTitle.getFont().getName(), simulateBookingTitle.getFont().getStyle(), 36));
        simulateBookingTitle.setBounds(200, 50, 400, 50);
        simulateBookingPanel.add(simulateBookingTitle);

        JLabel customerNameLabel = new JLabel("Enter Customer Name:");
        customerNameLabel.setFont(new Font(customerNameLabel.getFont().getName(), customerNameLabel.getFont().getStyle(), 22));
        customerNameLabel.setBounds(70, 150, 250, 30);
        simulateBookingPanel.add(customerNameLabel);

        customerNameField = new JTextField();
        customerNameField.setBounds(340, 150, 300, 35);
        simulateBookingPanel.add(customerNameField);

        JLabel checkInLabel = new JLabel("Enter check-in day:");
        checkInLabel.setFont(new Font(checkInLabel.getFont().getName(), checkInLabel.getFont().getStyle(), 22));
        checkInLabel.setBounds(70, 200, 300, 30);
        simulateBookingPanel.add(checkInLabel);

        checkInField = new JTextField();
        checkInField.setBounds(340, 200, 300, 35);
        simulateBookingPanel.add(checkInField);

        JLabel checkOutLabel = new JLabel("Enter check-out day:");
        checkOutLabel.setFont(new Font(deluxeLabel.getFont().getName(), deluxeLabel.getFont().getStyle(), 22));
        checkOutLabel.setBounds(70, 250, 300, 30);
        simulateBookingPanel.add(checkOutLabel);

        checkOutField = new JTextField();
        checkOutField.setBounds(340, 250, 300, 35);
        simulateBookingPanel.add(checkOutField);

        bookButton = new JButton("Book Reservation");
        bookButton.setBounds(315, 350, 200, 50);
        bookButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        simulateBookingPanel.add(bookButton);




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

            if (total > 50 || total == 0 || total < 0 || standard < 0 || deluxe < 0|| executive < 0) {
                JOptionPane.showMessageDialog(this, "Invalid number of rooms. Please enter again.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }

    public boolean validateCheckDates(){
        int checkIn = getCheckInField();
        int checkOut = getCheckOutField();
        boolean validity;

        if(checkOut < 1 || checkIn > 31 || checkIn >= checkOut || checkIn < 1 || checkOut > 31){
            validity = false;
        } else {
            validity = true;
        }

        return validity;

    }

    public void validateCreateHotel(Hotel h){
        if (h != null) {
            JOptionPane.showMessageDialog(this, "Hotel created successfully!");
            getCardLayout().show(getMainPanel(), "home");
            clearHotelFields();
        } else {
            JOptionPane.showMessageDialog(this, "Hotel already exists or invalid room numbers.");
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

    public void addBackButtonListener5(ActionListener listener) {
        backButton5.addActionListener(listener);
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
                    getCardLayout().show(getMainPanel(), "home");
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
            earningsLabel.setBounds(200, 460, 500, 40); // Increased height
            highLevelPanel.add(earningsLabel);
    
            // Back button
            highLevelPanel.add(backToViewHotelFromHighLevel);
    
            highLevelPanel.revalidate();
            highLevelPanel.repaint();
    
            getCardLayout().show(getMainPanel(), "highLevel");
        }
    }
    
    public void displayLowLevelInfo(Hotel hotel) {

        /*
        * This is for the displaying info for low level. My idea for High level info was to keep updating the screen whenever new choice. I wanted
        *to try doing something similar with low level info but idk if thats possible, just try.
        * Kind of like clearing the screen then re-adding the components again. Im not sure how to tackle yet low level info.
        */
        if (hotel != null) {

            lowLevelPanel.removeAll();
            JLabel lowLevelLabel = new JLabel("Low Level Information", JLabel.CENTER);
            lowLevelLabel.setBounds(200, 50, 400, 50);
            lowLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
            lowLevelPanel.add(lowLevelLabel);

            JTextField dayToCheckField = new JTextField();


            JLabel dayToCheckLabel = new JLabel("Name:");
            dayToCheckLabel.setFont(new Font(dayToCheckLabel.getFont().getName(), dayToCheckLabel.getFont().getStyle(), 22));
            dayToCheckLabel.setBounds(90, 150, 200, 30);
            lowLevelPanel.add(dayToCheckLabel);

            dayToCheckField = new JTextField();
            dayToCheckField.setBounds(350, 150, 300, 35);
            lowLevelPanel.add(dayToCheckField);

            // JLabel standardLabel = new JLabel("No. Standard Rooms:");
            // standardLabel.setFont(new Font(standardLabel.getFont().getName(), standardLabel.getFont().getStyle(), 22));
            // standardLabel.setBounds(90, 200, 300, 30);
            // createHotelPanel.add(standardLabel);

            // standardRoomField = new JTextField();
            // standardRoomField.setBounds(350, 200, 300, 35);
            // createHotelPanel.add(standardRoomField);

            // JLabel deluxeLabel = new JLabel("No. Deluxe Rooms:");
            // deluxeLabel.setFont(new Font(deluxeLabel.getFont().getName(), deluxeLabel.getFont().getStyle(), 22));
            // deluxeLabel.setBounds(90, 250, 300, 30);
            // createHotelPanel.add(deluxeLabel);

            // deluxeRoomField = new JTextField();
            // deluxeRoomField.setBounds(350, 250, 300, 35);
            // createHotelPanel.add(deluxeRoomField);

            // JLabel executiveLabel = new JLabel("No. Executive Rooms:");
            // executiveLabel.setFont(new Font(executiveLabel.getFont().getName(), executiveLabel.getFont().getStyle(), 22));
            // executiveLabel.setBounds(90, 300, 300, 30);
            // createHotelPanel.add(executiveLabel);

            // executiveRoomField = new JTextField();
            // executiveRoomField.setBounds(350, 300, 300, 35);
            // createHotelPanel.add(executiveRoomField);

            // createButton = new JButton("Create");
            // createButton.setBounds(330, 400, 150, 50);
            // createButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            // createButton.setFont(new Font("Arial", Font.BOLD, 16));
            // createHotelPanel.add(createButton);






            mainPanel.add(lowLevelPanel, "lowLevel");



















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

            getCardLayout().show(getMainPanel(), "lowLevel");
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

    public void setChangeNewName(String name){
        changeField.setText(name);
    }
    
    public void setDeluxeRooms(int rooms) {
        deluxeRoomField.setText(String.valueOf(rooms));
    }
    
    public void setExecutiveRooms(int rooms) {
        executiveRoomField.setText(String.valueOf(rooms));
    }

    public void setRemoveField(int rooms){
        removeField.setText(String.valueOf(rooms));
    }

    public void setAddField(int rooms){
        addField.setText(String.valueOf(rooms));
    }

    public void setCheckInFields(int checkIn){
        checkInField.setText(String.valueOf(checkIn));
    }

    public void setCheckOutFields(int checkOut){
        checkOutField.setText(String.valueOf(checkOut));
    }

    public void setCustomerName(String name){
        customerNameField.setText(name);
    }

    public void clearHotelFields() {
        setHotelName("");
        setStandardRooms(0);
        setDeluxeRooms(0);
        setExecutiveRooms(0);
        setChangeNewName("");
        setRemoveField(0);
        setAddField(0);
        setCustomerName("");
        setCheckInFields(0);
        setCheckOutFields(0);
    }


    public void addChangeNameListener(ActionListener listener){
        changeName.addActionListener(listener);
    }

    public void addChangeNewNameListener(ActionListener listener){
        changeNewName.addActionListener(listener);
    }

    public JButton getChangeNewNameButton(){
        return changeNewName;
    }

    public String getNewName(){
        return changeField.getText();
    }

    public void displayChangeName() {
        cardLayout.show(mainPanel, "changePanel");
    }

    public int displayConfirm(){
        // Display the confirm dialog
        int response = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Confirm", JOptionPane.OK_CANCEL_OPTION);

        // Check the user's response
        if (response == JOptionPane.OK_OPTION) {
            return 1;
            // Add your logic for the OK option here
        } else if (response == JOptionPane.CANCEL_OPTION) {
            return -1;
            // Add your logic for the Cancel option here
        } else {
            return -1;
        }
    
    }

    public void displayFillOut(){
        JOptionPane.showMessageDialog(this, "Do not leave the space blank");
    }

    public void displayInvalid(){
        JOptionPane.showMessageDialog(this, "Not successful");
    }

    public void displayvalid(){
        JOptionPane.showMessageDialog(this, "Successful");
    }

    public void addAddNewRoomsListener(ActionListener listener){
        addNewRooms.addActionListener(listener);
    }

    public void addAddRoomListener(ActionListener listener){
        addRoom.addActionListener(listener);
    }


    public int getAddRooms(){
        return Integer.parseInt(addField.getText());
    }

    public int getRoomOptions() {
        String[] options = {"Standard", "Deluxe", "Executive"};
        int result = JOptionPane.showOptionDialog(this, "Select Room Type", "Room Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(result == JOptionPane.CLOSED_OPTION || result == -1){
            getCardLayout().show(getMainPanel(), "home");
            return -1;
        }
        return result;
    }

    public int getRemoveRooms() {
        return Integer.parseInt(removeField.getText());
    }

    public void addRemoveRoomsListener(ActionListener listener) {
        removeRoom.addActionListener(listener);
    }

    public void addRemoveNewRoomsListener(ActionListener listener) {
        removeNewRooms.addActionListener(listener);
    }

    public void addUpdateBaseRoomPriceListener(ActionListener listener) {
        updateBaseRoomPrice.addActionListener(listener);
    }

    public void addUpdatePriceListener(ActionListener listener) {
        updatePrice.addActionListener(listener);
    }

    public int getUpdatePriceField(){
        return Integer.parseInt(updatePriceField.getText());
    }

    public void addRemoveReservationListener(ActionListener listener){
        removeReservation.addActionListener(listener);
    }

    public int getReservationOptions(Hotel hotel) {
        String[] options = {};
        if (hotel.getNumOfReservations() != 0) {
            for (int i = 0; i < hotel.getNumOfReservations(); i++) {
            options[i] = hotel.getReservations().get(i).getGuestName() + ", Days " + hotel.getReservations().get(i).getCheckInDate() + " to "
                        + hotel.getReservations().get(i).getCheckOutDate();
            }
            int result = JOptionPane.showOptionDialog(this, "Select a Reservation", "Reservations", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);  
            return result;
        }
        else {
            JOptionPane.showMessageDialog(this, "No current reservations.");
            getCardLayout().show(getMainPanel(), "home");
            return -1;
        }
    }

    public void addBookListener(ActionListener listener){
        bookButton.addActionListener(listener);
    }

    public String displayEnterDiscount() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to input a Discount code?", "Discount Code", JOptionPane.YES_NO_OPTION);
        String discountCode = null;
    
        if (response == JOptionPane.YES_OPTION) {
            // Show input dialog for the discount code
            discountCode = JOptionPane.showInputDialog(null, "Please enter your Discount code:", "Discount Code", JOptionPane.QUESTION_MESSAGE);
    
            if (discountCode != null && !discountCode.trim().isEmpty()) {
                // Handle the discount code
                JOptionPane.showMessageDialog(null, "Discount code entered: " + discountCode);
                return discountCode;
            } else if (discountCode != null) {
                // Handle the case where the input is empty
                JOptionPane.showMessageDialog(null, "No Discount code entered.", "Information", JOptionPane.INFORMATION_MESSAGE);
                return ""; // Proceed without discount code
            } else {
                // Handle the case where the user canceled the input dialog
                JOptionPane.showMessageDialog(null, "Enter Discount code Cancelled");
                return null; // Indicate to stop the booking process
            }
        } else {
            // Handle the case where the user chose not to input a discount code
            return ""; // Proceed without discount code
        }
    }
    
    
    

    public int getCheckInField(){
        return Integer.parseInt(checkInField.getText());
    }

    public int getCheckOutField(){
        return Integer.parseInt(checkOutField.getText());
    }

    public void displayValidCheckDates(){
        JOptionPane.showMessageDialog(null, "Enter valid check-in/check-out dates");
    }


    public int checkCoupon(String code, int checkInDate, int checkOutDate){
        if (code.equals("I_WORK_HERE")) {
            JOptionPane.showMessageDialog(null, "10% discount applied.");
            return 1;
        } else if (code.equals("STAY4_GET1")) {
            if (checkOutDate - checkInDate >= 4) {
                JOptionPane.showMessageDialog(null, "First day of reservation is given for free.");
                return 2;
            } else {
                JOptionPane.showMessageDialog(null, "Reservation is inelligible for discount code.");
                return 3;
            }
        } else if (code.equals("PAYDAY")) {
            if (checkInDate <= 15 && checkOutDate > 15 || checkInDate <= 30 && checkOutDate > 30) { // If stay contains day 15 / 30
                JOptionPane.showMessageDialog(null, "7% discount applied.");
                return 4;
            } else {
                JOptionPane.showMessageDialog(null, "Reservation is inelligible for discount code.");
                return 5;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Discount Code not found.");
            return 6;
        }

    }

    public void displaySuccessBooking() {
        JOptionPane.showMessageDialog(null, "Booking successful");
    }

    public void displayNoRooms() {
        JOptionPane.showMessageDialog(null, "No rooms available for the selected dates.");
    }


    


}
