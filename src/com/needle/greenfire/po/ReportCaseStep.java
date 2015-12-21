package com.needle.greenfire.po;

public class ReportCaseStep {
	private int tcid;
	private int tsid;
	private String note;
	private String kname;
	private String locator;
	private String locatorValue;
	private String strValue;
	private String result;
	private String errorimage;

	public ReportCaseStep(int tcid, int tsid, String note, String kname,
			String locator, String locatorValue, String strValue,
			String result, String errorimage) {
		this.tcid = tcid;
		this.tsid = tsid;
		this.note = note;
		this.kname = kname;
		this.locator = locator;
		this.locatorValue = locatorValue;
		this.strValue = strValue;
		this.result = result;
		this.errorimage = errorimage;
	}

	public String getLocator() {
		return this.locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getLocatorValue() {
		return this.locatorValue;
	}

	public void setLocatorValue(String locatorValue) {
		this.locatorValue = locatorValue;
	}

	public String getKname() {
		return this.kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	public String getStrValue() {
		return this.strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
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

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getErrorimage() {
		return this.errorimage;
	}

	public void setErrorimage(String errorimage) {
		this.errorimage = errorimage;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
