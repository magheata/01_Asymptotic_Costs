package Application;
import Domain.AsymtoticCostsTypes;
import Infrastructure.AsymtoticCalculatorService;
import Domain.Interfaces.IEvent;
import Domain.DTO.Point;
import Presentation.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsymtoticController implements IEvent {

    private Window window;
    private AsymtoticCalculatorService asymtoticCalculatorService;

    public AsymtoticController(Window window, AsymtoticCalculatorService asymtoticCalculatorService){
        this.window = window;
        this.asymtoticCalculatorService = asymtoticCalculatorService;
        this.window.addAsymtoticListener(new AsymtoticListener());
    }

    class AsymtoticListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    @Override
    public void notifyWindow(Point points) {

    }

    @Override
    public void notifyAlgorithm(AsymtoticCostsTypes type) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
