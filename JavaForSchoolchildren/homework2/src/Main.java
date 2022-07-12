import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Car firstCar = new Car();

        System.out.print("Description of the first car: \nBrand: ");
        Scanner scanner1 = new Scanner(System.in);
        firstCar.setBrand(scanner1.nextLine());

        System.out.print("Motor volume(l): ");
        firstCar.setMotorVolume(scannerProcessing(scanner1));

        System.out.print("Max speed(km/h): ");
        firstCar.setMaxSpeed(scannerProcessing(scanner1));

        System.out.print("Weight(kg): ");
        firstCar.setWeight(scannerProcessing(scanner1));

        System.out.print("Automatic transmission (true or false): ");
        firstCar.setAutomaticTransmission(scanner1.hasNext("true"));

        Car secondCar = new Car();

        System.out.print("\nDescription of the second car: \nBrand: ");
        Scanner scanner2 = new Scanner(System.in);
        secondCar.setBrand(scanner2.nextLine());

        System.out.print("Motor volume(l): ");
        secondCar.setMotorVolume(scannerProcessing(scanner2));

        System.out.print("Max speed(km/h): ");
        secondCar.setMaxSpeed(scannerProcessing(scanner2));

        System.out.print("Weight(kg): ");
        secondCar.setWeight(scannerProcessing(scanner2));

        System.out.print("Automatic transmission (true or false): ");
        secondCar.setAutomaticTransmission(scanner2.hasNext("true"));

        if (!firstCar.equals(secondCar)) {
            System.out.print("\nThese cars are different, but ");

            double comparison = (firstCar.getMotorVolume() / secondCar.getMotorVolume()) *
                    (firstCar.getMaxSpeed() / secondCar.getMaxSpeed());

            if (comparison > 1.05) {
                System.out.print("the characteristics of the first car is better." +
                        "\nTherefore, the race is likely to be won by the first car.");
            }
            else if (comparison < 0.95) {
                System.out.print("the characteristics of the second car is better." +
                        "\nTherefore, the race is likely to be won by the second car.");
            }
            else {
                System.out.print("characteristics are approximately equal." +
                        "\nSo in a race it all depends on the skills of the driver.");
            }
        }
        else {
            System.out.println("\nThese cars are absolutely identical." +
                    "\nIn a race, everything depends only on the skills of the driver.");
        }
    }

    public static double scannerProcessing(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("This is not a valid number, please enter another one: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
