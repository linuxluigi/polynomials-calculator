Polynomial
==========

.. java:package:: com.linuxluigi.polynomial
   :noindex:

.. java:type:: public class Polynomial

   Eine Klasse welche einzelne Polynome enthält die ausgegeben werden können, in einzelnen Elemente INT oder als Array. Gespeichert oder geändert werden kann das Objekt auch als Array oder über einzelne Elemente INT. Um auf einzelne Elemente INT zu zu greifen / ändern ist es möglich diese via die Funktionen get / set und ein Variable INT möglich.

   ..

   * 0 == x^0
   * 1 == x^1
   * 2 == x^2
   * 3 == x^3
   * 4 == x^4
   * 5 == x^5

   0 == Ergebnis, 1 == x^0, 7 == x^5

   :author: Steffen Exler

Constructors
------------
Polynomial
^^^^^^^^^^

.. java:constructor:: public Polynomial(double[] new_polylist)
   :outertype: Polynomial

   Neuen Polynom aus ein vollständigen INT Array erzeugen

   :param new_polylist: Kompletter Polynom

Polynomial
^^^^^^^^^^

.. java:constructor:: public Polynomial(int length)
   :outertype: Polynomial

   Leeren Polynom mit der länge 'length' erstellen.

   :param length: Länge des Polynoms

Methods
-------
Derivation
^^^^^^^^^^

.. java:method::  String Derivation()
   :outertype: Polynomial

   Gibt die 1. Ableitung des Polynomes zurück

   :return: Menschlich lesbare 1. Ableitung des Polynomes

get
^^^

.. java:method:: public double[] get()
   :outertype: Polynomial

   Gibt den Polynom als INT Array zurück

   :return: Gibt komplettes Polynom zurück

get
^^^

.. java:method:: public double get(int number)
   :outertype: Polynomial

   Gibt ein Element des Polynomes zurück

   :param number: Element nummer des Polynomes this.polylist[number]
   :return: Wert des Polynom Element

get_as_human_readable
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  String get_as_human_readable()
   :outertype: Polynomial

   Wandelt das Polynom Array als Menschlich lesbaren Polynom um

   :return: Polynom als lesbaren String

length
^^^^^^

.. java:method:: public int length()
   :outertype: Polynomial

   Gibt die Länge des Polynomes zurück

   :return: Int länge des Polynomes Array

set
^^^

.. java:method:: public void set(double[] new_polylist)
   :outertype: Polynomial

   Überschreibt den Polynom mit einem neuen 'new_polylist'

   :param new_polylist: Vollständiger Polynom als INT Array

set
^^^

.. java:method:: public void set(int poly_number, double poly_value)
   :outertype: Polynomial

   Überschreibt ein Element des Polynomes

   :param poly_number: Element des Polynomes
   :param poly_value: Wert des neuen Element im Polynom

