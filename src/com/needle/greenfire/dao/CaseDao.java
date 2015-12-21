package com.needle.greenfire.dao;

import com.needle.greenfire.po.ReportCase;
import com.needle.greenfire.po.TestCase;

import java.util.List;

public abstract interface CaseDao
{
  public abstract boolean AddTestCase(TestCase paramTestCase);

  public abstract boolean updateTestCase(TestCase paramTestCase);

  public abstract List<TestCase> FindProCaseInfo(int paramInt);

  public abstract List<ReportCase> FindReportCaseInfo(int paramInt);

  public abstract int getAddTestCaseID(int paramInt, String paramString);

  public abstract TestCase findTestCaseInfo(int paramInt1, int paramInt2);
}

