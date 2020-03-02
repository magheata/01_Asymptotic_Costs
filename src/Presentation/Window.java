package Presentation;

import Application.AsymtoticController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private final JButton on;
    private final JButton onlogn;
    private final JButton onsqr;

    public Window(String frameName) {
        super(frameName);
        // Create and set up a frame window
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define new buttons
        on = new JButton("Button 1");
        onlogn = new JButton("Button 2");
        onsqr = new JButton("Button 3");
        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(on);
        this.getContentPane().add(onlogn);
        this.getContentPane().add(onsqr);
        // Set the window to be visible as the default to be false
        this.pack();
        this.setVisible(true);
    }

    public void addAsymtoticListener(ActionListener asymtoticButtonListener){
        on.addActionListener(asymtoticButtonListener);
        onlogn.addActionListener(asymtoticButtonListener);
        onsqr.addActionListener(asymtoticButtonListener);
    }
}
