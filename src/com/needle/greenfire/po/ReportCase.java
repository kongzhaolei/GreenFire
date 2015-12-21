package com.needle.greenfire.po;

public class ReportCase {
	private int tcid;
	private String title;
	private String State;

	public ReportCase(int tcid, String title, String State) {
		this.tcid = tcid;
		this.title = title;
		this.State = State;
	}

	public String getState() {
		return this.State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public int getTcid() {
		return this.tcid;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
