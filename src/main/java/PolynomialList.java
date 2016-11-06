import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Random;

/**
 * Ein Polynom Klasse Array welche mitunter folgende funktionen mitbringt:
 * <ul>
 * <li>Einzelne Polynome aus den Polynom[] ausgeben</li>
 * <li>Polynome miteinander multiplizieren, addieren und subtrahieren</li>
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

        int counter = 0;

        for (int i = 0; i < this.PolylList.length - 1; i++) {
            if (i != PolynomialNumber) {
                newPolylList[counter] = this.PolylList[i];
                counter++;
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
            double newVaule;
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
     * Polynomdivision nach dem Horner Schema, bei erfogreicher Division
     * wird das neue Polynom Polynomial[] angehängt
     *
     * @param Polynomial Polynom welches dividiert werden soll
     * @param divisor    Die Zahl mit der das Polynom dividiert werden soll
     * @return Rest in Double
     */
    double mathHorner(Polynomial Polynomial, double divisor) {

        if (Polynomial.length() == 0) {
            Polynomial newPolynomial = new Polynomial(0);
            add(newPolynomial);
            return 0;
        }

        Polynomial newPolynomial = new Polynomial(Polynomial.length() - 1);
        newPolynomial.set(
                newPolynomial.length() - 1,
                Polynomial.get(Polynomial.length() - 1)
        );

        double remainder = 0;

        for (int i = Polynomial.length() - 1; i >= 0; i--) {
            remainder = Polynomial.get(i) + remainder * divisor;
            if (i > 1) {
                newPolynomial.set(
                        i - 2,
                        newPolynomial.get(i - 1) * divisor + Polynomial.get(i - 1)
                );
            }
        }

        add(newPolynomial);
        return remainder;
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

    /**
     * Erstellt ein Polynomial mit der Länge length und wenn random
     * wahr ist, mit festen Werten
     *
     * @param length länge des Beispiel Polynomes
     * @param random Polynom bekommt feste Werte zugewiesen mit [i] = i
     * @return zufälliges neues Polynomial
     */
    Polynomial randomPolynomial(int length, boolean random) {
        if (length < 0) {
            length = 0;
        }

        Polynomial Polynomial = new Polynomial(length);

        Random ran = new Random();

        for (int i = 0; i < length; i++) {
            if (random) {
                Polynomial.set(i, ran.nextInt() + ran.nextDouble());
            } else {
                Polynomial.set(i, (double) i);
            }
        }

        return Polynomial;
    }

    /**
     * Erstellt ein Polynomial[] mit zufalls Zahlen und arrayLength länge,
     * die länge der Polynome wird mit PolynomialLength bestimmt
     *
     * @param arrayLength      Länge von Polynomial[]
     * @param PolynomialLength Länge des Polynomial
     * @param random           Polynom bekommt feste Werte zugewiesen mit [i] = i
     * @return zufälliges neues Polynomial[]
     */
    Polynomial[] randomPolynomialArray(int arrayLength, int PolynomialLength, boolean random) {

        if (arrayLength < 0) {
            arrayLength = 0;
        }

        if (PolynomialLength < 0) {
            PolynomialLength = 0;
        }

        Polynomial[] PolynomialArray = new Polynomial[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            PolynomialArray[i] = randomPolynomial(PolynomialLength, random);
        }

        return PolynomialArray;
    }

}