package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPriceRepository extends JpaRepository<TicketPrice, Long> {

}
