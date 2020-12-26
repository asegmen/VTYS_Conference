package com.vtys.vtysdemo.models;

import com.vtys.vtysdemo.models.Base.Person;

import javax.persistence.*;

@Entity
@Table(name = "attendees")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
         name = "workShopTickets",
         procedureName = "findbyworkshopprocedure",
         resultClasses = { Attendee.class })
 })
public class Attendee extends Person {

    @Column(name = "company")
    private String Company;

    public Attendee() {
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
