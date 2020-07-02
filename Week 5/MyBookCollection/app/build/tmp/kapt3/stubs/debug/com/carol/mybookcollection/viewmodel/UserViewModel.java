package com.carol.mybookcollection.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/carol/mybookcollection/viewmodel/UserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getAllDatas", "Landroidx/lifecycle/LiveData;", "", "Lcom/carol/mybookcollection/model/UserAccount;", "repository", "Lcom/carol/mybookcollection/repository/UserRepository;", "getGetAllData", "insert", "", "data", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.AndroidViewModel {
    private com.carol.mybookcollection.repository.UserRepository repository;
    private androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> getAllDatas;
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.carol.mybookcollection.model.UserAccount data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> getGetAllData() {
        return null;
    }
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}