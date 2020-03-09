/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Infrastructure;

import Domain.AsymptoticCostsTypes;
import Domain.Interfaces.IAsymptoticCalculatorService;
import Domain.Point;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/***
 * Clase que calcula los costes
 */
public class AsymptoticCalculatorService implements IAsymptoticCalculatorService {

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    /***
     * Sirve para calcular el tiempo que dura ejecutar un código que tiene
     * como coste asintótico aquel que viene dado por el tipo.
     * @param type tipo de coste que se quiere calcular
     * @param n número de iteraciones
     * @return Punto calculado con coordenadas (x, y)
     */
    @Override
    public Future<Point> RunExample(AsymptoticCostsTypes type, int n) {
        return executor.submit(() -> {
            long temps;
            long timeElapsed = 0;
            switch (type){
                case O1:
                    temps = System.nanoTime();
                    Thread.sleep(1);
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ON:
                    temps = System.nanoTime();
                    for (int i = 0; i < n; i++){
                        Thread.sleep(1);
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ONSQR:
                    temps = System.nanoTime();
                    for (int i = 0; i < n; i++){
                        for (int j = 0; j < n; j++){
                            Thread.sleep(1);
                        }
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ONLOGN:
                    temps = System.nanoTime();
                    double l =  Math.log(n);
                    for (int i = 0; i < n ; i++){
                        for (double d = 0; d < l; d++){
                            Thread.sleep(1);
                        }
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
            }
            return new Point(n, timeElapsed);
        });
    }
}
