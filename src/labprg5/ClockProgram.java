package labprg5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClockProgram extends JFrame implements ActionListener {

    JButton digitalBtn, hourglassBtn;
    JLabel messageLabel;

    public ClockProgram() {
        setTitle("Clock Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Load images from package (labprg5 folder inside src)
        ImageIcon digitalIcon = new ImageIcon(getClass().getResource("/labprg5/Clock.JPG"));
        ImageIcon hourglassIcon = new ImageIcon(getClass().getResource("/labprg5/Hourglass.JPG"));

        // Create buttons with images
        digitalBtn = new JButton(digitalIcon);
        hourglassBtn = new JButton(hourglassIcon);

        // Label for message
        messageLabel = new JLabel("Click a button");

        // Add action listener
        digitalBtn.addActionListener(this);
        hourglassBtn.addActionListener(this);

        // Add to frame
        add(messageLabel);
        add(digitalBtn);
        add(hourglassBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalBtn) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == hourglassBtn) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ClockProgram();
    }
}