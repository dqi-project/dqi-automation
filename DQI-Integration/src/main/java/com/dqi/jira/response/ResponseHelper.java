package com.dqi.jira.response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dqi.dto.PSTeamMemberDetails;

public class ResponseHelper {
	
	public static Map<String, PSTeamMemberDetails> populatePSTeamMemberDetails(SearchResponse response) {
		
		List<Issues> issuesFromResponse = response.getIssues();
		
		Map<String, PSTeamMemberDetails> detailsMap = new HashMap<>();
		
		for(Issues issue : issuesFromResponse) {
			
			String email = issue.getFields().getAssignee().getEmailAddress();
			
			if(detailsMap.containsKey(issue.getFields().getAssignee().getEmailAddress())){
				
				PSTeamMemberDetails details = detailsMap.get(email);
				details.setTicketCount(details.getTicketCount() + 1);
				
				double totalResolutionTime = computeTotalResolutionTime(issue.getFields().getCreated(), issue.getFields().getResolutiondate());
				details.setTotalResolutionTime(details.getTotalResolutionTime() + totalResolutionTime);
				
//				StartTimeEndTimePair pair = new StartTimeEndTimePair();
//				pair.setCreated(issue.getFields().getCreated());
//				pair.setResolutiondate(issue.getFields().getResolutiondate());
//				
//				details.getStartTimeEndTimePairList().add(pair);
				
				detailsMap.put(email, details);
				
			} else {
				
				PSTeamMemberDetails details = new PSTeamMemberDetails();
				details.setEmail(issue.getFields().getAssignee().getEmailAddress());
				details.setDisplayName(issue.getFields().getAssignee().getDisplayName());
				
				details.setTicketCount(1);
				
				double totalResolutionTime = computeTotalResolutionTime(issue.getFields().getCreated(), issue.getFields().getResolutiondate());
				details.setTotalResolutionTime(totalResolutionTime);
				
//				StartTimeEndTimePair pair = new StartTimeEndTimePair();
//				pair.setCreated(issue.getFields().getCreated());
//				pair.setResolutiondate(issue.getFields().getResolutiondate());
//				
//				List<StartTimeEndTimePair> pairList = new ArrayList<>();
//				
//				pairList.add(pair);				
//				details.setStartTimeEndTimePairList(pairList);	
				
				detailsMap.put(email, details);
				
			}
		}
		
		
		return detailsMap;
	}

	private static double computeTotalResolutionTime(String created, String resolutiondate) throws ParseException {
		// TODO Auto-generated method stub
		double timeUnits = (ChronoUnit.HOURS.between(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ").parse(created).toInstant()
				                                      .atZone(ZoneId.systemDefault()).toLocalDateTime()  , 
				                                      new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ").parse(resolutiondate).toInstant()
				                                      .atZone(ZoneId.systemDefault())
				                                       .toLocalDateTime()))/24.0d; 

				   if(timeUnits<0)
					   timeUnits=(-timeUnits);
		return timeUnits;
		
	}
	

}
