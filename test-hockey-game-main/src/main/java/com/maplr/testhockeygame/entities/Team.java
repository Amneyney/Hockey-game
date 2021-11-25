package com.maplr.testhockeygame.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor @Getter @Setter
@Entity
public class Team implements Serializable{

	private static final long serialVersionUID = -4154874192539868377L;
	private @Id Long id;
	private String coach;
	private Long year;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "team",cascade=CascadeType.ALL)
	private List <Player> players;
	
}
