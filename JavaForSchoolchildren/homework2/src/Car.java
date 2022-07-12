import java.util.Objects;

public class Car {

    private String brand;
    private double motorVolume;
    private double maxSpeed;
    private double weight;
    private boolean automaticTransmission;

    public Car(String brand, double motorVolume, double maxSpeed,
               double weight, boolean automaticTransmission) {
        this.brand = brand;
        this.motorVolume = motorVolume;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.automaticTransmission = automaticTransmission;
    }
    public Car() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getMotorVolume() {
        return motorVolume;
    }

    public void setMotorVolume(double motorVolume) {
        if (motorVolume < 0) {
            motorVolume *= -1;
        }
        this.motorVolume = motorVolume;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        if (maxSpeed < 0) {
            maxSpeed *= -1;
        }
        this.maxSpeed = maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            weight *= -1;
        }
        this.weight = weight;
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    public void setAutomaticTransmission(boolean automaticTransmission) {
        this.automaticTransmission = automaticTransmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.motorVolume, motorVolume) == 0 &&
                Double.compare(car.maxSpeed, maxSpeed) == 0 &&
                Double.compare(car.weight, weight) == 0 &&
                automaticTransmission == car.automaticTransmission &&
                Objects.equals(brand, car.brand);
    }
}
