package com.example.jeffrey.academic.restaurant_menu;

public class Item {
    private int imageId;
    private String description;
    private int price;
    private boolean addToOrderList;
    private String name;


    public Item(int imageId, String description, int price, String name) {
        this.imageId = imageId;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAddToOrderList() {
        return addToOrderList;
    }

    public void setAddToOrderList(boolean addToOrderList) {
        this.addToOrderList = addToOrderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
