package labprg5;


import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class SwingExample {

    // Constructor
    SwingExample() {

        // Create JFrame
        JFrame jfrm = new JFrame("A Simple Swing Application");

        // Set size
        jfrm.setSize(600, 200);

        // Close operation
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create label
        JLabel jlab = new JLabel("Hello! VI C , Welcome to Swing Programming!");

        // Set font
        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));

        // Set color
        jlab.setForeground(Color.BLUE);

        // Center text
        jlab.setHorizontalAlignment(JLabel.CENTER);

        // Add label to frame
        jfrm.add(jlab);

        // Make visible
        jfrm.setVisible(true);
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExample();
            }
        });
    }
}
