//package com.linuxluigi.polynomials;
import java.util.Scanner;

/**
 * User Terminal Interface Ausgabe
 * Gibt ein Menu und sonstige nützliche
 * Userinterface features aus
 * Created by Steffen Exler on 18.10.16.
 */
class TerminalInterface {
    /**
     * Gibt den String Text in ein Rahm aus
     *
     * @param Text String der im Rahmen angezeigt werden soll
     */
    void BoarderText(String Text) {
        String FillerLine = "";

        for (int i = 0; i < Text.length(); i++) {
            FillerLine = FillerLine + "-";
        }

        System.out.printf("+---%s---+\n", FillerLine);
        System.out.printf("|   %s   |\n", Text);
        System.out.printf("+---%s---+\n", FillerLine);
    }

    /**
     * Ließt eine User Terminal eingabe und ueberprueft
     * ob es sich um ein String handelt und gibt diesen zurück
     *
     * @param TextError Text der bei Falscher eingabe wiederholt wird
     * @param Default   Return Wert wenn User keine eingabe tätigt
     * @return User eingabe als String
     */
    String InputString(String TextError, String Default) {
        Scanner ScannerInput = new Scanner(System.in);
        String UserInput;

        do {
            if (ScannerInput.hasNextLine()) {
                UserInput = ScannerInput.nextLine();
                if (UserInput.equals("")) {
                    // Enter drücken ohne weitere eingabe
                    UserInput = Default;
                    break;
                }
                System.out.println(UserInput);
            } else {
                System.out.println(TextError);
                UserInput = null;
            }
        } while (UserInput == null);

        return UserInput;
    }

    /**
     * Ließt eine User Terminal eingabe und überprüft
     * ob es sich um ein Int handelt und gibt diesen zurück
     *
     * @param TextError Text der bei Falscher eingabe wiederholt wird
     * @return User eingabe als Int
     */
    int InputInt(String TextError) {
        Scanner ScannerInput = new Scanner(System.in);

        boolean Error = true;
        int UserInput = 0;

        while (Error) {
            if (ScannerInput.hasNextInt())
                UserInput = ScannerInput.nextInt();
            else {
                System.out.println(TextError);
                ScannerInput.next();
                continue;
            }
            Error = false;
        }
        return UserInput;
    }

    /**
     * Erstellt ein User Terminal Menu, dieser kann mit der
     * Int eingabe auswählen welchen Menupunkt er auswählen
     * möchte. Das Menu wird mithilfe eines String[] gebildet
     * und gibt die Usereingabe zurück.
     *
     * @param MenuList Eine Liste mit allen Antwortmöglichkeiten
     * @param Back     True == fügt ein Menupunkt ein, um ins Vorherige Menu zurück zu kommen
     * @return User Antwort als Int Wert. Der Wert ist die Nummer im MenuList[].
     * Beispiel: Bei MenuList["Ich", "Du", "Er"] gibt der User
     * 2 an und meint damit "Du" und 1 wird auch als
     * Int zurück gegeben.
     */
    int ShowMenu(String[] MenuList, boolean Back) {
        for (int i = 0; i < MenuList.length; i++) {
            System.out.printf("[%d] %s\n\r", i + 1, MenuList[i]);
        }

        int MenuMaxNumber;
        if (Back) {
            System.out.printf("[%d] %s\n\r", MenuList.length + 1, "Zurück");
            MenuMaxNumber = MenuList.length + 1;
        } else {
            MenuMaxNumber = MenuList.length;
        }

        int UserInput;
        do {
            System.out.printf("Aktion auswählen mit eingabe des Menupunktes als Zahl zwischen %d und %d\n" +
                    "\n", 1, MenuMaxNumber);
            String ErrorMessage = String.format("Bitte nur Zahlen zwischen %d und %d eingeben!\n\r",
                    1, MenuMaxNumber);
            UserInput = InputInt(ErrorMessage);
        } while (UserInput > MenuMaxNumber || UserInput < 1);
        return UserInput - 1;
    }

}
