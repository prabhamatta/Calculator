package mycalculator;
/**
 * Job of the CalculatorTest:  understands the correctness of calculator
 * Created by prabha on 4/4/14.
 */

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class CalculatorTest {

    @Test
    public void testNothing() {
    }

    @Test
    public void dummyTestTwoPlusTwoEqualsFour(){
        assertEquals(4, (2+2));
    }

    @Test
    public void NinePlusTwoIsEleven(){
        Calculator calc = new Calculator();
        calc.enterDigit('9');
//        System.out.println(calc.getDisplayText());
        calc.enterOperator('+');
//        System.out.println(calc.getDisplayText());
        calc.enterDigit('2');
//        System.out.println(calc.getDisplayText());
        calc.enterOperator('=');
//        System.out.println(calc.getDisplayText());

        assertEquals(calc.getDisplayText(), "11=");
//        System.out.println("End...");
    }



}