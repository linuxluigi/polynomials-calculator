/**
 * Some comment
 *
 * @author      Steffen Exler
 * @version     %I%, %G%
 * @since       0.0.1
 */

package com.linuxluigi.polynomials;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * @param PolynomialList Liste mit allen Polynomial Objekten
         */
        List<Polynomial> PolynomialList = new ArrayList<Polynomial>();

        /*
        * PolyForm PolyForm = new PolyForm();
        * PolyForm.main();
        */


        Polynomial Polynomial1 = new Polynomial(5);
        System.out.println(Polynomial1.get(0));
        Polynomial1.set(0, 11);
        System.out.println(Polynomial1.get(0));

        PolynomialList.add(Polynomial1);

        System.out.println(PolynomialList.get(0).get(0));

    }
}
