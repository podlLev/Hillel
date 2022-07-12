import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {
    @Test
    public void addNumbersSuccessTest(){
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.add(2,5));
    }

    @Test
    public void addNumbersFailedTest(){
        Calculator calculator = new Calculator();
        assertNotEquals(5, calculator.add(2,2));
    }

    @Test
    public void subtractNumbersSuccessTest(){
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.subtract(10,7));
    }

    @Test
    public void subtractNumbersFailedTest(){
        Calculator calculator = new Calculator();
        assertNotEquals(13, calculator.subtract(21,7));
    }

    @Test
    public void multiplyNumbersSuccessTest(){
        Calculator calculator = new Calculator();
        assertEquals(49, calculator.multiply(7,7));
    }

    @Test
    public void multiplyNumbersFailedTest(){
        Calculator calculator = new Calculator();
        assertNotEquals(46, calculator.multiply(7,6));
    }

    @Test
    public void divideNumbersSuccessTest(){
        Calculator calculator = new Calculator();
        assertEquals(9, calculator.divide(81,9));
    }

    @Test
    public void divideNumbersFailedTest(){
        Calculator calculator = new Calculator();
        assertNotEquals(8, calculator.divide(45,5));
    }

    @Test
    public void combinationOfActionsSuccessTest(){
        Calculator calculator = new Calculator();
        assertEquals(182, calculator.multiply(
                calculator.divide(21,3),
                calculator.subtract(33,7)));
    }

    @Test
    public void combinationOfActionsFailedTest(){
        Calculator calculator = new Calculator();
        assertNotEquals(8, calculator.add(2, calculator.multiply(2,2)));
    }

}
