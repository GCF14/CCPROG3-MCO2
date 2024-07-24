import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageHotelController {

    private hotelGuiView gui;
    private createHotelModel model;
    private manageHotelModel model2;
    private Hotel selectedHotel;
    private Hotel h = null;
    int roomType;

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

        

    }

    class changeNameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedHotel = gui.getHotelOptions(model.getHotels());

            if (selectedHotel != null) {
                gui.displayChangeName();
            }
        }
    }

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


    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            gui.getCardLayout().show(gui.getMainPanel(), "manageHotel");
        }
    }

    class AddRoomsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (h.getName()!= null) {
                Hotel hotel = model.getHotels().get(model2.findHotel(h.getName()));
                int rooms = gui.getAddRooms();
        

                int confirm = JOptionPane.showConfirmDialog(gui, "Add " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION && rooms > 0) {
                    int num = model2.addRooms(hotel, roomType, rooms);
                    JOptionPane.showMessageDialog(gui, num + " rooms successfully added.");
                    gui.getCardLayout().show(gui.getMainPanel(), "home");
                } else {
                    gui.displayInvalid();
                    gui.getCardLayout().show(gui.getMainPanel(), "addPanel");
                }
            }
            
        }
    }

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


    class RemoveRoomsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (h.getName() != null) {
                 int hotelIndex = model2.findHotel(h.getName());
                h = model.getHotels().get(hotelIndex);
                int rooms = gui.getRemoveRooms();
                int confirm = JOptionPane.showConfirmDialog(gui, "Remove " + rooms + " rooms?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION && rooms >= 0) {
                    int num = model2.removeRooms(h, roomType, rooms);
                    JOptionPane.showMessageDialog(gui, num + " rooms successfully removed");
                    gui.getCardLayout().show(gui.getMainPanel(), "home");
                    gui.clearHotelFields();
                } else {
                    gui.displayInvalid();
                    gui.getCardLayout().show(gui.getMainPanel(), "removePanel");
                }
            }

        }
    }

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







}
