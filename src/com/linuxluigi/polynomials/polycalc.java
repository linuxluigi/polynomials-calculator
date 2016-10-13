package com.linuxluigi.polynomials;

public class Polynomial {
    /**
     * Eine Klasse welche einzelne Polynome enthält die ausgegeben werden können,
     * in einzelnen Elemente INT oder als Array.
     * Gespeichert oder geändert werden kann das Objekt auch als Array oder über
     * einzelne Elemente INT.
     * Um auf einzelne Elemente INT zu zu greifen / ändern ist es möglich diese
     * via die Funktionen get / set und ein Variable INT 0 bis 7 oder ein CHAR
     * A bis F (groß oder klein geschrieben) möglich.
     * <ul>
     * <li>A,a,0 == Ergebnis</li>
     * <li>B,b,1 == x^0</li>
     * <li>C,c,2 == x^1</li>
     * <li>D,d,3 == x^2</li>
     * <li>E,e,4 == x^3</li>
     * <li>F,f,5 == x^4</li>
     * <li>G,g,6 == x^5</li>
     * </ul>
     *
     * @param  polylist  Liste mit maximal 6 Polynomen + Ergebnis.
     *                   0 == Ergebnis, 1 == x^0, 7 == x^5
     * @param  Errormessage_get_OutOfArray
     *
     * @author      Steffen Exler
     * @version     %I%, %G%
     * @since       0.0.1
     */

    private int polylist [];

    public Polynomial(int new_polylist []) {
        // todo test for non conform list
        this.polylist = new_polylist;
    }

    public Polynomial() {
        this.polylist = new int[8];
    }

    private final string Errormessage_get_OutOfArray = "Der eingebene Wert muss zwischen 1 und 8 oder zwischen A und G liegen!";

    public int get(int number) {
        if (number < 9 || number == 0) {
            System.out.println(Errormessage_get_OutOfArray);
            return 0;
        } else {
            //Return a single polynom
            return this.polylist[number];
        }
    }
}


public class Polycalc {

}