package com.tcs.bits.dynamicautomation.to;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("config")
public class Config {
	
	private String ieDriverPath;
	private String chromeDriverPath;
	private String screenshotsPath;
	private String logsPath;
	
	
	
	public String getLogsPath() {
		return logsPath;
	}
	public void setLogsPath(String logsPath) {
		this.logsPath = logsPath;
	}
	public String getIeDriverPath() {
		return ieDriverPath;
	}
	public void setIeDriverPath(String ieDriverPath) {
		this.ieDriverPath = ieDriverPath;
	}
	public String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}
	public String getScreenshotsPath() {
		return screenshotsPath;
	}
	public void setScreenshotsPath(String screenshotsPath) {
		this.screenshotsPath = screenshotsPath;
	}
	
	

}
