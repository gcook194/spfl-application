package com.gavincook.spfl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gavincook.spfl.model.LeagueTable;
import com.gavincook.spfl.model.LeagueTableResponse;
import com.gavincook.spfl.service.LeagueTableManager;

@Service
public class LeagueTableManagerImpl implements LeagueTableManager {
	
	@Value("${zuul.fixture-service-url}")
	private String fixtureServiceUrl;  
	
	@Value("${zuul.team-service-url}")
	private String teamServiceUrl;  
	
	@Value("${zuul.league-table-service-url}")
	private String leagueTableServiceUrl;
	
	private WebClient webClient;
	
	public LeagueTableManagerImpl() {
		this.webClient = WebClient.create();
	}

	@Override
	public List<LeagueTable> getTableByLeague(Long leagueResourceId) {
		return webClient
			      .get()
			      .uri(leagueTableServiceUrl + "/league-tables/" + leagueResourceId)
			      .retrieve()
			      .toEntity(LeagueTableResponse.class)
			      .block()
			      .getBody()
			      .getLeagueTables();
	}

	@Override
	public Optional<LeagueTable> getTopScoringTeamsByLeagueResourceId(long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(leagueTableServiceUrl + "/league-tables/" + leagueResourceId + "/top-scoring-teams")
			      .retrieve()
			      .toEntity(LeagueTableResponse.class)
			      .block()
			      .getBody()
			      .getLeagueTables()
			      .get(0));
	}

	@Override
	public Optional<LeagueTable> getTopDefensiveTeamsByLeagueResourceId(long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(leagueTableServiceUrl + "/league-tables/" + leagueResourceId + "/top-defensive-teams")
			      .retrieve()
			      .toEntity(LeagueTableResponse.class)
			      .block()
			      .getBody()
			      .getLeagueTables()
			      .get(0));
	}

	@Override
	public Optional<LeagueTable> getTopGoalsPerGameByLeagueResourceId(long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(leagueTableServiceUrl + "/league-tables/" + leagueResourceId + "/goals-scored-per-game")
			      .retrieve()
			      .toEntity(LeagueTableResponse.class)
			      .block()
			      .getBody()
			      .getLeagueTables()
			      .get(0));
	}

	@Override
	public Optional<LeagueTable> getTopDefensiveTeamPerGameByLeagueResourceId(long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(leagueTableServiceUrl + "/league-tables/" + leagueResourceId + "/goals-conceded-per-game")
			      .retrieve()
			      .toEntity(LeagueTableResponse.class)
			      .block()
			      .getBody()
			      .getLeagueTables()
			      .get(0));
	}

}
