package com.example.royalpharmacy.IT212;

public class Medicine {

    String medName;
    String medAddDate;
    String quantity;

    public Medicine() {
    }

    public Medicine(String medName, String medAddDate, String quantity) {
        this.medName = medName;
        this.medAddDate = medAddDate;
        this.quantity = quantity;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedAddDate() {
        return medAddDate;
    }

    public void setMedAddDate(String medAddDate) {
        this.medAddDate = medAddDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
