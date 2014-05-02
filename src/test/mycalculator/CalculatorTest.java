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
        calc.enterOperator('+');
        calc.enterDigit('2');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "11=");
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



    @Test
    public void TestingDoubleDigitsOneFourPlusFiveIsNineteen(){
        Calculator calc = new Calculator();
        calc.enterDigit('1');
        calc.enterDigit('4');
        calc.enterOperator('+');
        calc.enterDigit('5');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "19=");
    }


    @Test
    public void TestingIntegerDivisionOneZeroDividedByTwoIsFive(){
        Calculator calc = new Calculator();
        calc.enterDigit('1');
        calc.enterDigit('0');
        calc.enterOperator('/');
        calc.enterDigit('2');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "5=");
    }


    @Test
    public void TestingDivisionByZero_FiveDividedByZeroGivesError(){
        Calculator calc = new Calculator();
        calc.enterDigit('5');
        calc.enterOperator('/');
        calc.enterDigit('0');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "ERR: Division by 0");
    }

    @Test
    public void TestingNonTerminatingDecimal_TenDivideThreeIsThreePointThreeThree(){
        Calculator calc = new Calculator();
        calc.enterDigit('1');
        calc.enterDigit('0');
        calc.enterOperator('/');
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "3.33333=");
    }

    @Test
    public void TestingSingleDecimal_TenDivideThreeIsThreePointThreeThree(){
        Calculator calc = new Calculator();
        calc.enterDigit('1');
        calc.enterDigit('0');
        calc.enterOperator('/');
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "3.33333=");
    }

    @Test
    public void DecimalArith_TenPointThreeAddThreePointThreeThreeIs13Point33(){
        Calculator calc = new Calculator();
        calc.enterDigit('1');
        calc.enterDigit('0');
        calc.enterPoint();
        calc.enterDigit('3');
        calc.enterOperator('+');
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('=');
        assertEquals("13.7=",calc.getDisplayText() );
    }

    @Test
    public void DecimalArith_LatestOperatorTakesPrecedenceNinePlusThreePointFourSubtractTwoIsTenPointFour(){
        Calculator calc = new Calculator();
        calc.enterDigit('9');
        calc.enterOperator('+');
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('-');
        calc.enterDigit('2');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "10.4=");
    }

    @Test
    public void TestingMultipleDigitsAfterDecimal_ThreePointFourFourSubtractPointThreeIsThreePointOneFour(){
        Calculator calc = new Calculator();
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterDigit('4');
        calc.enterOperator('-');
        calc.enterPoint();
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "3.14=");
    }


    @Test
    public void ThreePointFourSubtractPointThreeIsThreePointOne(){
        Calculator calc = new Calculator();
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('-');
        calc.enterPoint();
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "3.1=");
    }

    @Test
    public void TestingMultipleArithmeticOperationsOnDecimalNumbers(){
        Calculator calc = new Calculator();
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('*');
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('-');
        calc.enterPoint();
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "11.26=");
    }

    @Test
    public void CombinedMultipleOperationsOnDecimalAndIntegers(){
        Calculator calc = new Calculator();
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('*');
        calc.enterDigit('3');
        calc.enterPoint();
        calc.enterDigit('4');
        calc.enterOperator('-');
        calc.enterDigit('3');
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "8.56=");
    }

    @Test
    public void FiveChangeSignShouldGiveMinusFive(){
        Calculator calc = new Calculator();
        calc.enterDigit('5');
        calc.changeSign();
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "-5=");
    }

    @Test
    public void FivePointTwoChangeSignShouldGiveMinusFivePointTwo(){
        Calculator calc = new Calculator();
        calc.enterDigit('5');
        calc.enterPoint();
        calc.enterDigit('2');
        calc.changeSign();
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "-5.2=");
    }

    @Test
    public void FiveAddFourChangeSignShouldGiveOne(){
        Calculator calc = new Calculator();
        calc.enterDigit('5');
        calc.enterOperator('+');
        calc.enterDigit('4');
        calc.changeSign();
        calc.enterOperator('=');
        assertEquals(calc.getDisplayText(), "1=");
    }
}