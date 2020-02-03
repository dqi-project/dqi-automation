package com.dqi.process;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.burndown.ui.DQISaveFrame;
import com.burndown.ui.errordialog.DQIInvalidExcelSheetErrorDialog;
import com.burndown.ui.errordialog.DQIStringFoundErrorDialog;
import com.burndown.util.Constant;
import com.burndown.util.DQIVariables;
import com.dqi.compute.BaseMeasuresCalculator;
import com.dqi.compute.DataCollectionCompute;
import com.dqi.compute.DevTeamDataAggregator;
import com.dqi.compute.QATeamDataAggregator;
import com.dqi.compute.SetupParametersCalculator;
import com.dqi.jira.DevDataFactory;
import com.dqi.jira.DevTeamDataReader;
import com.dqi.reader.QATeamDataReader;
import com.dqi.vo.BaseMeasuresVO;
import com.dqi.vo.DataCollectionVO;
import com.dqi.vo.DevTeamDataAggregatorVO;
import com.dqi.vo.DevTeamMemberDetailsVO;
import com.dqi.vo.QATeamDataAggregatorVO;
import com.dqi.vo.QATeamMemberDetailsVO;
import com.dqi.vo.SetupParametersVO;
import com.dqi.writer.DQIDataWriter;
import com.dqiAutomation.exception.DQIInvalidExcelSheetException;

/**
 * 
 * This is the final class which is used to invoke the methods of all the
 * classes. finally it writes the data in the final excel sheet.
 * 
 * @author akansha.chaudhary
 *
 */
public class DQIDataProcessor {

	private static final Logger logger = Logger.getLogger(DQIDataProcessor.class);
	List<QATeamMemberDetailsVO> qAmemberlist;

	public void process() {

		QATeamDataReader qaTeamDataReader = new QATeamDataReader();
		DevTeamDataAggregator devTeamDataAggregator = new DevTeamDataAggregator();
		QATeamDataAggregator qATeamDataAggregator = new QATeamDataAggregator();
		SetupParametersCalculator setupParametersCalculator = new SetupParametersCalculator();
		BaseMeasuresCalculator baseMeasuresCalculator = new BaseMeasuresCalculator();
		DataCollectionCompute dataCollection = new DataCollectionCompute();
		DQIDataWriter dQIDataWriter = new DQIDataWriter();
	
		DevDataFactory devDataFactory = new DevDataFactory();

		// ---------------Object of DevTeamDataReader interface which is getting
		// the instance of fileType from DevDataFactory method

		logger.info("Application started successfully");

		DevTeamDataReader devTeamDataReader = devDataFactory.getInstance();

		try {

			// -----------List of DevTeamDetailsVO which contains devTeam
			// data----------------------
			List<DevTeamMemberDetailsVO> devmemberlist = devTeamDataReader.readDevTeamData();

			// -----------List of QATeamDetailsVO which contains QATeam
			// data----------------------		
 				qAmemberlist = qaTeamDataReader.readQaTeamData();
			
				// -------------------Map of DataCollectionCompute class which
				// contains aggregated analysis and dev efforts of dev team.
				Map<String, DataCollectionVO> dataCollectionMap = dataCollection.aggregateDevTeam(devmemberlist);

				// ------------DevTeamDataAggregatorVO-----------------

				DevTeamDataAggregatorVO devTeamDataAggregatorVO = devTeamDataAggregator
						.aggregateDevTeamData(devmemberlist);

				// -------------QATeamDataAggregatorVO------------------
				QATeamDataAggregatorVO qATeamDataAggregatorVO = qATeamDataAggregator.aggregateQATeamData(qAmemberlist);

				// ----------------BaseMeasuresVO-------------
				BaseMeasuresVO baseMeasuresVO = baseMeasuresCalculator.calculateBaseMeasures(qATeamDataAggregatorVO);

				// ------------------SetupParametersVO-------------
				SetupParametersVO setupParametersVO = setupParametersCalculator
						.calculateSetupParameters(devTeamDataAggregatorVO, qATeamDataAggregatorVO, baseMeasuresVO);

				// -----------------write method used to write the data in the
				// final sheet ---------------------

				DQIVariables.getInstance().setOpenSaveFrame(true);
					
			if(DQIVariables.getInstance().isWriteExcel())
			  dQIDataWriter.write(setupParametersVO, dataCollectionMap, qAmemberlist,  baseMeasuresVO);
			 
			
			DQIVariables.getInstance().setFileName(null);
		} catch (IllegalStateException errorMessage) {
			new DQIStringFoundErrorDialog();
			logger.error("Exception in DQIData processor class ", errorMessage);
		} catch (FileNotFoundException errorMessage) {
			new DQIInvalidExcelSheetErrorDialog();
			logger.error("Exception in DQIData processor class ", errorMessage);
		} catch (IOException errorMessage) {
			new DQIInvalidExcelSheetErrorDialog();
			logger.error("Exception in DQIData processor class ", errorMessage);
		} catch (DQIInvalidExcelSheetException errorMessage) {	
			new DQIInvalidExcelSheetErrorDialog();
			logger.error("Exception in DQIData processor class ", errorMessage);
		} catch (Exception e) {
			new DQIInvalidExcelSheetErrorDialog();
	logger.error("Exception in DQIData processor class ", e);

}
	}

}