package tests;

import application.MainApp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testSetExpressions {
    private MainApp mainTest;

    @Before
    public void setUp(){
        mainTest = new MainApp();
    }

    @Test
    public void testExpressionA(){
        mainTest.main(new String[0]);
        mainTest.setExpression("3*3");
        Assert.assertEquals("3*3", mainTest.getExpression());
    }

    @Test
    public void testExpressionB(){
        mainTest.main(new String[0]);
        mainTest.setExpression("78 - 35");
        Assert.assertEquals("78 - 35", mainTest.getExpression());
    }

    @Test
    public void testExpressionC(){
        mainTest.main(new String[0]);
        mainTest.setExpression("98 * 7");
        Assert.assertEquals("98 * 7", mainTest.getExpression());
    }

    @Test
    public void testExpressionD(){
        mainTest.main(new String[0]);
        mainTest.setExpression("1/1");
        Assert.assertEquals("1/1", mainTest.getExpression());
    }

    @After
    public void TearDown(){

    }
}
