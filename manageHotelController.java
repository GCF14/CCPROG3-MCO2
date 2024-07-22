package prog_mco2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class manageHotelController {
    private hotelGuiView gui;
    private manageHotelModel model;

    public manageHotelController(hotelGuiView gui, manageHotelModel model) {
        this.gui = gui;
        this.model = model;

        this.gui.addChangeNameListener(new ChangeNameListener());
        this.gui.addAddRoomsListener(new AddRoomsListener());
        this.gui.addRemoveRoomsListener(new RemoveRoomsListener());
        this.gui.addUpdatePriceListener(new UpdatePriceListener());
        this.gui.addRemoveReservationListener(new RemoveReservationListener());
        this.gui.addRemoveHotelListener(new RemoveHotelListener());
        this.gui.addChangeDatePriceListener(new ChangeDatePriceListener());
    }

    class ChangeNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "changePanel");
            String hotel = gui.getHotelOptions(model.getHotels());
            if (hotel != null) {
                int index = model.findHotel(hotel);
                if (index != -1) {
                    if (model.findHotel(gui.getNewName()) != -1) {
                        int confirm = JOptionPane.showConfirmDialog(gui, "Change hotel name to " + gui.getNewName() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            model.changeHotelName(model.getHotels().get(index), gui.getNewName());
                            JOptionPane.showMessageDialog(gui, "Name successfully changed.");
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(gui, "Hotel already exists.");
                }
                else
                    JOptionPane.showMessageDialog(gui, "No existing hotels");
            }
        }  
    }

    class AddRoomsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "addPanel");
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {
                int roomType = gui.getRoomOptions();
                Hotel hotel = model.getHotels().get(model.findHotel(name));
                int rooms = gui.getAddRooms();

                int confirm = JOptionPane.showConfirmDialog(gui, "Add " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int num = model.addRooms(hotel, roomType, rooms);
                    JOptionPane.showMessageDialog(gui, num + "rooms successfully added.");
                }
            }
            
        }
    }

    class RemoveRoomsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "removePanel");
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {
                int roomType = gui.getRoomOptions();
                Hotel hotel = model.getHotels().get(model.findHotel(name));
                int rooms = gui.getRemoveRooms();
                int confirm = JOptionPane.showConfirmDialog(gui, "Remove " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int num = model.removeRooms(hotel, roomType, rooms);
                    JOptionPane.showMessageDialog(gui, num + "rooms successfully removed");
                }
            }
        }
    }

    class UpdatePriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "pricePanel");
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {
                Hotel hotel = model.getHotels().get(model.findHotel(name));
                float newPrice = gui.getNewPrice();
                int confirm = JOptionPane.showConfirmDialog(gui, "Update base room price to " + newPrice + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int num = model.newPrice(hotel, newPrice);
                    if (num == 1)
                        JOptionPane.showMessageDialog(gui, "Room price successfully updated.");
                    else if (num == 0)
                        JOptionPane.showMessageDialog(gui, "Price change unsuccessful -- Hotel currently has reservations.");
                    else
                        JOptionPane.showMessageDialog(gui, "Price change unsuccessful -- New price too small.");
                }
            }
        }
    }

    class RemoveReservationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "reservationsPanel");
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {}
            Hotel hotel = model.getHotels().get(model.findHotel(name));
            int index = gui.getReservationOptions(hotel);
                int confirm = JOptionPane.showConfirmDialog(gui, "Remove reservation of " + hotel.getReservations().get(index).getGuestName() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeReservation(hotel, index);
                    JOptionPane.showMessageDialog(gui, "Reservation successfully removed.");
                }
            }
        }
    

    class RemoveHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {
                int index = model.findHotel(name);
                model.removeHotel(model.getHotels(), index);
            }
        }
    }

    class ChangeDatePriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "modifyPanel");
            String name = gui.getHotelOptions(model.getHotels());
            if (name != null) {
                Hotel hotel = model.getHotels().get(model.findHotel(name));
                model.modifyDatePriceModifier(hotel, gui.getDayField(), gui.getPercentField());
            }
        }
    }


}





