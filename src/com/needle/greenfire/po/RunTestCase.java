package com.needle.greenfire.po;

public class RunTestCase {
	private int tcid;
	private String runmode;
	private int tsid;
	private String kname;
	private String parameter;
	private String pageObject;
	private String strValue;

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

	public String getRunmode() {
		return this.runmode;
	}

	public void setRunmode(String runmode) {
		this.runmode = runmode;
	}

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

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getPageObject() {
		return this.pageObject;
	}

	public void setPageObject(String pageObject) {
		this.pageObject = pageObject;
	}
}
