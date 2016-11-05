import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Steffen Exler on 01.11.16.
 */
public class PolynomialTest {

    /**
     * Testet beide get Varianten mit zufalls und festen Werten
     *
     * @throws Exception
     */
    @org.junit.Test
    public void get() throws Exception {
        PolynomialList PolynomialList = new PolynomialList();

        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(1000, 1000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {

            // Gesamtes Polynom
            PolynomialArray[i].get();

            for (int j = 0; j < PolynomialArray[i].length(); j++) {
                // Jedes Int einzeln vom Polynom
                PolynomialArray[i].get(j);
            }
        }

        PolynomialArray = PolynomialList.randomPolynomialArray(10000, 10000, false);

        for (int i = 0; i < PolynomialArray.length; i++) {

            for (int j = 0; j < PolynomialArray[i].length(); j++) {

                // Jedes Int einzeln vom Polynom
                assertEquals((double) j, PolynomialArray[i].get(j), 0.005d);

            }
        }
    }

    /**
     * Fügt in mehren Polynomen
     *
     * @throws Exception
     */
    @org.junit.Test
    public void set() throws Exception {
        PolynomialList PolynomialList = new PolynomialList();
        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(1000, 1000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {

            for (int j = 0; j < PolynomialArray[i].length(); j++) {
                PolynomialArray[i].set(j, j);
                assertEquals((double) j, PolynomialArray[i].get(j), 0.005d);
            }

            double[] tmp = {5.88, 12.44, 13, 17, 22.55, 39, -22, 12};
            PolynomialArray[i].set(tmp);
            assertEquals(tmp, PolynomialArray[i].get());

            double[] tmp2 = {0,};
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

        PolynomialList PolynomialList = new PolynomialList();

        for (int i = -1000; i < 1000; i++) {
            Polynomial tmp = PolynomialList.randomPolynomial(i, true);

            if (i <= 0) {
                assertEquals(1, tmp.length());
            } else {
                assertEquals(i, tmp.length());
            }
        }

    }

    /**
     * Erste Ableitung Test
     *
     * @throws Exception
     */
    @org.junit.Test
    public void derivation() throws Exception {

        Polynomial tmp = new Polynomial(1);

        double[] tmpInt0 = {};
        tmp.set(tmpInt0);
        assertEquals("f(x)=0", tmp.Derivation());

        double[] tmpInt1 = {6};
        tmp.set(tmpInt1);
        assertEquals("f(x)=6", tmp.Derivation());

        double[] tmpInt2 = {7, 3};
        tmp.set(tmpInt2);
        assertEquals("f(x)=3", tmp.Derivation());

        double[] tmpInt3 = {-2, 55, -1245};
        tmp.set(tmpInt3);
        assertEquals("f(x)=55+(-2490x)", tmp.Derivation());

        double[] tmpInt4 = {2, 4356, 123, -23678};
        tmp.set(tmpInt4);
        assertEquals("f(x)=4356+246x+(-71034x²)", tmp.Derivation());

        double[] tmpInt5 = {-987654342, 3894249, 213246756, -24657223};
        tmp.set(tmpInt5);
        assertEquals("f(x)=3894249+426493512x+(-73971669x²)", tmp.Derivation());

        double[] tmpInt6 = {1, 1, 1, 1, 1};
        tmp.set(tmpInt6);
        assertEquals("f(x)=1+2x+3x²+4x³", tmp.Derivation());

        double[] tmpInt7 = {0, 0, 0, 0, 0, 0};
        tmp.set(tmpInt7);
        assertEquals("f(x)=0", tmp.Derivation());

        double[] tmpInt8 = {3894, -21354, 213, 0, -436, -1, 44};
        tmp.set(tmpInt8);
        assertEquals("f(x)=(-21354)+426x+(-1744x³)+(-5x⁴)+264x⁵", tmp.Derivation());

        double[] tmpInt9 = {65432, 21345, 6555432, 123546, 123456, 1324, 234543};
        tmp.set(tmpInt9);
        assertEquals("f(x)=21345+13110864x+370638x²+493824x³+6620x⁴+1407258x⁵", tmp.Derivation());

        double[] tmpInt10 = {65432.22, 21345.123, 6555432, -123546.23444, 123456, 1324, 234543};
        tmp.set(tmpInt10);
        assertEquals("f(x)=21345.123+13110864x+(-370638.703x²)+493824x³+6620x⁴+1407258x⁵", tmp.Derivation());

        double[] tmpInt11 = {0.123, 0.123, -0.123};
        tmp.set(tmpInt11);
        assertEquals("f(x)=0.123+(-0.246x)", tmp.Derivation());

    }

    @org.junit.Test
    public void get_as_human_readable() throws Exception {

        Polynomial tmp = new Polynomial(1);

        double[] tmpInt0 = {};
        tmp.set(tmpInt0);
        assertEquals("f(x)=0", tmp.get_as_human_readable());

        double[] tmpInt1 = {6};
        tmp.set(tmpInt1);
        assertEquals("f(x)=6", tmp.get_as_human_readable());

        double[] tmpInt2 = {7, 3};
        tmp.set(tmpInt2);
        assertEquals("f(x)=7+3x", tmp.get_as_human_readable());

        double[] tmpInt3 = {-2, 55, -1245};
        tmp.set(tmpInt3);
        assertEquals("f(x)=(-2)+55x+(-1245x²)", tmp.get_as_human_readable());

        double[] tmpInt4 = {2, 4356, 123, -23678};
        tmp.set(tmpInt4);
        assertEquals("f(x)=2+4356x+123x²+(-23678x³)", tmp.get_as_human_readable());

        double[] tmpInt5 = {-987654342, 3894249, 213246756, -24657223};
        tmp.set(tmpInt5);
        assertEquals("f(x)=(-987654342)+3894249x+213246756x²+(-24657223x³)", tmp.get_as_human_readable());

        double[] tmpInt6 = {1, 1, 1, 1, 1};
        tmp.set(tmpInt6);
        assertEquals("f(x)=1+1x+1x²+1x³+1x⁴", tmp.get_as_human_readable());

        double[] tmpInt7 = {0, 0, 0, 0, 0, 0};
        tmp.set(tmpInt7);
        assertEquals("f(x)=0", tmp.get_as_human_readable());

        double[] tmpInt8 = {3894, -21354, 213, 0, -436, -1, 44};
        tmp.set(tmpInt8);
        assertEquals("f(x)=3894+(-21354x)+213x²+(-436x⁴)+(-1x⁵)+44x⁶", tmp.get_as_human_readable());

        double[] tmpInt9 = {65432, 21345, 6555432, 123546, 123456, 1324, 234543};
        tmp.set(tmpInt9);
        assertEquals("f(x)=65432+21345x+6555432x²+123546x³+123456x⁴+1324x⁵+234543x⁶", tmp.get_as_human_readable());

    }

}