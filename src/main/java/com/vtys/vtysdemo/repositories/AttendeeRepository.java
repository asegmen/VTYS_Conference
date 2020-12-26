package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    @Procedure(name = "workShopTickets")
    List<Attendee> findAttendeesByWorkshop();
}
