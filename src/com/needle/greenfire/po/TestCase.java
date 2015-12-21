package com.needle.greenfire.po;

public class TestCase {
	private String pName;
	private int tcid;
	private String title;
	private String runmode;
	private int pid;
	private String createTime;

	public TestCase() {
	}

	public TestCase(int tcid, String title, String runmode, int pid,
			String createTime) {
		this.tcid = tcid;
		this.title = title;
		this.runmode = runmode;
		this.pid = pid;
		this.createTime = createTime;
	}

	public String getpName() {
		return this.pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
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

	public String getRunmode() {
		return this.runmode;
	}

	public void setRunmode(String runmode) {
		this.runmode = runmode;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
