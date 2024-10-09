package com.example.lab2_cau3;

public abstract class Employee {
    private String ID;
    private String Name;

    public Employee(String id, String name) {
        ID = id;
        Name = name;
    }

    public Employee() {

    }

    public String GetID() {
        return ID;
    }

    public void SetID(String id) {
        ID = id;
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String name) {
        Name = name;
    }

    public abstract double TinhLuong();

    public String toString() {
        return ID + " - " + Name ;
    }
}
class EmployeeParttime extends Employee {
    public EmployeeParttime(String id, String name, int type) {
        super(id, name);
    }

    public EmployeeParttime() {

    }

    @Override
    public double TinhLuong() {
        return 150.0;
    }

    @Override
    public String toString() {
        return super.toString() + " -->PartTime=150.0";
    }
}
class EmployeeFulltime extends Employee {
    public EmployeeFulltime(String id, String name, int type) {
        super(id, name);
    }

    public EmployeeFulltime() {
        super();
    }

    @Override
    public double TinhLuong() {
        return 500.0;
    }

    @Override
    public String toString() {
        return super.toString()+ " -->FullTime=500.0";
    }
}