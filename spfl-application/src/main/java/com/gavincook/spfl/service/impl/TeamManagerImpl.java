package com.gavincook.spfl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gavincook.spfl.model.Team;
import com.gavincook.spfl.model.TeamListResponse;
import com.gavincook.spfl.service.TeamManager;

@Service
public class TeamManagerImpl implements TeamManager {
	
	@Value("${zuul.team-service-url}")
	private String teamServiceUrl;  
	
	@Value("${zuul.league-table-service-url}")
	private String leagueTableServiceUrl;
	
	private WebClient webClient;
	
	@Autowired
	public TeamManagerImpl() {
		this.webClient = WebClient.create();
	}

	@Override
	public Team getTeamById(long teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeamByResourceId(long resourceId) {
		return webClient
			      .get()
			      .uri(teamServiceUrl + "/teams/" + resourceId)
			      .retrieve()
			      .toEntity(TeamListResponse.class)
			      .block()
			      .getBody()
			      .getTeams()
			      .get(0);
	}

}
