package org.study;

import java.io.Serializable;

public class Customer implements Serializable {
    private String companyName;
    private String specialization;
    private int quantityOfEquipment;

    public Customer(String companyName, String specialization, int quantityOfEquipment) {
        this.companyName = companyName;
        this.specialization = specialization;
        this.quantityOfEquipment = quantityOfEquipment;
    }

    public Customer() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getQuantityOfEquipment() {
        return quantityOfEquipment;
    }

    public void setQuantityOfEquipment(int quantityOfEquipment) {
        this.quantityOfEquipment = quantityOfEquipment;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "companyName='" + companyName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", quantityOfEquipment=" + quantityOfEquipment +
                '}';
    }
}



