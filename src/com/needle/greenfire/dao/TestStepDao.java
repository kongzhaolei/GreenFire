package com.needle.greenfire.dao;

import com.needle.greenfire.po.CaseStep;

import java.util.List;

public abstract interface TestStepDao
{
  public abstract boolean addTestSteps(List<CaseStep> paramList);
}

