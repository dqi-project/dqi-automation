package com.dqi.process;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dqi.common.ApplicationConstants;
import com.dqi.compute.BaseMeasuresCalculator;
import com.dqi.compute.DataCollectionCompute;
import com.dqi.compute.DevTeamDataAggregator;
import com.dqi.compute.QATeamDataAggregator;
import com.dqi.compute.SetupParametersCalculator;
import com.dqi.jira.DevDataFactory;
import com.dqi.jira.DevTeamDataReader;
import com.dqi.reader.JiraDevTeamDataReader;
import com.dqi.reader.QATeamDataReader;
import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.DataCollectionVO;
import com.dqi.vo.DevTeamDataAggregatorVO;
import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqi.vo.QATeamDataAggregatorVO;
import com.dqi.vo.QATeamMemberDetailsVO;
import com.dqi.vo.SetupParametersVO;
import com.dqi.writer.DQIDataWriter;

/**
 * 
 * This is the final class which is used to invoke the methods of all the
 * classes. finally it writes the data in the final excel sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class DQIDataProcessor {
	
@Autowired
QATeamDataAggregator qATeamDataAggregator;

	public void process() throws IOException {
		QATeamDataReader qaTeamDataReader = new QATeamDataReader();
		DevTeamDataAggregator devTeamDataAggregator = new DevTeamDataAggregator();
		//QATeamDataAggregator qATeamDataAggregator = new QATeamDataAggregator();
		System.out.println("AAAAAAAAAAAAA"+ qATeamDataAggregator);
		SetupParametersCalculator setupParametersCalculator = new SetupParametersCalculator();
		BaseMeasuresCalculator baseMeasuresCalculator = new BaseMeasuresCalculator();
		DataCollectionCompute dataCollection = new DataCollectionCompute();
		DQIDataWriter dQIDataWriter = new DQIDataWriter();
		DevDataFactory devDataFactory = new DevDataFactory();

		// ---------------Object of DevTeamDataReader interface which is getting
		// the instance of fileType from DevDataFactory method
		
		
		
		DevTeamDataReader devTeamDataReader = devDataFactory.getInstance();
		System.out.println("devTeamDataReader=="+devTeamDataReader);

		// -----------List of DevTeamDetailsVO which contains devTeam
		// data----------------------
		List<DevTeamMemberDetailsVO> devmemberlist = devTeamDataReader.readDevTeamData();
		
	//	List<DevTeamMemberDetailsVO> membersList =jiraDevTeamDataReader.readDevTeamData();
		// -----------List of QATeamDetailsVO which contains QATeam
		// data----------------------
		List<QATeamMemberDetailsVO> qAmemberlist = qaTeamDataReader.readQaTeamData();
		// -------------------Map of DataCollectionCompute class which contains
		// aggregated analysis and dev efforts of dev team.
		Map<String, DataCollectionVO> dataCollectionMap = dataCollection.aggregateDevTeam(devmemberlist);

		// ------------DevTeamDataAggregatorVO-----------------

		DevTeamDataAggregatorVO devTeamDataAggregatorVO = devTeamDataAggregator.aggregateDevTeamData(devmemberlist);

		// -------------QATeamDataAggregatorVO------------------
		QATeamDataAggregatorVO qATeamDataAggregatorVO = qATeamDataAggregator.aggregateQATeamData(qAmemberlist);
		// ----------------BaseMeasuresVO-------------
				BaseMeasuresVO baseMeasuresVO = baseMeasuresCalculator.calculateBaseMeasures(qATeamDataAggregatorVO);
		// ------------------SetupParametersVO-------------
		SetupParametersVO setupParametersVO = setupParametersCalculator
				.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO,baseMeasuresVO);
		

		// -----------------write method used to write the data in the final
		// sheet ---------------------

		dQIDataWriter.write(setupParametersVO, dataCollectionMap, qAmemberlist, baseMeasuresVO);

	
	}

	/*
	  public static void main(String[] args) throws IOException {
	  DQIDataProcessor dQIDataProcessor = new DQIDataProcessor();
	  dQIDataProcessor.process(); }
	*/

}