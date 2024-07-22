import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewHotelController {
    private hotelGuiView gui;
    private hotelModel model;

    public viewHotelController(hotelGuiView gui, hotelModel model) {
        this.gui = gui;
        this.model = model;

        // Add action listeners for the high and low level buttons
        this.gui.getHighLevelButton().addActionListener(new HighLevelButtonListener());
        this.gui.getLowLevelButton().addActionListener(new LowLevelButtonListener());

        // Add action listeners for the back buttons
        this.gui.backToViewHotelFromHighLevel().addActionListener(new BackToViewHotelListener());
        this.gui.backToViewHotelFromLowLevel().addActionListener(new BackToViewHotelListener());
    }

    class HighLevelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "highLevel");
        }
    }

    class LowLevelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "lowLevel");
        }
    }

    class BackToViewHotelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "viewHotel");
        }
    }
}

