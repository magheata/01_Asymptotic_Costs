import Application.AsymtoticController;
import Infrastructure.AsymtoticCalculatorService;
import Presentation.Window;

import javax.swing.*;

public class AsymtoticMVC {

    private static final int[] iterations = {10, 30, 50, 70, 100, 150, 200};

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            AsymtoticCalculatorService asymtoticCalculatorService = new AsymtoticCalculatorService();
            Window window = new Window("Asymtotic Costs", iterations.length);
            AsymtoticController controller = new AsymtoticController(window, asymtoticCalculatorService, iterations);
        }
        catch (Exception e) {
            // handle exception
        }
    }
}
