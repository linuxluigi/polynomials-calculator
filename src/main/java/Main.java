/**
 * Some comment
 *
 * @author      Steffen Exler
 * @version     %I%, %G%
 * @since       0.0.1
 */


public class Main {

    public static void main(String[] args) {
        /**
         *
         */

        PolynomialList PolynomialList = new PolynomialList();
        TerminalInterface Interface = new TerminalInterface();
        Interface.BoarderText("Polynom Rechner 0.1");
        System.out.println("Operationen mit Polynomen &  Speichern der Polynome in einer JSON Datei");

        // Json angeben
        System.out.println("Json Datei [save.json]");
        String FileName = Interface.InputString("Bitte Datei Pfad angeben");
        if (FileName != "") {
            PolynomialList.set_file(FileName);
        }

        // Json laden
        System.out.println("Json laden [Y/n]");
        if ("n" != Interface.InputString("Json laden [Y/n]")) {
            PolynomialList.load();
        }

        // Todo: Show Menu

    }
}
