// package prog_mco2;
import javax.swing.SwingUtilities;

/**Driver class that runs the program and contains the main method
 */
public class Driver {
    /** Main method that runs the program
     * Preconditions: none
     * Postconditions: Program runs
     * @param args - Command line arguments
     */
    public static void main(String[] args) {

        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                hotelGuiView gui = new hotelGuiView();
                
                gui.setVisible(true);
            }

        });



    }

}
