package com.gavincook.spfl.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		
		switch (leagueName) {
		case Constants.LEAGUE_NAME_PREMIERSHIP:
			
			league = leagueMgr.getCompetitionById(574L);
			leagueTable = Optional.of(tableMgr.getTableByLeague(574L).get(0));
			results = fixtureMgr.getRecentFixturesByStatusAndLeagueResourceId("FT", 574L);
			fixtures = fixtureMgr.getUnPlayedFixturesByLeagueResourceId(574L);
			
			break;
		case Constants.LEAGUE_NAME_CHAMPIONSHIP: 
			
			league = leagueMgr.getCompetitionById(573L);
			leagueTable = Optional.of(tableMgr.getTableByLeague(573L).get(0));
			results = fixtureMgr.getRecentFixturesByStatusAndLeagueResourceId("FT", 573L);
			fixtures = fixtureMgr.getUnPlayedFixturesByLeagueResourceId(573L);
			
			break;
		default:
			
			league = leagueMgr.getCompetitionById(574L);
			leagueTable = Optional.of(tableMgr.getTableByLeague(574L).get(0));
			results = fixtureMgr.getRecentFixturesByStatusAndLeagueResourceId("FT", 574L);
			fixtures = fixtureMgr.getUnPlayedFixturesByLeagueResourceId(574L);
			
			break;
		}
		
		league.ifPresent(l -> mav.addObject("league", l));
		leagueTable.ifPresent(lt -> mav.addObject("leagueTable", lt));
		results.ifPresent(r -> mav.addObject("results", r));
		fixtures.ifPresent(f -> mav.addObject("fixtures", f));
		
		return mav;
	}

	@GetMapping("/{leagueId}/goal-difference-per-game-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalDifferencePerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalDifferencePerGameByLeagueResourceId(leagueId).get());
	}	
	
	@GetMapping("/{leagueId}/goals-conceded-per-game-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalsConcededPerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopDefensiveTeamPerGameByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/{leagueId}/goals-conceded-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalsConcededChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopDefensiveTeamsByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/{leagueId}/goals-scored-per-game-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalsScoredPerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalsPerGameByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/{leagueId}/goals-scored-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalDifferenceChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopScoringTeamsByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/{leagueId}/goal-difference-chart.json")
	public @ResponseBody ResponseEntity<LeagueTable> getGoalsScoredChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalDifferenceByLeagueResourceId(leagueId).get());
	}

}
