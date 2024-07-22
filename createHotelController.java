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

            Hotel hotel = model.createHotel(name, standardRooms, deluxeRooms, executiveRooms, gui);

            if (hotel != null) {
                JOptionPane.showMessageDialog(gui, "Hotel created successfully!");
                gui.getCardLayout().show(gui.getMainPanel(), "home");
                gui.clearHotelFields();
            } else {
                JOptionPane.showMessageDialog(gui, "Hotel already exists or invalid room numbers.");
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
