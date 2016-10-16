package com.linuxluigi.polynomials;

public class Polynomial {
    /**
     * Eine Klasse welche einzelne Polynome enthält die ausgegeben werden können,
     * in einzelnen Elemente INT oder als Array.
     * Gespeichert oder geändert werden kann das Objekt auch als Array oder über
     * einzelne Elemente INT.
     * Um auf einzelne Elemente INT zu zu greifen / ändern ist es möglich diese
     * via die Funktionen get / set und ein Variable INT möglich.
     * <ul>
     * <li>0 == Ergebnis</li>
     * <li>1 == x^0</li>
     * <li>2 == x^1</li>
     * <li>3 == x^2</li>
     * <li>4 == x^3</li>
     * <li>5 == x^4</li>
     * <li>6 == x^5</li>
     * </ul>
     *
     * @param  polylist  Liste mit Polynomen + Ergebnis.
     *                   0 == Ergebnis, 1 == x^0, 7 == x^5
     *
     * @author      Steffen Exler
     * @version     %I%, %G%
     * @since       0.0.1
     */

    private int polylist [];

    /*
     * Start Konstruktor
     */
    public Polynomial(int new_polylist []) {
        /**
         * Neuen Polynom aus ein vollständigen INT Array erzeugen
         * @param new_polylist Kompletter Polynom
         */
        // Todo: test for non conform list
        this.polylist = new_polylist;
    }

    public Polynomial(int length) {
        /**
         * Leeren Polynom mit der länge 'length' erstellen.
         * @param length Länge des Polynoms
         */
        this.polylist = new int[length];
    }
    /*
     * End Konstruktor
     */


    /*
     * Start Default Strings
     * Für DRY Code, Strings die mehr als einmal vorkommen, Konstanten setzen
     */
    private final String Success_set = "Erfolg: Polynom wurde erfolgreich geändert!";
    private final String Errormessage_get_OutOfArray = "Fehler: Out of Array!";
    /*
     * End Default Strings
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
         * @param number Stelle des Polynomes this.polylist[number]
         */
        if (this.polylist.length < number || number < 0) {
            System.out.println(this.Errormessage_get_OutOfArray);
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
     * Start set
     */
    public void set(int[] new_polylist) {
        /**
         * Überschreibt den Polynom mit einem neuen 'new_polylist'
         * @param new_polylist Vollständiger Polynom als INT Array
         */
        this.polylist = new_polylist;
        System.out.println(this.Success_set);
    }

    public void set(int poly_number, int poly_value) {
        /**
         * Überschreibt ein einzelnen Wert des Polynomes
         * @param poly_number Stelle des INT Arrays
         * @param poly_value Wert der neuen Zahl im Polynom
         */
        if(this.polylist.length < poly_number || poly_number < 0) {
            System.out.println(this.Errormessage_get_OutOfArray);
        } else {
            this.polylist[poly_number] = poly_value;
            System.out.println(this.Success_set);
        }
    }
    /*
     * End set
     */

}