/**
 * Created by fubu on 16.10.16.
 */

import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class savejson {
    public static void start() throws IOException {
        List<Polynomial> PolynomialList = new ArrayList<Polynomial>();

        Polynomial Polynomial1 = new Polynomial(5);
        System.out.println(Polynomial1.get(0));
        Polynomial1.set(0, 11);
        System.out.println(Polynomial1.get(0));

        PolynomialList.add(Polynomial1);

        System.out.println(PolynomialList.get(0).get(0));





    }
}
