import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewHotelController {
    private hotelGuiView view;
    private createHotelModel model;

    public viewHotelController(hotelGuiView view, createHotelModel model) {
        this.view = view;
        this.model = model;

        this.view.getHighLevelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hotel selectedHotel = view.getHotelOptions(model.getHotels());
                if (selectedHotel != null) {
                    view.displayHighLevelInfo(selectedHotel);
                }
            }
        });

        this.view.getLowLevelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Hotel selectedHotel = view.getHotelOptions(model.getHotels());
                if (selectedHotel != null) {
                    view.getCardLayout().show(view.getMainPanel(), "lowLevel");
                }
            }
        });

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
    }

}
