public class Tesla implements Auto{

    private final String version;
    private static final String brand = "Tesla";
    private final String transmissionType;
    private final String driveUnit;
    private final int maxSpeed;
    private final double accelerationTo100;
    private byte numberOfDoors;
    private byte numberOfWheels;
    private byte batteryFull;
    private final double batteryVolume;
    private double clearance;
    private boolean autopilotOn;
    private boolean screenOn;

    public Tesla(String version, String transmissionType, String driveUnit, int maxSpeed,
               byte numberOfDoors, byte numberOfWheels, byte batteryFull, double batteryVolume,
               double clearance,  double accelerationTo100, boolean autopilotOn, boolean screenOn) {
        this.version = version;
        this.transmissionType = transmissionType;
        this.driveUnit = driveUnit;
        this.maxSpeed = maxSpeed;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
        this.batteryFull = batteryFull;
        this.batteryVolume = batteryVolume;
        this.clearance = clearance;
        this.accelerationTo100 = accelerationTo100;
        this.autopilotOn = autopilotOn;
        this.screenOn = screenOn;
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

    public byte getBatteryFull() {
        return batteryFull;
    }

    private void setBatteryFull(byte fuelSupply) {
        this.batteryFull = fuelSupply;
    }

    public double getBatteryVolume() {
        return batteryVolume;
    }

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    public boolean isAutopilotOn() {
        return autopilotOn;
    }

    private void setAutopilotOn(boolean autopilotOn) {
        this.autopilotOn = autopilotOn;
    }

    public boolean isScreenOn() {
        return screenOn;
    }

    private void setScreenOn(boolean screenOn) {
        this.screenOn = screenOn;
    }

    public void workWithAutopilot(boolean onOrOff, String destination){
        if(isAutopilotOn()==onOrOff){
            System.out.println("The autopilot is already in this state");
        }
        else{
            if(!onOrOff){
                setAutopilotOn(false);
                System.out.println("The autopilot in " + getBrand() + " is off, the steering wheel is in your hands!");
            }
            else {
                setAutopilotOn(true);
                System.out.println("The autopilot in " + getBrand() + " is on, you can rest! " +
                        "The path to " + destination + " has been paved.");
            }
        }
    }

    public void workWithScreen(boolean onOrOff, String toWatch){
        if(isScreenOn()==onOrOff){
            System.out.println("The screen is already in this state");
        }
        else{
            if(!onOrOff){
                setScreenOn(false);
                System.out.println("The screen is off, thanks for using!");
            }
            else {
                setScreenOn(true);
                System.out.println( toWatch + ", great choice! Happy viewing!");
            }
        }
    }

    @Override
    public void drive() {
        System.out.printf("\n%s %s is driving.\n", getBrand(), getVersion());
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
        if(percent+ getBatteryFull()>100 || percent<0){
            System.out.println("Please enter another number!");
        }
        else{
            setBatteryFull((byte) (getBatteryFull() + percent));
            System.out.printf("\nThe %s is filled with energies for %s percent. " +
                    "Total in battery %s percent.", getBrand(), percent, getBatteryFull());
        }
    }
}
