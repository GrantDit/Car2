package transport;

public class Bus extends Transport{
    public Bus() {
        super("По умолчанию", "По умолчанию", 0, "По умолчанию", "По умолчанию", 0);
    }
    public Bus(String model, String brand, int year, String country, String color, int maximumSpeed) {
        super(model, brand, year, country, color, maximumSpeed);
    }

    @Override
    public String toString() {
        return "Марка автомобиля: " + getBrand() + ", " + ",модель автомобиля:  " + getModel() + ", " + ",год производства: " + getYear() + ", " +
                ",страна производства:" + getCountry() + ", " + ",цвет кузова:: " + getColor() + ", " +
                "Максимальная скорость: " + getMaximumSpeed() + " км/ч";
    }
}
