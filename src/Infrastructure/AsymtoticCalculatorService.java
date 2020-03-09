package Infrastructure;

import Domain.AsymtoticCostsTypes;
import Domain.Interfaces.IAsymtoticCalculatorService;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsymtoticCalculatorService implements IAsymtoticCalculatorService {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    @Override
    public Future<Point> RunExample(AsymtoticCostsTypes type, int n) {
        return executor.submit(() -> {
            double temps;
            double timeElapsed = 0;
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
            return new Point(n, (int) timeElapsed);
        });
    }
}
