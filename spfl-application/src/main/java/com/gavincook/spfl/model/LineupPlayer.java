package com.gavincook.spfl.model;

import lombok.Data;

@Data
public class LineupPlayer {

	private long id; 
    private Lineup lineup; 
	private long playerResourceId; 
	private long teamResourceId;
	private String name; 
	private String position; 
	private int number; 
    private boolean substitute;

}
