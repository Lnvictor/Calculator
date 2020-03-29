package application;

import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.security.Key;
import java.util.*;
import java.util.List;

import static java.awt.event.KeyEvent.*;

/**
 * Graphical Interface of Math Calculator
 *
 * @author Victor Pereira
 * @version 1.0
 */
public class MainApp extends JFrame{
    private JTextArea tArea;
    private List<JButton> operationButtons;
    private List<JButton> numberButtons;
    public MainApp(){
        setTitle("MyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,200);

        operationButtons = new ArrayList<>();
        numberButtons = new ArrayList<>();

        List<JButton> numberButtons = new ArrayList<>();

        tArea = new JTextArea(2,20);
        tArea.addKeyListener(new MyKeyLinstener(this, new JButton("=")));

        for(int i = 0; i < 10; i++){
            numberButtons.add(new JButton(String.valueOf(i)));
        }

        operationButtons.add(new JButton("+"));
        operationButtons.add(new JButton("-"));
        operationButtons.add(new JButton("*"));
        operationButtons.add(new JButton("/"));
        operationButtons.add(new JButton("="));

        JPanel panel2 = new JPanel();
        JPanel panel = new JPanel();

        panel2.add(tArea);
        getContentPane().add(BorderLayout.BEFORE_FIRST_LINE, panel2);

        for(JButton b : operationButtons){
            b.addMouseListener(new MyMouseListener(this, b));
            panel.add(b);
        }

        for(JButton b : numberButtons){
            b.addMouseListener(new MyMouseListener(this, b));
            panel.add(b);
        }

        panel.setAlignmentX(SwingConstants.CENTER);
        panel.setAlignmentY(SwingConstants.BOTTOM);

        getContentPane().add(panel);
    }

    /**
     * Method that returns the expression to be calculated
     *
     * @return TextBox Content
     */
    public String getExpression(){
        return this.tArea.getText();
    }

    /**
     * Sets a expression in text box.
     *
     * @param expression
     */
    public void setExpression(String expression){
        this.tArea.setText(expression);
    }

    /**
     * Sets Calculation result in the text Box
     * @param result
     */
    public void setResult(double result){
        this.tArea.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.setVisible(true);
    }
}
