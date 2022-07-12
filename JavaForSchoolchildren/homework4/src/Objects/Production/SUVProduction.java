package Objects.Production;

import Interfaces.Production;
import Objects.Auto.SUV;

import java.math.BigInteger;
import java.time.LocalTime;

public class SUVProduction implements Production {

    private static final String typeOfCar = "SUV";
    private final SUV automaticTransmission;
    private final SUV manualTransmission;
    private final int availabilityOfSpareParts;
    private int numberOfSpareParts;
    private boolean workIsGoing;
    private BigInteger amountOfMoney;

    public SUVProduction(SUV auto1, SUV auto2, int availabilityOfSpareParts,
                         int numberOfSpareParts,boolean workIsGoing, BigInteger amountOfMoney) {
        SUV automaticTransmission = null;
        SUV manualTransmission = null;
        if(auto1.getTransmissionType().equals("automatic") &&
                auto2.getTransmissionType().equals("manual")){
            automaticTransmission = auto1;
            manualTransmission = auto2;
        }
        else if(auto2.getTransmissionType().equals("automatic") &&
                auto1.getTransmissionType().equals("manual")){
            automaticTransmission = auto2;
            manualTransmission = auto1;
        }
        this.automaticTransmission = automaticTransmission;
        this.manualTransmission = manualTransmission;
        this.availabilityOfSpareParts = availabilityOfSpareParts;
        this.numberOfSpareParts = numberOfSpareParts;
        this.workIsGoing = workIsGoing;
        this.amountOfMoney = amountOfMoney;
    }

    public String getTypeOfCar(){
        return typeOfCar;
    }

    public int getAvailabilityOfSpareParts() {
        return availabilityOfSpareParts;
    }

    public int getNumberOfSpareParts() {
        return numberOfSpareParts;
    }

    public void setNumberOfSpareParts(int numberOfSpareParts) {
        this.numberOfSpareParts = numberOfSpareParts;
    }

    public boolean isWorkIsGoing() {
        return workIsGoing;
    }

    public void setWorkIsGoing(boolean workIsGoing) {
        this.workIsGoing = workIsGoing;
    }

    public BigInteger getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigInteger amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public void startProduction(LocalTime now) {
        if(now.equals(startTime) && !isWorkIsGoing()){
            setWorkIsGoing(true);
            System.out.println("All fall into place, work on Sedans begins!");
        }
    }

    @Override
    public void finishProduction(LocalTime now) {
        if(now.equals(endTime) && isWorkIsGoing()){
            setWorkIsGoing(false);
            System.out.println("The work is over, good luck everyone. We hope it was a great day!");
        }
    }

    @Override
    public boolean checkAvailabilityOfSpareParts() {
        if(getNumberOfSpareParts() < getAvailabilityOfSpareParts()){
            System.out.println("There are not enough spare parts for SUVs, we need to order them urgently!");
            return  true;
        }
        else{
            System.out.println("Everything is fine, we continue to work!");
            return false;
        }
    }

    @Override
    public void orderSpareParts(int ordered) {
        setNumberOfSpareParts(getNumberOfSpareParts()+ordered);
        System.out.printf("We have ordered %s of spare parts for SUVs. " +
                "Now we have %s of pieces in stock", ordered, getNumberOfSpareParts());
    }

    @Override
    public String toString() {
        return "Our production line includes two BMW SUVs: " +
                "1) " + automaticTransmission.getVersion() + " with automatic transmission" +
                "2) " + manualTransmission.getVersion() + " with manual transmission" +
                "Our working day starts at " + startTime + " and ends at " + endTime + " o'clock";
    }
}
