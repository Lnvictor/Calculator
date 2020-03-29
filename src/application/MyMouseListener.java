package application;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

/**
 * Mouse Event Listener. Made with purpose of the
 * write the button labels in the text box
 * when cliked.
 *
 * @author Victor Pereira
 * @version 1.0
 */

public class MyMouseListener implements MouseListener {
    private MainApp myFrame;
    private JButton button;
    private JLabel resultOperation;

    public MyMouseListener(MainApp myFrame){
        this.myFrame = myFrame;
    }

    public MyMouseListener( MainApp myFrame, JButton button){
        this(myFrame);
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(resultOperation != null)
            myFrame.remove(resultOperation);

        if(this.button.getText().equals("=")){
            if(!myFrame.getExpression().isEmpty()) {
                double result = returnResultOfExpression(myFrame.getExpression());
                myFrame.setResult(result);
                this.myFrame.setVisible(true);
            }
        }
        else{
            myFrame.setExpression(this.myFrame.getExpression() + button.getText());
        }
    }

    /**
     * Receives a Math expression in String form
     * and returns the result in numerical form
     *
     * @param expression
     * @return a double that's the expression result
     */
    public double returnResultOfExpression(String expression) {
        List<String> symbols = new ArrayList<>();
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");

        for(String symbol : symbols) {
            if (expression.indexOf(symbol) > 0) {
                double number1 = Double.parseDouble(expression.substring(0, expression.indexOf(symbol)));
                double number2 = Double.parseDouble(expression.substring(expression.indexOf(symbol) + 1));

                if(symbol == "+"){
                    return number1 + number2;
                }
                if(symbol == "-"){
                    return number1 - number2;
                }
                if(symbol == "*"){
                    return number1 * number2;
                }
                return number1 / number2;
            }
        }
        return 0.0;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
