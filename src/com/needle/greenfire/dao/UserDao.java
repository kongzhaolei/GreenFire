package com.needle.greenfire.dao;

import com.needle.greenfire.po.User;

import java.util.Map;

public abstract interface UserDao
{
  public abstract User userLogin(String paramString1, String paramString2);

  public abstract boolean addUser(User paramUser);

  public abstract boolean deleteUsers(int[] paramArrayOfInt);

  public abstract User SelectOneUser(String paramString);

  public abstract boolean updateUser(User paramUser);

  public abstract Boolean checkPassWord(String paramString1, String paramString2);

  public abstract Map findAllUsers();

  public abstract boolean checkNameExist(String paramString);
}

