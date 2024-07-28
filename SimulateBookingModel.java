//package
import java.util.ArrayList;

/**
 * This class represents the model for simulating a booking in a hotel.
 */
public class SimulateBookingModel {

    private hotelGuiView gui;
    private manageHotelModel model2;

    /**
     * Constructor for the SimulateBookingModel class
     * @param hotels - ArrayList of hotels which contains all the hotels
     * @param  gui - Instance of hotelGuiView
     * @param model2 - Instance of manageHotelModel
     */
    public SimulateBookingModel(hotelGuiView gui, manageHotelModel model2) {
        this.gui = gui;
        this.model2 = model2;
    }
    

    /** Checks if the days are booked in a hotel
     * Preconditions: h is an instance of Hotel, checkIn, checkOut, and room are integers
     * Postconditions: returns a boolean
     * @param h - Instance of Hotel
     * @param checkIn - The check-in date
     * @param checkOut - The check-out date
     * @param room - The room number
     * @return boolean - True if the days are booked, false otherwise
     */
    public boolean areDaysBooked(Hotel h, int checkIn, int checkOut, int room) {
        for (int i = 0; i < h.getReservations().size(); i++) {
            Reservation reservation = h.getReservations().get(i);
            if (reservation.getRoomNumber() == room) {
                // Check for overlap with existing reservation
                if (!(checkIn >= reservation.getCheckOutDate() || checkOut < reservation.getCheckInDate())) {
                    return true;
                } 
                    
            }
        }
        return false;
    }
        
    
    /** Books a room in a hotel
     * Preconditions: hotels is an ArrayList of Hotels and instance hotels is initialized
     * Postconditions: A room is booked in a hotel
     * @param hotels - ArrayList of hotels which contains all the hotels
     */
    public void booking(ArrayList<Hotel> hotels, Hotel h, String customerName, int checkInDate, int checkOutDate) { 
        String code;
        int roomType = 0;
    
        if (h != null) { // just fixed it so that theres no return statement in the else :v
            if(gui.validateCheckDates()){
                roomType = gui.getRoomOptions();
                boolean bookedRoom = false;
        
                int room, maxRoom;
                float roomPrice;
        
                switch(roomType) {
                    case 0:
                        room = 1;
                        maxRoom = hotels.get(model2.findHotel(h.getName())).getRooms().lastStandard();
                        roomPrice = hotels.get(model2.findHotel(h.getName())).getRoomPrice();
                        break;
                    case 1:
                        room = hotels.get(model2.findHotel(h.getName())).getRooms().firstDeluxe();
                        maxRoom = hotels.get(model2.findHotel(h.getName())).getRooms().lastDeluxe();
                        roomPrice = hotels.get(model2.findHotel(h.getName())).getDeluxePrice();
                        break;
                    case 2:
                        room = hotels.get(model2.findHotel(h.getName())).getRooms().firstExecutive();
                        maxRoom = hotels.get(model2.findHotel(h.getName())).getRooms().lastExecutive();
                        roomPrice = hotels.get(model2.findHotel(h.getName())).getExecutivePrice();
                        break;
                    default:
                        room = -1;
                        maxRoom = -1;
                        roomPrice = -1;
                        break;
                }
        
                float totalPrice = 0;
                for(int i = checkInDate; i < checkOutDate; i++) {
                    totalPrice += roomPrice * hotels.get(model2.findHotel(h.getName())).getDatePriceModifiers(i);
                }
        
                while(room <= maxRoom && !bookedRoom) {
                    if (!areDaysBooked(hotels.get(model2.findHotel(h.getName())), checkInDate, checkOutDate, room)) {
                        code = gui.displayEnterDiscount();
                        if (code == null) {
                            // User canceled the discount code input
                            gui.getCardLayout().show(gui.getMainPanel(), "home");
                            return;
                        } else if (!code.isEmpty()) {
                            // Apply discount code
                            if (gui.checkCoupon(code, checkInDate, checkOutDate) == 1) {
                                totalPrice *= 0.9;
                            } else if (gui.checkCoupon(code, checkInDate, checkOutDate) == 2) {
                                totalPrice -= roomPrice;
                            } else if (gui.checkCoupon(code, checkInDate, checkOutDate) == 3){
                                totalPrice -= 0;
                                gui.getCardLayout().show(gui.getMainPanel(), "simulateBooking");
                                return;
                            } else if(gui.checkCoupon(code, checkInDate, checkOutDate) == 4){
                                totalPrice *= 0.93;
                            } else if (gui.checkCoupon(code, checkInDate, checkOutDate) == 5) {
                                totalPrice -= 0;
                            } else if (gui.checkCoupon(code, checkInDate, checkOutDate) == 6){
                                totalPrice -= 0;
                                gui.getCardLayout().show(gui.getMainPanel(), "simulateBooking");
                                return;
                            }
                        }
        
                        Reservation newReservation = new Reservation(customerName, checkInDate, checkOutDate, room, totalPrice);
                        hotels.get(model2.findHotel(h.getName())).addReservation(newReservation);
                        gui.displaySuccessBooking();
                        bookedRoom = true;
                        System.out.println("Room booked successfully: Room " + room);
                    }
        
                    room++;
                }
        
                if (!bookedRoom) {
                    gui.displayNoRooms();
                    gui.getCardLayout().show(gui.getMainPanel(), "home");
                }
            } else {
                gui.displayValidCheckDates();
                gui.clearHotelFields();
                gui.getCardLayout().show(gui.getMainPanel(), "home");
            }
        } else {
            gui.getCardLayout().show(gui.getMainPanel(), "home");
        }
    }
    
    
    

}
