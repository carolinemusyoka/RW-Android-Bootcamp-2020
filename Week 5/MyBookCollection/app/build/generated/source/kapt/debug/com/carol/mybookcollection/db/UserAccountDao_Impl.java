package com.carol.mybookcollection.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.carol.mybookcollection.model.UserAccount;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserAccountDao_Impl implements UserAccountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserAccount> __insertionAdapterOfUserAccount;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByUserId;

  public UserAccountDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserAccount = new EntityInsertionAdapter<UserAccount>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `UserAccount` (`id`,`username`,`password`,`fullname`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UserAccount value) {
        stmt.bindLong(1, value.getId());
        if (value.getUsername() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsername());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getFullname() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullname());
        }
      }
    };
    this.__preparedStmtOfDeleteByUserId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM UserAccount WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertUserData(final UserAccount user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserAccount.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByUserId(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByUserId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByUserId.release(_stmt);
    }
  }

  @Override
  public LiveData<List<UserAccount>> getDetails() {
    final String _sql = "select * from UserAccount";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"UserAccount"}, false, new Callable<List<UserAccount>>() {
      @Override
      public List<UserAccount> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUsername = CursorUtil.getColumnIndexOrThrow(_cursor, "username");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfFullname = CursorUtil.getColumnIndexOrThrow(_cursor, "fullname");
          final List<UserAccount> _result = new ArrayList<UserAccount>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UserAccount _item;
            _item = new UserAccount();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpUsername;
            _tmpUsername = _cursor.getString(_cursorIndexOfUsername);
            _item.setUsername(_tmpUsername);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            _item.setPassword(_tmpPassword);
            final String _tmpFullname;
            _tmpFullname = _cursor.getString(_cursorIndexOfFullname);
            _item.setFullname(_tmpFullname);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
