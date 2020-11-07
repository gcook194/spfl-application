package com.gavincook.spfl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FixtureStatisticsListResponse {
	private int results; 
	List<FixtureStatistics> statistics = new ArrayList<>();
}
