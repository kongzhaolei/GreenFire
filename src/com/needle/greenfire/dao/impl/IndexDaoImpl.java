package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.IndexDao;
import com.needle.greenfire.po.IndexInfo;
import com.needle.greenfire.po.RunCase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexDaoImpl implements IndexDao {
	public List<RunCase> findCaseRunInfo() {
		List<RunCase> runCases = new ArrayList<RunCase>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select (SUM(casenum)-SUM(failnum))as passnum ,SUM(failnum)as failnum from project";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				runCases.add(new RunCase("PASS", rs.getInt("passnum")));
				runCases.add(new RunCase("FAIL", rs.getInt("failnum")));
			}
		} catch (Exception localException) {
			try {
				rs.close();
				ps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				ps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return runCases;
	}

	public List<IndexInfo> findIndexInfo() {
		List<IndexInfo> indeInfoList = new ArrayList<IndexInfo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select proname as name,casenum as CaseNum,(casenum - failnum) as PassNum,failnum as FailNum from project";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				indeInfoList.add(new IndexInfo(rs.getString("name"), rs
						.getInt("CaseNum"), rs.getInt("PassNum"), rs
						.getInt("FailNum")));
		} catch (Exception localException) {
			try {
				rs.close();
				ps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				ps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return indeInfoList;
	}
}
