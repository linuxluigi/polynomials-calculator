# polynomials-calculator
Das Programm "Polynomials Calculator" ist ein reines Konsolenprogramm, welches dazu dient Polynome
bis zum n Grad zu Addieren, Subtrahieren, Multiplizieren und Dividieren.

Es wird dem User ermöglicht Polynome in einer Json Datei zu sichern und zu laden um zu einen späteren
Zeitpunkt weiter damit zu arbeiten.

Nach dem starten wird der Wizard-Modus gestartet um Polynome aus einer Json Datei zu laden und anschließend
wird das Menü gestartet, welche sich so lange wiederholt bis der User das Programm über das Menü schließt.

In Menü kann der User Polynome hinzufügen, bearbeiten und löschen aber auch Mathematische Operationen
Addieren, Subtrahieren, Multiplizieren und Dividieren ausführen sowie die Polynome als Json sichern
oder neu von der Json einlesen.

# Kompilieren

Im Rootverzeichnis des Projektes im Terminal wechseln und ```mvn clean install``` eingeben.
Damit werden alle Maven 2 abhänigkeiten automatisch heruntergeladen, tests ausgeführt und wenn die Test fehlerfrei
verlaufen wird die unter `/target/polynomials-calculator-1.0.jar` ausgegeben.

# Dokumentation

http://polynomials-calculator.readthedocs.io/de/latest/

# Build & Develop
IntelliJ IDEA 