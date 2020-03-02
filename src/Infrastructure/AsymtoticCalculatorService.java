package Infrastructure;

import Application.AsymtoticController;
import Domain.AsymtoticCostsTypes;
import Domain.DTO.Point;
import Domain.Interfaces.IAlgorithm;

import java.time.Duration;
import java.time.Instant;

public class AsymtoticCalculatorService implements IAlgorithm {

    @Override
    public Point RunExample(AsymtoticCostsTypes type, int n) {
        Instant start = Instant.now();
        int dummy_variable = 0;
        Instant finish;
        long timeElapsed = 0;
        switch (type){
            case ON:
                for (int i = 0; i < n; i++){
                    dummy_variable++;
                }
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();  //in millis
            case ONSQR:
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++){
                        dummy_variable++;
                    }
                }
                finish = Instant.now();
                timeElapsed = Duration.between(start, finish).toMillis();  //in millis
            case ONLOGN:
                break;
            default:

        }
        return new Point(n, timeElapsed);
    }
}
