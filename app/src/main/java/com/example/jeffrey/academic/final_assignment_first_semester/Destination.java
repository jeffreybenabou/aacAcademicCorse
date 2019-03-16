package com.example.jeffrey.academic.final_assignment_first_semester;

public class Destination {
    private String nameOfCountry,description,cost,flightNumber,date;
    private int imageId;



    public Destination(String nameOfCountry, String description, String cost, String flightNumber, String date, int imageId) {
        this.nameOfCountry = nameOfCountry;
        this.description = description;
        this.cost = cost;
        this.flightNumber = flightNumber;
        this.date = date;
        this.imageId = imageId;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
