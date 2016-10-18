import javax.swing.*;

/**
 * Created by fubu on 18.10.16.
 */
public class PolynomialForm {

    private JPanel MainPanel;

    public static void main() {
        JFrame frame = new JFrame("PolyForm");
        frame.setContentPane(new PolynomialForm().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
