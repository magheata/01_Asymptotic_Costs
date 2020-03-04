package Application;
import Domain.AsymtoticCostsTypes;
import Infrastructure.AsymtoticCalculatorService;
import Presentation.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class AsymtoticController {

    private Window window;
    private AsymtoticCalculatorService asymtoticCalculatorService;
    private final int[] examples = {10, 100, 1000, 10000, 100000, 1000000};

    public AsymtoticController(Window window, AsymtoticCalculatorService asymtoticCalculatorService){
        this.window = window;
        this.asymtoticCalculatorService = asymtoticCalculatorService;
        this.window.addAsymtoticListener(new AsymtoticListener());
    }

    class AsymtoticListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == window.o1){
                paintPointsToWindow(AsymtoticCostsTypes.O1);
            }
            else if (source == window.on){
                paintPointsToWindow(AsymtoticCostsTypes.ON);
            } else if (source == window.onlogn){
                paintPointsToWindow(AsymtoticCostsTypes.ONLOGN);
            } else {
                paintPointsToWindow(AsymtoticCostsTypes.ONSQR);
            }
        }

        private void paintPointsToWindow(AsymtoticCostsTypes type){
            List<Point> points = new ArrayList<>();
            for (int example: examples) {
                Future <Point> future = asymtoticCalculatorService.RunExample(type, example);
                while(!future.isDone()) {}
                try {
                    points.add(future.get());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            window.paintPoint(points);
        }
    }
}
