package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
