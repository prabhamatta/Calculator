package mycalculator;
/**
 * Job of the CalculatorTest:  understands the correctness of calculator
 * Created by prabha on 4/4/14.
 */

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class CalculatorTest {


    @Test
    public void TestingMultipleOperatorsNinePlusTwoPlusTwoIsThirteen(){
        Calculator calc = new Calculator();
        calc.enterDigit('9');
        calc.enterOperator('+');
        calc.enterDigit('2');
        calc.enterOperator('+');
        calc.enterDigit('2');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "13=");
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

    @Test
    public void LatestOperatorTakesPrecedenceNinePlusAndSubtractTwoSeven(){
        Calculator calc = new Calculator();
        calc.enterDigit('9');
        calc.enterOperator('+');
        calc.enterOperator('-');
        calc.enterDigit('2');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "7=");
    }



}