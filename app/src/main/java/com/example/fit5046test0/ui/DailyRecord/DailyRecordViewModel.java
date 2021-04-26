package com.example.fit5046test0.ui.DailyRecord;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DailyRecordViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DailyRecordViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is daily record fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}