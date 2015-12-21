package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.CaseStepDao;
import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.ReportCaseStep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaseStepDaoImpl implements CaseStepDao {
	public List<ReportCaseStep> FindCaseStepInfo(int pid) {
		List<ReportCaseStep> reportCaseSteps = new ArrayList<ReportCaseStep>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "SELECT r.tcid AS tcid, r.tsid AS tsid ,cs.note AS note ,cs.kname as kname,cs.locator as locator,cs.locatorValue as locatValue,cs.strValue as strvalue,r.results AS result,r.errorimage AS errorimage FROM result AS r LEFT JOIN casestep AS cs ON r.tsid = cs.tsid WHERE TO_DAYS(NOW()) - TO_DAYS(r.runTime)<=1 AND r.pid = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next())
				reportCaseSteps.add(new ReportCaseStep(rs.getInt("tcid"), rs
						.getInt("tsid"), rs.getString("note"), rs
						.getString("kname"), rs.getString("locator"), rs
						.getString("locatValue"), rs.getString("strvalue"), rs
						.getString("result"), rs.getString("errorimage")));
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
		return reportCaseSteps;
	}

	public boolean addCaseStep(CaseStep caseStep) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into casestep values(?,?,?,?,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, caseStep.getTsid());
			pstmt.setString(2, caseStep.getNote());
			pstmt.setString(3, caseStep.getKname());
			pstmt.setString(4, caseStep.getLocator());
			pstmt.setString(5, caseStep.getLocatorValue());
			pstmt.setString(6, caseStep.getStrValue());
			pstmt.setInt(7, caseStep.getTcid());
			pstmt.setString(8, caseStep.getCreateTime());
			int count = pstmt.executeUpdate();
			if (count != 0)
				flag = true;
		} catch (Exception e) {
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

	public List<CaseStep> FindCaseStepInfo(int pid, int tcid) {
		List<CaseStep> cslist = new ArrayList<CaseStep>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "SELECT * from casestep WHERE tcid in (SELECT tcid from testcase where pid=? and tcid = ?)";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, tcid);
			rs = ps.executeQuery();
			while (rs.next()) {
				CaseStep cs = new CaseStep();
				cs.setTcid(rs.getInt("tcid"));
				cs.setTsid(rs.getInt("tsid"));
				cs.setNote(rs.getString("note"));
				cs.setKname(rs.getString("kname"));
				cs.setLocator(rs.getString("locator"));
				cs.setLocatorValue(rs.getString("locatorValue"));
				cs.setStrValue(rs.getString("strValue"));
				cs.setCreateTime(rs.getString("createTime"));
				cslist.add(cs);
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
		return cslist;
	}

	public boolean checkCaseStepID(int pid, int tcid, int tsid) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "SELECT * FROM testcase as tc LEFT JOIN casestep AS cs ON tc.tcid = cs.tcid WHERE tc.pid = ? AND tc.tcid = ? AND cs.tsid = ?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, tcid);
			pstmt.setInt(3, tsid);
			rs = pstmt.executeQuery();
			if (rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateCaseStep(CaseStep caseStep) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update casestep set note = ?,kname = ? , locator = ?,locatorValue =?,strValue =? where tcid=? and tsid = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, caseStep.getNote());
			pre.setString(2, caseStep.getKname());
			pre.setString(3, caseStep.getLocator());
			pre.setString(4, caseStep.getLocatorValue());
			pre.setString(5, caseStep.getStrValue());
			pre.setInt(6, caseStep.getTcid());
			pre.setInt(7, caseStep.getTsid());
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
