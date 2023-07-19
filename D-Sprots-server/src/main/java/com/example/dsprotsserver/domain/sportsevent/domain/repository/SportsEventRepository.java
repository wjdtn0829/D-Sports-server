package com.example.dsprotsserver.domain.sportsevent.domain.repository;

import com.example.dsprotsserver.domain.sportsevent.domain.SportsEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsEventRepository extends JpaRepository<SportsEvent, Integer> {

}
