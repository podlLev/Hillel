package Objects;

import Interfaces.Factory;
import Objects.Production.SUVProduction;
import Objects.Production.SedanProduction;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class BMWFactory implements Factory {

    private static final String brand = "BMW";
    private final SUVProduction suvProduction;
    private final SedanProduction sedanProduction;
    private long numberOfWorkers;
    private final BigInteger productionSalary;
    private BigInteger amountOfMoney;
    private final LocalDate dateOfBirthday;
    private boolean workIsGoing;

    public BMWFactory(SUVProduction production1, SedanProduction production2,
                      long numberOfWorkers, BigInteger productionSalary,
                      BigInteger amountOfMoney, LocalDate dateOfBirthday, boolean workIsGoing) {
        this.suvProduction = production1;
        this.sedanProduction = production2;
        this.numberOfWorkers = numberOfWorkers;
        this.productionSalary = productionSalary;
        this.amountOfMoney = amountOfMoney;
        this.dateOfBirthday = dateOfBirthday;
        this.workIsGoing = workIsGoing;
    }

    public String getBrand(){
        return brand;
    }

    public long getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(long numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public BigInteger getProductionSalary() {
        return productionSalary;
    }

    public BigInteger getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigInteger amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public boolean isWorkIsGoing() {
        return workIsGoing;
    }

    public void setWorkIsGoing(boolean workIsGoing) {
        this.workIsGoing = workIsGoing;
    }

    @Override
    public void startWork(LocalTime now) {
        if(now.equals(startTime) && !isWorkIsGoing()){
            setWorkIsGoing(true);
            System.out.println("All fall into place, factory work begins!");
        }
    }

    @Override
    public void finishWork(LocalTime now) {
        if(now.equals(endTime) && isWorkIsGoing()){
            setWorkIsGoing(false);
            System.out.println("The factory work is over, good luck everyone. We hope it was a great day!");
        }
    }

    @Override
    public void checkProductions(SUVProduction suvProduction, SedanProduction sedanProduction) {
        if(suvProduction.checkAvailabilityOfSpareParts()){
            suvProduction.orderSpareParts(suvProduction.getAvailabilityOfSpareParts()- suvProduction.getNumberOfSpareParts());
            System.out.printf("The necessary spare parts for the %s factory were ordered",
                    suvProduction.getTypeOfCar());
        }
        else{
            System.out.printf("Everything is fine at the %s factory",
                    suvProduction.getTypeOfCar());
        }
        if(sedanProduction.checkAvailabilityOfSpareParts()){
            sedanProduction.orderSpareParts(sedanProduction.getAvailabilityOfSpareParts()- sedanProduction.getNumberOfSpareParts());
            System.out.printf("The necessary spare parts for the %s factory were ordered",
                    sedanProduction.getTypeOfCar());
        }
        else{
            System.out.printf("Everything is fine at the %s factory",
                    sedanProduction.getTypeOfCar());
        }
    }

    @Override
    public void issueSalary() {
        if(getAmountOfMoney().equals(getProductionSalary().multiply(BigInteger.TWO))){
            suvProduction.setAmountOfMoney(suvProduction.getAmountOfMoney().add(getProductionSalary()));
            sedanProduction.setAmountOfMoney(sedanProduction.getAmountOfMoney().add(getProductionSalary()));
            setAmountOfMoney(getAmountOfMoney().subtract(getProductionSalary().multiply(BigInteger.TWO)));
            System.out.println("Productions were given a salary of $ " + getProductionSalary());
        }
        else{
            System.out.println("Sorry, not enough funds. Salary will be issued later");
        }
    }

    @Override
    public void celebrateFactoryBirthday(LocalDate now) {
        if(now.equals(getDateOfBirthday())){
            System.out.println("Today is the birthday of the plant. We all celebrate together!");
        }
        else{
            System.out.println("Unfortunately, you will have to wait a little longer until factory birthday.");
        }
    }

    @Override
    public void hireEmployee() {
        setNumberOfWorkers(getNumberOfWorkers() + 1);
    }

    @Override
    public void fireEmployee() {
        setNumberOfWorkers(getNumberOfWorkers() - 1);
    }

    @Override
    public String toString() {
        return "Our factory produces " + getBrand() +  " cars and has two production facilities:" +
                "1) " + suvProduction.getTypeOfCar() + " production" +
                "2) " + sedanProduction.getTypeOfCar() + " production" +
                "(you can find out in more detail about them if you refer directly to the necessary)" +
                "At the moment we have " + getNumberOfWorkers() + " workers and our company continues to grow" +
                "Every day we start working at " + startTime + " and finish at " + endTime +
                "You can come to the birthday of our company which will take place on " + dateOfBirthday;
    }
}
