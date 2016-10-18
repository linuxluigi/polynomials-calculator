/**
 * Save & Load Json File
 *
 * Created by Steffen Exler on 17.10.16.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;



public class PolynomialList {
    public PolynomialList() {
        /**
         * load save.json
         */
    }
    public List<Polynomial> PolylList = new ArrayList<Polynomial>();
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

            System.out.println(content);

            Gson gson = new GsonBuilder().create();

            //Type Polynomial = new TypeToken<List<Polynomial>>(){}.getType();

            List list = gson.fromJson(content, ArrayList.class);

            this.PolylList = list;

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(0));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void save() {
        /**
         * save save.json >> into >> this.PolylList
         */

        Polynomial Polynomial1 = new Polynomial(5);
        System.out.println(Polynomial1.get(0));
        Polynomial1.set(0, 1);
        System.out.println(Polynomial1.get(0));

        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 2);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 3);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 4);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 5);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 6);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 7);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 8);
        this.PolylList.add(Polynomial1);
        Polynomial1.set(0, 9);
        this.PolylList.add(Polynomial1);

        Gson gson = new GsonBuilder().create();
        gson.toJson(this.PolylList, System.out);
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

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}