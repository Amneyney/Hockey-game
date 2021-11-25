package com.maplr.testhockeygame.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.testhockeygame.entities.Player;
import com.maplr.testhockeygame.entities.Team;
import com.maplr.testhockeygame.repositories.PlayersRepository;
import com.maplr.testhockeygame.repositories.TeamsRepository;

@RestController
@RequestMapping("/api")
public class TeamsController {

	private final TeamsRepository repTeam;
	private final PlayersRepository repPlayer;

	
	public TeamsController(TeamsRepository repTeam, PlayersRepository repPlayer) {
		this.repTeam = repTeam;
		this.repPlayer = repPlayer;
	}
	
	@GetMapping("/players")
	List<Player> findAllPlayers(){
		return repPlayer.findAll();
	}
	
	@GetMapping("/teams")
	List<Team> findAllTeams(){
		return repTeam.findAll();
	}
	
	@GetMapping("/team/{year}")
	List<Team> findbyYear(@PathVariable Long year) {
		return repTeam.findAll().stream().filter(t -> year.equals(t.getYear())).collect(Collectors.toList());
	}
	
	@PostMapping("/team/{year}")
	Team addPlayer(@PathVariable Long year,@RequestBody Player player){
		List<Team> teams = findbyYear(year);
		if(teams!=null && !teams.isEmpty()) {
			player.setTeam(teams.get(0));
			teams.get(0).getPlayers().add(player);
			return repTeam.save(teams.get(0));
		}
		return null;
	}


	@PutMapping("/player/captain/{id}")
	Player setCaptain(@PathVariable Long id) {
		return repPlayer.findById(id)
			      .map(p -> {
			        p.setIsCaptain(true);
			        return repPlayer.save(p);
			      }).orElseThrow();
	}
}
