package com.needle.greenfire.dao;

import com.needle.greenfire.po.ProInfo;
import com.needle.greenfire.po.Project;

import java.util.List;
import java.util.Map;

public abstract interface ProjectDao
{
  public abstract boolean addProject(Project paramProject);

  public abstract boolean deleteProjects(int[] paramArrayOfInt);

  public abstract Project getProjectInfo(int paramInt);

  public abstract boolean updateProject(Project paramProject);

  public abstract Map getAllProject();

  public abstract List<ProInfo> findCaseRroInfo();

  public abstract boolean updateProCaseNum(int paramInt);
}

