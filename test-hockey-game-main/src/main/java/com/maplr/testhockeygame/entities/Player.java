package com.maplr.testhockeygame.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor @Getter @Setter
@Entity
public class Player implements Serializable{

	private static final long serialVersionUID = 8128703757667417782L;
	private @Id Long number;
	private String name;
	private String lastname;
	private String position;
	private Boolean isCaptain;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnore
	private Team team;
	
}
