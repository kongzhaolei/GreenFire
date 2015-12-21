package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.LocatorDao;
import com.needle.greenfire.po.LocatName;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocatorDaoImpl implements LocatorDao {
	public List<LocatName> findLocatNameInfo() {
		List<LocatName> LocatNameInfoList = new ArrayList<LocatName>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select locatorName from locator";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				LocatNameInfoList
						.add(new LocatName(rs.getString("locatorName")));
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
		return LocatNameInfoList;
	}
}
