import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hotelController {
    private hotelGuiView view;
    private createHotelModel model;

    public hotelController(hotelGuiView view, createHotelModel model) {
        this.view = view;
        this.model = model;

        this.view.addCreateHotelButtonListener(new CreateHotelButtonListener());
        this.view.addViewInfoButtonListener(new ViewInfoButtonListener());
        this.view.addManageButtonListener(new ManageButtonListener());
        this.view.addBookingButtonListener(new addBookingButtonListener());
        this.view.addBackButtonListener(new BackButtonListener());
        this.view.addBackButtonListener2(new BackButtonListener());
        this.view.addBackButtonListener3(new BackButtonListener());
        this.view.addBackButtonListener4(new BackButtonListener());

    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardLayout().show(view.getMainPanel(), "home");
        }
    }

    class CreateHotelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardLayout().show(view.getMainPanel(), "createHotel");
        }
    }

    class ViewInfoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardLayout().show(view.getMainPanel(), "viewHotel");
        }
    }

    class ManageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.getCardLayout().show(view.getMainPanel(), "manageHotel");
        }
    }

    class addBookingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // view.getCardLayout().show(view.getMainPanel(), "simulateBooking");
            // Hotel selectedHotel = view.getHotelOptions(model.getHotels());
            view.getCardLayout().show(view.getMainPanel(), "simulateBooking");
        }
    }

    
}
