package com.gavincook.spfl.service;

import com.gavincook.spfl.model.Team;

public interface TeamManager {
	
	/**
	 * gets a team by its ID
	 * @param teamId
	 * @return
	 */
	Team getTeamById(long teamId);
	
	/**
	 * gets a team by its RapidAPI ID
	 * @param resourceId
	 * @return
	 */
	Team getTeamByResourceId(long resourceId);

}
