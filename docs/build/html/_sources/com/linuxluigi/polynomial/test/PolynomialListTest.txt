.. java:import:: org.junit Test

.. java:import:: java.util Random

PolynomialListTest
==================

.. java:package:: com.linuxluigi.polynomial.test
   :noindex:

.. java:type:: public class PolynomialListTest

   Created by Steffen Exler on 03.11.16.

Methods
-------
add
^^^

.. java:method:: @Test public void add() throws Exception
   :outertype: PolynomialListTest

   Erstellt ein PolynomialList Objekt und füllt es mit zufallswerten und überprüft ob die Ausgabe mit der Eingabe übereinstimmt, außerdem werden noch Vordefinierte double[] Werte als Polynom erstellt, PolynomialList angehängt und überprüft ob hier auch die Eingabe und Ausgabe übereinstimmt.

   :throws Exception:

delte
^^^^^

.. java:method:: @Test public void delte() throws Exception
   :outertype: PolynomialListTest

   Erzeugt ein zufälliges PolynomialList und löscht zufällig einzelne Werte heraus Test dann ob die länge von PolynomialList -1 ist und überprüft ob das Polynom wirklich aus PolynomialList gelöscht wurde

   :throws Exception:

mathAddSub
^^^^^^^^^^

.. java:method:: @Test public void mathAddSub() throws Exception
   :outertype: PolynomialListTest

   Test Addition und Subtraktion von Polynome mit zufallszahlen und fest Vordefinierten Zahlen

   :throws Exception:

mathHorner
^^^^^^^^^^

.. java:method:: @Test public void mathHorner() throws Exception
   :outertype: PolynomialListTest

   Test Hornerschema nach festen Werten

   :throws Exception:

mathMultiply
^^^^^^^^^^^^

.. java:method:: @Test public void mathMultiply() throws Exception
   :outertype: PolynomialListTest

   Test Multiplikation von Polynome mit zufallszahlen und fest Vordefinierten Zahlen

   :throws Exception:

