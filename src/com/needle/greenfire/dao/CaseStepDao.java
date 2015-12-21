package com.needle.greenfire.dao;

import com.needle.greenfire.po.CaseStep;
import com.needle.greenfire.po.ReportCaseStep;

import java.util.List;

public abstract interface CaseStepDao
{
  public abstract boolean addCaseStep(CaseStep paramCaseStep);

  public abstract List<ReportCaseStep> FindCaseStepInfo(int paramInt);

  public abstract List<CaseStep> FindCaseStepInfo(int paramInt1, int paramInt2);

  public abstract boolean checkCaseStepID(int paramInt1, int paramInt2, int paramInt3);

  public abstract boolean updateCaseStep(CaseStep paramCaseStep);
}

