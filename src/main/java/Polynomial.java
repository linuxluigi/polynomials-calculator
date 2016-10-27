/**
 * Eine Klasse welche einzelne Polynome enthält die ausgegeben werden können,
 * in einzelnen Elemente INT oder als Array.
 * Gespeichert oder geändert werden kann das Objekt auch als Array oder über
 * einzelne Elemente INT.
 * Um auf einzelne Elemente INT zu zu greifen / ändern ist es möglich diese
 * via die Funktionen get / set und ein Variable INT möglich.
 * <ul>
 * <li>0 == x^0</li>
 * <li>1 == x^1</li>
 * <li>2 == x^2</li>
 * <li>3 == x^3</li>
 * <li>4 == x^4</li>
 * <li>5 == x^5</li>
 * </ul>
 *
 * 0 == Ergebnis, 1 == x^0, 7 == x^5
 * @author Steffen Exler
 * @version %I%, %G%
 * @since 0.1.0
 */

public class Polynomial {
    /**
     * @param polylist  Liste mit Polynomen + Ergebnis.
     */

    private int polylist[];

    /*
     * Start Konstruktor
     */
    public Polynomial(int new_polylist[]) {
        /**
         * Neuen Polynom aus ein vollständigen INT Array erzeugen
         *
         * @param new_polylist Kompletter Polynom
         */
        // Todo: test for non conform list
        this.polylist = new_polylist;
    }

    public Polynomial(int length) {
        /**
         * Leeren Polynom mit der länge 'length' erstellen.
         *
         * @param length Länge des Polynoms
         */
        if (length < 1) {
            length = 1;
        }
        this.polylist = new int[length];
    }
    /*
     * End Konstruktor
     */

    /*
     * Start get
     */
    public int[] get() {
        /**
         * Gibt den Polynom als INT Array zurück
         */
        return this.polylist;
    }

    public int get(int number) {
        /**
         * Gib eine Stelle 'number' des Polynoms zurück
         *
         * @param number Stelle des Polynomes this.polylist[number]
         */
        if (this.polylist.length < number || number < 0) {
            System.out.println("Fehler: Out of Array!");
            return 0;
        } else {
            //Return a single polynom
            return this.polylist[number];
        }
    }

    public int length() {
        /**
         *  Gibt die Länge des Polynomes zurück
         */
        return this.polylist.length;
    }

    public String Derivation() {
        /**
         * Gibt die 1. Ableitung des Polynomes zurück
         */

        Polynomial newPolynomial = new Polynomial(this.polylist.length-1);

        for (int i = 1; i < this.polylist.length; i++) {
            newPolynomial.set(i-1, this.polylist[i]*i);
        }

        return newPolynomial.get_as_human_readable();
    }

    public String get_as_human_readable() {
        /**
         * Gibt den Polynom Menschlich lesbar zurück
         */
        String Polynomial_readable = "p(x)=";
        if (this.polylist.length == 1) {
            Polynomial_readable = Polynomial_readable + String.format("%d", this.polylist[0]);
        } else {
            for (int i = 0; i < this.polylist.length; i++) {
                if (this.polylist[i] == 0) {
                    continue;
                }

                if (i > 0) {
                    Polynomial_readable = Polynomial_readable + "+";
                }

                if (this.polylist[i] < 0) {
                    Polynomial_readable = Polynomial_readable + "(";
                }
                Polynomial_readable = Polynomial_readable + String.format("%d", this.polylist[i]);

                if (i > 0) {
                    Polynomial_readable = Polynomial_readable + "x";
                    if (i != 1) {
                        int IntExponent = i;
                        String StrExponent = "";
                        // Konvertiere Int zu String Exponent
                        while (IntExponent > 0) {
                            int IntSingleExponent = IntExponent % 10;
                            switch (IntSingleExponent) {
                                case 0:
                                    // 0
                                    StrExponent = "\u2070" + StrExponent;
                                    break;
                                case 1:
                                    // 1
                                    StrExponent = "\u00B9" + StrExponent;
                                    break;
                                case 2:
                                    // 2
                                    StrExponent = "\u00B2" + StrExponent;
                                    break;
                                case 3:
                                    // 3
                                    StrExponent = "\u00B3" + StrExponent;
                                    break;
                                case 4:
                                    // 4
                                    StrExponent = "\u2074" + StrExponent;
                                    break;
                                case 5:
                                    // 5
                                    StrExponent = "\u2075" + StrExponent;
                                    break;
                                case 6:
                                    // 6
                                    StrExponent = "\u2076" + StrExponent;
                                    break;
                                case 7:
                                    // 7
                                    StrExponent = "\u2077" + StrExponent;
                                    break;
                                case 8:
                                    // 8
                                    StrExponent = "\u2078" + StrExponent;
                                    break;
                                case 9:
                                    // 9
                                    StrExponent = "\u2079" + StrExponent;
                                    break;
                            }
                            IntExponent = IntExponent / 10;
                        }
                        Polynomial_readable = Polynomial_readable + StrExponent;
                    }
                }


                if (this.polylist[i] < 0) {
                    Polynomial_readable = Polynomial_readable + ")";
                }
            }
        }

        if (Polynomial_readable.equals("p(x)=")) {
            Polynomial_readable = "p(x)=0";
        }

        return Polynomial_readable;
    }
    /*
     * End get
     */


    public void set(int[] new_polylist) {
        /**
         * Überschreibt den Polynom mit einem neuen 'new_polylist'
         *
         * @param new_polylist Vollständiger Polynom als INT Array
         */
        this.polylist = new_polylist;
    }

    public void set(int poly_number, int poly_value) {
        /**
         * Überschreibt ein einzelnen Wert des Polynomes
         *
         * @param poly_number Stelle des INT Arrays
         * @param poly_value Wert der neuen Zahl im Polynom
         */
        if (this.polylist.length < poly_number || poly_number < 0) {
            System.out.println("Fehler: Out of Array!");
        } else {
            this.polylist[poly_number] = poly_value;
        }
    }
}