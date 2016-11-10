Über das Programm
-----------------
Das Programm "Polynomials Calculator" ist ein reines Konsolenprogramm, welches dazu dient Polynome
bis zum n Grad zu Addieren, Subtrahieren, Multiplizieren und Dividieren.

Es wird dem User ermöglicht Polynome in einer Json Datei zu sichern und zu laden um zu einen späteren
Zeitpunkt weiter damit zu arbeiten.

Nach dem starten wird der Wizard-Modus gestartet um Polynome aus einer Json Datei zu laden und anschließend
wird das Menü gestartet, welche sich so lange wiederholt bis der User das Programm über das Menü schließt.

In Menü kann der User Polynome hinzufügen, bearbeiten und löschen aber auch Mathematische Operationen
Addieren, Subtrahieren, Multiplizieren und Dividieren ausführen sowie die Polynome als Json sichern
oder neu von der Json einlesen.

Das Projekt wurde mit JUnit 4 tests getestete und die test Klassen befinden sich bei den Quellcode dabei.

- Quellcode: https://github.com/linuxluigi/polynomials-calculator
- Online Dokumentation: http://polynomials-calculator.readthedocs.io/de/latest/
.. index:: Git
.. index:: Quellcode
.. index:: Online Dokumentation

.. image:: img/PolyCalc-Intro-1.png

Kompilieren
-----------
.. index:: Kompilieren
.. index:: Build
.. index:: Build Artifacts
.. index:: Maven

Das Projekt wurde via Maven 2 konstruiert und kann mit ein Konsolen Befehl in einer Jar Datei Kompiliert werden, dafür
muss aber zuerst Maven 2 installiert werden, unter Ubuntu / Debian muss folgendes eingeben werden.

.. code-block:: bash

   $ sudo apt-get install maven2

Jetzt wurde Maven 2 installiert und nun kann das Projekt die abhänigkeiten installiert werden, test ausgeführt und
zur einer ausführbaren Jar ausgeben.

.. code-block:: bash

   $ mvn clean install

.. image:: img/PolyCalc-Compile-1.png

Abhänigkeiten
-------------
.. index:: Abhänigkeiten
Das Projekt wurde als Maven 2 Modul geschrieben und verwendet folgende Maven Module.

Maven Projekt Website: https://maven.apache.org/

Google GSON
^^^^^^^^^^^
.. index:: Google GSON
Gson ist eine Java Bibliothek die es ermöglicht Klassen und Variablen als Json Datei aus zu geben oder
ein String als Klasse oder Variable zu konvertieren.

| Name: google-gson
| Hersteller: Google Inc.
| Version: 2.7
| Link: https://github.com/google/gson

JUnit
^^^^^
.. index:: JUnit
Junit ist ein unit testing Framework für Java von Erich Gamma und Kent Beck.

| Name: JUnit
| Hersteller: Erich Gamma und Kent Beck
| Version: 4.12
| Link: http://junit.org/junit4/