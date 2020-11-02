package com.gavincook.spfl.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gavincook.spfl.model.Fixture;
import com.gavincook.spfl.model.Lineup;
import com.gavincook.spfl.service.FixtureManager;

@Controller
@RequestMapping("fixture")
public class FixtureController {
	
	private final FixtureManager fixtureMgr;
	
	@Autowired
	public FixtureController(FixtureManager fixtureMgr) {
		this.fixtureMgr = fixtureMgr;
	}

	@GetMapping("/{fixtureResourceId}")
	public ModelAndView getFixtureInfo(@PathVariable long fixtureResourceId) {
		
		ModelAndView mav = new ModelAndView("fixture");
		
		Fixture fixture = fixtureMgr.getFixtureByResourceId(fixtureResourceId).get();
		mav.addObject("fixture", fixture);
		
		Optional<List<Lineup>> lineup = fixtureMgr.getLineupsByFixtureId(fixtureResourceId);
		
		lineup.ifPresent(l -> mav.addObject("lineup", l));
		
		return new ModelAndView("fixture");
	}
}
