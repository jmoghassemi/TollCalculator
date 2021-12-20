import main.MotorBike;
import main.Vehicle;
import main.Car;
import main.TollCalculator;


import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        TollCalculator tollCalculatorObj = new TollCalculator();

        MotorBike mB = new MotorBike();
        Car car = new Car();


        /*  Test Section of The Program:
            Six Test-Cases are considered: 3 for a Car object driving during: 1) Rush-hr, 2) Not Rush-hr, 3) Weekend
                                           3 for a MotorBike object driving during: 1) Rush-hr, 2) Not Rush-hr, 3) Weekend

            Six LocalDateTime objects are created accordingly: 3 for the Car object
                                                               3 for the MotorBike object
         */

        //Same month(Nov) Same day(25) w/ Rush-hr: 8:30(morning rush-hr), 8:50(morning rush-hr), 9:10, 9:20, 9:30, 9:50
        LocalDateTime[] LDT1 = {LocalDateTime.of(2021, 11, 25, 8, 30), LocalDateTime.of(2021, 11, 25, 8, 50)
                , LocalDateTime.of(2021, 11, 25, 9, 10), LocalDateTime.of(2021, 11, 25, 9, 20),
                LocalDateTime.of(2021, 11, 25, 9, 30), LocalDateTime.of(2021, 11, 25, 9, 50)};

        //Same month(Nov) Same day(26) w/o Rush-hr: 13:15, 14:15, 15:00, 17:48, 19:50
        LocalDateTime[] LDT2 = {LocalDateTime.of(2021, 11, 26, 13, 15), LocalDateTime.of(2021, 11, 26, 14, 15),
                LocalDateTime.of(2021, 11, 26, 15, 00), LocalDateTime.of(2021, 11, 26, 17, 48),
                LocalDateTime.of(2021, 11, 26, 19, 50)};

        //Same month(Nov) Same day(27) during Weekend: 10:00, 13:00, 16:10
        LocalDateTime[] LDT3 = {LocalDateTime.of(2021, 11, 27, 10, 00), LocalDateTime.of(2021,11,27,13, 00),
                LocalDateTime.of(2021, 11, 27, 16, 10)};

        int firstCalculatedFee = tollCalculatorObj.getTollFee(car, LDT1);
        int expected1 = 18 + 18 + 11 + 11 + 11 + 11;
        System.out.println("Toll fee calculated by program= " + firstCalculatedFee);
        System.out.println("Expected output= " + expected1 + "\n");

        int secondCalculatedFee = tollCalculatorObj.getTollFee(car, LDT2);
        int expected2 = 11 + 11 + 11 + 11 + 11;
        System.out.println("Toll fee calculated by program= " + secondCalculatedFee);
        System.out.println("Expected output= " + expected2 + "\n");

        int thirdCalculatedFee = tollCalculatorObj.getTollFee(car, LDT3);
        int expected3 = 0 + 0 + 0;
        System.out.println("Toll fee calculated by program= " + thirdCalculatedFee);
        System.out.println("Expected output= " + expected3 + "\n");

        //Same month(Dec) Same day(23) w/ Rush-hr: 8:30(morning rush-hr), 10:10, 14:20, 16:15(evening rush-hr), 20:00
        LocalDateTime[] LDT4 = {LocalDateTime.of(2021, 12, 23, 8, 30), LocalDateTime.of(2021, 12, 23, 10, 10)
                , LocalDateTime.of(2021, 12, 23, 14, 20), LocalDateTime.of(2021, 12, 23, 16, 15),
                LocalDateTime.of(2021, 12, 23, 20, 20)};

        //Same month(Dec) Same day(24) w/o Rush-hr: 13:15, 14:15, 15:00, 17:48, 19:50
        LocalDateTime[] LDT5 = {LocalDateTime.of(2021, 12, 24, 13, 15), LocalDateTime.of(2021,12,24,14,15),
                LocalDateTime.of(2021, 12, 24, 15, 00), LocalDateTime.of(2021,12,24,17,48),
                LocalDateTime.of(2021,12,24, 19, 50)};

        //Same month(Dec) Same day(26) w/ Rush-hr during Weekend: 8:30, 10:00, 13:00, 16:10
        LocalDateTime[] LDT6 = {LocalDateTime.of(2021,12,26,8,30), LocalDateTime.of(2021, 12, 26, 10, 00),
                LocalDateTime.of(2021,12,26,13, 00),
                LocalDateTime.of(2021, 12, 26, 16, 10)};

        int fourthCalculatedFee = tollCalculatorObj.getTollFee(mB, LDT4);
        int expected4 = 18 + 8 + 8 + 18 + 8;
        System.out.println("Toll fee calculated by program=" + fourthCalculatedFee);
        System.out.println("Expected output= " + expected4 + "\n");

        int fifthCalculatedFee = tollCalculatorObj.getTollFee(mB, LDT5);
        int expected5 = 8 + 8 + 8 + 8 + 8;
        System.out.println("Toll fee calculated by program=" + fifthCalculatedFee);
        System.out.println("Expected output= " + expected5 + "\n");

        int sixthCalculatedFee = tollCalculatorObj.getTollFee(mB, LDT6);
        int expected6 = 0 + 0 + 0 + 0;
        System.out.println("Toll fee calculated by program=" + sixthCalculatedFee);
        System.out.println("Expected output= " + expected6 + "\n");
    }
}





