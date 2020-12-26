package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

}
