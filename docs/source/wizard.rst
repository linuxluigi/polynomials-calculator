Wizard Modus
============

Bedienung
^^^^^^^^^
Der Wizard Modus wird nur am Start des Programmes ausgeführt und dient zum Initialesieren
des Polynoms Array, Json Datei zu bestimmen und bei bedarf Polynome aus dieser Datei zu laden
und zur späteren Verwendung auf zu bereiten.

Nach dem start wird als erstes der Name und die Version des Programmes angezegt.
Anschließend wird abgefragt welche Json Datei zum sichern und laden der Polynome verwendet
werden soll und anschließend ob diese Datei geladen werden wird.

Die Aussagen die in den Eckigen Klammern stehen sind die Standartwerte, die verwendet werden sobald der
User nur Enter drückt, ohne eine weitere Eingabe zu tätigen.


.. image:: img/PolyCalc-Wizard-1.png


Die eingaben in dem Bild wird mit grüner Schrift dargestellt. Die Eingabe bedeutet in diesem Beispiel das
die Json Datei `save.json` verwendet werden soll um die Polynome zu sichern und mit dem folgenden `Y` lädt das
Programm die Polynome die in `save.json` hinterlegt sind.

In diesem Beispiel wäre es kein unterschied ob der User 2 mal einfach nur Enter gedrückt hatte oder eine
vollstänge Eingabe getätigt hatte, da die Standart werde eingeben wurden.

Datei Laden und Sichern
^^^^^^^^^^^^^^^^^^^^^^^

.. index:: Json Laden und Sichern

Bei dem Laden von der Json Datei, wird überprüft ob die Datei vorliegt, falls nicht wird sie neu erzeugt und
es wird ein Leeres Polynom Array zurückgeben. Falls die Datei exiestiert wird versucht den Inhalt, sobald
einer vorhanden ist, als Polynom Array zu konvertieren.

Ein Json Beispiel für 5 Polynome.

.. code-block:: json

    [
      {"polylist":[44.3,122345.0,-5.654,54.0,416.0,45.0]},
      {"polylist":[5.0,-16.0,0.0,-9.0,10.0,4.0]},
      {"polylist":[0.0,6.0,2.0]},
      {"polylist":[0.0,6.0,2.0,3.0]},
      {"polylist":[123.324,123.0,56.0,-5612.42332,654.234,5.0]}
    ]