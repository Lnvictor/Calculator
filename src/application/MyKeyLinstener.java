package application;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Key Events Listener. Made for when the user
 * presses "ENTER" key so appears the result
 * in text box...
 *
 * @author Victor Pereira
 * @version 1.0
 */
public class MyKeyLinstener implements KeyListener {
    private MainApp myFrame;
    private JButton myButton;

    public MyKeyLinstener(JFrame myFrame){
        this.myFrame = (MainApp) myFrame;
    }

    public MyKeyLinstener(JFrame myFrame, JButton myButton){
        this(myFrame);
        this.myButton = myButton;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            MyMouseListener myListener = new MyMouseListener(myFrame, myButton);
            myFrame.setResult(myListener.returnResultOfExpression(myFrame.getExpression()));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
