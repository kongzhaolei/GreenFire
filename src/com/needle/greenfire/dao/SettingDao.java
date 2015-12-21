package com.needle.greenfire.dao;

import com.needle.greenfire.po.Setting;

import java.util.Map;

public abstract interface SettingDao
{
  public abstract String getRemodeURL(int paramInt, String paramString);

  public abstract boolean addProjectSetting(Setting paramSetting);

  public abstract Map findSettingInfo(int paramInt);

  public abstract Setting getSettingInfo(int paramInt1, int paramInt2);

  public abstract boolean updateSetting(Setting paramSetting);
}

