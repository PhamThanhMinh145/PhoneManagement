package model;

import javax.print.DocFlavor;

public class Phone implements Comparable<Phone>{
    private String model;
    private String CPU;
    private String RAM;
    private String primaryCamera;
    private double screeenSize;
    private double price;
    private String color;
    private String brand;

    public Phone(String model) {
        this.model = model;
    }

    public Phone(String model, String CPU, String RAM, String primaryCamera,
                 double screeenSize, double price, String color, String brand)
    {
        this.model = model;
        this.CPU = CPU;
        this.RAM = RAM;
        this.primaryCamera = primaryCamera;
        this.screeenSize = screeenSize;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public double getScreeenSize() {
        return screeenSize;
    }

    public void setScreeenSize(double screeenSize) {
        this.screeenSize = screeenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    @Override
    public int compareTo(Phone p) {
        return this.model.compareToIgnoreCase(p.model);
    }

    public void printPhones(){
        String  msg;

        msg = String.format("|%-15s|%-30s|%-6s|%-15s|%-11.2f|%-7.3f$|%-15s|%-35s|",
                model,CPU,RAM,primaryCamera,screeenSize,price,color,brand);

            System.out.println(msg);
    }
}
