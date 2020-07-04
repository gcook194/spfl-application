package com.gavincook.spfl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gavincook.spfl.model.LeagueTable;
import com.gavincook.spfl.service.LeagueTableManager;

@Controller
@RequestMapping("/")
public class DashboardController {
	
	private LeagueTableManager tableMgr; 
	
	@Autowired
	public DashboardController(LeagueTableManager tableMgr) {
		this.tableMgr = tableMgr;
	}

	@GetMapping("table")
	public ModelAndView showDashboard() {
		
		LeagueTable premiershipTable = tableMgr.getTableByLeague(574L).get(0);
		
		return new ModelAndView("dashboard").addObject("premiershipTable", premiershipTable);
	}
	
	@GetMapping
	public ModelAndView showHomePage() {
		return new ModelAndView("index");
	}

}
