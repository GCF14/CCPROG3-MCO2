//package
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Controller class for the simulate booking panel
 */
public class SimulateBookingController {
    private hotelGuiView gui;
    private createHotelModel model;
    private SimulateBookingModel model2;
    private manageHotelModel model3;


    /**
     * Constructor for the SimulateBookingController class
     * @param gui - Instance of hotelGuiView
     * @param model - Instance of createHotelModel
     */
    public SimulateBookingController(hotelGuiView gui, createHotelModel model){
        this.gui = gui;
        this.model = model;
        this.model3 = new manageHotelModel(model.getHotels());
        this.model2 = new SimulateBookingModel(gui, model3);
        this.gui.addBookListener(new BookingListener());
    }

    /**
     * Listener class for the booking button. Books a room in a hotel when the button is pressed.
     */
    class BookingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String customerName = gui.getCustomerNameField();
            int checkIn = gui.getCheckInField();
            int checkOut = gui.getCheckOutField();

            Hotel h = gui.getHotelOptions(model.getHotels());
            if(h != null) {
                model2.booking(model.getHotels(), h, customerName, checkIn, checkOut);
                gui.getCardLayout().show(gui.getMainPanel(), "home");
                gui.clearHotelFields();
            } else {
                gui.getCardLayout().show(gui.getMainPanel(), "home");
                gui.clearHotelFields();
            }
        
           
        }
    }




}
