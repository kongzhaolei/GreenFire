package com.needle.greenfire.dao;

import com.needle.greenfire.po.IndexInfo;
import com.needle.greenfire.po.RunCase;

import java.util.List;

public abstract interface IndexDao
{
  public abstract List<IndexInfo> findIndexInfo();

  public abstract List<RunCase> findCaseRunInfo();
}

