package com.gavincook.spfl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LineupListResponse {
	private int results; 
	List<Lineup> lineups = new ArrayList<>();
}
