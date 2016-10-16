/**
 * Some comment
 *
 * @author      Steffen Exler
 * @version     %I%, %G%
 * @since       0.0.1
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        /**
         * @param PolynomialList Liste mit allen Polynomial Objekten
         */
        List<Polynomial> PolynomialList = new ArrayList<Polynomial>();

        /*
        * PolyForm PolyForm = new PolyForm();
        * PolyForm.main();
        */

        Polynomial Polynomial1 = new Polynomial(5);
        System.out.println(Polynomial1.get(0));
        Polynomial1.set(0, 11);
        System.out.println(Polynomial1.get(0));

        PolynomialList.add(Polynomial1);

        System.out.println(PolynomialList.get(0).get(0));

        Gson gson = new GsonBuilder().create();
        gson.toJson(PolynomialList, System.out);
        String content = gson.toJson(PolynomialList);

        try {
            File file = new File("save.json");

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
