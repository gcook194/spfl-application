package com.gavincook.spfl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.FixtureListResponse;
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

}
