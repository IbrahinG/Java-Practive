
/*
 * ConverterFrame.java
 * 
 * A GUI frame for converting distances between inches and centimeters.
 * The user can enter a distance, select a conversion type, and view the result.
 * 
 * Author: Ibrahim Gonzalez
 * Created: October 27, 2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterFrame extends JFrame {
    private JTextField inputField;
    private JComboBox<String> conversionOptions;
    private JLabel resultLabel;

    /*
     * Constructor to set up the GUI components for the conversion frame.
     */
    public ConverterFrame() {
        setTitle("Distance Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Initialize components
        inputField = new JTextField(10);
        String[] options = { "Inches to Centimeters", "Centimeters to Inches" };
        conversionOptions = new JComboBox<>(options);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result: ");

        // Set layout
        setLayout(new GridLayout(4, 1, 10, 10));
        add(new JLabel("Enter amount to convert:"));
        add(inputField);
        add(conversionOptions);
        add(convertButton);
        add(resultLabel);

        // Add action listener to the button
        convertButton.addActionListener(new ConversionAction());
    }

    /*
     * Inner class to handle the conversion action when the button is clicked.
     */
    private class ConversionAction implements ActionListener {
        private final double INCH_TO_CM = 2.54;
        private final double CM_TO_INCH = 1 / INCH_TO_CM;

        /*
         * Performs the conversion based on the selected option.
         *
         * @param e Action event triggered by the convert button.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double input = Double.parseDouble(inputField.getText());
                double result;

                // Determine the conversion type based on combo box selection
                if (conversionOptions.getSelectedItem().equals("Inches to Centimeters")) {
                    result = input * INCH_TO_CM;
                } else {
                    result = input * CM_TO_INCH;
                }

                // Display result in label with two decimal places
                resultLabel.setText("Result: " + String.format("%.2f", result));

            } catch (NumberFormatException ex) {
                // Display error dialog for invalid input
                JOptionPane.showMessageDialog(ConverterFrame.this,
                        "Please enter a valid number.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
