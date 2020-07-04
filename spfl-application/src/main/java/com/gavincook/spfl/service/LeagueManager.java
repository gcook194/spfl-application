package com.gavincook.spfl.service;

import java.util.Optional;

import com.gavincook.spfl.model.Competition;

public interface LeagueManager {
	
	/**
	 * gets a league or cup using its ID
	 * @param id
	 * @return
	 */
	public Optional<Competition> getCompetitionById(long id);

}
