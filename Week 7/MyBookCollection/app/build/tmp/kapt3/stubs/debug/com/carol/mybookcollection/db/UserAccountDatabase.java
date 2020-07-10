package com.carol.mybookcollection.db;

import java.lang.System;

@androidx.room.Database(entities = {com.carol.mybookcollection.model.UserAccount.class}, version = 2, exportSchema = true)
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/carol/mybookcollection/db/UserAccountDatabase;", "Landroidx/room/RoomDatabase;", "()V", "daoAccess", "Lcom/carol/mybookcollection/db/UserAccountDao;", "Companion", "app_debug"})
public abstract class UserAccountDatabase extends androidx.room.RoomDatabase {
    private static com.carol.mybookcollection.db.UserAccountDatabase INSTANCE;
    public static final com.carol.mybookcollection.db.UserAccountDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.carol.mybookcollection.db.UserAccountDao daoAccess();
    
    public UserAccountDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/carol/mybookcollection/db/UserAccountDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/carol/mybookcollection/db/UserAccountDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.carol.mybookcollection.db.UserAccountDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}