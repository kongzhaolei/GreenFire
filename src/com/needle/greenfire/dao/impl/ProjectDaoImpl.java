package com.needle.greenfire.dao.impl;

import com.needle.greenfire.common.DbUtil;
import com.needle.greenfire.dao.ProjectDao;
import com.needle.greenfire.po.ProInfo;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements ProjectDao {
	public boolean addProject(Project project) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into project values(null,?,?,0,0,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setString(1, project.getProname());
			pstmt.setString(2, project.getDescribe());
			pstmt.setString(3, Utils.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
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

	public boolean deleteProjects(int[] ids) {
		DbUtil daoUtil = null;
		PreparedStatement ps = null;
		Connection conn = null;
		String sql = "delete from project where pid=?";
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

	public Map getAllProject() {
		Map<Integer, Project> proMap = new HashMap<Integer, Project>();
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
				proMap.put(new Integer(project.getPid()), project);
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
		return proMap;
	}

	public Project getProjectInfo(int pid) {
		Project project = new Project();
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from project where pid = ? ";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setInt(1, pid);
			rs = pre.executeQuery();
			if (rs.next()) {
				project.setPid(rs.getInt("pid"));
				project.setProname(rs.getString("proname"));
				project.setDescribe(rs.getString("describes"));
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
		return project;
	}

	public boolean updateProject(Project project) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update project set proname = ?,describes = ? where pid=? ";
		try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, project.getProname());
			pre.setString(2, project.getDescribe());
			pre.setInt(3, project.getPid());
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

	public List<ProInfo> findCaseRroInfo() {
		List caseRroInfoList = new ArrayList();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select pid,proname from project";
		try {
			dbUtil = new DbUtil();
			ps = dbUtil.getCon().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
				caseRroInfoList.add(new ProInfo(rs.getInt("pid"), rs
						.getString("proname")));
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
		return caseRroInfoList;
	}

	public boolean updateProCaseNum(int pid) {
		Boolean flag = Boolean.valueOf(false);
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		String sql = "update project set casenum = casenum + 1,failnum = failnum + 1 where pid = ?";
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
