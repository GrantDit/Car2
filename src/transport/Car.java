package transport;

import java.util.Objects;

public class Car extends Transport {
    private final String bodyType;
    private final int places;
    private final Key key;
    private double engineVolume;
    private String transmission;
    private String carNumber;
    private boolean tires;

    public Car() {
        super("","",0,"","",0);
        engineVolume = 1.5;
        transmission = "Механика";
        bodyType = "Седан";
        carNumber = "x000xx000";
        places = 5;
        tires = false;
        key = new Key();
    }

    public Car(String brand, String model, int year, String country, String color, int maximumSpeed, double engineVolume, String transmission, String bodyType, String carNumber, int places, boolean tires, Key key) {
        super(brand, model, year, country, color, maximumSpeed);
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (transmission == null || transmission.isEmpty() || transmission.isBlank()) {
            this.transmission = "Механика";
        } else {
            this.transmission = transmission;
        }
        if (bodyType == null || bodyType.isEmpty() || bodyType.isBlank()) {
            this.bodyType = "Седан";
        } else {
            this.bodyType = bodyType;
        }
        if (carNumber == null || carNumber.isEmpty() || carNumber.isBlank()) {
            this.carNumber = "x000xx000";
        } else {
            this.carNumber = carNumber;
        }
        if (places < 2 || places > 9) {
            throw new IndexOutOfBoundsException("от 2 до 9 включая водилу");
        } else {
            this.places = places;
        }
        this.tires = tires;
        this.key = new Key(key.remoteStartEngine, key.keylessAccess);
    }

    public Key getKey() {
        return key;
    }

    public boolean isTires() {
        return tires;
    }

    public void setTires(boolean tires) {
        this.tires = tires;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getPlaces() {
        return places;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission == null || transmission.isEmpty() || transmission.isBlank()) {
            this.transmission = "Механика";
        } else {
            this.transmission = transmission;
        }
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        if (carNumber == null || carNumber.isEmpty() || carNumber.isBlank()) {
            this.carNumber = "x000xx000";
        } else {
            this.carNumber = carNumber;
        }
    }

    public void changeTires(int currentMonth) {
        this.tires = currentMonth >= 11 || currentMonth <= 4;
    }
    public boolean Number() {
        //x000xx000
        if (carNumber.length() != 9) {
            return false;
        }
        char[] chars = carNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) &&
                Character.isDigit(chars[6]) && Character.isDigit(chars[7]) &&
                Character.isDigit(chars[8]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return places == car.places && Double.compare(car.engineVolume, engineVolume) == 0 && tires == car.tires && Objects.equals(bodyType, car.bodyType) && Objects.equals(key, car.key) && Objects.equals(transmission, car.transmission) && Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType, places, key, engineVolume, transmission, carNumber, tires);
    }

    public String toString() {

        return " Марка автомобиля: " + getBrand() + ",модель автомобиля: " + getModel() + String.format("объем двигателя: %.1f л." ,engineVolume)+ ",цвет кузова: " + getColor() +", максимальная скорость: "+ getMaximumSpeed() + " км/ч " + ",год производства: " + getYear() + ",страна производства: " + getCountry() + ", коробка передач: " + transmission + ", тип кузова: " + bodyType + ", регистрационный номер: " + carNumber + ", количество мест: " + places + ", " +
                (isTires() ? " зимняя резина" : " летняя резина, ") + (getKey().isKeylessAccess() ? "Бесключевой доступ" : "доступ с ключем ") + ", " + (getKey().isRemoteStartEngine() ? "Дистанционный запуск" : "Класический запуск.");
    }

    public static class Key {
        private final boolean remoteStartEngine;
        private final boolean keylessAccess;

        public Key(boolean remoteStartEngine, boolean keylessAccess) {
            this.remoteStartEngine = remoteStartEngine;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteStartEngine() {
            return remoteStartEngine;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return remoteStartEngine == key.remoteStartEngine && keylessAccess == key.keylessAccess;
        }

        @Override
        public int hashCode() {
            return Objects.hash(remoteStartEngine, keylessAccess);
        }
    }
}


