package homework01.logic;

public class Car {
    private String model;
    private String manufacturer;
    private int vin;
    private int year;
    private String color;
    private int horsePower;
    private EngineType engine;
    private String owner;

    protected Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getVin() {
        return vin;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", vin=" + vin +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", horsePower=" + horsePower +
                ", engine='" + engine + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
