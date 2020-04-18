package com.dqi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PSTeamMemberDetails {
	
	String email;
	String displayName;
	int ticketCount;
//	String resolutionDate;
//	String created;
	double totalResolutionTime;
	
}
