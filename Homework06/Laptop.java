package Homework06;

public class Laptop {
    String model;
    String color;
    int ramGB;
    int hddGB;
    String os;

    public void getInfo() {
        System.out.println(this.model + ":\n\tЦвет: " + this.color + "\n\tОЗУ: " + this.ramGB + "\n\tОбъем ЖД: "
                + this.hddGB + "\n\tОперационная система: " + this.os + "\n");
    }

    @Override
    public String toString() {
        return "Laptop [model=" + this.model + ", color=" + this.color + ", ram=" + this.ramGB + ", rom = " + this.hddGB
                + ", os=" + this.os + "]";
    }

    public Laptop() {
        this.model = null;
        this.color = null;
        this.ramGB = 0;
        this.hddGB = 0;
        this.os = null;
    }

    public Laptop(String model, String color, int ram, int hdd, String os) {
        this.model = model;
        this.color = color;
        this.ramGB = ram;
        this.hddGB = hdd;
        this.os = os;
    }
}
