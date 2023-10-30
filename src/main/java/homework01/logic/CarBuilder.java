package homework01.logic;

public class CarBuilder {
    private static CarBuilder carBuilder;
    private Car car;

    private CarBuilder() {
    }

    public static CarBuilder getInstance() {
        if (carBuilder == null) {
            carBuilder = new CarBuilder();
        }
        carBuilder.car = new Car();
        return carBuilder;
    }

    public CarBuilder setModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder setManufacturer(String manufacturer) {
        car.setManufacturer(manufacturer);
        return this;
    }

    public CarBuilder setVin(int vin) {
        car.setVin(vin);
        return this;
    }

    public CarBuilder setYear(int year) {
        car.setYear(year);
        return this;
    }

    public CarBuilder setColor(String color) {
        car.setColor(color);
        return this;
    }

    public CarBuilder setEngine(EngineType engine) {
        car.setEngine(engine);
        return this;
    }

    public CarBuilder setHorsePower(int horsepower) {
        car.setHorsePower(horsepower);
        return this;
    }

    public CarBuilder setOwner(String owner) {
        car.setOwner(owner);
        return this;
    }

    public Car build() {
        if (validateCar()) {
            return car;
        } else {
            System.out.println("Не ввели обязательные значения VIN и владелец");
            return null;
        }
    }

    private boolean validateCar() {
        return (car.getVin() != 0 && car.getOwner() != null);
    }

}
