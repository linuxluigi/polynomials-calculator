import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Steffen Exler on 01.11.16.
 */
public class PolynomialTest {

    /**
     * Erstellt ein Polynomial mit der Länge length und wenn random
     * wahr ist, mit festen Werten
     *
     * @param length länge des Beispiel Polynomes
     * @param random Polynom bekommt feste Werte zugewiesen mit [i] = i
     *
     * @return
     */
    private Polynomial randomPolynomial(int length, boolean random) {
        if (length < 0) {
            length = 0;
        }

        Polynomial Polynomial = new Polynomial(length);

        Random ran = new Random();

        for (int i = 0; i < length; i++) {
            if (random) {
                Polynomial.set(i, ran.nextInt(100) -100);
            } else {
                Polynomial.set(i, i);
            }
        }

        return Polynomial;
    }

    /**
     * Erstellt ein Polynomial[] mit zufalls Zahlen und arrayLength länge,
     * die länge der Polynome wird mit PolynomialLength bestimmt
     *
     * @param arrayLength Länge von Polynomial[]
     * @param PolynomialLength Länge des Polynomial
     * @param random Polynom bekommt feste Werte zugewiesen mit [i] = i
     * @return
     */
    private Polynomial[] randomPolynomialArray(int arrayLength, int PolynomialLength, boolean random) {

        if (arrayLength < 0) {
            arrayLength = 0;
        }

        if (PolynomialLength < 0) {
            PolynomialLength = 0;
        }

        Polynomial[] PolynomialArray = new Polynomial[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            PolynomialArray[i] = randomPolynomial(arrayLength, random);
        }

        return PolynomialArray;
    }

    /**
     * Testet beide get Varianten mit zufalls und festen Werten
     *
     * @throws Exception
     */
    @org.junit.Test
    public void get() throws Exception {

        Polynomial[] PolynomialArray = randomPolynomialArray(1000, 1000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {

            // Gesamtes Polynom
            PolynomialArray[i].get();

            for (int j = 0; j < PolynomialArray[i].length(); j++) {
                // Jedes Int einzeln vom Polynom
                PolynomialArray[i].get(j);
            }
        }

        PolynomialArray = randomPolynomialArray(10000, 10000, false);

        for (int i = 0; i < PolynomialArray.length; i++) {

            for (int j = 0; j < PolynomialArray[i].length(); j++) {

                // Jedes Int einzeln vom Polynom
                assertEquals(PolynomialArray[i].get(j), j);

            }
        }
    }

    /**
     * Fügt in mehren Polynomen
     * @throws Exception
     */
    @org.junit.Test
    public void set() throws Exception {
        Polynomial[] PolynomialArray = randomPolynomialArray(1000, 1000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {

            for (int j = 0; j < PolynomialArray[i].length(); j++) {
                PolynomialArray[i].set(j, j);
                assertEquals(PolynomialArray[i].get(j), j);
            }

            int[] tmp = {5, 12, 13, 17, 22, 39, -22, 12};
            PolynomialArray[i].set(tmp);
            assertEquals(PolynomialArray[i].get(), tmp);

            int[] tmp2 = {0,};
            PolynomialArray[i].set(tmp2);
            assertEquals(PolynomialArray[i].get(), tmp2);

        }
    }

    /**
     * Probiert zwischen -1000 bis 1000 alle Längen durch
     * und überprüft ob die funktion length den erwarteten Wert
     * zurück gibt.
     *
     * @throws Exception
     */
    @org.junit.Test
    public void length() throws Exception {

        for (int i = -1000; i < 1000; i++) {
            Polynomial tmp = randomPolynomial(i, true);

            if (i <= 0) {
                assertEquals(tmp.length(), 1);
            } else {
                assertEquals(tmp.length(), i);
            }
        }

    }

    @org.junit.Test
    public void derivation() throws Exception {

        Polynomial tmp = new Polynomial(1);

        int[] tmpInt1 = {6};
        tmp.set(tmpInt1);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt2 = {6};
        tmp.set(tmpInt2);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt3 = {6};
        tmp.set(tmpInt3);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt4 = {6};
        tmp.set(tmpInt4);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt5 = {6};
        tmp.set(tmpInt5);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt6 = {6};
        tmp.set(tmpInt6);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt7 = {6};
        tmp.set(tmpInt7);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt8 = {6};
        tmp.set(tmpInt8);
        assertEquals(tmp.Derivation(), "f(x)=6");

        int[] tmpInt9 = {6};
        tmp.set(tmpInt9);
        assertEquals(tmp.Derivation(), "f(x)=6");

    }

    @org.junit.Test
    public void get_as_human_readable() throws Exception {
        Polynomial tmp1 = new Polynomial(1);

        int[] tmpInt1 = {6};
        tmp1.set(tmpInt1);
        assertEquals(tmp1.get_as_human_readable(), "f(x)=6");
    }

}