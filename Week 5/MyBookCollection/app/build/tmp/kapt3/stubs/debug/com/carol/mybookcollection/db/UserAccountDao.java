package com.carol.mybookcollection.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\'\u00a8\u0006\f"}, d2 = {"Lcom/carol/mybookcollection/db/UserAccountDao;", "", "deleteByUserId", "", "id", "", "getDetails", "Landroidx/lifecycle/LiveData;", "", "Lcom/carol/mybookcollection/model/UserAccount;", "insertUserData", "user", "app_debug"})
public abstract interface UserAccountDao {
    
    @androidx.room.Insert()
    public abstract void insertUserData(@org.jetbrains.annotations.NotNull()
    com.carol.mybookcollection.model.UserAccount user);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from UserAccount")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> getDetails();
    
    @androidx.room.Query(value = "DELETE FROM UserAccount WHERE id = :id")
    public abstract void deleteByUserId(long id);
}