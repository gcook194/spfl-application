package com.gavincook.spfl.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gavincook.spfl.model.LeagueTable;
import com.gavincook.spfl.model.Team;
import com.gavincook.spfl.service.LeagueTableManager;
import com.gavincook.spfl.service.TeamManager;

@Controller
@RequestMapping("team")
public class TeamController {
	
	private final TeamManager teamMgr; 
	private final LeagueTableManager tableMgr; 

	@Autowired
	public TeamController(TeamManager teamMgr, LeagueTableManager tableMgr) {
		this.teamMgr = teamMgr;
		this.tableMgr = tableMgr;
	}

	@GetMapping("/{teamResourceId}")
	public ModelAndView getTeam(@PathVariable long teamResourceId) {
		
		ModelAndView mav = new ModelAndView("team");
		
		Team team = teamMgr.getTeamByResourceId(teamResourceId); 
		LeagueTable leagueTable = tableMgr.getTableByLeague(2655L).get(0);
		
		mav.addObject(team);
		mav.addObject(leagueTable);
		
		return mav; 
	}
}
