//package
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class for the manage hotel panel
 */
public class manageHotelController {

    private hotelGuiView gui;
    private createHotelModel model;
    private manageHotelModel model2;
    private Hotel selectedHotel;
    private Hotel h = null;
    int roomType;

    /**
     * Constructor for the manageHotelController class
     * @param gui - Instance of hotelGuiView
     * @param model - Instance of createHotelModel
     */
    public manageHotelController(hotelGuiView gui, createHotelModel model) {
        this.gui = gui;
        this.model = model;
        this.model2 = new manageHotelModel(model.getHotels());
        this.gui.addChangeNameListener(new changeNameButtonListener());
        this.gui.addChangeNewNameListener(new changeNewNameListener());
        this.gui.addBackButtonListener5(new backButtonListener());
        this.gui.addAddNewRoomsListener(new AddRoomsListener());
        this.gui.addAddRoomListener(new addRoomListener());
        this.gui.addRemoveNewRoomsListener(new RemoveRoomsListener());
        this.gui.addRemoveRoomsListener(new removeListener());
        this.gui.addUpdateBaseRoomPriceListener(new updateBaseRoomListener());
        this.gui.addUpdatePriceListener(new updateListener());
        this.gui.addRemoveReservationListener(new removeReservationListener());
        this.gui.addRemoveHotelListener(new addremoveHotelsListener());
        this.gui.addUpdatePriceModifierListener(new updatePriceModiferListener());

    }

    /**
     * Listener class for the change name button. Redirects to the change panel when the button is pressed.
     */
    class changeNameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedHotel = gui.getHotelOptions(model.getHotels());

            if (selectedHotel != null) {
                gui.getCardLayout().show(gui.getMainPanel(), "changePanel");
            }
        }
    }

    /**
     * Listener class for the change new name button. Changes the name of the hotel when the button is pressed.
     */
    class changeNewNameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedHotel != null) {
                int index = model2.findHotel(selectedHotel.getName());
                String newName = gui.getNewName();
                
                if (newName == null || newName.trim().isEmpty()) {
                    gui.displayFillOut();  // Call method to display message
                    gui.getCardLayout().show(gui.getMainPanel(), "changePanel");
                } else {
                    model.getHotels().get(index).setName(newName);
                    if(gui.displayConfirm() == 1){
                        gui.displayvalid();
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                        gui.clearHotelFields();
                    } else {
                        gui.displayInvalid();
                        gui.getCardLayout().show(gui.getMainPanel(), "changePanel");
                    }
                }
                
                
            }
        }
    }

    /**
     * Listener class for the back button. Shows the manage hotel panel when the back button is pressed.
     */
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            gui.getCardLayout().show(gui.getMainPanel(), "manageHotel");
        }
    }

    /**
     * Listener class for the add new rooms button. Adds rooms when the button is pressed.
     */
    class AddRoomsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (h.getName()!= null) {
                Hotel hotel = model.getHotels().get(model2.findHotel(h.getName()));
                int rooms = gui.getAddRooms();
        

                int confirm = gui.displayConfirmAddRooms(rooms);

                if (confirm == JOptionPane.YES_OPTION && rooms > 0) {
                    int num = model2.addRooms(hotel, roomType, rooms);
                    gui.displaySuccessAddRooms(num);
                    gui.getCardLayout().show(gui.getMainPanel(), "home");
                } else {
                    gui.displayInvalid();
                    gui.getCardLayout().show(gui.getMainPanel(), "addPanel");
                }
            }
            
        }
    }

    /**
     * Listener class for the add rooms button. Redirects to the add panel when the button is pressed.
     */
    class addRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            gui.getCardLayout().show(gui.getMainPanel(), "addPanel");
            h = gui.getHotelOptions(model.getHotels());

            if(h != null){
                roomType = gui.getRoomOptions();
            }
            
        }
    }

    /**
     * Listener class for the remove rooms button. Removes rooms when the button is pressed.
     */
    class RemoveRoomsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (h.getName() != null) {
                 int hotelIndex = model2.findHotel(h.getName());
                h = model.getHotels().get(hotelIndex);
                int rooms = gui.getRemoveRooms();
                int confirm = gui.displayConfirmRemoveRooms(rooms);
                if (confirm == JOptionPane.YES_OPTION && rooms >= 0) {
                    int num = model2.removeRooms(h, roomType, rooms);
                    gui.displaySuccessRemoveRooms(num);
                    gui.getCardLayout().show(gui.getMainPanel(), "home");
                    gui.clearHotelFields();
                } else {
                    gui.displayInvalid();
                    gui.getCardLayout().show(gui.getMainPanel(), "removePanel");
                }
            }

        }
    }

    /**
     * Listener class for the remove button. Redirects to the remove panel when the button is pressed.
     */
    class removeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "removePanel");
            h = gui.getHotelOptions(model.getHotels());

            if(h != null){
                roomType = gui.getRoomOptions();
            }
            
        }
    }

    /**
     * Listener class for the update base room price button. Redirects to the update price panel when the button is pressed.
     */
    class updateBaseRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            h = gui.getHotelOptions(model.getHotels());

            if(h != null){
                gui.getCardLayout().show(gui.getMainPanel(), "updatePricePanel");
            }
            
        }
    }

    /**
     * Listener class for the update price button. Updates the base room price when the button is pressed.
     */
    class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (h.getName() != null) {
                int hotelIndex = model2.findHotel(h.getName());
                h = model.getHotels().get(hotelIndex);
                float newPrice = gui.getUpdatePriceField();
                int confirm = gui.displayConfirmUpdateBasePrice(newPrice);
                if (confirm == JOptionPane.YES_OPTION) {
                    int num = model2.newPrice(h, newPrice);
                    if (num == 1) {
                        gui.displaySuccessPriceChange();
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                    } else if (num == 0){
                        gui.displayUnsuccessPriceChange(1);
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                    } else {
                        gui.displayUnsuccessPriceChange(2);
                        gui.getCardLayout().show(gui.getMainPanel(), "updatePricePanel");
                    }
                }
    
           }
            
        }
    }

    /**
     * Listener class for the remove reservation button. Removes a reservation when the button is pressed.
     */
    class removeReservationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            h = gui.getHotelOptions(model.getHotels());
            if (h != null && h.getName() != null) {
                int index = gui.getReservationOptions(h);
                if (index >= 0 && index < h.getNumOfReservations()) {
                    int confirm = gui.displayConfirmRemoveReservation(h, index);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model2.removeReservation(h, index);
                        gui.displaySuccessReservationRemoved();
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                    }
                }
            } else {
                gui.displayNoHotels();
                gui.getCardLayout().show(gui.getMainPanel(), "home");
            }
        }
    }

    /**
     * Listener class for the remove hotel button. Removes a hotel when the button is pressed.
     */
    class addremoveHotelsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            h = gui.getHotelOptions(model.getHotels());
            if (h != null && h.getName() != null) {
                int confirm = JOptionPane.CLOSED_OPTION;
                while (confirm == JOptionPane.CLOSED_OPTION) {
                    confirm = gui.displayConfirmRemoveHotel(h);
                    if (confirm == JOptionPane.YES_OPTION) {
                        model2.getHotels().remove(h);
                        gui.displayRemoveHotelMessage(confirm);
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                        
                    } else if (confirm == JOptionPane.NO_OPTION) {
                        gui.displayRemoveHotelMessage(confirm);
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                        
                    }
                }
            } else if (model.getHotels().isEmpty()){ 
                gui.getCardLayout().show(gui.getMainPanel(), "home");
            } else {
                gui.displayRemoveHotelMessage(3);
                gui.getCardLayout().show(gui.getMainPanel(), "home");
            }
        }
    }

    /**
     * Listener class for the update price modifier button. Updates the price modifier when the button is pressed.
     */
    class updatePriceModiferListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Hotel h = gui.getHotelOptions(model.getHotels());
            if (h != null && h.getName() != null && gui.displayEnterPriceModifier(h) != false) {
                int confirm = JOptionPane.CLOSED_OPTION;
                while (confirm == JOptionPane.CLOSED_OPTION) {
                    gui.displayEnterPriceModifier(h);
                    confirm = gui.displayConfirmUpdatePrice();
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        gui.displayPriceRateMessage(1);
                        gui.getCardLayout().show(gui.getMainPanel(), "home");
                        
                    } else {
                        gui.displayPriceRateMessage(2);
                        gui.getCardLayout().show(gui.getMainPanel(), "manageHotel");
                        
                    }
                }
            } else if (model.getHotels().isEmpty()) {
                gui.getCardLayout().show(gui.getMainPanel(), "home");
                
            } else {
                gui.displayPriceRateMessage(3);
                gui.getCardLayout().show(gui.getMainPanel(), "home");
                
            }
        }
    }
    



}
