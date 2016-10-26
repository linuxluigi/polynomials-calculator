/**
 * Some comment
 *
 * @author Steffen Exler
 * @version %I%, %G%
 * @since 0.0.1
 */


public class Main {
    public static void main(String[] args) {
        /**
         * Fragt nach welche Daten geladen werden soll
         * und initialesiert die Variablen
         */
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Rechner 0.1.0");
        System.out.println("Operationen mit Polynomen &  Speichern der Polynome in einer JSON Datei");

        // Json angeben
        System.out.println("Json Datei [save.json]");
        String FileName = Interface.InputString("Bitte Datei Pfad angeben", PolynomialList.get_FileName());
        if (FileName.equals(PolynomialList.get_FileName()) == false) {
            PolynomialList.set_file(FileName);
        }

        // Json laden
        System.out.println("Json laden [Y/n]");
        String Question_LoadJsonM = Interface.InputString("Json laden [Y/n]", "Y");
        if (Question_LoadJsonM.equals("n") == false || Question_LoadJsonM.equals("N")) {
            PolynomialList.load();
        }

        //Lade MainMenu
        while (true == true) {
            MainMenu();
        }
    }

    private static PolynomialList PolynomialList = new PolynomialList();

    private static void MainMenu() {
        /**
         * Erstellt das Hauptmenu
         */
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Haupt Menu");
        String[] MainMenuArray = {
                "Polynome Anzeigen",
                "Polynom hinzufügen",
                "Polynom bearbeiten",
                "Polynom löschen",
                "Json laden",
                "Json speichern",
                "Programm beenden",
        };
        int choice = Interface.ShowMenu(MainMenuArray, false);

        switch (choice) {
            case 1:
                // Polynome Anzeigen
                MainMenu_ShowPolynomialList();
                break;
            case 2:
                // Polynom hinzufügen
                MainMenu_AddPolynomial();
                break;
            case 3:
                // Polynom bearbeiten
                if (PolynomialList.length() == 0) {
                    MainMenu_ShowPolynomialList();
                } else {
                    MainMenu_ChangePolynomial();
                }
                break;
            case 4:
                // Polynom löschen
                if (PolynomialList.length() == 0) {
                    MainMenu_ShowPolynomialList();
                } else {
                    MainMenu_DeletePolynomial();
                }
                break;
            case 5:
                // Json laden
                MainMenu_Load();
                break;
            case 6:
                // Json speichern
                MainMenu_Save();
                break;
            case 7:
                // Programm beenden
                Interface.BoarderText("Goodby my friend =)");
                System.exit(0);
                break;
        }
    }

    private static void MainMenu_ShowPolynomialList() {
        /**
         * zeige alle Polynome von PolynomialList als Menlisch lesbare liste
         */

        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Liste");
        if (PolynomialList.length() == 0) {
            System.out.println("Kein Polynom vorhanden");
        } else {
            Polynomial[] PolylList = PolynomialList.get_PolylList();
            for (int i = 0; i < PolylList.length; i++) {
                System.out.printf("[%d] %s\n\r", i + 1, PolylList[i].get_as_human_readable());
            }
        }
    }

    private static void MainMenu_AddPolynomial() {
        /**
         * Erstellt ein neues Polynom durch den User im Terminal
         */

        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Erstelle neues Polynom");
        System.out.println("Wie viel Elemente besitzt dein Polynom");
        System.out.println("Beispiel für 5 Elemente: 55=2+6x+2x\u00B2+6x\u00B3+4x\u2074");
        int IntArrayLength = 0;
        String StrErrorLength = "Bitte ein Zahl die größer als 1 ist eingeben.";
        while (IntArrayLength < 1) {
            IntArrayLength = Interface.InputInt(StrErrorLength);
            if (IntArrayLength < 1) {
                System.out.println(StrErrorLength);
            }
        }
        Polynomial Polynomial = new Polynomial(IntArrayLength + 1);
        String StrErrorInt = "Bitte nur Zahlen in Positiven und Negativen bereich eingeben";
        System.out.println("Ergebnis des Polynoms eingeben:");
        Polynomial.set(0, Interface.InputInt(StrErrorInt));

        for (int i = 0; i < IntArrayLength; i++) {
            System.out.printf("Element %d eingeben\n\r", i + 1);
            Polynomial.set(i + 1, Interface.InputInt(StrErrorInt));
        }
        PolynomialList.add(Polynomial);
        Interface.BoarderText("Neues Polynom: " + Polynomial.get_as_human_readable());
    }

    private static void MainMenu_DeletePolynomial() {
        /**
         * Löscht ein Polynom aus PolynomialList
         */

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

    private static void MainMenu_ChangePolynomial() {
        /**
         * Ändert ein Polynom aus PolynomialList
         */

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
        System.out.printf("neues Ergebnis [%d]\n\r", Polynomial.get(0));
        Polynomial.set(0, Interface.InputInt("Bitte nur eine Int Zahl angeben!"));

        for(int i = 1; i < Polynomial.length(); i++){
            System.out.printf("neuen Wert für Element %d [%d]\n\r", i, Polynomial.get(i));
            Polynomial.set(i, Interface.InputInt("Bitte nur eine Int Zahl angeben!"));
        }
        System.out.printf("Polynom zu %s geändert\n\r", Polynomial.get_as_human_readable());
        PolynomialList.set(UserInput, Polynomial);

        Interface.BoarderText("Polynom geändert");
    }

    private static void MainMenu_Load() {
        PolynomialList.load();
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Json geladen");
    }

    private static void MainMenu_Save() {
        PolynomialList.save();
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Gespeichert");
    }

}
