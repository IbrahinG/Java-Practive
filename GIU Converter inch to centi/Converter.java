
/*
 * Converter.java
 * 
 * Main class to launch the distance converter GUI application.
 * This program allows users to convert distances between inches and centimeters.
 * 
 * Author: Ibrahin Gonzalez
 * Created: October 27, 2024
 */
import javax.swing.*;

public class Converter {
    /*
     * Main method to launch the GUI in the Event Dispatch Thread.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConverterFrame frame = new ConverterFrame();
            frame.setVisible(true);
        });
    }
}
