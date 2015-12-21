package com.needle.greenfire.po;

public class Setting {
	private int sid;
	private int pid;
	private String aliasName;
	private String remodeUrl;
	private String localIP;
	private String createTime;

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getRemodeUrl() {
		return this.remodeUrl;
	}

	public void setRemodeUrl(String remodeUrl) {
		this.remodeUrl = remodeUrl;
	}

	public String getLocalIP() {
		return this.localIP;
	}

	public void setLocalIP(String localIP) {
		this.localIP = localIP;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
