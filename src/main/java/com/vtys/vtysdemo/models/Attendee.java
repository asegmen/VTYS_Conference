package com.vtys.vtysdemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vtys.vtysdemo.models.Base.Person;

import javax.persistence.*;

@Entity
@Table(name = "attendees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendee extends Person {

    @Column(name = "company")
    private String Company;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attendee_id")
    private Long attendeeId;

    public Attendee() {
    }

    public Long getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Long attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
