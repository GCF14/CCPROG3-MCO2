import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * View class for the hotel reservation system
 */
public class hotelGuiView extends JFrame {
    // Home page portion
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JButton createHotelButton;
    private JButton viewInfoButton;
    private JButton manageButton;
    private JButton bookingButton;
    private JButton backButton;
    private JButton backButton2;
    private JButton backButton3;
    private JButton backButton4;
    private JButton backButton5;


    // Create Hotel portion
    private JTextField nameField;
    private JTextField standardRoomField;
    private JTextField deluxeRoomField;
    private JTextField executiveRoomField;
    private JButton createButton;

    // View Hotel portion
    private JButton highLevelButton;
    private JButton lowLevelButton;
    private JButton backToViewHotelFromHighLevel;
    private JButton backToViewHotelFromLowLevel;
    private JPanel highLevelPanel;
    private JPanel showLowLevelPanel;
    private JPanel lowLevelPanel;
    private JTextField dayField;
    private JTextField roomCheckField;
    private JButton viewLowButton;


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
    private JButton removeHotel;
    private JButton updatePriceModifier;
    


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
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        addComponents();

        add(mainPanel);
        setVisible(true);

        // Initialize controllers with the view (this) and models
        createHotelModel model = new createHotelModel(); 
        viewHotelModel model2 = new viewHotelModel(model.getHotels());
        hotelController controller = new hotelController(this);
        viewHotelController viewController = new viewHotelController(this, model, model2);
        createHotelController createHotel = new createHotelController(this, model);
        manageHotelController manageHotel = new manageHotelController(this, model);
        SimulateBookingController simulateBooking = new SimulateBookingController(this, model);
    }

    /**
     * Function that adds components to the main panel
     */
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


        JLabel dayLabel = new JLabel("Enter day to check:");
        dayLabel.setFont(new Font(dayLabel.getFont().getName(), dayLabel.getFont().getStyle(), 22));
        dayLabel.setBounds(90, 150, 300, 30);
        lowLevelPanel.add(dayLabel);

        dayField = new JTextField();
        dayField.setBounds(350, 150, 300, 35);
        lowLevelPanel.add(dayField);

        JLabel roomLabel = new JLabel("Enter room to check:");
        roomLabel.setFont(new Font(roomLabel.getFont().getName(), roomLabel.getFont().getStyle(), 22));
        roomLabel.setBounds(90, 200, 300, 30);
        lowLevelPanel.add(roomLabel);

        roomCheckField = new JTextField();
        roomCheckField.setBounds(350, 200, 300, 35);
        lowLevelPanel.add(roomCheckField);

        viewLowButton = new JButton("View");
        viewLowButton.setBounds(330, 400, 150, 50);
        viewLowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewLowButton.setFont(new Font("Arial", Font.BOLD, 16));
        lowLevelPanel.add(viewLowButton);

        mainPanel.add(lowLevelPanel, "lowLevel");

        showLowLevelPanel =  new JPanel(null);
        JLabel lowLevelLabel2 = new JLabel("Low Level Information", JLabel.CENTER);
        showLowLevelPanel.setBounds(200, 50, 400, 50);
        showLowLevelPanel.setFont(new Font("Arial", Font.BOLD, 36));
        showLowLevelPanel.add(lowLevelLabel2);
        mainPanel.add(showLowLevelPanel, "showLowLevel");


        // Manage Hotel portion
        JPanel manageHotelPanel = new JPanel(null);
        JLabel manageHotelTitle = new JLabel("Manage Hotel", JLabel.CENTER);
        manageHotelTitle.setFont(new Font(manageHotelTitle.getFont().getName(), manageHotelTitle.getFont().getStyle(), 36));
        manageHotelTitle.setBounds(200, 10, 400, 50);
        manageHotelPanel.add(manageHotelTitle);
        
        int manageButtonWidth = 275;
        int manageButtonHeight = 50;
        int manageButtonMidX = (panelWidth - manageButtonWidth) / 2;
        int manageButtonX1 = manageButtonMidX - (manageButtonMidX/2 + 30);
        int manageButtonX2 = manageButtonMidX + (manageButtonMidX/2 + 30);

        // Initialization of manageHotelPanel with buttons

        backButton3 = new JButton("Back");
        Font buttonFont3 = new Font("Arial", Font.BOLD, 16);
        backButton3.setBounds(680, 500, 100, 50);
        backButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton3.setFont(buttonFont3);
        manageHotelPanel.add(backButton3);

        changeName = new JButton("Change Hotel Name");
        changeName.setBounds(manageButtonX1, 80, manageButtonWidth, manageButtonHeight);  // Adjusted position and size
        changeName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeName.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.setLayout(null);  // Ensure null layout is set
        manageHotelPanel.add(changeName);

        addRoom = new JButton("Add Room(s)");
        addRoom.setBounds(manageButtonX1, 150, manageButtonWidth, manageButtonHeight);  // Adjusted position and size
        addRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addRoom.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(addRoom);

        removeRoom = new JButton("Remove Room(s)");
        removeRoom.setBounds(manageButtonX1, 220, manageButtonWidth, manageButtonHeight);
        removeRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeRoom.setFont(new Font("Arial", Font.BOLD, 20));

        manageHotelPanel.add(removeRoom);

        updateBaseRoomPrice = new JButton("Update Base Room Price");
        updateBaseRoomPrice.setBounds(manageButtonX1, 290, manageButtonWidth, manageButtonHeight);  // Adjusted position and size
        updateBaseRoomPrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBaseRoomPrice.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(updateBaseRoomPrice);

        removeReservation = new JButton("Remove Reservation");
        removeReservation.setBounds(manageButtonX2, 80, manageButtonWidth, manageButtonHeight);  // Adjusted position and size
        removeReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeReservation.setFont(new Font("Arial", Font.BOLD, 20));  // Adjusted font size for consistency
        manageHotelPanel.add(removeReservation);

        removeHotel = new JButton("Remove Hotel(s)");
        removeHotel.setBounds(manageButtonX2, 150, manageButtonWidth, manageButtonHeight);
        removeHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeHotel.setFont(new Font("Arial", Font.BOLD, 20));

        manageHotelPanel.add(removeHotel);

        updatePriceModifier = new JButton("Update Price Modifier");
        updatePriceModifier.setBounds(manageButtonX2, 220, manageButtonWidth, 50);
        updatePriceModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updatePriceModifier.setFont(new Font("Arial", Font.BOLD, 20));

        manageHotelPanel.add(updatePriceModifier);

        mainPanel.add(manageHotelPanel, "manageHotel");


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

    /**
     * Function to check if the user input for the number of rooms is valid
     * @return boolean - true if the input is valid, false otherwise
     */
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

    public String getCustomerNameField(){
        return customerNameField.getText();
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

    public void addBackToViewHotelFromLowLevelListener(ActionListener listener) {
        backToViewHotelFromLowLevel.addActionListener(listener);
    }

    public void addBackToViewHotelFromHighLevelListener(ActionListener listener) {
        backToViewHotelFromHighLevel.addActionListener(listener);
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

    public void addLowLevelButton(ActionListener listener){
        lowLevelButton.addActionListener(listener);
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
    
    public void displayLowLevelInfo(Hotel h, int index, int dayToCheck, int roomToCheck, viewHotelModel model2) {
        if (h != null) {
            // Create the main panel for low level information
            JPanel lowLevelContentPanel = new JPanel();
            lowLevelContentPanel.setLayout(null);  // Use null layout
    
            // Increase the size of the main panel
            lowLevelContentPanel.setPreferredSize(new Dimension(1000, 1000));
    
            // Centered low-level information label
            JLabel lowLevelLabel = new JLabel("Low Level Information", JLabel.CENTER);
            lowLevelLabel.setFont(new Font("Arial", Font.BOLD, 36));
            lowLevelLabel.setBounds(150, 10, 500, 50);
            lowLevelContentPanel.add(lowLevelLabel);
    
            // Room and Guest Information
            JPanel roomGuestPanel = new JPanel();
            roomGuestPanel.setLayout(null);
            roomGuestPanel.setBounds(10, 70, 380, 400);  // Set position and size
            lowLevelContentPanel.add(roomGuestPanel);
    
            JLabel roomInfoLabel = new JLabel("Room Information");
            roomInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
            roomInfoLabel.setBounds(10, 10, 300, 25);
            roomGuestPanel.add(roomInfoLabel);
    
            JLabel numRoomsLabel = new JLabel(String.format("Number of booked rooms for the day: %d", model2.isDayBooked(h, dayToCheck)));
            numRoomsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            numRoomsLabel.setBounds(10, 50, 360, 25);
            roomGuestPanel.add(numRoomsLabel);
    
            JLabel availableLabel = new JLabel(String.format("Number of available rooms for the day: %d", h.getRooms().getTotal() - model2.isDayBooked(h, dayToCheck)));
            availableLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            availableLabel.setBounds(10, 90, 360, 25);
            roomGuestPanel.add(availableLabel);
    
            JLabel roomLabel = new JLabel("Room name: %d", roomToCheck);
            roomLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            roomLabel.setBounds(10, 130, 360, 25);
            roomGuestPanel.add(roomLabel);
    
            float roomPrice;
            if (roomToCheck >= 1 && roomToCheck <= h.getRooms().lastStandard()) {
                roomPrice = h.getRoomPrice();
            } else if (roomToCheck >= h.getRooms().firstDeluxe() && roomToCheck <= h.getRooms().lastDeluxe()) {
                roomPrice = h.getDeluxePrice();
            } else {
                roomPrice = h.getExecutivePrice();
            }
    
            JLabel priceLabel = new JLabel(String.format("Price per night in the room: %.2f", roomPrice));
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            priceLabel.setBounds(10, 170, 360, 25);
            roomGuestPanel.add(priceLabel);
            
            JLabel guestInfoLabel = new JLabel("Room's Guest information");
            guestInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
            guestInfoLabel.setBounds(10, 210, 360, 25);
            roomGuestPanel.add(guestInfoLabel);
            
            if (index >= 0) {
                JLabel guestNameLabel = new JLabel("Guest name: " + h.getReservations().get(index).getGuestName());
                guestNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                guestNameLabel.setBounds(10, 250, 360, 25);
                roomGuestPanel.add(guestNameLabel);
        
                JLabel checkInLabel = new JLabel("Check-in Day: %d", h.getReservations().get(index).getCheckInDate());
                checkInLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                checkInLabel.setBounds(10, 290, 360, 25);
                roomGuestPanel.add(checkInLabel);
        
                JLabel checkOutLabel = new JLabel("Check-out Day: %d", h.getReservations().get(index).getCheckOutDate());
                checkOutLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                checkOutLabel.setBounds(10, 330, 360, 25);
                roomGuestPanel.add(checkOutLabel);
        
                JLabel totalPriceLabel = new JLabel(String.format("Total price for booking: %.2f", h.getReservations().get(index).getTotalPrice()));
                totalPriceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                totalPriceLabel.setBounds(10, 370, 360, 25);
                roomGuestPanel.add(totalPriceLabel);
            }
            else {
                JLabel noBooking = new JLabel("No Bookings for this Room.");
                noBooking.setFont(new Font("Arial", Font.PLAIN, 18));
                noBooking.setBounds(10, 250, 360, 25);
                roomGuestPanel.add(noBooking);
            }
    
            // Availability Dates
            JPanel availabilityPanel = new JPanel();
            availabilityPanel.setLayout(null);
            availabilityPanel.setBounds(410, 70, 500, 500);  // Increase the size of the availability panel
            lowLevelContentPanel.add(availabilityPanel);
    
            JLabel availabilityTitleLabel = new JLabel("Availability");
            availabilityTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            availabilityTitleLabel.setBounds(120, 10, 400, 45);
            availabilityPanel.add(availabilityTitleLabel);
    
            for (int i = 0; i < 31; i++) {
                String availability = h.isRoomBookedOnDay(roomToCheck, i + 1) ? "Booked" : "Available";
                JLabel dayLabel = new JLabel(String.format("Day %d: %s", i + 1, availability));
                dayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                if (i < 16) {
                    dayLabel.setBounds(10, 50 + (i * 25), 360, 25);
                } else {
                    dayLabel.setBounds(200, 50 + ((i - 16) * 25), 360, 25);  // Changed to 200 to ensure proper spacing for the second column
                }
                availabilityPanel.add(dayLabel);
            }
    
            // Back button
            backToViewHotelFromLowLevel.setBounds(650, 520, 120, 30);
            lowLevelContentPanel.add(backToViewHotelFromLowLevel);
    
            showLowLevelPanel.removeAll(); // Clear previous components
            showLowLevelPanel.add(lowLevelContentPanel);
            showLowLevelPanel.revalidate();
            showLowLevelPanel.repaint();
            mainPanel.add(lowLevelContentPanel, "showLowLevel");
    
            getCardLayout().show(getMainPanel(), "showLowLevel");
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
        setDayField(0);
        setRoomCheckField(0);
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
        if (hotel.getNumOfReservations() != 0) {
            String[] options = new String[hotel.getNumOfReservations()];
            for (int i = 0; i < hotel.getNumOfReservations(); i++) {
                Reservation reservation = hotel.getReservations().get(i);
                options[i] = "Guest: " + reservation.getGuestName() +
                             ", Room: " + reservation.getRoomNumber() +
                             ", Days: " + reservation.getCheckInDate() + " to " + reservation.getCheckOutDate() +
                             ", Price: " + reservation.getTotalPrice();
            }
            int result = JOptionPane.showOptionDialog(this, "Select a Reservation", "Reservations", 
                                                      JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                      null, options, options[0]);
            return result;
        } else {
            JOptionPane.showMessageDialog(this, "No current reservations.");
            getCardLayout().show(getMainPanel(), "home");
            return -1;
        }
    }

    public int getReservationOptions2(Hotel hotel) {
        if (hotel.getNumOfReservations() != 0) {
            String[] options = new String[hotel.getNumOfReservations()];
            for (int i = 0; i < hotel.getNumOfReservations(); i++) {
                Reservation reservation = hotel.getReservations().get(i);
                options[i] = "Guest: " + reservation.getGuestName() +
                             ", Room: " + reservation.getRoomNumber() +
                             ", Days: " + reservation.getCheckInDate() + " to " + reservation.getCheckOutDate() +
                             ", Price: " + reservation.getTotalPrice();
            }
            int result = JOptionPane.showOptionDialog(this, "Select a Reservation", "Reservations", 
                                                      JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                      null, options, options[0]);
            return result;
        } else {
            JOptionPane.showMessageDialog(this, "No current reservations.");
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

    public void addRemoveHotelListener(ActionListener listener){
        removeHotel.addActionListener(listener);
    }

    public void addUpdatePriceModifierListener(ActionListener listener){
        updatePriceModifier.addActionListener(listener);
    }


    public boolean displayEnterPriceModifier(Hotel h) {
        try {
            String input = JOptionPane.showInputDialog(null, "Please enter the day for which you want to change the price rate:", "Price Rate Modifier", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                getCardLayout().show(getMainPanel(), "manageHotel");
                return false;
            }
            
            String input2 = JOptionPane.showInputDialog(null, "Please enter your new price rate:", "Price Rate Modifier", JOptionPane.QUESTION_MESSAGE);
            if (input2 == null) {
                getCardLayout().show(getMainPanel(), "manageHotel");
                return false;
            }
    
            float newPriceRate = Float.parseFloat(input2);
            int day = Integer.parseInt(input);
            
            if (newPriceRate < 50 || newPriceRate > 150) {
                JOptionPane.showMessageDialog(null, "Price rate change can only be between 50-150.");
                getCardLayout().show(getMainPanel(), "manageHotel");
                return false;
            } else if (day > 31 || day < 1) {
                JOptionPane.showMessageDialog(null, "Day must be between 1-31");
                getCardLayout().show(getMainPanel(), "manageHotel");
                return false;
            } else {
                h.setDatePriceModifier(day, newPriceRate / 100);
                return true;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price rate. Please enter a valid integer.");
            getCardLayout().show(getMainPanel(), "manageHotel");
            return false;
        }
    }

    public int getdayField(){
        return Integer.parseInt(dayField.getText());
    }

    public void setDayField(int num){
        dayField.setText(String.valueOf(num));
    }

    public int getRoomCheckField(){
        return Integer.parseInt(roomCheckField.getText());
    }

    public void setRoomCheckField(int num){
        roomCheckField.setText(String.valueOf(num));
    }

    public void addViewLowLevelListener(ActionListener listener){
        viewLowButton.addActionListener(listener);
    }


    //JOptions for manage hotel

    public void displaySuccessPriceChange(){
        JOptionPane.showMessageDialog(this, "Room price successfully updated.");
    }

    public void displayUnsuccessPriceChange(int num){
        if(num == 1) {
            JOptionPane.showMessageDialog(this, "Price change unsuccessful -- Hotel currently has reservations.");
        } else {
            JOptionPane.showMessageDialog(this, "Price change unsuccessful -- New price too small.");
        }
    }

    public int displayConfirmUpdatePrice(){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Update Price?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return confirm;
    }

    public void displayPriceRateMessage(int num){
        if(num == 1){
            JOptionPane.showMessageDialog(this, "Price rate changed.");
        } else if(num == 2){
            JOptionPane.showMessageDialog(this, "Price rate change cancelled");
        } else {
            JOptionPane.showMessageDialog(this, "No hotel selected or Cancelled.");
        }
        
    }

    public void displayRemoveHotelMessage(int num){
        if(num == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Hotel removed successfully.");
        } else if(num == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(this, "Hotel removal cancelled.");
        } else {
            JOptionPane.showMessageDialog(this, "No hotel selected");
        }
    }

    public int displayConfirmRemoveHotel(Hotel h){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Remove Hotel " + h.getName() + "?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return confirm;
    }

    public int displayConfirmViewReservation(){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Confirm view reservation?", "Confirm", JOptionPane.YES_NO_OPTION);
        return confirm;
    }
    
    public void displayInvalidDayRoom(){
        JOptionPane.showMessageDialog(this, "Invalid day or room number. Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int displayConfirmAddRooms(int rooms){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Add " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);
        return confirm;
    }

    public void displaySuccessAddRooms(int num){
        JOptionPane.showMessageDialog(this, num + " rooms successfully added.");
    }

    public int displayConfirmRemoveRooms(int rooms) {
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Remove " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);
        return confirm;
    }

    public void displaySuccessRemoveRooms(int num){
        JOptionPane.showMessageDialog(this, num + " rooms successfully removed");
    }

    public int displayConfirmUpdateBasePrice(float newPrice){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Update base room price to " + newPrice + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        return confirm;
    }

    public int displayConfirmRemoveReservation(Hotel h, int index){
        int confirm;
        confirm = JOptionPane.showConfirmDialog(this, "Remove reservation of " + h.getReservations().get(index).getGuestName() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        return confirm;
    }

    public void displaySuccessReservationRemoved(){
        JOptionPane.showMessageDialog(this, "Reservation successfully removed.");
    }

    public void displayNoHotels(){
        JOptionPane.showMessageDialog(this, "No hotel selected.");
    }
    
    


}
