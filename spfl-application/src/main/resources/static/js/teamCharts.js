function getGoalsScoredChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goals-scored-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalsScoredGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalsScored = data.entries.map(e => e.goalsScored);

	    	var goalsScoredChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goals Scored",
	    	    		data: goalsScored, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getGoalsScoredPerGameChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goals-scored-per-game-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalsScoredPerGameGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalsScoredPerGame = data.entries.map(e => e.goalsScoredPerGame.toFixed(2));

	    	var goalsScoredPerGameChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goals Scored Per Game",
	    	    		data: goalsScoredPerGame, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getGoalsConcededChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goals-conceded-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalsConcededGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalsConceded = data.entries.map(e => e.goalsConceded);

	    	var goalsConcededChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goals Conceded",
	    	    		data: goalsConceded, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getGoalsConcededPerGameChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goals-conceded-per-game-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalsConcededPerGameGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalsConcededPerGame = data.entries.map(e => e.goalsConcededPerGame.toFixed(2));

	    	var goalsConcededChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goals Conceded Per Game",
	    	    		data: goalsConcededPerGame, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getGoalDifferenceChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goal-difference-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalDifferenceGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalDifference = data.entries.map(e => e.goalDifference);

	    	var goalDifferenceChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goal Difference",
	    	    		data: goalDifference, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getGoalDifferencePerGameChart(leagueId) {
	$.ajax('/league/' + leagueId + '/goal-difference-per-game-chart.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('goalDifferencePerGameGraph');
	    	
	    	var labels = data.entries.map(e => e.teamName); 
	    	var goalDifferencePerGame = data.entries.map(e => e.goalDifferencePerGame.toFixed(2));

	    	var goalDifferenceChart = new Chart(ctx, {
	    	    type: 'horizontalBar',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Goal Difference Per Game",
	    	    		data: goalDifferencePerGame, 
	    	    		backgroundColor: "rgb(0,123,255)"
	    	    	}]
	    	    },
	    	    options: []
	    	});
		}
	});
}

function getLeagueTableByWeek(leagueId, teamResourceId) {
	$.ajax('/league/' + leagueId + '/league-table-by-matchday.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('tablesByMatchweekGraph');
			
			var labels = []; 
			
			for (var i = 0; i < data.leagueTables.length; i++) {
				labels.push("Matchday " + (i+1));
			}
			
			var chartData = []; 
			
			for (var i = 0; i < data.leagueTables.length; i++) {
				for (var j = 0; j < data.leagueTables[i].entries.length; j++) {
					if (data.leagueTables[i].entries[j].teamResourceId == teamResourceId) {
						chartData.push(data.leagueTables[i].entries[j].position); 
					}
				}
			}

			console.log(labels);
			
	    	var leagueTablePerWeekChart = new Chart(ctx, {
	    	    type: 'line',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "League Position",
	    	    		data: chartData, 
	    	    		borderColor: "rgb(0,123,255)", 
	    	    		lineTension: 0
	    	    	}]
	    	    },
	    	    options: {
				  scales: {
				    yAxes: [{
				      ticks: {
				        reverse: true,
				        stepSize: 1, 
				        max: 12, 
				        min: 1
				      }
				    }]
				  }
				}
	    	});
		}
	});
}

function getPointsWonPerWeek(leagueId, teamResourceId) {
	$.ajax('/league/' + leagueId + '/league-table-by-matchday.json', {
	    success: function (data, status, xhr) {	    
	    	var ctx = document.getElementById('pointsWonByMatchWeekGraph');
			
			var labels = []; 
			
			for (var i = 0; i < data.leagueTables.length; i++) {
				labels.push("Matchday " + (i+1));
			}
			
			var chartData = []; 
			
			for (var i = 0; i < data.leagueTables.length; i++) {
				for (var j = 0; j < data.leagueTables[i].entries.length; j++) {
					if (data.leagueTables[i].entries[j].teamResourceId == teamResourceId) {
						chartData.push(data.leagueTables[i].entries[j].points); 
					}
				}
			}

			console.log(labels);
			
	    	var pointsPerWeekChart = new Chart(ctx, {
	    	    type: 'line',
	    	    data: {
	    	    	labels: labels, 
	    	    	datasets: [{
	    	    		label: "Points",
	    	    		data: chartData, 
	    	    		borderColor: "rgb(0,123,255)", 
	    	    		lineTension: 0
	    	    	}]
	    	    },
	    	    options: {
				  scales: {
				    yAxes: [{
				      ticks: {
				        stepSize: 1,  
				        min: 0
				      }
				    }]
				  }
				}
	    	});
		}
	});
}

