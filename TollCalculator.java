package main;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TollCalculator {
    public static int getTollFee(Vehicle vehicle, LocalDateTime[] dates) {
        //Declaring and initializing totalFee, which is the variable that stores the total amount of toll tax for each vehicle
        int totalFee = 0;

        // Declaring and initializing the variables that indicate when the morning rush hour starts & ends, the evening rush hour starts & ends
        LocalTime morningRushHourStart = LocalTime.of(8, 00);
        LocalTime morningRushHourEnd = LocalTime.of(9, 00);
        LocalTime eveningRushHourStart = LocalTime.of(16, 00);
        LocalTime eveningRushHourEnd = LocalTime.of(17, 00);

        // Using a for-loop that loops through all the LocalDateTime objects that are passed as input. Calculating the totalFee for each input. Returning totalFee when the loop is completed.
        for (LocalDateTime date : dates) {
            //Storing the day value of the LCD object to determine whether that day is a weekend or not, later on.
            DayOfWeek dayOfDate = date.getDayOfWeek();

            // Converting LCD input to Local Time object to determine whether the vehicle has passed the camera during rush hour periods, or not.
            LocalTime timeOfDate = date.toLocalTime();

            // Determining whether the vehicle has driven during morning or evening rush hour periods.
            boolean drivingDuringMorningRushHour = timeOfDate.isAfter(morningRushHourStart) && timeOfDate.isBefore(morningRushHourEnd);
            boolean drivingDuringEveningRushHour = timeOfDate.isAfter(eveningRushHourStart) && timeOfDate.isBefore(eveningRushHourEnd);

            // Using the value of dayOfDate to determine if it is a weekend, or not.
            if (dayOfDate == DayOfWeek.SATURDAY || dayOfDate == DayOfWeek.SUNDAY) {
                totalFee += 0;
                System.out.println("It is weekend. No charges apply.");
            }
            // Checking if it is a rush hour period, or not.
            else if (drivingDuringMorningRushHour || drivingDuringEveningRushHour) {
                totalFee += 18;
            }
            // Calling the getFee method of the Vehicle Interface and accumulating all the fees in totalFee.
            else {
                totalFee += vehicle.getFee();
            }
        }
        // for-loop is completed. Returning totalFee
        return totalFee;
    }
}







