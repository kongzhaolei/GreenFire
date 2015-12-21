package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.SettingDao;
import com.needle.greenfire.po.Setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SettingDaoImpl implements SettingDao {
	public String getRemodeURL(int pid, String localURL) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select remodeURL from setting where pid = ? and localIP = ?";
		String remodeURL = null;
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, localURL);
			rs = ps.executeQuery();
			while (rs.next())
				remodeURL = rs.getString("remodeURL");
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
		return remodeURL;
	}

	public boolean addProjectSetting(Setting setting) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into setting values(null,?,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, setting.getPid());
			pstmt.setString(2, setting.getAliasName());
			pstmt.setString(3, setting.getRemodeUrl());
			pstmt.setString(4, setting.getLocalIP());
			pstmt.setString(5, setting.getCreateTime());
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

	public Map findSettingInfo(int pid) {
		Map SettingMap = new HashMap();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from setting where pid = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Setting setting = new Setting();
				setting.setSid(rs.getInt("sid"));
				setting.setPid(rs.getInt("pid"));
				setting.setAliasName(rs.getString("aliasName"));
				setting.setRemodeUrl(rs.getString("remodeURL"));
				setting.setLocalIP(rs.getString("localIP"));
				setting.setCreateTime(rs.getString("CreateTime"));
				SettingMap.put(Integer.valueOf(setting.getSid()), setting);
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
		return SettingMap;
	}

	public Setting getSettingInfo(int sid, int pid) {
		Setting setting = new Setting();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from setting where sid = ? and pid = ?";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setInt(2, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				setting.setSid(rs.getInt("sid"));
				setting.setPid(rs.getInt("pid"));
				setting.setAliasName(rs.getString("aliasName"));
				setting.setRemodeUrl(rs.getString("remodeURL"));
				setting.setLocalIP(rs.getString("localIP"));
				setting.setCreateTime(rs.getString("CreateTime"));
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
		return setting;
	}

	public boolean updateSetting(Setting setting) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update setting set aliasName = ?,remodeURL = ? , localIP = ?  where sid = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, setting.getAliasName());
			pre.setString(2, setting.getRemodeUrl());
			pre.setString(3, setting.getLocalIP());
			pre.setInt(4, setting.getSid());
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
