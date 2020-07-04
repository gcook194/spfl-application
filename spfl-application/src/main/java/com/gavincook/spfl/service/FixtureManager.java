package com.gavincook.spfl.service;

import java.util.List;
import java.util.Optional;

import com.gavincook.spfl.model.Fixture;

public interface FixtureManager {

	/**
	 * Gets a list of fixtures by fixture status and league ID 
	 * @param status
	 * @param leagueResourceId
	 * @return
	 */
	Optional<List<Fixture>> getFixturesByStatusAndLeagueResourceId(String status, long leagueResourceId);
	
	/**
	 * Gets a list of fixtures by fixture status and league ID ordered by fixture date descending
	 * @param status
	 * @param leagueResourceId
	 * @return
	 */
	Optional<List<Fixture>> getRecentFixturesByStatusAndLeagueResourceId(String status, long leagueResourceId);
}
