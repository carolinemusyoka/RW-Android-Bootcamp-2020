package com.carol.mybookcollection.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u001c\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/carol/mybookcollection/repository/UserRepository;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allData", "Landroidx/lifecycle/LiveData;", "", "Lcom/carol/mybookcollection/model/UserAccount;", "daoAccess", "Lcom/carol/mybookcollection/db/UserAccountDao;", "getAllData", "insertData", "", "data", "LoginInsertion", "app_debug"})
public final class UserRepository {
    private com.carol.mybookcollection.db.UserAccountDao daoAccess;
    private androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> allData;
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.carol.mybookcollection.model.UserAccount>> getAllData() {
        return null;
    }
    
    public final void insertData(@org.jetbrains.annotations.NotNull()
    com.carol.mybookcollection.model.UserAccount data) {
    }
    
    public UserRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/carol/mybookcollection/repository/UserRepository$LoginInsertion;", "Landroid/os/AsyncTask;", "Lcom/carol/mybookcollection/model/UserAccount;", "Ljava/lang/Void;", "daoAccess", "Lcom/carol/mybookcollection/db/UserAccountDao;", "(Lcom/carol/mybookcollection/db/UserAccountDao;)V", "doInBackground", "data", "", "([Lcom/carol/mybookcollection/model/UserAccount;)Ljava/lang/Void;", "app_debug"})
    static final class LoginInsertion extends android.os.AsyncTask<com.carol.mybookcollection.model.UserAccount, java.lang.Void, java.lang.Void> {
        private final com.carol.mybookcollection.db.UserAccountDao daoAccess = null;
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        com.carol.mybookcollection.model.UserAccount... data) {
            return null;
        }
        
        public LoginInsertion(@org.jetbrains.annotations.NotNull()
        com.carol.mybookcollection.db.UserAccountDao daoAccess) {
            super();
        }
    }
}