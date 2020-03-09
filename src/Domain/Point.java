/***
 * AUTHORS: RAFAEL ADRIÁN GIL CAÑESTRO
 *          MIRUNA ANDREEA GHEATA
 */

package Domain;

/***
 * Clase que sirve para definir el objeto Punto. No se ha usado el java.awt.Point
 * porque define la x y la y como int, y nosotros necesitamos long por razones de
 * precisión y rango
 */
public class Point {
    public long x;
    public long y;

    /***
     *
     * @param x
     * @param y
     */
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
