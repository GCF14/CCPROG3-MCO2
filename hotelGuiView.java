package prog_mco2;
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
    private JButton backButton;

    // Declare buttons at class level
    private JButton highLevelButton;
    private JButton lowLevelButton;

    // Manage Hotel
    private JPanel changePanel;
    private JButton changeName;
    private JTextField changeField;
    private JPanel addPanel;
    private JButton addRooms;
    private JTextField addField;
    private JPanel removePanel;
    private JButton removeRooms;
    private JTextField removeField;
    private JPanel pricePanel;
    private JButton updatePrice;
    private JTextField priceField;
    private JPanel reservationsPanel;
    private JButton removeReservation;
    private JButton removeHotel;
    private JPanel modifyPanel;
    private JButton changeDatePrice;
    private JTextField modifyDayField;
    private JTextField percentField;


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

        // Manage Hotel portion
        int buttonHeight2 = 40;

        JPanel manageHotelPanel = new JPanel(null);
        JLabel manageHotelTitle = new JLabel("ManageHotel", JLabel.CENTER);
        manageHotelTitle.setFont(new Font(manageHotelTitle.getFont().getName(), manageHotelTitle.getFont().getStyle(), 36));
        manageHotelTitle.setBounds(200, 50, 400, 50);
        manageHotelPanel.add(manageHotelTitle);
        int buttonY = 150;

        changeName = new JButton("Change Hotel Name");
        changeName.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        changeName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeName.setFont(buttonFont);
        manageHotelPanel.add(changeName);

        changePanel = new JPanel();
        JLabel changeLabel = new JLabel("New Name:");
        changeLabel.setFont(new Font(changeLabel.getFont().getName(), changeLabel.getFont().getStyle(), 22));
        changeLabel.setBounds(90, 150, 200, 30);
        changePanel.add(changeLabel);

        changeField = new JTextField();
        changeField.setBounds(350, 150, 300, 35);
        changePanel.add(changeField);

        mainPanel.add(changePanel, "changePanel");


        addRooms = new JButton("Add Room(s)");
        buttonY += 50;
        addRooms.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        addRooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addRooms.setFont(buttonFont);
        manageHotelPanel.add(addRooms);

        addPanel = new JPanel();
        JLabel numRooms = new JLabel("No. of Rooms:");
        numRooms.setFont(new Font("Arial", Font.BOLD, 20));
        numRooms.setBounds(90, 150, 200, 30);
        addPanel.add(numRooms);

        addField = new JTextField();
        addField.setBounds(350, 150, 300, 35);
        addPanel.add(addField);

        mainPanel.add(addPanel, "addPanel");


        removeRooms = new JButton("Remove Room(s)");
        buttonY += 50;
        removeRooms.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        removeRooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeRooms.setFont(buttonFont);
        manageHotelPanel.add(removeRooms);

        removePanel = new JPanel();
        removePanel.add(numRooms);

        removeField = new JTextField();
        removeField.setBounds(350, 150, 300, 35);
        removePanel.add(removeField);

        mainPanel.add(removePanel, "removePanel");


        updatePrice = new JButton("Update Base Room Price");
        buttonY += 50;
        updatePrice.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        updatePrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updatePrice.setFont(buttonFont);
        manageHotelPanel.add(updatePrice);

        pricePanel = new JPanel();
        JLabel newPrice = new JLabel("Enter New Room Price:");
        newPrice.setFont(new Font("Arial", Font.BOLD, 20));
        newPrice.setBounds(90, 150, 200, 30);
        pricePanel.add(newPrice);

        priceField = new JTextField();
        priceField.setBounds(350, 150, 300, 35);
        pricePanel.add(priceField);
        
        mainPanel.add(pricePanel, "pricePanel");


        removeReservation = new JButton("Remove reservation");
        buttonY += 50;
        removeReservation.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        removeReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeReservation.setFont(buttonFont);
        manageHotelPanel.add(removeReservation);

        reservationsPanel = new JPanel();
        JLabel resTitle = new JLabel("Choose a reservation to remove");
        resTitle.setFont(new Font("Arial", Font.BOLD, 30));
        resTitle.setBounds(200, 50, 400, 50);

        removeHotel = new JButton("Remove Hotel");
        buttonY += 50;
        removeHotel.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        removeHotel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeHotel.setFont(buttonFont);
        manageHotelPanel.add(removeHotel);

        mainPanel.add(reservationsPanel, "reservationsPanel");

        changeDatePrice = new JButton("Modify Date Price");
        buttonY += 50;
        changeDatePrice.setBounds(buttonX, buttonY, buttonWidth, buttonHeight2);
        changeDatePrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeDatePrice.setFont(buttonFont);
        manageHotelPanel.add(changeDatePrice);

        modifyPanel = new JPanel();
        JLabel dayLabel = new JLabel("Enter Day to Modify:");
        dayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dayLabel.setBounds(90, 150, 200, 30);
        modifyPanel.add(dayLabel);
        
        modifyDayField = new JTextField();
        modifyDayField.setBounds(350, 150, 300, 35);
        modifyPanel.add(modifyDayField);

        JLabel percentLabel = new JLabel("Enter Percentage:");
        percentLabel.setFont(new Font("Arial", Font.BOLD, 20));
        percentLabel.setBounds(90, 400, 200, 30);
        modifyPanel.add(percentLabel);

        percentField = new JTextField();
        percentField.setBounds(350, 400, 200, 35);
        modifyPanel.add(percentField);

        mainPanel.add(modifyPanel, "modifyPanel");


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

    // public void addNewComponents() {
    //     // Get the viewHotelPanel
    //     JPanel viewHotelPanel = (JPanel) mainPanel.getComponent(2); // Assuming viewHotelPanel is at index 1

    //     JLabel nameLabel2 = new JLabel("Pick a hotel:");
    //     nameLabel2.setFont(new Font(nameLabel2.getFont().getName(), nameLabel2.getFont().getStyle(), 22));
    //     nameLabel2.setBounds(90, 150, 200, 30);
    //     viewHotelPanel.add(nameLabel2);

        
    // }

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

    // viewHotel
    public void addHighLevelButtonListener(ActionListener listener) {
        highLevelButton.addActionListener(listener);
    }

    public void addLowLevelButtonListener(ActionListener listener) {
        lowLevelButton.addActionListener(listener);
    }

    // manageHotel
    public String getNewName() {
        return changeField.getText();
    }

    public int getAddRooms() {
        return Integer.parseInt(addField.getText());
    }

    public int getRemoveRooms() {
        return Integer.parseInt(removeField.getText());
    }
    
    public float getNewPrice() {
        return Float.parseFloat(priceField.getText());
    }

    public int getDayField() {
        return Integer.parseInt(modifyDayField.getText());
    }

    public float getPercentField() {
        return Float.parseFloat(percentField.getText());
    }

    public void addChangeNameListener(ActionListener listener) {
        changeName.addActionListener(listener);
    }

    public void addRemoveRoomsListener(ActionListener listener) {
        removeRooms.addActionListener(listener);
    }

    public void addAddRoomsListener(ActionListener listener) {
        addRooms.addActionListener(listener);
    }

    public void addUpdatePriceListener(ActionListener listener) {
        updatePrice.addActionListener(listener);
    }

    public void addRemoveReservationListener(ActionListener listener) {
        removeReservation.addActionListener(listener);
    }

    public void addRemoveHotelListener(ActionListener listener) {
        removeHotel.addActionListener(listener);
    }

    public void addChangeDatePriceListener(ActionListener listener) {
        changeDatePrice.addActionListener(listener);
    }

    public String getHotelOptions(ArrayList<Hotel> hotels) {
        String[] options = {};
        int result = -1;
        if (hotels.size() == 0) {
            JOptionPane.showMessageDialog(this, "No current hotels.");
            return null;
        }
        else {
            for (int i = 0; i < hotels.size(); i++) {
                options[i] = hotels.get(i).getName();
            }
            if (options.length != 0) 
                result = JOptionPane.showOptionDialog(this, "Choose a Hotel", "Hotel Options", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            
            if (result != -1)
                return options[result];
            else
                return null;
        }
        
    }

    public int getRoomOptions() {
        String[] options = {"Standard", "Deluxe", "Executive"};
        int result = JOptionPane.showOptionDialog(this, "Select Room Type", "Room Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return result;
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
            return -1;
        }
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
    // public void displayNewComponents() {
    //     addNewComponents();
    // }
}
