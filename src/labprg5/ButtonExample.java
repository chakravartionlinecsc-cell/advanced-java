package labprg5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonExample {
	


	    JLabel l1;

	    ButtonExample() {

	        JFrame f = new JFrame("Button Example");

	        l1 = new JLabel();
	        l1.setBounds(50, 50, 700, 100);
	        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));

	        JButton b1 = new JButton("India");
	        JButton b2 = new JButton("SriLanka");

	        // Button 1
	        b1.setBounds(100, 200, 120, 50);
	        b1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                l1.setText("India is pressed");
	            }
	        });

	        // Button 2
	        b2.setBounds(250, 200, 120, 50);
	        b2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                l1.setText("SriLanka is pressed");
	            }
	        });

	        // Add components
	        f.add(b1);
	        f.add(b2);
	        f.add(l1);

	        // Frame settings
	        f.setSize(500, 350); // increased size for better display
	        f.setLayout(null);
	        f.setVisible(true);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {
	        new ButtonExample();
	    }
	}


