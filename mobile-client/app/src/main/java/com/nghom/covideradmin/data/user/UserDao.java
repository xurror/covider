package com.nghom.covideradmin.data.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users ORDER BY user_name ASC")
    LiveData<List<User>> getAllUsers();
}
