//package
import java.util.ArrayList;

/**
 * This class represents the model for simulating a booking in a hotel.
 */
public class SimulateBookingModel extends SimulateBooking{

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
    
    /** Books a room in a hotel
     * Preconditions: hotels is an ArrayList of Hotels and instance hotels is initialized
     * Postconditions: A room is booked in a hotel if certain conditions are met
     * @param hotels - ArrayList of hotels which contains all the hotels
     * @param h - Hotel to be booked
     * @param customerName - Name of the customer
     * @param checkInDate - Check in date of the booking
     * @param checkOutDate - Check out date of the booking
     */
    public void booking(ArrayList<Hotel> hotels, Hotel h, String customerName, int checkInDate, int checkOutDate) { 
        String code;
        int roomType = 0;
    
        roomType = gui.getRoomOptions();
        if (h != null && roomType >= 0) { 
            if(gui.validateCheckDates()){
                
                boolean bookedRoom = false;
        
                int room, maxRoom;
                float roomPrice;
                int discount;
        
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
                
                code = gui.displayEnterDiscount();
                int coupon = 0;
                if (!(code.equals("") || code == null))
                    coupon = gui.checkCoupon(code, checkInDate, checkOutDate);
            
                while(room <= maxRoom && !bookedRoom) {
                    if (!areDaysBooked(hotels.get(model2.findHotel(h.getName())), checkInDate, checkOutDate, room)) {
                        
                        // Apply discount code
                        switch (coupon) {
                            case 1:
                                totalPrice *= 0.9;
                                discount = 1;
                                break;
                            case 2:
                                totalPrice -= roomPrice;
                                discount = 2;
                                break;
                            case 3:
                                totalPrice *= 0.93;
                                discount = 3;
                                break;
                            default:
                                discount = -1;
                                break;
                        }
                                                   
                        Reservation newReservation = new Reservation(customerName, checkInDate, checkOutDate, room, totalPrice, discount);
                        hotels.get(model2.findHotel(h.getName())).addReservation(newReservation);
                        gui.displaySuccessBooking();
                        bookedRoom = true;
                    }
        
                    room++;
                }
        
                if (!bookedRoom) {
                    gui.displayNoRooms();
                }

            } else {
                gui.displayValidCheckDates();
                gui.clearHotelFields();
            }
        } 
    }
    
    
    

}
