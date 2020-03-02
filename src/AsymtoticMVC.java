import Application.AsymtoticController;
import Domain.DTO.Point;
import Infrastructure.AsymtoticCalculatorService;
import Presentation.Window;

import javax.swing.*;

public class AsymtoticMVC {

    private Window window;
    private AsymtoticController asymtoticController;

    private boolean active_process;
    private Point[] points;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            AsymtoticCalculatorService asymtoticCalculatorService = new AsymtoticCalculatorService();
            Window window = new Window("Asymtotic Costs");
            AsymtoticController controller = new AsymtoticController(window, asymtoticCalculatorService);
        }
        catch (Exception e) {
            // handle exception
        }
    }
}
