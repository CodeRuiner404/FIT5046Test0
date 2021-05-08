package com.example.fit5046test0.ui.viewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fit5046test0.room.PainRecord;
import com.example.fit5046test0.room.PainRecordRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private PainRecordRepository pRepository;
    private LiveData<List<PainRecord>> recorders;

    public SharedViewModel(Application application) {
        //super(application);
        pRepository = new PainRecordRepository(application);
        recorders = pRepository.getAllRecords();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public CompletableFuture<PainRecord> findByIDFuture(final int recordId){
        return pRepository.findByIDFuture(recordId);
    }
    public LiveData<List<PainRecord>> getAllRecords() {
        return recorders;
    }
    public void insert(PainRecord pr) {
        pRepository.insert(pr);
    }
    public void deleteAll() {
        pRepository.deleteAll();
    }
    public void update(PainRecord pr) {
        pRepository.updatePainRecord(pr);
    }
}
