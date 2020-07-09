package com.gavincook.spfl.service;

import java.util.List;
import java.util.Optional;

import com.gavincook.spfl.model.Competition;
import com.gavincook.spfl.model.LeagueTable;

public interface LeagueTableManager {

	/**
	 * gets current table for a league
	 * @param leagueResourceId
	 * @return
	 */
	List<LeagueTable> getTableByLeague(Long leagueResourceId);

	/**
	 * Takes a league resource ID and fetches a table of top scoring teams
	 * @param leagueResourceId
	 * @return
	 */
	Optional<LeagueTable> getTopScoringTeamsByLeagueResourceId(long leagueResourceId);

	/**
	 * Takes a league resource ID and fetches a table of top defensive teams
	 * @param leagueResourceId
	 * @return
	 */
	Optional<LeagueTable> getTopDefensiveTeamsByLeagueResourceId(long leagueResourceId);

	/**
	 * Takes a league table and sorts by goals scored divided by number of fixtures played
	 * @param l
	 * @return
	 */
	Optional<LeagueTable> getTopGoalsPerGameByLeagueResourceId(long leagueResourceId);

	/**
	 * Takes a league table and sorts it by goals conceded divided by number of fixtures played ascending
	 * @param l
	 * @return
	 */
	Optional<LeagueTable> getTopDefensiveTeamPerGameByLeagueResourceId(long leagueResourceId);

	/**
	 * Takes a league table entry and sorts it by goal difference descending
	 * @param l
	 * @return
	 */
	Optional<LeagueTable> getTopGoalDifferenceByLeagueResourceId(long leagueResourceId);

	/**
	 * Takes a league table entry and sorts it by goal difference divided by number of fixtures played descending
	 * @param i
	 * @return
	 */
	Optional<LeagueTable> getTopGoalDifferencePerGameByLeagueResourceId(long leagueResourceId);
}
