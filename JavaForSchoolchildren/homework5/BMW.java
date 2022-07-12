public class BMW implements Auto{

    private final String version;
    private static final String brand = "BMW";
    private final String transmissionType;
    private final String driveUnit;
    private final int maxSpeed;
    private final double accelerationTo100;
    private byte numberOfDoors;
    private byte numberOfWheels;
    private byte tankFull;
    private final double fuelTankVolume;
    private double clearance;
    private boolean speedCutterOn;
    private boolean climateControlOn;

    public BMW(String version, String transmissionType, String driveUnit, int maxSpeed,
                 byte numberOfDoors, byte numberOfWheels, byte tankFull, double fuelTankVolume,
                 double clearance, double accelerationTo100, boolean speedCutterOn, boolean climateControlOn) {
        this.version = version;
        this.transmissionType = transmissionType;
        this.driveUnit = driveUnit;
        this.maxSpeed = maxSpeed;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
        this.tankFull = tankFull;
        this.fuelTankVolume = fuelTankVolume;
        this.clearance = clearance;
        this.accelerationTo100 = accelerationTo100;
        this.speedCutterOn = speedCutterOn;
        this.climateControlOn = climateControlOn;
    }

    public String getVersion() {
        return version;
    }

    public String getBrand() {
        return brand;
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

    public double getAccelerationTo100() {
        return accelerationTo100;
    }

    public byte getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(byte numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public byte getTankFull() {
        return tankFull;
    }

    private void setTankFull(byte fuelSupply) {
        this.tankFull = fuelSupply;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    public boolean isSpeedCutterOn() {
        return speedCutterOn;
    }

    private void setSpeedCutterOn(boolean speedCutterOn) {
        this.speedCutterOn = speedCutterOn;
    }

    public boolean isClimateControlOn() {
        return climateControlOn;
    }

    private void setClimateControlOn(boolean climateControlOn) {
        this.climateControlOn = climateControlOn;
    }

    public void workWithSpeedCutter(boolean onOrOff){
        if(isSpeedCutterOn()==onOrOff){
            System.out.println("The speed limiter is already in this state.");
        }
        else{
            if(!onOrOff){
                setSpeedCutterOn(false);
                System.out.println("Speed limiter in " + getBrand() + " removed!");
            }
            else {
                setSpeedCutterOn(true);
                System.out.println("Speed limiter in " + getBrand() + " included!");
            }
        }
    }

    public void workWithClimateControl(boolean onOrOff){
        if(isClimateControlOn()==onOrOff){
            System.out.println("The climate control is already in this state.");
        }
        else{
            if(!onOrOff){
                setClimateControlOn(false);
                System.out.println("Climate control in " + getBrand() + " off!");
            }
            else {
                setClimateControlOn(true);
                System.out.println("Climate control in " + getBrand() + " is on, have a nice trip!\n");
            }
        }
    }

    @Override
    public void drive() {
        System.out.printf("\n%s %s is driving.", getBrand(), getVersion());
    }

    @Override
    public void brake() {
        System.out.println( getBrand() + " is braking.");
    }

    @Override
    public void turn(String direction) {
        System.out.println( getBrand() + " is turning on " + direction);
    }

    @Override
    public void openDoors(byte[] doorsArray) {
        for (int i = 0; i < doorsArray.length; i++) {
            if (doorsArray[i] < getNumberOfDoors() && doorsArray[i] > 0) {
                System.out.printf( getBrand() + "'s door under number %s opened.", i);
            }
        }
    }

    @Override
    public void openTrunk() {
        System.out.println( getBrand() + "'s trunk opened.");
    }

    @Override
    public void replenishStock(byte percent) {
        if(percent+ getTankFull()>100 || percent<0){
            System.out.println("Please enter another number!");
        }
        else{
        setTankFull((byte) (getTankFull() + percent));
        System.out.printf("\nThe %s is filled with fuel for %s percent. " +
                "Total in tank %s percent.", getBrand(), percent, getTankFull());
        }
    }
}
