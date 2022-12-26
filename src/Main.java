
import transport.Bus;
import transport.Car;

import java.time.LocalDate;

public class Main {
    private static final int CURRENT_MONTH = LocalDate.now().getMonthValue();
    public static void main(String[] args) {
        Car ladaGranta = new Car("Lada", "Granta", 2015, "Russia",
                "yellow", 180, 1.7, "M", "sedan",
                "в217тр023", 5, true, new Car.Key());
        Car audiA8 = new Car("Audi", "A8 50L TDI quattro", 2020, "Germany",
                "black", 250, 3.0, "A", "sedan",
                "а341вв199", 4, true, new Car.Key(true,
                true));
        Car bmwZ8 = new Car("BMW", "Z8", 2021, "Germany", "black",
                240, 3.0, "M", "cabriolet", "е810вр178",
                2, false, new Car.Key());
        Car kiaSportage = new Car("Kia", "Sportage 4th generation", 2018,
                "South Korea", "red", 225, 2.4, "A",
                "suv", "у435тл150", 5, true,
                new Car.Key(true, true));
        Car hyundaiAvante = new Car("Hyundai", "Avante", 2016, "South Korea",
                "orange", 196, 1.6, "A", "sedan",
                "р821ат152", 5, true, new Car.Key());

        System.out.println(ladaGranta);
        System.out.println(audiA8);
        System.out.println(bmwZ8);
        bmwZ8.changeTires(CURRENT_MONTH);
        System.out.println(bmwZ8);
        System.out.println(kiaSportage);
        System.out.println(hyundaiAvante);

//        Task 2
        System.out.println();

        Bus man = new Bus("Man", "Lion's Coach", 2016, "Germany",
                "white", 138);
        Bus mercerdes = new Bus("Mercedes-Benz", "Travego RHD 15 RHD", 2018,
                "Germany", "blue", 150);
        Bus scania = new Bus("Scania", "Touring 6X2", 2021, "Sweden",
                "black", 142);

        System.out.println(man);
        System.out.println(mercerdes);
        System.out.println(scania);
    }
}