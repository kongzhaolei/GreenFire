package com.needle.greenfire.po;

public class Log {
	private int logid;
	private String className;
	private String method;
	private String createTime;
	private String loglevel;
	private String logmsg;

	public Log(int logid, String className, String method, String createTime,
			String loglevel, String logmsg) {
		this.logid = logid;
		this.className = className;
		this.method = method;
		this.createTime = createTime;
		this.loglevel = loglevel;
		this.logmsg = logmsg;
	}

	public int getLogid() {
		return this.logid;
	}

	public void setLogid(int logid) {
		this.logid = logid;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLoglevel() {
		return this.loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	public String getLogmsg() {
		return this.logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}
}
