package com.tcs.bits.dynamicautomation.action;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.openqa.jetty.html.Input;

import com.tcs.bits.dynamicautomation.gui.ExecutionOutput;
import com.tcs.bits.dynamicautomation.to.Config;
import com.tcs.bits.dynamicautomation.to.DataSet;
import com.tcs.bits.dynamicautomation.to.Output;
import com.thoughtworks.xstream.XStream;

public class InputReader {

	public void StartProcessing(String testingURL, String dataPath, String configPath, boolean isChrome){
		
		String browser = "Chrome"; //default
		
		if(isChrome)
		 browser = "Chrome";
		
		List<DataSet> datasetArray;
		Config config;
		
		
		try {
			datasetArray = InputReader.ReadXML(dataPath);
			config = InputReader.ReadConfigXML(configPath);
			Output outputTO = Validation.StartVerification(datasetArray, browser, testingURL,config);
			ExecutionOutput.runOutputPanel(outputTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<DataSet> ReadXML(String dataXML) throws FileNotFoundException {

		FileReader fileReader = new FileReader(dataXML);
		XStream xstream = new XStream();
		xstream.alias("dataset", DataSet.class);
		List<DataSet> dataSet = (List<DataSet>) xstream.fromXML(fileReader);

		return dataSet;

	}
	
	public static Config ReadConfigXML(String configXML) throws FileNotFoundException {

		FileReader fileReader1 = new FileReader(configXML);
		XStream xstream = new XStream();
		xstream.alias("config", Config.class);
		Config config = (Config) xstream.fromXML(fileReader1);
		
		return config;

	}

}
