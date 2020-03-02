package Domain.Interfaces;

import Domain.AsymtoticCostsTypes;
import Domain.DTO.Point;

public interface IAlgorithm {
    Point RunExample(AsymtoticCostsTypes type, int n);
}
