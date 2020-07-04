package com.gavincook.spfl.service;

import java.util.List;
import java.util.Optional;

import com.gavincook.spfl.model.Fixture;

public interface FixtureManager {

	Optional<List<Fixture>> getFixturesByStatusAndLeagueResourceId(String status, long leagueResourceId);
}
