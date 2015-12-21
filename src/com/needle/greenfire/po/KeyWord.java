package com.needle.greenfire.po;

public class KeyWord {
	private int id;
	private String keyname;
	private String parameter;
	private String note;
	private String createTime;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyname() {
		return this.keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
