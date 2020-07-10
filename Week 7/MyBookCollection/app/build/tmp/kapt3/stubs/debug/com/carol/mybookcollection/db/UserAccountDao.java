package com.carol.mybookcollection.db;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/carol/mybookcollection/db/UserAccountDao;", "", "deleteByUserId", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetails", "Landroidx/lifecycle/LiveData;", "", "Lcom/carol/mybookcollection/model/UserAccount;", "insertUserData", "user", "app_debug"})
public abstract interface UserAccountDao {
    
    @androidx.room.Insert()
    public abstract void insertUserData(@org.jetbrains.annotations.NotNull()
    com.carol.mybookcollection.model.UserAccount user);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from UserAccount")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> getDetails();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM UserAccount WHERE id = :id")
    public abstract java.lang.Object deleteByUserId(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}