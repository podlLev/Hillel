package Interfaces;

import Objects.Production.SUVProduction;
import Objects.Production.SedanProduction;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Factory {
    LocalTime startTime = LocalTime.parse("8h00");
    LocalTime endTime = LocalTime.parse("18h00");

    void startWork(LocalTime now);
    void finishWork(LocalTime now);
    void checkProductions(SUVProduction suvProduction, SedanProduction sedanProduction);
    void issueSalary();
    void celebrateFactoryBirthday(LocalDate now);
    void hireEmployee();
    void fireEmployee();

    default void checkFactoryProgress(int planProgress, int progress){
        if(planProgress <= progress){
            System.out.println("We are doing great!");
        }
        else{
            System.out.println("We need to push!");
        }
    }
}
