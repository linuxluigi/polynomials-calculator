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
                assertEquals(j, PolynomialArray[i].get(j));

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
                assertEquals(j, PolynomialArray[i].get(j));
            }

            int[] tmp = {5, 12, 13, 17, 22, 39, -22, 12};
            PolynomialArray[i].set(tmp);
            assertEquals(tmp, PolynomialArray[i].get());

            int[] tmp2 = {0,};
            PolynomialArray[i].set(tmp2);
            assertEquals(tmp2, PolynomialArray[i].get());

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
                assertEquals(1, tmp.length());
            } else {
                assertEquals(i, tmp.length());
            }
        }

    }

    /**
     * Erste Ableitung Test
     * @throws Exception
     */
    @org.junit.Test
    public void derivation() throws Exception {

        Polynomial tmp = new Polynomial(1);

        int[] tmpInt0 = {};
        tmp.set(tmpInt0);
        assertEquals("f(x)=0", tmp.Derivation());

        int[] tmpInt1 = {6};
        tmp.set(tmpInt1);
        assertEquals("f(x)=6", tmp.Derivation());

        int[] tmpInt2 = {7, 3};
        tmp.set(tmpInt2);
        assertEquals("f(x)=3", tmp.Derivation());

        int[] tmpInt3 = {-2, 55, -1245};
        tmp.set(tmpInt3);
        assertEquals("f(x)=55+(-2490x)", tmp.Derivation());

        int[] tmpInt4 = {2, 4356, 123, -23678};
        tmp.set(tmpInt4);
        assertEquals("f(x)=4356+246x+(-71034x²)", tmp.Derivation());

        int[] tmpInt5 = {-987654342, 3894249, 213246756, -24657223};
        tmp.set(tmpInt5);
        assertEquals("f(x)=3894249+426493512x+(-73971669x²)", tmp.Derivation());

        int[] tmpInt6 = {1, 1, 1, 1, 1};
        tmp.set(tmpInt6);
        assertEquals("f(x)=1+2x+3x²+4x³", tmp.Derivation());

        int[] tmpInt7 = {0, 0, 0, 0, 0, 0};
        tmp.set(tmpInt7);
        assertEquals("f(x)=0", tmp.Derivation());

        int[] tmpInt8 = {3894, -21354, 213, 0, -436, -1, 44};
        tmp.set(tmpInt8);
        assertEquals("f(x)=(-21354)+426x+(-1744x³)+(-5x⁴)+264x⁵", tmp.Derivation());

        int[] tmpInt9 = {65432, 21345, 6555432, 123546, 123456, 1324, 234543};
        tmp.set(tmpInt9);
        assertEquals("f(x)=21345+13110864x+370638x²+493824x³+6620x⁴+1407258x⁵", tmp.Derivation());

    }

    @org.junit.Test
    public void get_as_human_readable() throws Exception {

        Polynomial tmp = new Polynomial(1);

        int[] tmpInt0 = {};
        tmp.set(tmpInt0);
        assertEquals("f(x)=0", tmp.get_as_human_readable());

        int[] tmpInt1 = {6};
        tmp.set(tmpInt1);
        assertEquals("f(x)=6", tmp.get_as_human_readable());

        int[] tmpInt2 = {7, 3};
        tmp.set(tmpInt2);
        assertEquals("f(x)=7+3x", tmp.get_as_human_readable());

        int[] tmpInt3 = {-2, 55, -1245};
        tmp.set(tmpInt3);
        assertEquals("f(x)=(-2)+55x+(-1245x²)", tmp.get_as_human_readable());

        int[] tmpInt4 = {2, 4356, 123, -23678};
        tmp.set(tmpInt4);
        assertEquals("f(x)=2+4356x+123x²+(-23678x³)", tmp.get_as_human_readable());

        int[] tmpInt5 = {-987654342, 3894249, 213246756, -24657223};
        tmp.set(tmpInt5);
        assertEquals("f(x)=(-987654342)+3894249x+213246756x²+(-24657223x³)", tmp.get_as_human_readable());

        int[] tmpInt6 = {1, 1, 1, 1, 1};
        tmp.set(tmpInt6);
        assertEquals("f(x)=1+1x+1x²+1x³+1x⁴", tmp.get_as_human_readable());

        int[] tmpInt7 = {0, 0, 0, 0, 0, 0};
        tmp.set(tmpInt7);
        assertEquals("f(x)=0", tmp.get_as_human_readable());

        int[] tmpInt8 = {3894, -21354, 213, 0, -436, -1, 44};
        tmp.set(tmpInt8);
        assertEquals("f(x)=3894+(-21354x)+213x²+(-436x⁴)+(-1x⁵)+44x⁶", tmp.get_as_human_readable());

        int[] tmpInt9 = {65432, 21345, 6555432, 123546, 123456, 1324, 234543};
        tmp.set(tmpInt9);
        assertEquals("f(x)=65432+21345x+6555432x²+123546x³+123456x⁴+1324x⁵+234543x⁶", tmp.get_as_human_readable());

    }

}