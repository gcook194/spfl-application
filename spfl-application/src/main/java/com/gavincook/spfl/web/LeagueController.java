package com.gavincook.spfl.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gavincook.spfl.Constants;
import com.gavincook.spfl.model.Competition;
import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.LeagueTable;
import com.gavincook.spfl.service.FixtureManager;
import com.gavincook.spfl.service.LeagueManager;
import com.gavincook.spfl.service.LeagueTableManager;

@Controller
@RequestMapping("league")
public class LeagueController {
	
	private LeagueManager leagueMgr;
	private LeagueTableManager tableMgr; 
	private FixtureManager fixtureMgr;
	
	@Autowired
	public LeagueController(LeagueManager leagueMgr, LeagueTableManager tableMgr, FixtureManager fixtureMgr) {
		this.leagueMgr = leagueMgr;
		this.tableMgr = tableMgr;
		this.fixtureMgr = fixtureMgr;
	}

	@GetMapping("/{leagueName}")
	public ModelAndView getLeague(@PathVariable String leagueName) {
		
		ModelAndView mav = new ModelAndView("league");
		Optional<Competition> league;
		Optional<LeagueTable> leagueTable;
		Optional<List<Fixture>> results;
		Optional<List<Fixture>> fixtures;
		Optional<LeagueTable> topScoringTeams;
		Optional<LeagueTable> topDefensiveTeams;
		Optional<LeagueTable> goalsPerGame;
		Optional<LeagueTable> goalsConcededPerGame;
		
		switch (leagueName) {
		case Constants.LEAGUE_NAME_PREMIERSHIP:
			
			league = leagueMgr.getCompetitionById(574L);
			leagueTable = Optional.of(tableMgr.getTableByLeague(574L).get(0));
			results = fixtureMgr.getRecentFixturesByStatusAndLeagueResourceId("FT", 574L);
			fixtures = fixtureMgr.getUnPlayedFixturesByLeagueResourceId(574L);
			topScoringTeams = tableMgr.getTopScoringTeamsByLeagueResourceId(574L);
			topDefensiveTeams = tableMgr.getTopDefensiveTeamsByLeagueResourceId(574L);
			goalsPerGame = tableMgr.getTopGoalsPerGameByLeagueResourceId(574L);
			goalsConcededPerGame = tableMgr.getTopDefensiveTeamPerGameByLeagueResourceId(574L);
			
			break;
		default:
			
			league = leagueMgr.getCompetitionById(574L);
			leagueTable = Optional.of(tableMgr.getTableByLeague(574L).get(0));
			results = fixtureMgr.getRecentFixturesByStatusAndLeagueResourceId("FT", 574L);
			fixtures = fixtureMgr.getUnPlayedFixturesByLeagueResourceId(574L);
			topScoringTeams = tableMgr.getTopScoringTeamsByLeagueResourceId(574L);
			topDefensiveTeams = tableMgr.getTopDefensiveTeamsByLeagueResourceId(574L);
			goalsPerGame = tableMgr.getTopGoalsPerGameByLeagueResourceId(574L);
			goalsConcededPerGame = tableMgr.getTopDefensiveTeamPerGameByLeagueResourceId(574L);
			
			break;
		}
		
		league.ifPresent(l -> mav.addObject("league", l));
		leagueTable.ifPresent(lt -> mav.addObject("leagueTable", lt));
		results.ifPresent(r -> mav.addObject("results", r));
		fixtures.ifPresent(f -> mav.addObject("fixtures", f));
		topScoringTeams.ifPresent(ts -> mav.addObject("topScoringTeams", ts));
		topDefensiveTeams.ifPresent(td -> mav.addObject("topDefensiveTeams", td));
		goalsPerGame.ifPresent(gpg -> mav.addObject("topScoringTeamsPerGame", gpg));
		goalsConcededPerGame.ifPresent(gcpg -> mav.addObject("topDefensiveTeamPerGame", gcpg));
		
		return mav;
	}

}
