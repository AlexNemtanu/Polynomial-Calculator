package View;

import Form.Polynomial;
import Operations.Operations;

import javax.swing.*;
import java.awt.*;

import static Form.Polynomial.setPolynomial;


public class View {

    private JLabel labelOp;
    private JTextField textPol1;
    private JTextField textPol2;
    private JTextField textResult;

    public void GUI()
    {
        JFrame frame = new JFrame("Polynomial Calculator");
        frame.getContentPane().setBackground(new Color(30, 25,25));
        frame.setBounds(100, 100, 600, 600);
        frame.getContentPane().setLayout(null);



        JLabel labelPol1 = new JLabel("Polynomial 1:");
        labelPol1.setForeground(new Color(95, 94, 94));
        labelPol1.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPol1.setFont(new Font("Roboto Bono", Font.PLAIN,17));
        labelPol1.setBounds(10,10,100,50);
        frame.getContentPane().add(labelPol1);

        JLabel labelPol2 = new JLabel("Polynomial 2:");
        labelPol2.setForeground(new Color(95, 94, 94));
        labelPol2.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPol2.setFont(new Font("Roboto Bono", Font.PLAIN,17));
        labelPol2.setBounds(10,110,100,50);
        frame.getContentPane().add(labelPol2);

        JLabel labelResult = new JLabel("Result:");
        labelResult.setForeground(new Color(95, 94, 94));
        labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
        labelResult.setFont(new Font("Roboto Bono", Font.PLAIN, 17));
        labelResult.setBounds(10, 210, 100, 50);
        frame.getContentPane().add(labelResult);

        labelOp = new JLabel("Sign");
        labelOp.setForeground(new Color(95, 94, 94));
        labelOp.setBackground(new Color(30, 25, 25));
        labelOp.setHorizontalAlignment(SwingConstants.CENTER);
        labelOp.setFont(new Font("Roboto Bono", Font.PLAIN, 17));
        labelOp.setBounds(160, 60, 100, 50);
        frame.getContentPane().add(labelOp);

        textPol1 = new JTextField();
        textPol1.setForeground(new Color(255, 255, 255));
        textPol1.setBackground(new Color(30, 25, 25));
        textPol1.setFont(new Font("Roboto Bono", Font.PLAIN, 17));
        textPol1.setColumns(100);
        textPol1.setBorder(BorderFactory.createEmptyBorder());
        textPol1.setBounds(120, 10, 400, 50);
        frame.getContentPane().add(textPol1);

        textPol2 = new JTextField();
        textPol2.setForeground(new Color(255, 255, 255));
        textPol2.setBackground(new Color(30, 25, 25));
        textPol2.setFont(new Font("Roboto Bono", Font.PLAIN, 17));
        textPol2.setColumns(10);
        textPol2.setBorder(BorderFactory.createEmptyBorder());
        textPol2.setBounds(120, 110, 400, 50);
        frame.getContentPane().add(textPol2);

        textResult = new JTextField();
        textResult.setBackground(new Color(30, 25, 25));
        textResult.setForeground(new Color(255, 255, 205));
        textResult.setFont(new Font("Roboto Bono", Font.PLAIN, 17));
        textResult.setBounds(120, 210, 400, 50);
        textResult.setBorder(BorderFactory.createEmptyBorder());
        frame.getContentPane().add(textResult);
        textResult.setColumns(10);

        JButton buttonAddition = new JButton("+");
        buttonAddition.setFont(new Font("Roboto Bono", Font.PLAIN, 40));
        buttonAddition.setBackground(new Color(30, 25, 25));
        buttonAddition.setForeground(new Color(255, 255, 205));
        buttonAddition.setBounds(10, 300, 100, 70);
        frame.getContentPane().add(buttonAddition);

        JButton buttonSubstract = new JButton("-");
        buttonSubstract.setFont(new Font("Roboto Bono", Font.PLAIN, 40));
        buttonSubstract.setBackground(new Color(30, 25, 25));
        buttonSubstract.setForeground(new Color(255, 255, 205));
        buttonSubstract.setBounds(10, 425, 100, 70);
        frame.getContentPane().add(buttonSubstract);

        JButton buttonMultiplication = new JButton("x");
        buttonMultiplication.setFont(new Font("Roboto Bono", Font.PLAIN, 40));
        buttonMultiplication.setBackground(new Color(30, 25, 25));
        buttonMultiplication.setForeground(new Color(255, 255, 205));
        buttonMultiplication.setBounds(230, 300, 100, 70);
        frame.getContentPane().add(buttonMultiplication);

        JButton buttonDivision = new JButton("/");
        buttonDivision.setFont(new Font("Roboto Bono", Font.PLAIN, 40));
        buttonDivision.setBackground(new Color(30, 25, 25));
        buttonDivision.setForeground(new Color(255, 255, 205));
        buttonDivision.setBounds(230, 425, 100, 70);
        frame.getContentPane().add(buttonDivision);

        JButton buttonEquals = new JButton("=");
        buttonEquals.setFont(new Font("Roboto Bono", Font.PLAIN, 60));
        buttonEquals.setBounds(430, 363, 100, 70);
        buttonEquals.setBackground(new Color(245, 198, 198));
        buttonEquals.setForeground(new Color(30, 25, 25));
        frame.getContentPane().add(buttonEquals);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonAddition.addActionListener(e ->{

            String firstPoly = textPol1.getText();
            String secondPoly = textPol2.getText();
            Polynomial p1 = setPolynomial(firstPoly);
            Polynomial p2 = setPolynomial(secondPoly);
            Polynomial result = Operations.addPolynomials(p1, p2);
            textResult.setText(result.polynomialToString());
            labelOp.setText("+");
        });

        buttonSubstract.addActionListener(e ->
        {
            String firstPoly = textPol1.getText();
            String secondPoly = textPol2.getText();
            Polynomial p1 = setPolynomial(firstPoly);
            Polynomial p2 = setPolynomial(secondPoly);
            Polynomial result = Operations.subPolynomials(p1, p2);
            textResult.setText(result.polynomialToString());
            labelOp.setText("-");
        });

        buttonMultiplication.addActionListener(e ->
        {
            String firstPoly = textPol1.getText();
            String secondPoly = textPol2.getText();
            Polynomial p1 = setPolynomial(firstPoly);
            Polynomial p2 = setPolynomial(secondPoly);
            Polynomial result = Operations.multiplyPolynomials(p1, p2);
            textResult.setText(result.polynomialToString());
            labelOp.setText("x");
        });

                    frame.setVisible(true);
    }

}
