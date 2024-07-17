package com.online_housing.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Housing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String housingName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int numberOfFloors;

    @Column(nullable = false)
    private int numberOfMasterRoom;

    @Column(nullable = false)
    private int numberOfSingleRoom;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfMasterRoom() {
        return numberOfMasterRoom;
    }

    public void setNumberOfMasterRoom(int numberOfMasterRoom) {
        this.numberOfMasterRoom = numberOfMasterRoom;
    }

    public int getNumberOfSingleRoom() {
        return numberOfSingleRoom;
    }

    public void setNumberOfSingleRoom(int numberOfSingleRoom) {
        this.numberOfSingleRoom = numberOfSingleRoom;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
