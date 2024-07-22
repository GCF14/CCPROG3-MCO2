import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewHotelController {
    private hotelGuiView gui;
    private createHotelModel model;

    public viewHotelController(hotelGuiView gui, createHotelModel model) {
        this.gui = gui;
        this.model = model;

        this.gui.getHighLevelButton().addActionListener(new HighLevelButtonListener());
        this.gui.getLowLevelButton().addActionListener(new LowLevelButtonListener());
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

