package com.example.royalpharmacy.IT211;

public class Order {

    String orderId;
    String oName;
    String oAge;
    String oDate;

    public Order() {
    }

    public Order(String orderId, String oName, String oAge,String oDate) {
        this.orderId = orderId;
        this.oName = oName;
        this.oAge = oAge;
        this.oDate=oDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoAge() {
        return oAge;
    }

    public void setoAge(String oAge) {
        this.oAge = oAge;
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }
}
