package com.dqi.initializer;

public class SearchResponse {
	
	public final static String SEARCH_RESPONSE = "{\r\n" + 
			"    \"expand\": \"schema,names\",\r\n" + 
			"    \"startAt\": 0,\r\n" + 
			"    \"maxResults\": 50,\r\n" + 
			"    \"total\": 116,\r\n" + 
			"    \"issues\": [\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"5656566\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/56655656\",\r\n" + 
			"            \"key\": \"XYZ-3599\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Development\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Rab_Rabbit\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Rab_Rabbit@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=5656556\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=56556\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=55665\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=556556\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Rab Rabbit\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" + 
			"                \"timespent\": 50400,\r\n" + 
			"                \"timeoriginalestimate\": 64800\r\n" + 
			"            }\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"23232323\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/666009\",\r\n" + 
			"            \"key\": \"XYZ-3598\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Analysis\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Rab_Rabbit\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Rab_Rabbit@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=7878787\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=787878\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=878878\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=8787878\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Rab Rabbit\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" + 
			"                \"timespent\": 43200,\r\n" + 
			"                \"timeoriginalestimate\": 43200\r\n" + 
			"            }\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"665226\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/11111111\",\r\n" + 
			"            \"key\": \"XYZ-3594\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Code changes for PBL-3593\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Rab_Rabbit\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Rab_Rabbit@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=1212122\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=12121212\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=1212\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=121212\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Rab Rabbit\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" + 
			"                \"timespent\": 50400,\r\n" + 
			"                \"timeoriginalestimate\": 50400\r\n" + 
			"             }\r\n" + 
			"        }\r\n" + 
			"    ]\r\n" + 
			"}";
	
	
	
	public final static String SEARCH_RESPONSE_PS = "{\r\n" + 
			"    \"expand\": \"schema,names\",\r\n" + 
			"    \"startAt\": 0,\r\n" + 
			"    \"maxResults\": 50,\r\n" + 
			"    \"total\": 116,\r\n" + 
			"    \"issues\": [\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"5656566\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/56655656\",\r\n" + 
			"            \"key\": \"XYZ-3599\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Development\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Rab_Rabbit\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Rab_Rabbit@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=5656556\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=56556\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=55665\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=556556\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Rab Rabbit\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" +  
			"                \"resolutiondate\": \"2020-02-25T15:30:27.000-0800\",\r\n" + 
			"                \"created\": \"2020-02-22T15:30:27.000-0800\"\r\n" + 				
			"            }\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"23232323\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/666009\",\r\n" + 
			"            \"key\": \"XYZ-3598\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Analysis\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Rab_Rabbit\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Rab_Rabbit@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=7878787\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=787878\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=878878\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=8787878\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Rab Rabbit\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" + 
			"                \"resolutiondate\": \"2020-02-20T15:30:27.000-0800\",\r\n" + 
			"                \"created\": \"2020-02-19T15:30:27.000-0800\"\r\n" + 
			"            }\r\n" + 
			"        },\r\n" + 
			"        {\r\n" + 
			"            \"expand\": \"operations,versionedRepresentations,editmeta,changelog,transitions,renderedFields\",\r\n" + 
			"            \"id\": \"665226\",\r\n" + 
			"            \"self\": \"https://ecom.jira.test.com/rest/api/2/issue/11111111\",\r\n" + 
			"            \"key\": \"XYZ-3594\",\r\n" + 
			"            \"fields\": {\r\n" + 
			"                \"summary\": \"Code changes for PBL-3593\",\r\n" + 
			"                \"assignee\": {\r\n" + 
			"                    \"self\": \"https://ecom.jira.test.com/rest/api/2/user?username=Tig_Tiger\",\r\n" + 
			"                    \"name\": \"Rab_Rabbit\",\r\n" + 
			"                    \"key\": \"Rab_Rabbit\",\r\n" + 
			"                    \"emailAddress\": \"Tig_Tiger@test.com\",\r\n" + 
			"                    \"avatarUrls\": {\r\n" + 
			"                        \"48x48\": \"https://ecom.jira.test.com/secure/useravatar?avatarId=1212122\",\r\n" + 
			"                        \"24x24\": \"https://ecom.jira.test.com/secure/useravatar?size=small&avatarId=12121212\",\r\n" + 
			"                        \"16x16\": \"https://ecom.jira.test.com/secure/useravatar?size=xsmall&avatarId=1212\",\r\n" + 
			"                        \"32x32\": \"https://ecom.jira.test.com/secure/useravatar?size=medium&avatarId=121212\"\r\n" + 
			"                    },\r\n" + 
			"                    \"displayName\": \"Tig Tiger\",\r\n" + 
			"                    \"active\": true,\r\n" + 
			"                    \"timeZone\": \"America/Los_Angeles\"\r\n" + 
			"                },\r\n" + 
			"                \"resolutiondate\": \"2020-02-25T15:30:27.000-0800\",\r\n" + 
			"                \"created\": \"2020-02-22T15:30:27.000-0800\"\r\n" + 	
			"             }\r\n" + 
			"        }\r\n" + 
			"    ]\r\n" + 
			"}";

}
