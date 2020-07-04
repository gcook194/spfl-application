package com.gavincook.spfl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LeagueListResponse {
	Integer results;
	List<Competition> leagues = new ArrayList<>(); 
}
