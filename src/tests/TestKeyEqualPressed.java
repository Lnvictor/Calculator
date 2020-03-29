package tests;

import application.MainApp;
import application.MyMouseListener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Victor Pereira
 * @version 1.0
 */
public class TestKeyEqualPressed {
    private MainApp mainTest;

    /**
     * Method that simulate a comportament when
     * the EQUAL Key is pressed
     */
    public void setkKeyEqualPressedMock(){
        MyMouseListener tester = new MyMouseListener(mainTest);
        mainTest.setResult(tester.returnResultOfExpression(mainTest.getExpression()));
    }

    @Before
    public void setUp(){
        mainTest = new MainApp();
    }

    @Test
    public void testResultWithEnterPressed(){
        mainTest.setExpression("3*3");
        this.setkKeyEqualPressedMock();
        Assert.assertEquals("9.0", mainTest.getExpression());
    }
}
