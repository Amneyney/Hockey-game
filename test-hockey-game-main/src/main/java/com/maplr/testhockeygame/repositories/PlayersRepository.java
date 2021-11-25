package com.maplr.testhockeygame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maplr.testhockeygame.entities.Player;

public interface PlayersRepository extends JpaRepository<Player, Long>{

}
