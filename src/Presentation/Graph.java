package Presentation;

import Domain.Interfaces.IGraph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph extends JPanel implements IGraph {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private static final int BORDER_GAP = 30;
    private static final Color GRAPH_COLOR_1 = Color.green;
    private static final Color GRAPH_COLOR_2 = Color.red;
    private static final Color GRAPH_COLOR_3 = Color.blue;
    private static final Color GRAPH_COLOR_4 = Color.lightGray;
    private static final Color GRAPH_POINT_COLOR = new Color(150, 50, 50, 180);
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    private static final int GRAPH_POINT_WIDTH = 10;
    private static int Y_HATCH_CNT;
    private static int number_of_examples;

    public Graph(int number_of_examples){
        this.number_of_examples = number_of_examples;
        Y_HATCH_CNT = number_of_examples;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // create x and y axes
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
        g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);
        // create hatch marks for y axis.
        for (int i = 0; i < Y_HATCH_CNT; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
            int y1 = y0;
            g2.drawLine(x0, y0, x1, y1);
        }
        // and for x axis
        for (int i = 0; i < number_of_examples - 1; i++) {
            int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (number_of_examples - 1) + BORDER_GAP;
            int x1 = x0;
            int y0 = getHeight() - BORDER_GAP;
            int y1 = y0 - GRAPH_POINT_WIDTH;
            g2.drawLine(x0, y0, x1, y1);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    public void paintPoints(Graphics g, List<Domain.Point> graphPointsInput, int color){
        long MIN_SCORE = getMinimumTime(graphPointsInput);
        Graphics2D g2 = (Graphics2D)g;
        Insets insets = getInsets();
        int h = getHeight() - insets.top - insets.bottom;
        g2.scale(1.0, -1.0);
        g2.translate(0, -h - insets.top);
        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (graphPointsInput.size() - 1);
        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < graphPointsInput.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) ((graphPointsInput.get(i).y * 2) / MIN_SCORE) + BORDER_GAP;
            graphPoints.add(new Point(x1, y1));
        }
        Stroke oldStroke = g2.getStroke();
        switch(color){
            case 1:
                g2.setColor(GRAPH_COLOR_1);
                break;
            case 2:
                g2.setColor(GRAPH_COLOR_2);
                break;
            case 3:
                g2.setColor(GRAPH_COLOR_3);
                break;
            case 4:
                g2.setColor(GRAPH_COLOR_4);
                break;
        }
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
        }
        g2.setStroke(oldStroke);
        g2.setColor(GRAPH_POINT_COLOR);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
            int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
            int ovalW = GRAPH_POINT_WIDTH;
            int ovalH = GRAPH_POINT_WIDTH;
            g2.fillOval(x, y, ovalW, ovalH);
        }
    }

    private Long getMinimumTime(List<Domain.Point> points){
        List<Long> timePoints = new ArrayList();
        for (int i = 0; i < points.size(); i++){
            timePoints.add(points.get(i).y);
        }
        return Collections.min(timePoints, null);
    }
}
