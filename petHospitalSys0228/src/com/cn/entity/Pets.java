package com.cn.entity;

public class Pets {
    private int petID;
    private String petName;
    private String birthDate;
    private String breed;
    private int ownerID;

    public Pets() {
    }

    public Pets(int petID, String petName, String birthDate, String breed, int ownerID) {
        this.petID = petID;
        this.petName = petName;
        this.birthDate = birthDate;
        this.breed = breed;
        this.ownerID = ownerID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthdate) {
        this.birthDate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
