import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Ein Polynom Klasse Array welche mitunter folgende funktionen mitbringt:
 * <ul>
 * <li>Einzelne Polynome aus den Polynom[] ausgeben</li>
 * <li>Polynome miteinander multiplizieren, addieren und subtraieren</li>
 * <li>Einzelne Polynome löschen, bearbeiten oder neu hinzufügen</li>
 * <li>Polynom[] bilden durch laden einer Json Datei</li>
 * <li>Die eigene Klasse als Json Datei speichern</li>
 * </ul>
 */
class PolynomialList {

    private Polynomial[] PolylList;
    private File file = new File("save.json");

    /**
     * Konstruktor
     * Erstellt ein neues leeres Polynomial[]
     */
    public PolynomialList() {
        this.PolylList = new Polynomial[0];
    }

    /**
     * Setzt den Namen und Pfad der Json Datei
     *
     * @param FileName Datei Namen und Pfad der neuen Json Datei
     */
    void set_file(String FileName) {
        this.file = new File(FileName);
    }

    /**
     * Gibt den Json Datei String zurück
     *
     * @return Json Datei namen als String
     */
    String get_FileName() {
        return this.file.getName();
    }

    /**
     * Gibt das Polynomial[] zurück
     *
     * @return Polynomial[]
     */
    Polynomial[] get_PolylList() {
        return this.PolylList;
    }

    /**
     * Gibt ein einzelnes Polynomial aus dem Polynomial[] zurück
     *
     * @param PolynomialNumber Element des Polynomial[] welches zurück gegeben werden soll
     * @return Polynomial Objekt
     */
    Polynomial get_Polynomial(int PolynomialNumber) {
        return this.PolylList[PolynomialNumber];
    }

    /**
     * Gibt die länge des Polynomial[] zurück
     *
     * @return Int länge des Polynomial[]
     */
    public int length() {
        if (this.PolylList == null) {
            return 0;
        } else {
            return this.PolylList.length;
        }
    }

    /**
     * Hängt ein neues Polynomial an Polynomial[] an
     *
     * @param newPolynomial neues Polynomial welches angehängt werden soll
     */
    public void add(Polynomial newPolynomial) {
        Polynomial[] newPolylList = new Polynomial[this.PolylList.length + 1];

        System.arraycopy(this.PolylList, 0, newPolylList, 0, this.PolylList.length);

        newPolylList[this.PolylList.length] = newPolynomial;
        this.PolylList = newPolylList;
    }

    /**
     * Überschreibt ein Polynomial aus Polynomial[] mit einen neuem Polynomial
     *
     * @param ArrayNumber   Element nummer des zu überschreibenen Polynomial
     * @param newPolynomial Neues Polynomial welches das alte überschreiben soll
     */
    public void set(int ArrayNumber, Polynomial newPolynomial) {
        this.PolylList[ArrayNumber - 1] = newPolynomial;
    }

    /**
     * Löscht ein Element aus den Polynomial[]
     *
     * @param PolynomialNumber Element des Polynomial[] welches gelöscht werden soll
     */
    void delte(int PolynomialNumber) {
        Polynomial[] newPolylList = new Polynomial[this.PolylList.length - 1];

        for (int i = 0; i < this.PolylList.length - 1; i++) {
            if (i != PolynomialNumber) {
                newPolylList[i] = this.PolylList[i];
            }
        }

        this.PolylList = newPolylList;
    }


    /**
     * Addiert oder Subtraiert 2 Polynome miteinander, gibt dieses als Polynomial Klasse zurück
     * und fügt es in Polynomial[] hinzu
     *
     * @param Polynomial_1 Polynom 1 welche zu Polynom 2 addiert wird
     * @param Polynomial_2 Polynom 2 welche zu Polynom 1 addiert wird
     * @param operator     1 == +, 0 == -
     * @return Neues Polynomial welches durch die Berechnung entstand
     */
    Polynomial mathAddSub(Polynomial Polynomial_1, Polynomial Polynomial_2, boolean operator) {

        // Überprüft welches Polynom mehr Elemente besitzt und speichert beide Polynom länge als Int
        int PolyMaxLength;
        int PolyMinLength;

        if (Polynomial_1.length() >= Polynomial_2.length()) {
            PolyMaxLength = Polynomial_1.length();
            PolyMinLength = Polynomial_2.length();
        } else {
            PolyMaxLength = Polynomial_2.length();
            PolyMinLength = Polynomial_1.length();
        }

        Polynomial newPolynomial = new Polynomial(PolyMaxLength);

        // Addiere / Subtraiere Polynome bis in der Element höhe des kleineren Polynomes
        for (int i = 0; i < PolyMinLength; i++) {
            int newVaule;
            if (operator) {
                newVaule = Polynomial_1.get(i) + Polynomial_2.get(i);
            } else {
                newVaule = Polynomial_1.get(i) - Polynomial_2.get(i);
            }
            newPolynomial.set(i, newVaule);
        }

        // den Bereich wo ein Polynom größer war als der andere
        // schreibe die weiteren Werte im neuen Polynomial
        for (int i = PolyMinLength; i < PolyMaxLength; i++) {
            if (Polynomial_1.length() == PolyMaxLength) {
                if (operator) {
                    newPolynomial.set(i, Polynomial_1.get(i));
                } else {
                    newPolynomial.set(i, Polynomial_1.get(i) * -1);
                }
            } else {
                if (operator) {
                    newPolynomial.set(i, Polynomial_2.get(i));
                } else {
                    newPolynomial.set(i, Polynomial_2.get(i) * -1);
                }
            }
        }

        // fügt das neue Polynomial Polynomial[] hinzu
        add(newPolynomial);

        return newPolynomial;
    }

    /**
     * Multipliziert 2 Polynome miteinander und speichert das Polynom in PolylList
     *
     * @param Polynomial_1 Polynom 1 welches zu Polynom 2 multipliziert werden soll
     * @param Polynomial_2 Polynom 2 welches zu Polynom 1 multipliziert werden soll
     * @return neues multipliziertes Polynom
     */
    Polynomial mathMultiply(Polynomial Polynomial_1, Polynomial Polynomial_2) {
        Polynomial newPolynomial = new Polynomial(Polynomial_1.length() + Polynomial_2.length() - 1);

        for (int i = 0; i < Polynomial_1.length(); i++) {
            for (int j = 0; j < Polynomial_2.length(); j++) {
                newPolynomial.set(
                        i + j,
                        (Polynomial_1.get(i) * Polynomial_2.get(j)) + newPolynomial.get(i + j)
                );
            }
        }

        // fügt das neue Polynomial Polynomial[] hinzu
        add(newPolynomial);

        return newPolynomial;
    }

    /**
     * Ersetzt das vorhandene Polynomial[] mit der aus der this.file Json Datei
     * angeben Werten Polynomial[]
     */
    void load() {
        try {
            if (!this.file.exists()) {
                this.file.createNewFile();
            }

            FileReader fr = new FileReader(this.file);
            BufferedReader br = new BufferedReader(fr);

            String row;
            String content = "";

            while ((row = br.readLine()) != null) {
                content = content + row;
            }
            br.close();

            Gson gson = new GsonBuilder().create();

            this.PolylList = gson.fromJson(content, Polynomial[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Speichert Polynomial[] in this.file angeben Datei als Json format ab
     */
    void save() {
        Gson gson = new GsonBuilder().create();
        String content = gson.toJson(this.PolylList);

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}