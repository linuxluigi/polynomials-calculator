package com.linuxluigi.polynomials;

import javax.swing.*;

import java.util.Date;

/**
 * Created by Steffen Exler on 14.10.16.
 */
public class PolyForm {
    private JPanel panel1;
    private JButton NEWButton;
    private JButton LOADButton;
    private JButton NEWButton1;
    private JButton LOADButton1;
    private JButton NEWButton2;
    private JButton SAVEButton2;
    private JButton SAVEButton;
    private JButton SAVEButton1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton DELETEButton2;
    private JButton DELETEButton1;
    private JButton DELETEButton;


    public static void main() {
        JFrame frame = new JFrame("PolyForm");
        frame.setContentPane(new PolyForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
