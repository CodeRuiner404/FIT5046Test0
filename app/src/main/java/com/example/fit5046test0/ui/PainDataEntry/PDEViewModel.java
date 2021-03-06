package com.example.fit5046test0.ui.PainDataEntry;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fit5046test0.room.PainRecord;
import com.example.fit5046test0.room.PainRecordRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PDEViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private PainRecordRepository pRepository;
    private LiveData<List<PainRecord>> recorders;

    public PDEViewModel(Application application) {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is pain data entry fragment");
        super(application);
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

//    public LiveData<String> getText() {
//        return mText;
//    }
}