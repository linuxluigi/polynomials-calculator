package com.linuxluigi.polynomial;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Steffen Exler on 03.11.16.
 */
public class PolynomialListTest {

    /**
     * Erstellt ein PolynomialList Objekt und füllt es mit zufallswerten und überprüft
     * ob die Ausgabe mit der Eingabe übereinstimmt, außerdem werden noch Vordefinierte double[]
     * Werte als Polynom erstellt, PolynomialList angehängt und überprüft ob hier auch die Eingabe
     * und Ausgabe übereinstimmt.
     *
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        PolynomialList PolynomialList = new PolynomialList();
        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(10000, 10000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {
            // Test ob Inhalt gleich ist
            PolynomialList.add(PolynomialArray[i]);
            assertEquals(
                    PolynomialArray[i].get(),
                    PolynomialList.get_Polynomial(i).get()
            );

            // Test ob es eine Richtige länge vorliegt
            assertEquals(i + 1, PolynomialList.length());
        }

        // Test Vordefinierte double[] Werte
        double[] tmpDouble0 = {2, 3, 785, 5.44,};
        Polynomial tmp = new Polynomial(tmpDouble0);
        assertEquals(tmpDouble0, tmp.get());

        double[] tmpDouble1 = {0};
        tmp = new Polynomial(tmpDouble1);
        assertEquals(tmpDouble1, tmp.get());

        double[] tmpDouble2 = {};
        tmp = new Polynomial(tmpDouble2);
        assertEquals(tmpDouble2, tmp.get());

        double[] tmpDouble3 = {56154, -15154165.45414, 4515614, 456145, 45641, 465416, 41654165, 45641653, 46541165.25, 89476, 86};
        tmp = new Polynomial(tmpDouble3);
        assertEquals(tmpDouble3, tmp.get());

        double[] tmpDouble4 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        tmp = new Polynomial(tmpDouble4);
        assertEquals(tmpDouble4, tmp.get());
    }

    /**
     * Erzeugt ein zufälliges PolynomialList und löscht zufällig einzelne Werte heraus
     * Test dann ob die länge von PolynomialList -1 ist und überprüft ob das Polynom
     * wirklich aus PolynomialList gelöscht wurde
     *
     * @throws Exception
     */
    @Test
    public void delte() throws Exception {
        PolynomialList PolynomialList = new PolynomialList();
        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(10000, 10000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {
            PolynomialList.add(PolynomialArray[i]);
        }

        Random ran = new Random();

        for (int i = 0; i < 2000; i++) {
            // ein zufälliges Polynom aus PolynomialList löschen
            int randomInt = ran.nextInt(PolynomialList.length() - 1);
            int tmpLength = PolynomialList.length();
            Polynomial tmp = PolynomialList.get_Polynomial(randomInt);
            PolynomialList.delte(randomInt);

            // Test ob neue Länge -1 des alten Wertes ist
            tmpLength--;
            assertEquals(tmpLength, PolynomialList.length());

            // Überprüft ob ein Identisches Polynom existiert, kann in einzelfall vorkommen!
            for (int j = 0; j < PolynomialList.length(); j++) {
                assertNotEquals(tmp, PolynomialList.get_Polynomial(j));
            }
        }
    }

    /**
     * Test Addition und Subtraktion von Polynome mit zufallszahlen und fest Vordefinierten Zahlen
     *
     * @throws Exception
     */
    @Test
    public void mathAddSub() throws Exception {
        // Zufällige Werte Testen
        PolynomialList PolynomialList = new PolynomialList();
        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(10000, 10000, true);

        for (int i = 0; i < PolynomialArray.length; i++) {
            PolynomialList.add(PolynomialArray[i]);
        }

        Random ran = new Random();

        for (int i = 0; i < 2000; i++) {

            int randomInt1 = ran.nextInt(PolynomialList.length() - 1);
            int randomInt2 = ran.nextInt(PolynomialList.length() - 1);

            int tmpLength = PolynomialList.length() + 1;

            Polynomial tmp1 = PolynomialList.get_Polynomial(randomInt1);
            Polynomial tmp2 = PolynomialList.get_Polynomial(randomInt2);

            PolynomialList.mathAddSub(tmp1, tmp2, true);
            assertEquals(tmpLength, PolynomialList.length());

            tmpLength++;
            PolynomialList.mathAddSub(tmp1, tmp2, false);
            assertEquals(tmpLength, PolynomialList.length());

        }

        // Feste Werte Testen
        PolynomialList = new PolynomialList();
        PolynomialList.add(
                new Polynomial(
                        new double[]{0, 6, 45, 66,}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{568.44, 865416, 656, 56, -3}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{0}
                )
        );

        // Rechung 1
        Polynomial tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(0),
                PolynomialList.get_Polynomial(0),
                true
        );

        assertEquals("f(x)=+12x+90x²+132x³", tmp.get_as_human_readable());

        // Rechung 2
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(0),
                PolynomialList.get_Polynomial(0),
                false
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 3
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(2),
                PolynomialList.get_Polynomial(1),
                false
        );

        assertEquals("f(x)=(-568.440)+(-865416x)+(-656x²)+(-56x³)+3x⁴", tmp.get_as_human_readable());

        // Rechung 4
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(2),
                PolynomialList.get_Polynomial(2),
                true
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 5
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(3),
                PolynomialList.get_Polynomial(1),
                true
        );

        assertEquals("f(x)=568.440+865416x+656x²+56x³+(-3x⁴)", tmp.get_as_human_readable());

        // Rechung 6
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(1),
                PolynomialList.get_Polynomial(3),
                true
        );

        assertEquals("f(x)=568.440+865416x+656x²+56x³+(-3x⁴)", tmp.get_as_human_readable());

        // Rechung 7
        tmp = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(2),
                PolynomialList.get_Polynomial(3),
                false
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());
    }

    /**
     * Test Multiplikation von Polynome mit zufallszahlen und fest Vordefinierten Zahlen
     *
     * @throws Exception
     */
    @Test
    public void mathMultiply() throws Exception {
        // Zufällige Werte Testen
        PolynomialList PolynomialList = new PolynomialList();
        Polynomial[] PolynomialArray = PolynomialList.randomPolynomialArray(1000, 100, true);

        for (int i = 0; i < PolynomialArray.length; i++) {
            PolynomialList.add(PolynomialArray[i]);
        }

        Random ran = new Random();

        for (int i = 0; i < 2000; i++) {

            int randomInt1 = ran.nextInt(PolynomialList.length() - 1);
            int randomInt2 = ran.nextInt(PolynomialList.length() - 1);

            int tmpLength = PolynomialList.length() + 1;

            Polynomial tmp1 = PolynomialList.get_Polynomial(randomInt1);
            Polynomial tmp2 = PolynomialList.get_Polynomial(randomInt2);

            PolynomialList.mathMultiply(tmp1, tmp2);
            assertEquals(tmpLength, PolynomialList.length());

            tmpLength++;
            PolynomialList.mathMultiply(tmp1, tmp2);
            assertEquals(tmpLength, PolynomialList.length());

        }

        // Feste Werte Testen
        PolynomialList = new PolynomialList();
        PolynomialList.add(
                new Polynomial(
                        new double[]{0, 6, 45, 66,}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{568.44, 865416, 656, 56, -3}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{0}
                )
        );

        // Rechung 1
        Polynomial tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(0),
                PolynomialList.get_Polynomial(0)
        );

        assertEquals("f(x)=4356+5940x+2817x²+540x³+36x⁴", tmp.get_as_human_readable());

        // Rechung 2
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(0),
                PolynomialList.get_Polynomial(1)
        );

        assertEquals("f(x)=(-198)+3561x+45798x²+57147312x³+38985173.040x⁴+5218075.800x⁵+3410.640x⁶", tmp.get_as_human_readable());

        // Rechung 3
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(2),
                PolynomialList.get_Polynomial(1)
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 4
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(2),
                PolynomialList.get_Polynomial(2)
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 5
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(3),
                PolynomialList.get_Polynomial(1)
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 6
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(1),
                PolynomialList.get_Polynomial(3)
        );

        assertEquals("f(x)=0", tmp.get_as_human_readable());

        // Rechung 7
        tmp = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(0),
                PolynomialList.get_Polynomial(1)
        );

        assertEquals("f(x)=(-198)+3561x+45798x²+57147312x³+38985173.040x⁴+5218075.800x⁵+3410.640x⁶", tmp.get_as_human_readable());
    }

    /**
     * Test Hornerschema nach festen Werten
     *
     * @throws Exception
     */
    @Test
    public void mathHorner() throws Exception {
        // Feste Werte Testen
        PolynomialList PolynomialList = new PolynomialList();
        PolynomialList.add(
                new Polynomial(
                        new double[]{18, -27, -8, 5}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{8, -10, 0, 2}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{0}
                )
        );

        PolynomialList.add(
                new Polynomial(
                        new double[]{-4, -2, 4, 2}
                )
        );

        // Rechung 1
        double tmp = PolynomialList.mathHorner(
                PolynomialList.get_Polynomial(0),
                -2
        );

        assertEquals("f(x)=9+(-18x)+5x²", PolynomialList.get_Polynomial(PolynomialList.length() - 1).get_as_human_readable());
        assertEquals(0, tmp, 0.005d);

        // Rechung 2
        tmp = PolynomialList.mathHorner(
                PolynomialList.get_Polynomial(1),
                1
        );

        assertEquals("f(x)=(-8)+2x+2x²", PolynomialList.get_Polynomial(PolynomialList.length() - 1).get_as_human_readable());
        assertEquals(0, tmp, 0.005d);

        // Rechung 3
        tmp = PolynomialList.mathHorner(
                PolynomialList.get_Polynomial(4),
                -1
        );

        assertEquals("f(x)=(-4)+2x+2x²", PolynomialList.get_Polynomial(PolynomialList.length() - 1).get_as_human_readable());
        assertEquals(0, tmp, 0.005d);
    }
}