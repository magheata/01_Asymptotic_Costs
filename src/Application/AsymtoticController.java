/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Application;
import Domain.AsymtoticCostsTypes;
import Domain.Point;
import Infrastructure.AsymtoticCalculatorService;
import Presentation.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class AsymtoticController {

    private Window window;
    private AsymtoticCalculatorService asymtoticCalculatorService;
    private int[] examples;

    /***
     * Constructor
     * @param window elemento gráfico
     * @param asymtoticCalculatorService elemento que calcula el coste de tiempo
     * @param examples lista de ejemplos de iteraciones
     */
    public AsymtoticController(Window window, AsymtoticCalculatorService asymtoticCalculatorService, int[] examples){
        this.window = window;
        this.asymtoticCalculatorService = asymtoticCalculatorService;
        this.window.addAsymtoticListener(new AsymtoticListener());
        this.examples = examples;
    }

    /***
     * Clase que sirve para poder detectar cuando se pulsa un botón desde la ventana
     */
    class AsymtoticListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == window.o1){
                paintPointsToWindow(AsymtoticCostsTypes.O1, 1);
            }
            else if (source == window.on){
                paintPointsToWindow(AsymtoticCostsTypes.ON, 2);
            } else if (source == window.onlogn){
                paintPointsToWindow(AsymtoticCostsTypes.ONLOGN, 3);
            } else {
                paintPointsToWindow(AsymtoticCostsTypes.ONSQR, 4);
            }
        }

        /***
         *
         * @param type tipo de coste que se ha seleccionado, está asociado al botón que se ha pulsado
         * @param color color de la línea del gráfico que se va a pintar
         */
        private void paintPointsToWindow(AsymtoticCostsTypes type, int color){
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
            window.paintPoints(points, color);
        }
    }
}
