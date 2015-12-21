package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.UserDao;
import com.needle.greenfire.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {
	public User userLogin(String name, String password) {
		User user = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from user where username=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if ((rs.next()) && (password.equals(rs.getString("password")))) {
				user.setId(Integer.valueOf(rs.getInt("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setState(rs.getString("state"));
				user.setCreateTime(rs.getString("createTime"));
				User localUser1 = user;
				return localUser1;
			}
		} catch (Exception localException) {
		} finally {
			try {
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			pstmt.close();
			dbUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public User SelectOneUser(String uid) {
		User user = new User();
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from user where id = ? ";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, uid);
			rs = pre.executeQuery();
			if (rs.next()) {
				user.setId(Integer.valueOf(rs.getInt("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setState(rs.getString("state"));
				user.setCreateTime(rs.getString("createTime"));
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
		return user;
	}

	public Map<Integer, User> findAllUsers() {
		Map<Integer, User> userMap = new HashMap<Integer, User>();
		DbUtil dao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user";
		try {
			dao = new DbUtil();
			ps = dao.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(Integer.valueOf(rs.getInt("id")));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setState(rs.getString("state"));
				user.setCreateTime(rs.getString("createTime"));
				userMap.put(new Integer(user.getId().intValue()), user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				rs.close();
				ps.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userMap;
	}

	public boolean addUser(User user) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into user values(null,?,?,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getState());
			pstmt.setString(6, user.getCreateTime());
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

	public boolean updateUser(User user) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update user set password = ? , email = ? , phone = ? , state = ?  where username = ?";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, user.getPassword());
			pre.setString(2, user.getEmail());
			pre.setString(3, user.getPhone());
			pre.setString(4, user.getState());
			pre.setString(5, user.getUsername());
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

	public boolean deleteUsers(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from user where id=?";
		try {
			daoUtil = new DbUtil();
			conn = daoUtil.getCon();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int j = 0; j < ids.length; j++) {
				ps.setInt(1, ids[j]);
				ps.addBatch();
			}
			int[] k = ps.executeBatch();
			conn.commit();
			if (k.length == ids.length)
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

	public Boolean checkPassWord(String name, String password) {
		Boolean fly = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet re = null;
		String sql = "select * from user where username = ? ";

		label171: try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, name);
			re = pre.executeQuery();
			if (re.next()) {
				if (!re.getString("password").equals(password)) {
					fly = Boolean.valueOf(false);
					break label171;
				}
				fly = Boolean.valueOf(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				re.close();
				pre.close();
				dao.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				re.close();
				pre.close();
				dao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return fly;
	}

	public boolean checkNameExist(String name) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from user where name=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
