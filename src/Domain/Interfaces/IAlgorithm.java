package Domain.Interfaces;

import Domain.AsymtoticCostsTypes;

import java.awt.*;
import java.util.concurrent.Future;

public interface IAlgorithm {
    Future<Point> RunExample(AsymtoticCostsTypes type, int n);
}
