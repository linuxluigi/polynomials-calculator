package com.linuxluigi.polynomial;

/**
 * Main Klasse, die das Terminal und PolynomialList initialesiert,
 * außerdem staratet es den Wizard Modus der den User fragt ob die
 * Json Datei geladen werden soll und deren Pfad definiert.
 * Anschließend wird das Usermenu gestartet welches in Endloschleife
 * arbeitet bis der User das Programm über das Menu beendet.
 *
 * @author Steffen Exler
 * @version %I%, %G%
 * @since 0.1.0
 */



public class Main {
    private static PolynomialList PolynomialList = new PolynomialList();

    /**
     * Die Main Klasse zum starten des Userinterface, fragen nach der Json Datei Pfad
     * und MainMenu in endlos Schleife starten äääöö
     *
     * @param args ...
     */
    public static void main(String[] args) {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Rechner 1.0.0");
        System.out.println("Operationen mit Polynomen &  Speichern der Polynome in einer JSON Datei");

        // Json angeben
        System.out.println("Json Datei [save.json]");
        String FileName = Interface.InputString("Bitte Datei Pfad angeben", PolynomialList.get_FileName());
        if (!FileName.equals(PolynomialList.get_FileName())) {
            PolynomialList.set_file(FileName);
        }

        // Json laden
        System.out.println("Json laden [Y/n]");
        String Question_LoadJsonM = Interface.InputString("Json laden [Y/n]", "Y");
        if (!Question_LoadJsonM.equals("n") || Question_LoadJsonM.equals("N")) {
            PolynomialList.load();
        }

        //Lade MainMenu
        while (true) {
            MainMenu();
        }
    }

    /**
     * Erstellt das Hauptmenu
     */
    private static void MainMenu() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Haupt Menu");
        String[] MainMenuArray = {
                "Polynome Anzeigen",
                "Polynom hinzufügen",
                "Polynom bearbeiten",
                "Polynom löschen",
                "Polynom addieren",
                "Polynom subtraieren",
                "Polynom ableiten",
                "Polynom multiplizieren",
                "Polynom Horner-Schema",
                "Json laden",
                "Json speichern",
                "Programm beenden",
        };
        int choice = Interface.ShowMenu(MainMenuArray, false);

        switch (choice) {
            case 0:
                // Polynome Anzeigen
                MainMenu_ShowPolynomialList();
                break;
            case 1:
                // Polynom hinzufügen
                MainMenu_AddPolynomial();
                break;
            case 2:
                // Polynom bearbeiten
                if (PolynomialList.length() == 0) {
                    MainMenu_ShowPolynomialList();
                } else {
                    MainMenu_ChangePolynomial();
                }
                break;
            case 3:
                // Polynom löschen
                if (PolynomialList.length() == 0) {
                    MainMenu_ShowPolynomialList();
                } else {
                    MainMenu_DeletePolynomial();
                }
                break;
            case 4:
                // Polynom addieren
                if (PolynomialList.length() < 1) {
                    System.out.println("Es muss mindestens 1 Polynom vorhanden sein, bitte erstell ein weiteres Polynom");
                } else {
                    MainMenu_mathAddSub(true);
                }
                break;
            case 5:
                // Polynom subtrahieren
                if (PolynomialList.length() < 1) {
                    System.out.println("Es muss mindestens 1 Polynom vorhanden sein, bitte erstell ein weiteres Polynom");
                } else {
                    MainMenu_mathAddSub(false);
                }
                break;
            case 6:
                // Polynom ableiten
                if (PolynomialList.length() < 1) {
                    System.out.println("Es muss mindestens 1 Polynom vorhanden sein, bitte erstell ein weiteres Polynom");
                } else {
                    MainMenu_Derivation();
                }
                break;
            case 7:
                // Polynom multiplizieren
                if (PolynomialList.length() < 1) {
                    System.out.println("Es muss mindestens 1 Polynom vorhanden sein, bitte erstell ein weiteres Polynom");
                } else {
                    MainMenu_Multiply();
                }
                break;
            case 8:
                // Horner-Schema
                if (PolynomialList.length() < 1) {
                    System.out.println("Es muss mindestens 1 Polynom vorhanden sein, bitte erstell ein weiteres Polynom");
                } else {
                    MainMenu_Horner();
                }
                break;
            case 9:
                // Json laden
                MainMenu_Load();
                break;
            case 10:
                // Json speichern
                MainMenu_Save();
                break;
            case 11:
                // Polynom Programm beenden
                Interface.BoarderText("Goodby my friend =)");
                System.exit(0);
                break;
        }
    }

    /**
     * zeige alle Polynome von PolynomialList als Menlisch lesbare liste
     */
    private static void MainMenu_ShowPolynomialList() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Liste");

        if (PolynomialList.length() == 0) {
            System.out.println("Kein Polynom vorhanden");
        } else {
            Polynomial[] PolylList = PolynomialList.get_PolylList();

            for (int i = 0; i < PolylList.length; i++) {
                System.out.printf("[%d] %s%n", i + 1, PolylList[i].get_as_human_readable());
            }

        }
    }

    /**
     * Erstellt ein neues Polynom durch den User im Terminal
     */
    private static void MainMenu_AddPolynomial() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Erstelle neues Polynom");

        System.out.println("Wie viel Elemente besitzt dein Polynom");
        System.out.println("Beispiel für 5 Elemente: p(x)=2+6x+2x\u00B2+6x\u00B3+4x\u2074");

        int IntArrayLength = 0;
        String StrErrorLength = "Bitte ein Zahl die größer als 1 ist eingeben.";

        while (IntArrayLength < 1) {
            IntArrayLength = Interface.InputInt(StrErrorLength);
            if (IntArrayLength < 1) {
                System.out.println(StrErrorLength);
            }
        }

        Polynomial Polynomial = new Polynomial(IntArrayLength);

        for (int i = 0; i < IntArrayLength; i++) {
            System.out.printf("Element %d eingeben%n", i + 1);
            Polynomial.set(i, Interface.InputDouble("Bitte nur Reele Zahlen in Positiven und Negativen bereich eingeben"));
        }

        PolynomialList.add(Polynomial);
        Interface.BoarderText("Neues Polynom: " + Polynomial.get_as_human_readable());
    }

    /**
     * Löscht ein Polynom aus PolynomialList
     */
    private static void MainMenu_DeletePolynomial() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Löschen");

        System.out.println("Gib an welches der folgenden Polynome gelöscht werden soll");
        MainMenu_ShowPolynomialList();

        int UserInput;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        do {
            UserInput = Interface.InputInt(StrErrorNumber);
            if (UserInput < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput > PolynomialList.length() || UserInput < 1);

        Polynomial Polynomial = PolynomialList.get_Polynomial(UserInput - 1);
        System.out.println("Polynom wirklich löschen? " + Polynomial.get_as_human_readable() + " [y/N]");
        String Question_Delete = Interface.InputString("error", "N");

        if (Question_Delete.equals("y") || Question_Delete.equals("Y")) {
            PolynomialList.delte(UserInput);
            Interface.BoarderText("Polynom gelöscht");
        } else {
            Interface.BoarderText("Polynom nicht gelöscht");
        }
    }

    /**
     * Ändert ein Polynom aus PolynomialList
     */
    private static void MainMenu_ChangePolynomial() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom bearbeiten");

        System.out.println("Gib an welches der folgenden Polynome geändert werden soll");
        MainMenu_ShowPolynomialList();

        int UserInput;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        do {
            UserInput = Interface.InputInt(StrErrorNumber);
            if (UserInput < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput > PolynomialList.length() || UserInput < 1);

        Polynomial Polynomial = PolynomialList.get_Polynomial(UserInput - 1);

        for (int i = 0; i < Polynomial.length(); i++) {

            int doubleLength;
            if (Polynomial.get(i) % 1 != 0) {
                doubleLength = 3;
            } else {
                doubleLength = 0;
            }

            System.out.printf("neuen Wert für Element %d [%." + doubleLength + "f]%n", i + 1, Polynomial.get(i));
            Polynomial.set(i, Interface.InputDouble("Bitte nur eine Reele Zahl angeben!"));
        }

        System.out.printf("Polynom zu %s geändert%n", Polynomial.get_as_human_readable());
        PolynomialList.set(UserInput, Polynomial);

        Interface.BoarderText("Polynom geändert");
    }

    /**
     * Menu zum addieren und subtrahieren von 2 Polynomen
     *
     * @param operator gibt an ob eine Addition oder Subtraion vorgenommen werden soll
     *                 true == +; false == -
     */
    private static void MainMenu_mathAddSub(boolean operator) {
        TerminalInterface Interface = new TerminalInterface();
        String StrOperator;

        if (operator) {
            StrOperator = "addieren";
        } else {
            StrOperator = "subtraieren";
        }

        Interface.BoarderText("Polynome " + StrOperator);

        System.out.printf("Welches der folgenden Polynome soll %s werden%n", StrOperator);

        MainMenu_ShowPolynomialList();
        int UserInput_1;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        do {
            UserInput_1 = Interface.InputInt(StrErrorNumber);
            if (UserInput_1 < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput_1 > PolynomialList.length() || UserInput_1 < 1);

        System.out.printf("Welches der folgenden Polynome soll %s werden%n", StrOperator);

        MainMenu_ShowPolynomialList();
        int UserInput_2;

        do {
            UserInput_2 = Interface.InputInt(StrErrorNumber);
            if (UserInput_2 < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput_2 > PolynomialList.length() || UserInput_2 < 1);

        Polynomial newPolynomial = PolynomialList.mathAddSub(
                PolynomialList.get_Polynomial(UserInput_1 - 1),
                PolynomialList.get_Polynomial(UserInput_2 - 1),
                operator
        );

        Interface.BoarderText("Neues Polynom: " + newPolynomial.get_as_human_readable());
    }

    /**
     * 1. Ableitung eines Polynoms
     */
    private static void MainMenu_Derivation() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Ableiten eines Polynomes");

        int UserInput;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        MainMenu_ShowPolynomialList();

        do {
            UserInput = Interface.InputInt(StrErrorNumber);
            if (UserInput < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput > PolynomialList.length() || UserInput < 1);

        Interface.BoarderText(PolynomialList.get_Polynomial(UserInput - 1).Derivation());
    }

    /**
     * 2 Polynome miteinander Multiplizieren
     */
    private static void MainMenu_Multiply() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynome Multiplizieren");

        System.out.println("Welches der folgenden Polynome soll multipliziert werden");

        MainMenu_ShowPolynomialList();
        int UserInput_1;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        do {
            UserInput_1 = Interface.InputInt(StrErrorNumber);
            if (UserInput_1 < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput_1 > PolynomialList.length() || UserInput_1 < 1);

        System.out.println("Welches der folgenden Polynome soll multipliziert werden");

        MainMenu_ShowPolynomialList();
        int UserInput_2;

        do {
            UserInput_2 = Interface.InputInt(StrErrorNumber);
            if (UserInput_2 < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput_2 > PolynomialList.length() || UserInput_2 < 1);

        Polynomial newPolynomial = PolynomialList.mathMultiply(
                PolynomialList.get_Polynomial(UserInput_1 - 1),
                PolynomialList.get_Polynomial(UserInput_2 - 1)
        );

        Interface.BoarderText(
                "Neues Polynom: " + newPolynomial.get_as_human_readable()
        );
    }

    /**
     * Horner Schema berechnen
     */
    private static void MainMenu_Horner() {
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Horner-Schema");

        System.out.println("Welches der folgenden Polynome soll dividiert werden");

        MainMenu_ShowPolynomialList();
        int UserInput;
        String StrErrorNumber = "Bitte eine Zahl aus der Polynomliste angeben.";

        do {
            UserInput = Interface.InputInt(StrErrorNumber);
            if (UserInput < 1) {
                System.out.println(StrErrorNumber);
            }
        } while (UserInput > PolynomialList.length() || UserInput < 1);

        System.out.println("Divisor eingeben.");
        double divisor = Interface.InputDouble("Bitte eine Reele Zahl eingeben.");

        double horner = PolynomialList.mathHorner(PolynomialList.get_Polynomial(UserInput - 1), divisor);

        if (horner == 0.0) {
            Interface.BoarderText(
                    "Erfolg: " + PolynomialList.get_Polynomial(PolynomialList.length() - 1).get_as_human_readable()
            );
        } else {
            System.out.printf("%s %nRest: %.3f%n", PolynomialList.get_Polynomial(PolynomialList.length() - 1).get_as_human_readable(), horner);
        }
    }

    /**
     * Lädt PolynomialList neu aus der Json Datei
     */
    private static void MainMenu_Load() {
        PolynomialList.load();
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Json geladen");
    }

    /**
     * Sichert PolynomialList in der Json Datei
     */
    private static void MainMenu_Save() {
        PolynomialList.save();
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Gespeichert");
    }

}
