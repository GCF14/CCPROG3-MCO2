import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class viewHotelController {
    private hotelGuiView view;
    private createHotelModel model;
    private viewHotelModel model2;
    private Hotel h;

    public viewHotelController(hotelGuiView view, createHotelModel model, viewHotelModel model2) {
        this.view = view;
        this.model = model;
        this.model2 = new viewHotelModel(model.getHotels());

        this.view.getHighLevelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hotel selectedHotel = view.getHotelOptions(model.getHotels());
                if (selectedHotel != null) {
                    view.displayHighLevelInfo(selectedHotel);
                }
            }
        });

        // this.view.getLowLevelButton().addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {

        //         Hotel selectedHotel = view.getHotelOptions(model.getHotels());
        //         if (selectedHotel != null) {
        //             view.getCardLayout().show(view.getMainPanel(), "lowLevel");
        //         }
        //     }
        // });

        this.view.getBackButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCardLayout().show(view.getMainPanel(), "home");
            }
        });

        this.view.backToViewHotelFromHighLevel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCardLayout().show(view.getMainPanel(), "viewHotel");
            }
        });

        this.view.backToViewHotelFromLowLevel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCardLayout().show(view.getMainPanel(), "viewHotel");
            }
        });
        
        
        this.view.addViewLowLevelListener(new addViewLowListener());
        this.view.addLowLevelButton(new addLowLevelButtonListener());
    }



    //for redirecting
    class addLowLevelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            h = view.getHotelOptions(model.getHotels());

            if (h != null) {
                view.getCardLayout().show(view.getMainPanel(), "lowLevel");
            }
        }
    }

    //for viewing the information
    class addViewLowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int dayToCheck = view.getdayField();
            int roomToCheck = view.getRoomCheckField();

            if((dayToCheck > 0 || dayToCheck < 32) && (roomToCheck > 0 || roomToCheck <= h.getRooms().getTotal())) {

                int index = view.getReservationOptions(h);
                if (index >= 0 && index < h.getNumOfReservations()) {
                    int confirm = JOptionPane.showConfirmDialog(view, "Confirm view Reservation?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        view.displayLowLevelInfo(h, index, dayToCheck, roomToCheck, model2);
                    }
                }



            } else {

            }


           
        }
    }



}
