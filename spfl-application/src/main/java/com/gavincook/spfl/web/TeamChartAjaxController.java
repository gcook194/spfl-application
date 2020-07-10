package com.gavincook.spfl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gavincook.spfl.model.LeagueTable;
import com.gavincook.spfl.model.LeagueTableResponse;
import com.gavincook.spfl.service.LeagueTableManager;

@RestController
public class TeamChartAjaxController {
	
	private final LeagueTableManager tableMgr; 
	
	@Autowired
	public TeamChartAjaxController(LeagueTableManager tableMgr) {
		this.tableMgr = tableMgr;
	}

	@GetMapping("/league/{leagueId}/goal-difference-chart.json")
	public ResponseEntity<LeagueTable> getGoalsScoredChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalDifferenceByLeagueResourceId(leagueId).get());
	}	

	@GetMapping("/league/{leagueId}/goal-difference-per-game-chart.json")
	public ResponseEntity<LeagueTable> getGoalDifferencePerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalDifferencePerGameByLeagueResourceId(leagueId).get());
	}	
	
	@GetMapping("/league/{leagueId}/goals-conceded-per-game-chart.json")
	public ResponseEntity<LeagueTable> getGoalsConcededPerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopDefensiveTeamPerGameByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/league/{leagueId}/goals-conceded-chart.json")
	public ResponseEntity<LeagueTable> getGoalsConcededChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopDefensiveTeamsByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/league/{leagueId}/goals-scored-per-game-chart.json")
	public ResponseEntity<LeagueTable> getGoalsScoredPerGameChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopGoalsPerGameByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/league/{leagueId}/goals-scored-chart.json")
	public ResponseEntity<LeagueTable> getGoalDifferenceChart(@PathVariable long leagueId) {
		return ResponseEntity.ok(tableMgr.getTopScoringTeamsByLeagueResourceId(leagueId).get());
	}
	
	@GetMapping("/league/{leagueId}/league-table-by-matchday.json")
	public ResponseEntity<LeagueTableResponse> gegetLeagueTalesByMatchday(@PathVariable long leagueId) {
		
		LeagueTableResponse response = new LeagueTableResponse();
		response.setLeagueTables(tableMgr.getMatchdayLeagueTableByTeam(leagueId).get());
		
		return ResponseEntity.ok(response);
	}

}
