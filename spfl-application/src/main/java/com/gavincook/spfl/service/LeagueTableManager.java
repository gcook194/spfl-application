package com.gavincook.spfl.service;

import java.util.List;

import com.gavincook.spfl.model.LeagueTable;

public interface LeagueTableManager {

	/**
	 * gets current table for a league
	 * @param leagueResourceId
	 * @return
	 */
	List<LeagueTable> getTableByLeague(Long leagueResourceId);
}
