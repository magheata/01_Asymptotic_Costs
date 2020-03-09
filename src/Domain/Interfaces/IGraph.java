package Domain.Interfaces;

import java.awt.*;
import java.util.List;

public interface IGraph {
    void paintPoints(Graphics g, List<Point> graphPointsInput, int color);
}
