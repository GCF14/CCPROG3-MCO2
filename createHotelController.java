import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class createHotelController {
    private hotelGuiView gui;
    private createHotelModel model;

    public createHotelController(hotelGuiView gui, createHotelModel model) {
        this.gui = gui;
        this.model = model;
        initialize();
    }

    private void initialize() {
        gui.addCreateButtonListener(new CreateButtonListener());
        gui.addBackButtonListener(new BackButtonListener());
    }

    class CreateButtonListener implements ActionListener {
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

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "home");
            gui.clearHotelFields();
        }
    }
}
