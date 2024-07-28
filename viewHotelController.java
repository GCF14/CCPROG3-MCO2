
//package 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Controller class for the view hotel panel
 */
public class viewHotelController {
    private hotelGuiView gui;
    private createHotelModel model;
    private viewHotelModel model2;
    private Hotel h;

    /**
     * Constructs a viewHotelController object with the specified view and model.
     * Adds action listeners to the view's buttons.
     *
     * @param view the view component of the MVC architecture
     * @param model the model component of the MVC architecture
     */
    public viewHotelController(hotelGuiView gui, createHotelModel model, viewHotelModel model2) {
        this.gui = gui;
        this.model = model;
        this.model2 = new viewHotelModel(model.getHotels());

        this.gui.addHighLevelButtonListener(new highLevelListener());
        this.gui.addBackToViewHotelFromHighLevelListener(new addBacktoViewHotelListener());
        this.gui.addBackToViewHotelFromLowLevelListener(new addBacktoViewHotelListener());
        this.gui.addViewLowLevelListener(new addViewLowListener());
        this.gui.addLowLevelButton(new addLowLevelListener());
    }

    /**
     * Listener class for the high level button. Shows the high level panel when the button is pressed.
     */
    class highLevelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Hotel selectedHotel = gui.getHotelOptions(model.getHotels());
            if (selectedHotel != null) {
                gui.displayHighLevelInfo(selectedHotel);
            }
        }
    }

    /**
     * Listener class for the back to view hotel button. Shows the view hotel panel when the button is pressed.
     */
    class addBacktoViewHotelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "viewHotel");
        }
    }

    /**
     * Listener class for the low level button. Shows the low level panel when the button is pressed.
     */
    class addLowLevelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            h = gui.getHotelOptions(model.getHotels());

            if (h != null) {
                gui.getCardLayout().show(gui.getMainPanel(), "lowLevel");
            }
        }
    }

    /**
     * Listener class for the view low level button. Shows the low level panel when the button is pressed.
     */
    class addViewLowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int dayToCheck = gui.getdayField();
            int roomToCheck = gui.getRoomCheckField();
    
            // Validate the day and room numbers
            if (dayToCheck > 0 && dayToCheck <= 31 && roomToCheck > 0 && roomToCheck <= h.getRooms().getTotal()) {
                int index = gui.getReservationOptions(h);
                if (index >= 0 && index < h.getNumOfReservations()) {
                    int confirm = gui.displayConfirmViewReservation();
                    if (confirm == JOptionPane.YES_OPTION) {
                        gui.clearHotelFields();
                        gui.displayLowLevelInfo(h, index, dayToCheck, roomToCheck, model2);
                    } else {
                        // Redirect to the lowLevel panel if the user cancels
                        gui.clearHotelFields();
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                    }
                } else if(index == -1) {
                    gui.displayLowLevelInfo(h, index, dayToCheck, roomToCheck, model2);
                }
            } else {
                // Show an error message and redirect to the lowLevel panel
                gui.displayInvalidDayRoom();
                gui.clearHotelFields();
                gui.getCardLayout().show(gui.getMainPanel(), "lowLevel");
            }
        }
    }
    



}
