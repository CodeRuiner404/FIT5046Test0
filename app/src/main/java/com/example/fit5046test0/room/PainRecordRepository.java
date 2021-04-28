package com.example.fit5046test0.room;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class PainRecordRepository {
    private PainRecordDAO painRecordDAO;
    private LiveData<List<PainRecord>> allRecords;

    public PainRecordRepository(Application application){
        PainRecordDatabase pdb = PainRecordDatabase.getInstance(application);
        painRecordDAO = pdb.painRecordDAO();
        allRecords = painRecordDAO.getAll();
    }

    public LiveData<List<PainRecord>> getAllRecords(){
        return  allRecords;
    }

    public void insert(final PainRecord painRecord){
        PainRecordDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                painRecordDAO.insert(painRecord);
            }
        });
    }

    public void deleteAll(){
        PainRecordDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                painRecordDAO.deleteAll();
            }
        });
    }

    public void delete(final PainRecord painRecord){
        PainRecordDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                painRecordDAO.delete(painRecord);
            }
        });
    }

    public void updatePainRecord(final PainRecord painRecord){
        PainRecordDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                painRecordDAO.updatePainRecord(painRecord);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<PainRecord> findByIDFuture(final int recordId){
        return CompletableFuture.supplyAsync(new Supplier<PainRecord>() {
            @Override
            public PainRecord get() {
                return painRecordDAO.findByID(recordId);
            }
        },PainRecordDatabase.databaseWriteExecutor);
    }





}
