package Infrastructure;

import Domain.AsymtoticCostsTypes;
import Domain.Interfaces.IAlgorithm;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsymtoticCalculatorService implements IAlgorithm {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    @Override
    public Future<Point> RunExample(AsymtoticCostsTypes type, int n) {
        return executor.submit(() -> {
            long temps = System.nanoTime();
            int dummy_variable = 0;
            long timeElapsed = 0;
            switch (type){
                case O1:
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ON:
                    for (int i = 0; i < n; i++){
                        dummy_variable++;
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ONSQR:
                    for (int i = 0; i < n; i++){
                        for (int j = 0; j < n; j++){
                            dummy_variable++;
                        }
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                case ONLOGN:
                    double l =  Math.log10(n);
                    for (int i = 0; i < n ; i++){
                        for (double d = 0; d < l; d++){
                            dummy_variable++;
                        }
                    }
                    timeElapsed = System.nanoTime() - temps;  //in millis
                    break;
                default:
            }
            return new Point(n, (int) timeElapsed);
        });
    }
}
