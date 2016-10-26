import java.util.Scanner;

/**
 * User Interface Ausgabe
 * Created by Steffen Exler on 18.10.16.
 */
public class TerminalInterface {
    public void BoarderText (String Text) {
        /**
         * Gibt den String Text in ein Rahm aus
         * @param Text String der im Rahmen angezeigt werden soll
         * @param FillerLine Obere und untere Rahmen, automatische Längenanpassung von Text
         */
        String FillerLine = "";

        for (int i = 0; i < Text.length(); i++) {
            FillerLine = FillerLine + "-";
        }

        System.out.printf("+---%s---+\n", FillerLine);
        System.out.printf("|   %s   |\n", Text);
        System.out.printf("+---%s---+\n", FillerLine);
    }

    public String InputString (String TextError, String Default) {
        /**
         * Überprüft Scanner Consolen eingabe auf String
         * eine Richtige eingabe zu tätigen
         * @param TextError Text der bei Falscher eingabe wiederholt wird
         * @param Default Return Wert wenn User keine eingabe tätigt
         */
        Scanner ScannerInput = new Scanner(System.in);

        String UserInput;
        do {
            if (ScannerInput.hasNextLine()) {
                UserInput = ScannerInput.nextLine();
                if (UserInput.isEmpty()) {
                    // Enter drücken ohne weitere eingabe
                    UserInput = Default;
                    break;
                }
                System.out.println(UserInput);
            } else {
                System.out.println(TextError);
                UserInput = null;
            }
        } while(UserInput==null);
        return UserInput;
    }

    public int InputInt (String TextError) {
        /**
         * Überprüft Scanner Consolen eingabe auf Int
         * eine Richtige eingabe zu tätigen
         * @param TextError Text der bei Falscher eingabe wiederholt wird
         */
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

    public int ShowMenu (String[] MenuList, boolean Back) {
        /**
         * @param MenuList Eine Liste mit allen Antwortmöglichkeiten
         * @param Back True == fügt ein Menupunkt ein, um ins Vorherige Menu zurück zu kommen
         *
         * return   Menuauswahl Nummer von MenuList Array
         */

        for(int i = 0; i < MenuList.length; i++){
            System.out.printf("[%d] %s\n\r", i+1, MenuList[i]);
        }

        int MenuMaxNumber;
        if(Back == true){
            System.out.printf("[%d] %s\n\r", MenuList.length+1, "Zurück");
            MenuMaxNumber = MenuList.length+1;
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
        }while(UserInput > MenuMaxNumber || UserInput < 1);
        return UserInput;
    }

}
