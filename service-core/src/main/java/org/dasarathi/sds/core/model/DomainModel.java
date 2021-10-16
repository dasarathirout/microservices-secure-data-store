package org.dasarathi.sds.core.model;

import java.io.Serializable;

public abstract class DomainModel implements Serializable {

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getDateOfBirth();

    public abstract void setDateOfBirth(String dateOfBirth);

    public abstract double getSalary();

    public abstract void setSalary(double salary);

    public abstract int getCurrentAge();

    public abstract void setCurrentAge(int currentAge);
}
