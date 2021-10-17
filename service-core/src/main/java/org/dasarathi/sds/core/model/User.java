package org.dasarathi.sds.core.model;

public class User extends DomainModel {
    private int id;
    private String name;
    private String dateOfBirth;
    private double salary;
    private int currentAge;

    public User() {
        super();
    }

    public User(int id, String name, String dateOfBirth, double salary, int currentAge) {
        this();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.currentAge = currentAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    @Override
    public String toString() {
        return "USER { "
                + "ID : " + id+" , "
                + "NAME : " + name+" , "
                + "DOB : " + dateOfBirth+" , "
                + "SALARY : " + salary+" , "
                + "AGE : " + currentAge
                + " } ";
    }
}
