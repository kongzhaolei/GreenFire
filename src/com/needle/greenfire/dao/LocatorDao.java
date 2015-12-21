package com.needle.greenfire.dao;

import com.needle.greenfire.po.LocatName;

import java.util.List;

public abstract interface LocatorDao
{
  public abstract List<LocatName> findLocatNameInfo();
}

