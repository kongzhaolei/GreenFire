package com.needle.greenfire.dao.impl;

import com.needle.greenfire.Model.Model;
import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.CaseDao;
import com.needle.greenfire.po.ReportCase;
import com.needle.greenfire.po.TestCase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaseDaoImpl implements CaseDao {
	public boolean AddTestCase(TestCase testCase) {
		Model model = new Model();
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into testcase values(null,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, testCase.getTitle());
			pstmt.setString(2, testCase.getRunmode());
			pstmt.setInt(3, testCase.getPid());
			pstmt.setString(4, testCase.getCreateTime());
			int count = pstmt.executeUpdate();
			if ((count != 0) && (model.updateProCaseNum(testCase.getPid())))
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

	public List<TestCase> FindProCaseInfo(int pid) {
		List<TestCase> caseInfoList = new ArrayList<TestCase>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from testcase where pid = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next())
				caseInfoList.add(new TestCase(rs.getInt("tcid"), rs
						.getString("title"), rs.getString("runmode"), rs
						.getInt("pid"), rs.getString("createTime")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return caseInfoList;
	}

	public List<ReportCase> FindReportCaseInfo(int pid) {
		List<ReportCase> reportCases = new ArrayList<ReportCase>();
		PreparedStatement rcps = null;
		ResultSet rcrs = null;
		DbUtil dbUtil = null;
		PreparedStatement tsps = null;
		ResultSet tsrs = null;
		String csSql = "SELECT  r.tcid AS tcid ,r.results AS result,COUNT(DISTINCT r.tcid) FROM result AS r LEFT JOIN casestep AS cs ON r.tsid = cs.tsid WHERE TO_DAYS(NOW()) - TO_DAYS(r.runTime)<=1 AND r.pid = ? and r.tcid = ? GROUP BY r.tsid ";
		String sql = "select r.tcid AS tcid,tc.title AS title,COUNT(DISTINCT r.tcid) FROM result AS r LEFT JOIN testcase AS tc ON r.tcid = tc.tcid WHERE TO_DAYS(NOW()) - TO_DAYS(r.runTime)<=1 AND r.pid = ? GROUP BY r.tcid ";
		try {
			dbUtil = new DbUtil();
			rcps = dbUtil.getCon().prepareStatement(sql);
			rcps.setInt(1, pid);
			rcrs = rcps.executeQuery();
			while (rcrs.next()) {
				int tcid = rcrs.getInt("tcid");
				tsps = dbUtil.getCon().prepareStatement(csSql);
				tsps.setInt(1, pid);
				tsps.setInt(2, tcid);
				tsrs = tsps.executeQuery();
				boolean flag = true;
				while (tsrs.next()) {
					if ((tcid != tsrs.getInt("tcid"))
							|| (tsrs.getString("result").trim().equals("PASS")))
						continue;
					flag = false;
				}

				if (flag)
					reportCases.add(new ReportCase(tcid, rcrs
							.getString("title"), "PASS"));
				else {
					reportCases.add(new ReportCase(tcid, rcrs
							.getString("title"), "FAIL"));
				}
				tsrs.close();
				tsps.close();
			}
		} catch (Exception localException) {
			try {
				rcrs.close();
				rcps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				rcrs.close();
				rcps.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return reportCases;
	}

	public int getAddTestCaseID(int pid, String title) {
		int caseid = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select tcid from testcase where pid = ? and title = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, title);
			rs = ps.executeQuery();
			while (rs.next())
				caseid = rs.getInt("tcid");
		} catch (Exception e) {
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
		return caseid;
	}

	public TestCase findTestCaseInfo(int pid, int tcid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "SELECT p.pid as pid,p.proname,tc.tcid,tc.title,tc.runmode FROM project AS p LEFT JOIN testcase AS tc ON p.pid = tc.pid WHERE p.pid = ? and tc.tcid= ?";
		TestCase tc = new TestCase();
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, tcid);
			rs = ps.executeQuery();
			while (rs.next()) {
				tc.setTcid(rs.getInt("tcid"));
				tc.setTitle(rs.getString("title"));
				tc.setRunmode(rs.getString("runmode"));
				tc.setPid(rs.getInt("pid"));
				tc.setpName(rs.getString("proname"));
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
		return tc;
	}

	public boolean updateTestCase(TestCase testCase) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update testcase set title = ?,runmode = ? where tcid = ? and pid = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, testCase.getTitle());
			pre.setString(2, testCase.getRunmode());
			pre.setInt(3, testCase.getTcid());
			pre.setInt(4, testCase.getPid());
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
