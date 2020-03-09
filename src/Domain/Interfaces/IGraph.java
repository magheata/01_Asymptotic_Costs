package Domain.Interfaces;

import java.awt.*;
import java.util.List;

public interface IGraph {
    void paintPoints(Graphics g, List<Domain.Point> graphPointsInput, int color);
}
