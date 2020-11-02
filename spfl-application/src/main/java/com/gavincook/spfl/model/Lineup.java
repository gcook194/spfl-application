package com.gavincook.spfl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Lineup {
	private long id; 
	private long fixtureResourceId;
	private long teamResourceId; 
	private long managerResourceId; 
	private String manager; 
	private String formation;    
	private List<LineupPlayer> squad = new ArrayList<>(); 
}
