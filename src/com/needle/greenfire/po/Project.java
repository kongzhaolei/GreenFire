package com.needle.greenfire.po;

public class Project {
	private int pid;
	private String proname;
	private String describe;
	private String createTime;

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
