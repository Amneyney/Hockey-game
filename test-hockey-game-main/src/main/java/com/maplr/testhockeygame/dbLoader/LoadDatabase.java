package com.maplr.testhockeygame.dbLoader;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.repositories.PlayersRepository;
import com.maplr.testhockeygame.repositories.TeamsRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	
	private Team generateTeam(int i) {
		Team t = new Team();
		t.setCoach("The coach "+ i);
		t.setId(1L +i);
		t.setYear(2020l +i);
		return t;
	}
	
	@Bean
	CommandLineRunner initDatabaseTeams(TeamsRepository repository) {
	/// adding the list of the teams to the database.
		return args ->{
			log.info("Preloading" + repository.save(generateTeam(0)));
			log.info("Preloading" + repository.save(generateTeam(1)));
			log.info("Preloading" + repository.save(generateTeam(2)));
			log.info("Preloading" + repository.save(generateTeam(3)));
		};
	}
}
