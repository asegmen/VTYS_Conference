package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
