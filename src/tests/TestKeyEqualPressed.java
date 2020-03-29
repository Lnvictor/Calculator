package tests;

import application.MainApp;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestKeyEqualPressed {
    private MainApp mainTest;

    @Before
    public void setUp(){
        mainTest = new MainApp();
    }

    @Test
    public void testResultWithEnterPressed(){
        mainTest.setExpression("3*3");
        mainTest.setkKeyEqualPressedMock();
        Assert.assertEquals("9.0", mainTest.getExpression());
    }

    @After
    public void TearDown(){

    }

}
