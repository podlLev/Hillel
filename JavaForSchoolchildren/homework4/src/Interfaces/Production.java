package Interfaces;

import java.time.LocalTime;

public interface Production {
    LocalTime startTime = LocalTime.parse("8h00");
    LocalTime endTime = LocalTime.parse("16h00");

    void startProduction(LocalTime now);
    void finishProduction(LocalTime now);
    boolean checkAvailabilityOfSpareParts();
    void orderSpareParts(int ordered);

    default void checkProductionProgress(int planProgress, int progress){
        if(planProgress <= progress){
            System.out.println("We are doing great!");
        }
        else{
            System.out.println("We need to push!");
        }
    }
}