import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class createHotelController {
    private createHotelView view;
    private createHotelModel model;
    private ArrayList<Hotel> hotels;

    public createHotelController(createHotelView view, createHotelModel model, ArrayList<Hotel> hotels) {
        this.view = view;
        this.model = model;
        this.hotels = hotels;

        this.view.addCreateButtonListener(new CreateButtonListener());
        this.view.addBackButtonListener(new BackButtonListener());
    }

    class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = view.getHotelName();
            int standardRooms = view.getStandardRooms();
            int deluxeRooms = view.getDeluxeRooms();
            int executiveRooms = view.getExecutiveRooms();

            if (findHotelByName(name) == null) {
                Hotel hotel = model.createHotel(name, standardRooms, deluxeRooms, executiveRooms);
                hotels.add(hotel);
                // Show success message (optional)
            } else {
                // Show error message: hotel already exists
            }
        }

        private Hotel findHotelByName(String name) {
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(name)) {
                    return hotel;
                }
            }
            return null;
        }
    }

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new HotelGui();
            view.dispose();
        }
    }
}
