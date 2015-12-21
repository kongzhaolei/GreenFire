package com.needle.greenfire.dao;

import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.Project;
import com.needle.greenfire.po.Result;

import java.util.List;

public abstract interface RunTestCaseDao
{
  public abstract List<Project> findProjects();

  public abstract List<CaseStep> findCaseSteps(int paramInt);

  public abstract boolean addResult(Result paramResult);

  public abstract boolean updateFailNum(int paramInt);
}

