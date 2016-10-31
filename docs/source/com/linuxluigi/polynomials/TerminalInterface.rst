.. java:import:: java.util Scanner

TerminalInterface
=================

.. java:package:: com.linuxluigi.polynomials
   :noindex:

.. java:type::  class TerminalInterface

   User Terminal Interface Ausgabe Gibt ein Menu und sonstige nützliche Userinterface features aus Created by Steffen Exler on 18.10.16.

Methods
-------
BoarderText
^^^^^^^^^^^

.. java:method::  void BoarderText(String Text)
   :outertype: TerminalInterface

   Gibt den String Text in ein Rahm aus

   :param Text: String der im Rahmen angezeigt werden soll

InputInt
^^^^^^^^

.. java:method::  int InputInt(String TextError)
   :outertype: TerminalInterface

   Ließt eine User Terminal eingabe und überprüft ob es sich um ein Int handelt und gibt diesen zurück

   :param TextError: Text der bei Falscher eingabe wiederholt wird
   :return: User eingabe als Int

InputString
^^^^^^^^^^^

.. java:method::  String InputString(String TextError, String Default)
   :outertype: TerminalInterface

   Ließt eine User Terminal eingabe und ueberprueft ob es sich um ein String handelt und gibt diesen zurück

   :param TextError: Text der bei Falscher eingabe wiederholt wird
   :param Default: Return Wert wenn User keine eingabe tätigt
   :return: User eingabe als String

ShowMenu
^^^^^^^^

.. java:method::  int ShowMenu(String[] MenuList, boolean Back)
   :outertype: TerminalInterface

   Erstellt ein User Terminal Menu, dieser kann mit der Int eingabe auswählen welchen Menupunkt er auswählen möchte. Das Menu wird mithilfe eines String[] gebildet und gibt die Usereingabe zurück.

   :param MenuList: Eine Liste mit allen Antwortmöglichkeiten
   :param Back: True == fügt ein Menupunkt ein, um ins Vorherige Menu zurück zu kommen
   :return: User Antwort als Int Wert. Der Wert ist die Nummer im MenuList[]. Beispiel: Bei MenuList["Ich", "Du", "Er"] gibt der User 2 an und meint damit "Du" und 1 wird auch als Int zurück gegeben.

