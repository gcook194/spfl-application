package com.gavincook.spfl.model;

import lombok.Data;

@Data
public class Competition {
	private long id; 
	private Long resourceId;
	private String name;  
	private String type;
	private String logo;
}
