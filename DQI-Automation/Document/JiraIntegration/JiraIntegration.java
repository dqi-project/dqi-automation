package com.dqi.jira;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Akansha.chaudhary
 *
 */
public class JiraIntegration {

	public static void main(String[] args) {
		String loginResponse = "";
		String jSessionID = "";
		String jsonData = "";
		String csvData = "";
		String writeToFillOutput = "";
		String baseURL = "https://jira.hl7.org/login.jsp?os_destination=https%3A%2F%2Fjira.hl7.org%2Fplugins%2Fservlet%2Fmobile%23myjirahome";
		String loginURL = "auth/1/session";
		String biExportURL = "getbusinessintelligenceexport/1.0/message";
		String analysisStartDate = "01-APR-20";
		String analysisEndDate = "30-Apr-20";
		String loginUserName = "admin";
		String loginPassword = "admin";
		boolean errorsOccured = false;
		String exportDirectory="./downloads/";

		if (!errorsOccured) {

			loginResponse = loginToJira(baseURL, loginURL, loginUserName, loginPassword);
			if (loginResponse == "ERROR") {
				errorsOccured = true;
			}
		}

		if (!errorsOccured) {
			jSessionID = parseJSessionID(loginResponse);
			if (jSessionID == "ERROR") {
				errorsOccured = true;
			}
		}

		if (!errorsOccured) {
			jsonData = getJsonData(baseURL, biExportURL, jSessionID, analysisStartDate, analysisEndDate);

			if (jsonData == "ERROR") {
				errorsOccured = true;
			}
		}
		if (!errorsOccured) {
			csvData = formatAsCSV(jsonData);
			if (csvData == "ERROR") {
				errorsOccured = true;
			}
		}
		if (!errorsOccured) {
			writeToFillOutput = writeToFile(csvData,exportDirectory);
			if (writeToFillOutput == "ERROR") {
				errorsOccured = true;
			}
		}

		else {
			System.out.println("running successfully");
		}
	}

	private static String loginToJira(String baseURL, String loginURL, String loginUserName, String loginPassword) {
		String loginResponse = "";
		URL url = null;
		HttpURLConnection conn = null;
		String input = "";
		OutputStream os = null;
		BufferedReader br = null;
		String output = null;

		try {
			// create url object
			url = new URL(baseURL + loginURL);
			// use the url to ceate connection
			conn = (HttpURLConnection) url.openConnection();
			// set properties
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Conent-Type", "application/json");

			// create json post data

			input = "{\"username\":\"" + loginUserName + "\",\"password\":\"" + loginPassword + "\"}";

			// send our request
			os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			// handle out response

			if (conn.getResponseCode() == 200) {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while ((output = br.readLine()) != null) {
					loginResponse += output;
				}
				conn.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
			loginResponse = "ERROR";

		}
		return loginResponse;
	}

	private static String parseJSessionID(String input) {
		String jSessionID = "";
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(input);
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject sessionJsonObject = (JSONObject) jsonObject.get("session");
			jSessionID = (String) sessionJsonObject.get("value");

		} catch (Exception e) {
			System.out.println("Error in parseJSessionID" + e.getMessage());
			jSessionID = "ERROR";
		}
		System.out.println("SessionID:");
		System.out.println(jSessionID);
		return jSessionID;
	}

	private static String getJsonData(String baseURL, String biExportURL, String jSessionID, String analysisStartDate,
			String analysisEndDate) {
		String jsonData = "";
		try {
			URL url = new URL(baseURL + "api/2/issue/picker" + "?currentJQL=assignee%3Dadmin");
			String cookie = "JSESSIONID=" + jSessionID;
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Cookie", cookie);
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String output = "";
				while ((output = br.readLine()) != null) {
					jsonData += output;
				}
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("ERROR in getJsonData" + e.getMessage());
			jsonData = "ERROR";
		}
		System.out.println("\njsonData");
		System.out.println(jsonData);
		return jsonData;
	}

	private static String formatAsCSV(String jsonData) {
		String csvData = "";
		try {
			JSONParser parser = new JSONParser();
			JSONArray records = null;
			String headerRow = "";
			String dataRows = "";

			String[] arrColNames = { "column's name need to be filled" };
			List<String> colNames = Arrays.asList(arrColNames);
			for (int i = 0; i < colNames.size(); i++) {
				headerRow += colNames.get(i) + ",";

			}
			headerRow = headerRow.replaceAll(",$", "\n");
			Object obj = parser.parse(jsonData);
			JSONObject jsonvalue = (JSONObject) obj;
			records = (JSONArray) jsonvalue.get("records");
			Iterator iterRecords = records.iterator();

			while (iterRecords.hasNext()) {

				JSONObject thisRecord = (JSONObject) iterRecords.next();
				String strRecord = "";
				for (int i = 0; i < colNames.size(); i++) {
					String thisColName = colNames.get(i);
					strRecord += "\"" + (String) thisRecord.get(thisColName) + "\",";

				}
				strRecord = strRecord.replaceAll(",$", "\n");
				dataRows += strRecord;
			}

		} catch (Exception e) {
			System.out.println("ERROR in csvData" + e.getMessage());
			csvData = "ERROR";
		}
		System.out.println("\ncsvData");
		System.out.println(csvData);// TODO: handle exception

		return csvData;
	}

	private static String writeToFile(String csvData,String exportDirectory) {
		String writeToFillOutput = "";
		try {
			String currentTimeStamp=new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new java.util.Date());
			BufferedWriter writer=new BufferedWriter(new FileWriter(exportDirectory+"JiraIssues_"+currentTimeStamp+".csv"));
			writer.write(csvData);
			writer.close();
			
		} catch (Exception e) {
			System.out.println("ERROR in writeToFillOutput" + e.getMessage());
			writeToFillOutput = "ERROR";
		}
		System.out.println("\nwriteToFillOutput");
		System.out.println(writeToFillOutput);// TODO: handle exception

		return writeToFillOutput;
	}

}
