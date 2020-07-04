package com.gavincook.spfl.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gavincook.spfl.model.Competition;
import com.gavincook.spfl.model.LeagueListResponse;
import com.gavincook.spfl.service.LeagueManager;

@Service
public class LeagueManagerImpl implements LeagueManager {
	
	@Value("${zuul.fixture-service-url}")
	private String fixtureServiceUrl;  
	
	@Value("${zuul.team-service-url}")
	private String teamServiceUrl;  
	
	@Value("${zuul.league-table-service-url}")
	private String leagueTableServiceUrl;
	
	@Value("${zuul.league-service-url}")
	private String leagueDataServiceUrl;
	
	private WebClient webClient;
	
	public LeagueManagerImpl() {
		this.webClient = WebClient.create();
	}

	@Override
	public Optional<Competition> getCompetitionById(long id) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(leagueDataServiceUrl + "/leagues/" + id)
			      .retrieve()
			      .toEntity(LeagueListResponse.class)
			      .block()
			      .getBody()
			      .getLeagues()
			      .get(0));
	}

}
