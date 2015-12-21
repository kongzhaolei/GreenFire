package com.needle.greenfire.po;

public class Result {
	private int pid;
	private int tcid;
	private int tsid;
	private String results;
	private String errorimage;
	private String runTime;

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTcid() {
		return this.tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public int getTsid() {
		return this.tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public String getResults() {
		return this.results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getErrorimage() {
		return this.errorimage;
	}

	public void setErrorimage(String errorimage) {
		this.errorimage = errorimage;
	}

	public String getRunTime() {
		return this.runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
}
