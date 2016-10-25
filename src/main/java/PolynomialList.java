/**
 * Save & Load Json File
 *
 * Created by Steffen Exler on 17.10.16.
 */

import java.io.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class PolynomialList {
    /**
     * Laden und Speichern eines Polynomial Array
     * @param PolylList Polynomial Array
     * @param file JSON Datei für laden und sichern des Polynomial Array
     */

    private Polynomial[] PolylList;
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
        Polynomial[] newPolylList = new Polynomial[this.PolylList.length+1];
        for(int i = 0; i < this.PolylList.length; i++) {
            newPolylList[i] = this.PolylList[i];
        }
        newPolylList[this.PolylList.length] = newPolynomial;
        this.PolylList = newPolylList;
    }

    public void delte(int PolynomialNumber) {
        /**
         * Löscht ein Polynom aus PolylList
         * @param PolynomialNumber Zahl im PolylList array
         */
        Polynomial[] newPolylList = new Polynomial[this.PolylList.length-1];
        for(int i = 0; i < this.PolylList.length; i++) {
            if(i != PolynomialNumber) {
                newPolylList[i] = this.PolylList[i];
            }
        }
        this.PolylList = newPolylList;
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

            while( (row = br.readLine()) != null )
            {
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