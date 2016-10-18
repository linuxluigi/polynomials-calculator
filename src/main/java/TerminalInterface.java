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

    public String InputString (String TextError) {
        /**
         * Überprüft Scanner Consolen eingabe auf String
         * eine Richtige eingabe zu tätigen
         * @param TextError Text der bei Falscher eingabe wiederholt wird
         */
        Scanner ScannerInput = new Scanner(System.in);

        boolean Error = true;
        String UserInput = "";

        while (Error) {
            if (ScannerInput.hasNext())
                UserInput = ScannerInput.next();
            else {
                System.out.println(TextError);
                ScannerInput.next();
                continue;
            }
            Error = false;
        }
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

}
