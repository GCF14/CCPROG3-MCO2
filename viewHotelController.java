import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class viewHotelController {
    private hotelGuiView gui;
    private hotelModel model;

    public viewHotelController(hotelGuiView gui, hotelModel model) {
        this.gui = gui;
        this.model = model;
        initialize();
    }

    private void initialize() {
        gui.addBackButtonListener(new BackButtonListener());
        gui.addHighLevelButtonListener(new HighLevelButtonListener());
        gui.addLowLevelButtonListener(new LowLevelButtonListener());
    }
    

    class HighLevelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Hide buttons and update UI
            gui.getHighLevelButton().setVisible(false);
            gui.getLowLevelButton().setVisible(false);
            gui.getMainPanel().revalidate();
            gui.getMainPanel().repaint();

            // Add new components after the UI update
            SwingUtilities.invokeLater(() -> {
                gui.addNewComponents();
                gui.getMainPanel().revalidate();
                gui.getMainPanel().repaint();
            });
        }
    }

    class LowLevelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Hide buttons and update UI
            gui.getHighLevelButton().setVisible(false);
            gui.getLowLevelButton().setVisible(false);
            gui.getMainPanel().revalidate();
            gui.getMainPanel().repaint();

            // Add new components after the UI update
            SwingUtilities.invokeLater(() -> {
                gui.addNewComponents();
                gui.getMainPanel().revalidate();
                gui.getMainPanel().repaint();
            });
        }
    }

    

    class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            gui.getCardLayout().show(gui.getMainPanel(), "home");
        }
    }

    private void handleBackButton() {
        gui.getCardLayout().show(gui.getMainPanel(), "home");
    }
}
