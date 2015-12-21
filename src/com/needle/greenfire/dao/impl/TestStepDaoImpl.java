package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.TestStepDao;
import com.needle.greenfire.po.CaseStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestStepDaoImpl implements TestStepDao {
	public boolean addTestSteps(List<CaseStep> casestepList) {
		PreparedStatement ps = null;
		Connection conn = null;
		DbUtil daoUtil = null;
		String sql = "insert into testcase values(?,?,?,?,?,?,?)";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < casestepList.size(); i++)
				;
		} catch (Exception localException) {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
