import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulateBookingController {
    private hotelGuiView gui;
    private createHotelModel model;
    private SimulateBookingModel model2;
    private manageHotelModel model3;
    SimulateBooking  simulateBooking = new SimulateBooking();


    public SimulateBookingController(hotelGuiView gui, createHotelModel model){
        this.gui = gui;
        this.model = model;
        this.model3 = new manageHotelModel(model.getHotels());
        this.model2 = new SimulateBookingModel(model.getHotels(), gui, model3);
        this.gui.addBookListener(new BookingListener());
    }

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
