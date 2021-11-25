package com.maplr.testhockeygame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maplr.testhockeygame.entities.Team;

public interface TeamsRepository extends JpaRepository<Team, Long> {

}
