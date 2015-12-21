package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.KeyWordDao;
import com.needle.greenfire.po.KeyName;
import com.needle.greenfire.po.KeyWord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyWordDaoImpl implements KeyWordDao {
	public boolean addKeyword(KeyWord keyWord) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into keyword values(null,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, keyWord.getKeyname());
			pstmt.setString(2, keyWord.getParameter());
			pstmt.setString(3, keyWord.getNote());
			pstmt.setString(4, keyWord.getCreateTime());
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

	public boolean updateKeyword(KeyWord keyWord) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update keyword set keyname = ?,parameter = ? , note = ?  where id = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, keyWord.getKeyname());
			pre.setString(2, keyWord.getParameter());
			pre.setString(3, keyWord.getNote());
			pre.setInt(4, keyWord.getId());
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

	public boolean deleteKeyWord(int[] kids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from keyword where id=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int j = 0; j < kids.length; j++) {
				ps.setInt(1, kids[j]);
				ps.addBatch();
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if (k.length == kids.length)
				return true;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ps.close();
				daoUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			ps.close();
			daoUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Map<Integer, KeyWord> findAllKeyWord() {
		Map<Integer, KeyWord> keyMap = new HashMap<Integer, KeyWord>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from keyword";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				KeyWord keyWord = new KeyWord();
				keyWord.setId(rs.getInt("id"));
				keyWord.setKeyname(rs.getString("keyname"));
				keyWord.setParameter(rs.getString("parameter"));
				keyWord.setNote(rs.getString("note"));
				keyWord.setCreateTime(rs.getString("CreateTime"));
				keyMap.put(new Integer(keyWord.getId()), keyWord);
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
		return keyMap;
	}

	public KeyWord getKeyWordInfo(int kid) {
		KeyWord keyWord = new KeyWord();
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from keyword where id = ? ";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setInt(1, kid);
			rs = pre.executeQuery();
			if (rs.next()) {
				keyWord.setId(rs.getInt("id"));
				keyWord.setKeyname(rs.getString("keyname"));
				keyWord.setParameter(rs.getString("parameter"));
				keyWord.setNote(rs.getString("note"));
				keyWord.setCreateTime(rs.getString("createTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				rs.close();
				pre.close();
				dao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				pre.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return keyWord;
	}

	public List<KeyName> findKeyNameInfo() {
		List<KeyName> keynameInfoList = new ArrayList<KeyName>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select keyname from keyword";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				keynameInfoList.add(new KeyName(rs.getString("keyname")));
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
		return keynameInfoList;
	}
}
