package com.example.royalpharmacy;

public class Stock {
    String type;
    String quantity;
    String price;

    public Stock() {
    }

    public Stock(String type, String quantity, String price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
