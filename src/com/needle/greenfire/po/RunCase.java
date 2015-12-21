package com.needle.greenfire.po;

public class RunCase {
	private String name;
	private int share;

	public RunCase(String name, int share) {
		this.name = name;
		this.share = share;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShare() {
		return this.share;
	}

	public void setShare(int share) {
		this.share = share;
	}
}
