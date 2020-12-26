package com.vtys.vtysdemo.models;

import com.vtys.vtysdemo.models.Base.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Column(name = "phone")
    private String phone;

    @Column(name="department")
    private String department;

    public Employee() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
