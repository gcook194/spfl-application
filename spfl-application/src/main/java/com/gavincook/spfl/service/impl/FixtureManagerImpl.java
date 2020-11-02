package com.gavincook.spfl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.FixtureListResponse;
import com.gavincook.spfl.model.Lineup;
import com.gavincook.spfl.model.LineupListResponse;
import com.gavincook.spfl.service.FixtureManager;

@Service
public class FixtureManagerImpl implements FixtureManager {

	@Value("${zuul.fixture-service-url}")
	private String fixtureServiceUrl;  
	
	private WebClient webClient;
	
	public FixtureManagerImpl() {
		this.webClient = WebClient.create();
	}
	
	@Override
	public Optional<List<Fixture>> getFixturesByStatusAndLeagueResourceId(String status, long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(fixtureServiceUrl + "/fixtures/status/" + status + "/league/" + leagueResourceId)
			      .retrieve()
			      .toEntity(FixtureListResponse.class)
			      .block()
			      .getBody()
			      .getFixtures());
	}

	@Override
	public Optional<List<Fixture>> getRecentFixturesByStatusAndLeagueResourceId(String status, long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(fixtureServiceUrl + "/fixtures/status/" + status + "/league/" + leagueResourceId + "?fixtureDateDesc=true")
			      .retrieve()
			      .toEntity(FixtureListResponse.class)
			      .block()
			      .getBody()
			      .getFixtures());
	}

	@Override
	public Optional<List<Fixture>> getUnPlayedFixturesByLeagueResourceId(long leagueResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(fixtureServiceUrl + "/fixtures/status/unplayed/league/" + leagueResourceId + "?fixtureDateDesc=true")
			      .retrieve()
			      .toEntity(FixtureListResponse.class)
			      .block()
			      .getBody()
			      .getFixtures());
	}

	@Override
	public Optional<Fixture> getFixtureByResourceId(long fixtureResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(fixtureServiceUrl + "/fixtures/" + fixtureResourceId)
			      .retrieve()
			      .toEntity(FixtureListResponse.class)
			      .block()
			      .getBody()
			      .getFixtures()
			      .get(0));
	}

	@Override
	public Optional<List<Lineup>> getLineupsByFixtureId(long fixtureResourceId) {
		return Optional.ofNullable(webClient
			      .get()
			      .uri(fixtureServiceUrl + "/fixture-data/" + fixtureResourceId + "/lineups")
			      .retrieve()
			      .toEntity(LineupListResponse.class)
			      .block()
			      .getBody()
			      .getLineups());
	}

}
