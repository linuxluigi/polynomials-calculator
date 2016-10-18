/**
 * Save & Load Json File
 *
 * Created by Steffen Exler on 17.10.16.
 */

import java.io.*;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class PolynomialList {
    public PolynomialList() {
        /**
         * load save.json
         */
        load();
    }
    private Polynomial[] PolylList;
    private final File file = new File("save.json");

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

        Polynomial[] myPolynomial = new Polynomial[2];

        myPolynomial[0] = new Polynomial(5);
        myPolynomial[1] = new Polynomial(5);


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