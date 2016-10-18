/**
 * Some comment
 *
 * @author      Steffen Exler
 * @version     %I%, %G%
 * @since       0.0.1
 */


public class Main {

    public static void main(String[] args) {
        /**
         * @param PolynomialList Liste mit allen Polynomial Objekten
         */

        PolynomialList PolynomialList = new PolynomialList();
        PolynomialList.load();
        PolynomialList.save();


    }
}
