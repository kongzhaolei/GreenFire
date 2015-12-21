package com.needle.greenfire.dao;

import com.needle.greenfire.po.KeyName;
import com.needle.greenfire.po.KeyWord;

import java.util.List;
import java.util.Map;

public abstract interface KeyWordDao
{
  public abstract boolean addKeyword(KeyWord paramKeyWord);

  public abstract KeyWord getKeyWordInfo(int paramInt);

  public abstract boolean updateKeyword(KeyWord paramKeyWord);

  public abstract boolean deleteKeyWord(int[] paramArrayOfInt);

  public abstract Map findAllKeyWord();

  public abstract List<KeyName> findKeyNameInfo();
}

