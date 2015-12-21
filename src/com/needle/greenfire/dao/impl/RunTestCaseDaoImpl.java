package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.RunTestCaseDao;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.po.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunTestCaseDaoImpl implements RunTestCaseDao {
	public List<Project> findProjects() {
		List projects = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from project";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				project.setPid(rs.getInt("pid"));
				project.setProname(rs.getString("proname"));
				project.setDescribe(rs.getString("describes"));
				project.setCreateTime(rs.getString("CreateTime"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				rs.close();
				ps.close();
				dbUtil.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
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
		return projects;
	}

	public List<CaseStep> findCaseSteps(int tcid) {
		List csList = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from casestep where tcid = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, tcid);
			rs = ps.executeQuery();
			while (rs.next()) {
				CaseStep cs = new CaseStep();
				cs.setTsid(rs.getInt("tsid"));
				cs.setNote(rs.getString("note"));
				cs.setKname(rs.getString("kname"));
				cs.setLocator(rs.getString("locator"));
				cs.setLocatorValue(rs.getString("locatorValue"));
				cs.setStrValue(rs.getString("strValue"));
				cs.setTcid(tcid);
				cs.setCreateTime(rs.getString("createTime"));
				csList.add(cs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return csList;
	}

	public boolean addResult(Result result) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into result values(?,?,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, result.getPid());
			pstmt.setInt(2, result.getTcid());
			pstmt.setInt(3, result.getTsid());
			pstmt.setString(4, result.getResults());
			pstmt.setString(5, result.getErrorimage());
			pstmt.setString(6, result.getRunTime());
			int i = pstmt.executeUpdate();
			if (i != 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean updateFailNum(int pid) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update project set failnum = failnum + 1 where pid = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setInt(1, pid);
			pre.addBatch();
			pre.executeBatch();
			flag = Boolean.valueOf(true);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				pre.close();
				dao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pre.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag.booleanValue();
	}
}
