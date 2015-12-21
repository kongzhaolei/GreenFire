package com.needle.greenfire.po;

public class IndexInfo {
	private String Name;
	private int CaseNum;
	private int PassNum;
	private int FailNum;

	public IndexInfo(String name, int casenum, int passnum, int failnum) {
		this.Name = name;
		this.CaseNum = casenum;
		this.PassNum = passnum;
		this.FailNum = failnum;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getCaseNum() {
		return this.CaseNum;
	}

	public void setCaseNum(int caseNum) {
		this.CaseNum = caseNum;
	}

	public int getPassNum() {
		return this.PassNum;
	}

	public void setPassNum(int passNum) {
		this.PassNum = passNum;
	}

	public int getFailNum() {
		return this.FailNum;
	}

	public void setFailNum(int failNum) {
		this.FailNum = failNum;
	}
}
