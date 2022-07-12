import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to us!\n");
        System.out.println("""
                Calculator rules:
                1) If you want to use an intermediate number that remained after solving the previous example, insert r instead
                2) If you want to see the result, enter = at the end of the example
                """);
        BigDecimal intermediateResult = BigDecimal.ZERO;
        BigDecimal result = BigDecimal.ZERO;
        boolean haveResult = false;

        while (!haveResult) {
            System.out.println("Please enter your example: ");
            String calculation;
            calculation = setString(intermediateResult);


            String[] charArray = calculation.split("");
            Character[] characterArray = toCharacterArray(charArray);

            String[] numArray = calculation.split("[+/*=-]");
            BigDecimal[] numberArray = toNumberArray(numArray);

            intermediateResult = BigDecimal.ZERO;

            for (int i = 0;i < numberArray.length - 1; i++) {

                switch (characterArray[i]) {
                    case '+' -> {
                        if (i < characterArray.length - 1) {
                            checkNextCharacter(numberArray, characterArray, i);
                        }
                        intermediateResult = intermediateResult.add(numberArray[i].add(numberArray[i + 1]));
                        numberArray[i + 1] = BigDecimal.ZERO;
                        numberArray[i] = BigDecimal.ZERO;
                    }
                    case '-' -> {
                        if (i < characterArray.length - 1) {
                            checkNextCharacter(numberArray, characterArray, i);
                        }
                        intermediateResult = intermediateResult.subtract(numberArray[i + 1].subtract(numberArray[i]));
                        numberArray[i + 1] = BigDecimal.ZERO;
                        numberArray[i] = BigDecimal.ZERO;
                    }
                    case '*' -> {
                        numberArray[i + 1] = numberArray[i].multiply(numberArray[i + 1]);
                        numberArray[i] = BigDecimal.ZERO;
                        characterArray[i] = '+';

                        if (i < characterArray.length - 1) {
                            checkNextCharacter(numberArray, characterArray, i);
                        }
                        intermediateResult = numberArray[i+1];
                        numberArray[i+1] = BigDecimal.ZERO;
                    }
                    case '/' -> {
                        checkZero(String.valueOf(numberArray[i+1]));

                        numberArray[i + 1] = numberArray[i].divide(numberArray[i + 1], 5, RoundingMode.HALF_UP);
                        numberArray[i] = BigDecimal.ZERO;
                        characterArray[i] = '+';

                        if (i < characterArray.length - 1) {
                            checkNextCharacter(numberArray, characterArray, i);
                        }
                        intermediateResult = numberArray[i+1];
                        numberArray[i+1] = BigDecimal.ZERO;
                    }
                    case '=' -> {
                        result = intermediateResult;
                        haveResult = true;
                    }
                }
            }
            System.out.println("\nIntermediate number saved...");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        String resultString = decimalFormat.format(result);
        System.out.println("\nDecision result is " + resultString);
    }

    public static String setString(BigDecimal intermediateResult) {
        Scanner scanner = new Scanner(System.in);
        String calculation = scanner.nextLine();

        calculation = calculation.replaceAll("[rR]", String.valueOf(intermediateResult));
        calculation = calculation.replaceAll(",", ".");
        calculation = calculation.replaceAll("[^0-9rR+/*=.-]", "");
        calculation = calculation.replaceAll("\\s+", "");

        if(calculation.matches("(.*)=(.*)")){
            int a = calculation.indexOf('=');
            StringBuilder delete = new StringBuilder(calculation);
            delete.delete(a+1, calculation.length());
            calculation = new String(delete);
        }

        char[] characters = new char[]{'=', '+', '-', '/', '*'};
        for (char character : characters) {
            if (calculation.endsWith(String.valueOf(character))) {
                StringBuilder add = new StringBuilder(calculation);
                calculation = new String(add.append('0'));
                break;
            }
        }
        return calculation;
    }

    public static BigDecimal[] toNumberArray(String[] numArray) {
        BigDecimal[] numberArray = new BigDecimal[0];
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i].matches("(.*)[0-9](.*)")) {
                numberArray = addOneToNumArray(numberArray);
                numberArray[i] = new BigDecimal(numArray[i]);
            }
            else if (Objects.equals(numArray[i], "") || Objects.equals(numArray[i], ".")) {
                numberArray = addOneToNumArray(numberArray);
                numberArray[i] = BigDecimal.ZERO;
            }
        }
        return numberArray;
    }

    public static Character[] toCharacterArray(String[] charArray) {
        Character[] characterArray = new Character[0];
        int step = 0;

        for (String character : charArray) {
            if (character.matches("(.*)[+*/=-](.*)")) {
                characterArray = addOneToCharArray(characterArray);
                characterArray[step] = character.charAt(0);
                step++;
            }
        }
        return characterArray;
    }


    public static void checkNextCharacter(BigDecimal[] numberArray, Character[] characterArray, int i) {
        switch (characterArray[i + 1]) {
            case '*' -> {
                numberArray[i + 2] = numberArray[i + 1].multiply(numberArray[i + 2]);
                numberArray[i + 1] = BigDecimal.ZERO;

                switch (characterArray[i]) {
                    case '+' -> characterArray[i + 1] = '+';
                    case '-' -> characterArray[i + 1] = '-';
                }
                if (characterArray[i].equals('*') || characterArray[i].equals('/')) {
                    checkNextCharacter(numberArray, characterArray, i++);
                }
            }
            case '/' -> {
                checkZero(String.valueOf(numberArray[i+2]));

                numberArray[i + 2] = numberArray[i + 1].divide(numberArray[i + 2], 5, RoundingMode.HALF_UP);
                numberArray[i + 1] = BigDecimal.ZERO;

                switch (characterArray[i]) {
                    case '+' -> characterArray[i + 1] = '+';
                    case '-' -> characterArray[i + 1] = '-';
                }
                if (characterArray[i].equals('*') || characterArray[i].equals('/')) {
                    checkNextCharacter(numberArray, characterArray, i++);
                }
            }
        }
    }

    public static BigDecimal[] addOneToNumArray(BigDecimal[] array) {
        return Arrays.copyOf(array, array.length + 1);
    }

    public static Character[] addOneToCharArray(Character[] array) {
        return Arrays.copyOf(array, array.length + 1);
    }

    public static void checkZero(String checkingNumber){
        if(checkingNumber.startsWith("0")){
            System.out.println("\nIt is forbidden to divide by zero, the example doesn't make sense\n");
            System.exit(0);
        }
    }
}
