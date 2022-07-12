package Objects.Auto;

import Interfaces.Auto;

public class SUV implements Auto {

    private final String version;
    private static final String brand = "BMW";
    private static final String typeOfCar = "SUV";
    private final String transmissionType;
    private final String driveUnit;
    private final int maxSpeed;
    private byte numberOfDoors;
    private byte numberOfWheels;
    private byte fuelSupply;
    private final double fuelTankVolume;
    private double tireWidth;
    private double clearance;
    private double suspensionElasticity;

    public SUV(String version, String transmissionType, String driveUnit, int maxSpeed,
               byte numberOfDoors, byte numberOfWheels, byte fuelSupply, double fuelTankVolume,
               double tireWidth, double clearance, double suspensionElasticity) {
        this.version = version;
        this.transmissionType = transmissionType;
        this.driveUnit = driveUnit;
        this.maxSpeed = maxSpeed;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
        this.fuelSupply = fuelSupply;
        this.fuelTankVolume = fuelTankVolume;
        this.tireWidth = tireWidth;
        this.clearance = clearance;
        this.suspensionElasticity = suspensionElasticity;
    }

    public String getVersion() {
        return version;
    }

    public String getBrand() {
        return brand;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public String getDriveUnit() {
        return driveUnit;
    }

    public byte getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(byte numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public byte getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(byte numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public byte getFuelSupply() {
        return fuelSupply;
    }

    public void setFuelSupply(byte fuelSupply) {
        this.fuelSupply = fuelSupply;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public double getTireWidth() {
        return tireWidth;
    }

    public void setTireWidth(double tireWidth) {
        this.tireWidth = tireWidth;
    }

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    public double getSuspensionElasticity() {
        return suspensionElasticity;
    }

    public void setSuspensionElasticity(double suspensionElasticity) {
        this.suspensionElasticity = suspensionElasticity;
    }

    @Override
    public void drive() {
        System.out.printf("SUV %s is driving", getVersion());
    }

    @Override
    public void brake() {
        System.out.println("SUV is braking");
    }

    @Override
    public void turn(String direction) {
        System.out.println("SUV is turning on " + direction);
    }

    @Override
    public void openDoors(byte[] doorsArray) {
        for (int i = 0; i < doorsArray.length; i++) {
            if (doorsArray[i] < getNumberOfDoors() && doorsArray[i] > 0) {
                System.out.printf("SUV's door under number %s opened", i);
            }
        }
    }

    @Override
    public void openTrunk() {
        System.out.println("SUV's trunk opened");
    }

    @Override
    public void refuel(byte liters) {
        setFuelSupply((byte) (getFuelSupply() + liters));
        System.out.printf("The SUV is filled with fuel for %s liters. " +
                "Total in tank %s liters", liters, getFuelSupply());
    }
}