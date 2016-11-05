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
 * <p>
 * 0 == Ergebnis, 1 == x^0, 7 == x^5
 *
 * @author Steffen Exler
 * @version %I%, %G%
 * @since 0.1.0
 */

public class Polynomial {

    private double[] polylist;

    /*
     *  Start Konstruktor
     */

    /**
     * Neuen Polynom aus ein vollständigen INT Array erzeugen
     *
     * @param new_polylist Kompletter Polynom
     */
    public Polynomial(double[] new_polylist) {

        this.polylist = new_polylist;
    }

    /**
     * Leeren Polynom mit der länge 'length' erstellen.
     *
     * @param length Länge des Polynoms
     */
    public Polynomial(int length) {
        if (length < 1) {
            length = 1;
        }
        this.polylist = new double[length];
    }
    /*
     * End Konstruktor
     */

    /*
     * Start get
     */

    /**
     * Gibt den Polynom als INT Array zurück
     *
     * @return Gibt komplettes Polynom zurück
     */
    public double[] get() {
        return this.polylist;
    }

    /**
     * Gibt ein Element des Polynomes zurück
     *
     * @param number Element nummer des Polynomes this.polylist[number]
     * @return Wert des Polynom Element
     */
    public double get(int number) {
        if (this.polylist.length < number || number < 0) {
            System.out.println("Fehler: Out of Array!");
            return 0;
        } else {
            //Return a single polynom
            return this.polylist[number];
        }
    }

    /*
     * End get
     */

    /*
     * start set
     */

    /**
     * Überschreibt den Polynom mit einem neuen 'new_polylist'
     *
     * @param new_polylist Vollständiger Polynom als INT Array
     */
    public void set(double[] new_polylist) {
        this.polylist = new_polylist;
    }

    /**
     * Überschreibt ein Element des Polynomes
     *
     * @param poly_number Element des Polynomes
     * @param poly_value  Wert des neuen Element im Polynom
     */
    public void set(int poly_number, double poly_value) {
        if (this.polylist.length < poly_number || poly_number < 0) {
            System.out.println("Fehler: Out of Array!");
        } else {
            this.polylist[poly_number] = poly_value;
        }
    }
    /*
     * start set
     */

    /**
     * Gibt die Länge des Polynomes zurück
     *
     * @return Int länge des Polynomes Array
     */
    public int length() {
        return this.polylist.length;
    }

    /**
     * Gibt die 1. Ableitung des Polynomes zurück
     *
     * @return Menschlich lesbare 1. Ableitung des Polynomes
     */
    String Derivation() {

        if (this.polylist.length <= 1) {
            return get_as_human_readable();
        }

        Polynomial newPolynomial;
        newPolynomial = new Polynomial(this.polylist.length - 1);

        for (int i = 1; i < this.polylist.length; i++) {
            newPolynomial.set(i - 1, this.polylist[i] * (double) i);
        }

        return newPolynomial.get_as_human_readable();
    }

    /**
     * Wandelt das Polynom Array als Menschlich lesbaren Polynom um
     *
     * @return Polynom als lesbaren String
     */
    String get_as_human_readable() {
        // Standart Polynom anfang schreiben
        String Polynomial_readable = "f(x)=";

        for (int i = 0; i < this.polylist.length; i++) {
            // Wenn das Polynom Element den Wert 0 besitzt --> continue
            if (this.polylist[i] == 0) {
                continue;
            }

            // Für Elemente ab 2 Stelle --> '+' den String anfügen
            if (i > 0) {
                Polynomial_readable = Polynomial_readable + "+";
            }

            // Falls das Element negativ ist --> eine Klammer setzen
            if (this.polylist[i] < 0) {
                Polynomial_readable = Polynomial_readable + "(";
            }

            // Element den String anfügen
            int doubleLength;
            if (this.polylist[i] % 1 != 0) {
                doubleLength = 3;
            } else {
                doubleLength = 0;
            }
            Polynomial_readable = Polynomial_readable + String.format("%." + doubleLength + "f", this.polylist[i]);

            // Den Exponenten und 'x' des Elementes den String anfügen solange Exponent > 0
            if (i > 0) {

                Polynomial_readable = Polynomial_readable + "x";

                // Exponenten nur anfügen sobald er größer als 1 ist
                if (i != 1) {
                    int IntExponent = i;
                    String StrExponent = "";

                    // Konvertiere Int zu String Exponent als unicode
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

            // Falls das Element negativ ist --> eine Klammer schließen
            if (this.polylist[i] < 0) {
                Polynomial_readable = Polynomial_readable + ")";
            }
        }

        // Falls kein Element des Polynomes ein Wert besaß --> 0 Gleichung ausgeben
        if (Polynomial_readable.equals("f(x)=")) {
            Polynomial_readable = "f(x)=0";
        }

        return Polynomial_readable;
    }
}