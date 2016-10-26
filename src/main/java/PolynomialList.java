/**
 * Save & Load Json File
 * <p>
 * Created by Steffen Exler on 17.10.16.
 */

import java.io.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class PolynomialList {
    /**
     * Laden und Speichern eines Polynomial Array
     *
     * @param PolylList Polynomial Array
     * @param file JSON Datei für laden und sichern des Polynomial Array
     */

    private Polynomial[] PolylList = new Polynomial[0];
    private File file = new File("save.json");

    public void set_file(String FileName) {
        /**
         * @param FileName Datei Namen und Pfad der neuen Json Datei
         */
        this.file = new File(FileName);
    }

    public String get_FileName() {
        /**
         * Gibt den Json Datei Namen zurück
         */
        return this.file.getName();
    }

    public Polynomial[] get_PolylList() {
        /**
         * return PolylList
         */
        return this.PolylList;
    }

    public Polynomial get_Polynomial(int PolynomialNumber) {
        /**
         * @param PolynomialNumber Zahl im PolylList array
         * return ein einzelnes Polynom
         */
        return this.PolylList[PolynomialNumber];
    }

    public int length() {
        /**
         * return PolylList length
         */
        return this.PolylList.length;
    }

    public void add(Polynomial newPolynomial) {
        /**
         * Hängt ein neues Polynom PolylList an
         * @param newPolynomial Polynom aus der Klasse Polynomial, wird PolylList angehängt
         */
        Polynomial[] newPolylList = new Polynomial[this.PolylList.length + 1];
        for (int i = 0; i < this.PolylList.length; i++) {
            newPolylList[i] = this.PolylList[i];
        }
        newPolylList[this.PolylList.length] = newPolynomial;
        this.PolylList = newPolylList;
    }

    public void set(int ArrayNumber, Polynomial newPolynomial) {
        /**
         * Überschreib das Polynom PolylList[ArrayNumber] mit newPolynomial
         *
         * @param ArrayNumber Array nummer von PolylList
         * @param newPolynomial neues Polynom was eingesetzt werden soll
         */

        this.PolylList[ArrayNumber - 1] = newPolynomial;
    }

    public void delte(int PolynomialNumber) {
        /**
         * Löscht ein Polynom aus PolylList
         *
         * @param PolynomialNumber Zahl im PolylList array
         */

        Polynomial[] newPolylList = new Polynomial[this.PolylList.length - 1];
        for (int i = 0; i < this.PolylList.length - 1; i++) {
            if (i != PolynomialNumber) {
                newPolylList[i] = this.PolylList[i];
            }
        }
        this.PolylList = newPolylList;
    }

    public Polynomial mathAddSub(Polynomial Polynomial_1, Polynomial Polynomial_2, boolean operator) {
        /**
         * Addiert oder Subtraiert 2 Polynome miteinander, gibt dieses als Polynomial Klasse zurück
         * und fügt es in PolylList hinzu
         *
         * @param Polynomial_1 Polynom 1 welche zu Polynom 2 addiert wird
         * @param Polynomial_2 Polynom 2 welche zu Polynom 1 addiert wird
         * @param operator 1 == +, 0 == -
         */

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

        for (int i = 0; i < PolyMinLength; i++) {
            int newVaule;
            if(operator == true) {
                newVaule = Polynomial_1.get(i) + Polynomial_2.get(i);
            } else {
                newVaule = Polynomial_1.get(i) - Polynomial_2.get(i);
            }
            newPolynomial.set(i, newVaule);
        }
        for (int i = PolyMinLength-1; i < PolyMaxLength; i++) {
            if(Polynomial_1.length() == PolyMaxLength) {
                newPolynomial.set(i, Polynomial_1.get(i));
            } else {
                newPolynomial.set(i, Polynomial_2.get(i));
            }
        }

        add(newPolynomial);

        return newPolynomial;
    }

    public void load() {
        /**
         * load save.json >> into >> this.PolylList
         */

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


    public void save() {
        /**
         * save save.json >> into >> this.PolylList
         */
        Gson gson = new GsonBuilder().create();
        String content = gson.toJson(this.PolylList);

        try {
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}