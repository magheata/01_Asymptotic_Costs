/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Window extends JFrame {

    public JButton o1;
    public JButton on;
    public JButton onlogn;
    public JButton onsqr;
    private Graph graph;

    /***
     *
     * @param frameName
     * @param number_of_examples
     */
    public Window(String frameName, int number_of_examples) {
        super(frameName);
        graph = new Graph(number_of_examples);
        // Create and set up a frame window
        this.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(graph, BorderLayout.CENTER);
        this.getContentPane().add(addButtons(), BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    /***
     *
     * @param asymtoticButtonListener
     */
    public void addAsymtoticListener(ActionListener asymtoticButtonListener){
        o1.addActionListener(asymtoticButtonListener);
        on.addActionListener(asymtoticButtonListener);
        onlogn.addActionListener(asymtoticButtonListener);
        onsqr.addActionListener(asymtoticButtonListener);
    }

    /***
     *
     * @param points
     * @param color
     */
    public void paintPoints(List<Domain.Point> points, int color){
        graph.paintPoints(this.getGraphics(), points, color);
    }

    /***
     *
     * @return
     */
    private JPanel addButtons(){
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
        return buttonsPanel;
    }
}
