.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson GsonBuilder

.. java:import:: java.util Random

PolynomialList
==============

.. java:package:: com.linuxluigi.polynomial
   :noindex:

.. java:type::  class PolynomialList

   Ein Polynom Klasse Array welche mitunter folgende funktionen mitbringt:

   ..

   * Einzelne Polynome aus den Polynom[] ausgeben
   * Polynome miteinander multiplizieren, addieren und subtrahieren
   * Einzelne Polynome löschen, bearbeiten oder neu hinzufügen
   * Polynom[] bilden durch laden einer Json Datei
   * Die eigene Klasse als Json Datei speichern

Constructors
------------
PolynomialList
^^^^^^^^^^^^^^

.. java:constructor:: public PolynomialList()
   :outertype: PolynomialList

   Konstruktor Erstellt ein neues leeres Polynomial[]

Methods
-------
add
^^^

.. java:method:: public void add(Polynomial newPolynomial)
   :outertype: PolynomialList

   Hängt ein neues Polynomial an Polynomial[] an

   :param newPolynomial: neues Polynomial welches angehängt werden soll

delte
^^^^^

.. java:method::  void delte(int PolynomialNumber)
   :outertype: PolynomialList

   Löscht ein Element aus den Polynomial[]

   :param PolynomialNumber: Element des Polynomial[] welches gelöscht werden soll

get_FileName
^^^^^^^^^^^^

.. java:method::  String get_FileName()
   :outertype: PolynomialList

   Gibt den Json Datei String zurück

   :return: Json Datei namen als String

get_PolylList
^^^^^^^^^^^^^

.. java:method::  Polynomial[] get_PolylList()
   :outertype: PolynomialList

   Gibt das Polynomial[] zurück

   :return: Polynomial[]

get_Polynomial
^^^^^^^^^^^^^^

.. java:method::  Polynomial get_Polynomial(int PolynomialNumber)
   :outertype: PolynomialList

   Gibt ein einzelnes Polynomial aus dem Polynomial[] zurück

   :param PolynomialNumber: Element des Polynomial[] welches zurück gegeben werden soll
   :return: Polynomial Objekt

length
^^^^^^

.. java:method:: public int length()
   :outertype: PolynomialList

   Gibt die länge des Polynomial[] zurück

   :return: Int länge des Polynomial[]

load
^^^^

.. java:method::  void load()
   :outertype: PolynomialList

   Ersetzt das vorhandene Polynomial[] mit der aus der this.file Json Datei angeben Werten Polynomial[]

mathAddSub
^^^^^^^^^^

.. java:method::  Polynomial mathAddSub(Polynomial Polynomial_1, Polynomial Polynomial_2, boolean operator)
   :outertype: PolynomialList

   Addiert oder Subtraiert 2 Polynome miteinander, gibt dieses als Polynomial Klasse zurück und fügt es in Polynomial[] hinzu

   :param Polynomial_1: Polynom 1 welche zu Polynom 2 addiert wird
   :param Polynomial_2: Polynom 2 welche zu Polynom 1 addiert wird
   :param operator: 1 == +, 0 == -
   :return: Neues Polynomial welches durch die Berechnung entstand

mathHorner
^^^^^^^^^^

.. java:method::  double mathHorner(Polynomial Polynomial, double divisor)
   :outertype: PolynomialList

   Polynomdivision nach dem Horner Schema, bei erfogreicher Division wird das neue Polynom Polynomial[] angehängt

   :param Polynomial: Polynom welches dividiert werden soll
   :param divisor: Die Zahl mit der das Polynom dividiert werden soll
   :return: Rest in Double

mathMultiply
^^^^^^^^^^^^

.. java:method::  Polynomial mathMultiply(Polynomial Polynomial_1, Polynomial Polynomial_2)
   :outertype: PolynomialList

   Multipliziert 2 Polynome miteinander und speichert das Polynom in PolylList

   :param Polynomial_1: Polynom 1 welches zu Polynom 2 multipliziert werden soll
   :param Polynomial_2: Polynom 2 welches zu Polynom 1 multipliziert werden soll
   :return: neues multipliziertes Polynom

randomPolynomial
^^^^^^^^^^^^^^^^

.. java:method::  Polynomial randomPolynomial(int length, boolean random)
   :outertype: PolynomialList

   Erstellt ein Polynomial mit der Länge length und wenn random wahr ist, mit festen Werten

   :param length: länge des Beispiel Polynomes
   :param random: Polynom bekommt feste Werte zugewiesen mit [i] = i
   :return: zufälliges neues Polynomial

randomPolynomialArray
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  Polynomial[] randomPolynomialArray(int arrayLength, int PolynomialLength, boolean random)
   :outertype: PolynomialList

   Erstellt ein Polynomial[] mit zufalls Zahlen und arrayLength länge, die länge der Polynome wird mit PolynomialLength bestimmt

   :param arrayLength: Länge von Polynomial[]
   :param PolynomialLength: Länge des Polynomial
   :param random: Polynom bekommt feste Werte zugewiesen mit [i] = i
   :return: zufälliges neues Polynomial[]

save
^^^^

.. java:method::  void save()
   :outertype: PolynomialList

   Speichert Polynomial[] in this.file angeben Datei als Json format ab

set
^^^

.. java:method:: public void set(int ArrayNumber, Polynomial newPolynomial)
   :outertype: PolynomialList

   Überschreibt ein Polynomial aus Polynomial[] mit einen neuem Polynomial

   :param ArrayNumber: Element nummer des zu überschreibenen Polynomial
   :param newPolynomial: Neues Polynomial welches das alte überschreiben soll

set_file
^^^^^^^^

.. java:method::  void set_file(String FileName)
   :outertype: PolynomialList

   Setzt den Namen und Pfad der Json Datei

   :param FileName: Datei Namen und Pfad der neuen Json Datei

