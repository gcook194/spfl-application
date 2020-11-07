package com.gavincook.spfl.service;

import java.util.List;
import java.util.Optional;

import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.FixtureStatistics;
import com.gavincook.spfl.model.Lineup;

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

	/**
	 * gets a list of fixtures where the status is not FT, AET or PEN
	 * @param l
	 * @return
	 */
	Optional<List<Fixture>> getUnPlayedFixturesByLeagueResourceId(long leagueResourceId);
	
	/**
	 * gets a fixture using the RapidApi resource ID
	 * @param fixtureResourceId
	 * @return
	 */
	Optional<Fixture> getFixtureByResourceId(long fixtureResourceId);
	
	/**
	 * gets the lineups for a fixture
	 * @param fixtureResourceId
	 * @return
	 */
	Optional<List<Lineup>> getLineupsByFixtureId(long fixtureResourceId);
	

	/**
	 * gets the fixture statistics for a fixture
	 * @param fixtureResourceId
	 * @return
	 */
	Optional<List<FixtureStatistics>> getFixtureStatisticsByFixtureResourceId(long fixtureResourceId);
}
