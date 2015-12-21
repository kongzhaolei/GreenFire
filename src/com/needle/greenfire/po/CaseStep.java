package com.needle.greenfire.po;

public class CaseStep {
	private int tsid;
	private String note;
	private String kname;
	private String locator;
	private String locatorValue;
	private String strValue;
	private int tcid;
	private String createTime;

	public int getTsid() {
		return this.tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public String getKname() {
		return this.kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
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

	public String getStrValue() {
		return this.strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTcid() {
		return this.tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
