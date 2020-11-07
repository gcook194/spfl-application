package com.gavincook.spfl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FixtureStatistics {
	
	private long id; 
	private long fixtureResourceId; 
	private String type; 
	private String displayName; 
	private long homeTeam; 
	private long awayTeam; 

}
