
public interface Auto {

    void drive();
    void brake();
    void turn(String direction);
    void openDoors(byte[] doorsArray);
    void openTrunk();
    void replenishStock(byte percent);

    default void startTheAuto(){
        System.out.println("The is started and ready for the trip");
    }
}