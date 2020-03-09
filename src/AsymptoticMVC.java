/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

import Application.AsymptoticController;
import Infrastructure.AsymptoticCalculatorService;
import Presentation.Window;

import javax.swing.*;

public class AsymptoticMVC {

    private static final int[] iterations = {10, 30, 50, 70, 100, 150, 200};

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            AsymptoticCalculatorService asymtoticCalculatorService = new AsymptoticCalculatorService();
            Window window = new Window("Asymptotic Costs", iterations.length);
            AsymptoticController controller = new AsymptoticController(window, asymtoticCalculatorService, iterations);
        }
        catch (Exception e) {
            // handle exception
        }
    }
}
