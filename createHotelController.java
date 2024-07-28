//package prog_mco2
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the create hotel panel
 */
public class createHotelController {
    private hotelGuiView gui;
    private createHotelModel model;

    /** Constructor for the createHotelController class
     * Preconditions: hotelGuiView and createHotelModel are initialized
     * Postconditions: returns the number of reservations in one day
     * @param gui - Instance of hotelGuiView
     * @param model - Instance of createHotelModel
     */
    public createHotelController(hotelGuiView gui, createHotelModel model) {
        this.gui = gui;
        this.model = model;
        this.gui.addCreateButtonListener(new CreateButtonListener());
        this.gui.addBackButtonListener(new BackButtonListener());
    }

    /**
     * This method is called when the create hotel button is clicked.
     * It retrieves hotel name and room counts from the GUI, checks for valid input,
     * and then creates a hotel if the inputs are valid. If the inputs are not valid,
     * it displays a message to the user to fill out all fields and redisplays the create hotel panel.
     */
    class CreateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = gui.getHotelName();
            int standardRooms = gui.getStandardRooms();
            int deluxeRooms = gui.getDeluxeRooms();
            int executiveRooms = gui.getExecutiveRooms();

            
            if (name == null || name.trim().isEmpty() || name == null) {
                gui.displayFillOut();  // Call method to display message
                gui.getCardLayout().show(gui.getMainPanel(), "createHotel");
            } else {
                Hotel hotel = model.createHotel(name, standardRooms, deluxeRooms, executiveRooms, gui);
                gui.validateCreateHotel(hotel);
            }

        
        }
    }

    /**
     * This method is called when the back button is clicked.
     * It shows the home panel and clears the hotel fields.
     */
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "home");
            gui.clearHotelFields();
        }
    }

    


}
