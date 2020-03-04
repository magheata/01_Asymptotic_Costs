package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Window extends JFrame {

    public final JButton o1;
    public final JButton on;
    public final JButton onlogn;
    public final JButton onsqr;
    private Graph graph;

    public Window(String frameName) {
        super(frameName);
        graph = new Graph();
        // Create and set up a frame window
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define new buttons
        o1 = new JButton("O(1)");
        on = new JButton("O(n)");
        onlogn = new JButton("O(n*logn)");
        onsqr = new JButton("O(n^2)");
        // Define the panel to hold the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(o1);
        buttonsPanel.add(on);
        buttonsPanel.add(onlogn);
        buttonsPanel.add(onsqr);
        this.getContentPane().add(graph, BorderLayout.CENTER);
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public void addAsymtoticListener(ActionListener asymtoticButtonListener){
        o1.addActionListener(asymtoticButtonListener);
        on.addActionListener(asymtoticButtonListener);
        onlogn.addActionListener(asymtoticButtonListener);
        onsqr.addActionListener(asymtoticButtonListener);
    }

    public void paintPoint(List<Point> points){
        graph.paintPoints(this.getGraphics(), points);
    }
}
