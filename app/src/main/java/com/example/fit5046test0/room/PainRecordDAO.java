package com.example.fit5046test0.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PainRecordDAO {
    @Query("SELECT * FROM pain_record ORDER BY record_id ASC")
    LiveData<List<PainRecord>> getAll();
    @Query("SELECT * FROM pain_record WHERE record_id = :painRecordId LIMIT 1")
    PainRecord findByID(int painRecordId);
    @Insert
    void insert(PainRecord painRecord);
    @Delete
    void delete(PainRecord painRecord);
    @Update
    void updatePainRecord(PainRecord painRecord);
    @Query("DELETE FROM pain_record")
    void deleteAll();
}
