import javax.swing.*;

/**
 * Created by fubu on 18.10.16.
 */
public class PolynomialForm {

    private JPanel MainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    public static void main() {
        JFrame frame = new JFrame("PolyForm");
        frame.setContentPane(new PolynomialForm().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
