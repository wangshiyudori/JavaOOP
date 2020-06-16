package com.cn.entity;

public class Visits {
    private int visitID;
    private int petID;
    private int ownerID;
    private int vetID;
    private String visitDate;
    private String description;
    private String treatment;

    public Visits() {
    }

    public Visits(int visitID, int petID, int ownerID, int vetID, String visitDate, String description, String treatment) {
        this.visitID = visitID;
        this.petID = petID;
        this.ownerID = ownerID;
        this.vetID = vetID;
        this.visitDate = visitDate;
        this.description = description;
        this.treatment = treatment;
    }

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getVetID() {
        return vetID;
    }

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
