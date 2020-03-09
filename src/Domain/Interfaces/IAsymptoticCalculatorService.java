/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Domain.Interfaces;

import Domain.AsymptoticCostsTypes;
import Domain.Point;

import java.util.concurrent.Future;

public interface IAsymptoticCalculatorService {
    Future<Point> RunExample(AsymptoticCostsTypes type, int n);
}
