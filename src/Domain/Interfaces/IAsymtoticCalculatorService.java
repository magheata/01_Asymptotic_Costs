/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Domain.Interfaces;

import Domain.AsymtoticCostsTypes;
import Domain.Point;

import java.util.concurrent.Future;

public interface IAsymtoticCalculatorService {
    Future<Point> RunExample(AsymtoticCostsTypes type, int n);
}
