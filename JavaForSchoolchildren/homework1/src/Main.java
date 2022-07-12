import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("We have no limitations in calculations, so be careful with your desires)");
        System.out.println("\nFractional numbers will be rounded, but if you want, please use a comma(,)");
        System.out.print("Your number: ");

        Scanner inputNumber = new Scanner(System.in);

        while (!inputNumber.hasNextBigDecimal()) {
            System.out.print("Please enter a number: ");
            inputNumber.next();
        }

        BigDecimal toBigInteger = inputNumber.nextBigDecimal();
        BigDecimal help = new BigDecimal("5.5");

        while (toBigInteger.compareTo(help) <= 0) {
            System.out.print("\nWhy do you need such a small number? \nEnter more: ");
            toBigInteger = inputNumber.nextBigDecimal().setScale(0, RoundingMode.HALF_UP);
        }

        toBigInteger = toBigInteger.setScale(0, RoundingMode.HALF_UP);

        BigInteger factorial = toBigInteger.toBigInteger();
        BigInteger result = factorial;
        result = calculatingFactorial(factorial, result);

        System.out.printf("\nThe factorial of %s is %s ", factorial, result);
    }

    public static BigInteger calculatingFactorial(BigInteger factorial, BigInteger result) {

        if (factorial.compareTo(BigInteger.ONE.add(BigInteger.ONE)) <= -1) {
            return result;
        }
        factorial = factorial.subtract(BigInteger.ONE);
        result = result.multiply(factorial);

        return calculatingFactorial(factorial, result);
    }
}
