package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
