//package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the hotel panel
 */
public class hotelController {
    private hotelGuiView gui;

    /**
     * Constructs a hotelController object with the specified view.
     * Adds action listeners to the view's buttons.
     * @param gui - the instance of the hotelGuiView class
     */
    public hotelController(hotelGuiView gui) {
        this.gui = gui;

        this.gui.addCreateHotelButtonListener(new CreateHotelButtonListener());
        this.gui.addViewInfoButtonListener(new ViewInfoButtonListener());
        this.gui.addManageButtonListener(new ManageButtonListener());
        this.gui.addBookingButtonListener(new addBookingButtonListener());
        this.gui.addBackButtonListener(new BackButtonListener());
        this.gui.addBackButtonListener2(new BackButtonListener());
        this.gui.addBackButtonListener3(new BackButtonListener());
        this.gui.addBackButtonListener4(new BackButtonListener());

    }


    /**
     * Listener class for the back button. Shows the home panel when the back button is pressed.
     */
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "home");
        }
    }

    /**
     * Listener class for the create hotel button. Shows the create hotel panel when the button is pressed.
     */
    class CreateHotelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "createHotel");
        }
    }

    /**
     * Listener class for the view info button. Shows the view hotel panel when the button is pressed.
     */
    class ViewInfoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "viewHotel");
        }
    }

    /**
     * Listener class for the manage button. Shows the manage hotel panel when the button is pressed.
     */
    class ManageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "manageHotel");
        }
    }

    /**
     * Listener class for the booking button. Shows the simulate booking panel when the button is pressed.
     */
    class addBookingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "simulateBooking");
        }
    }

    
}
