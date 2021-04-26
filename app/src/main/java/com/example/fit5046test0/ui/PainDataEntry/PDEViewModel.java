package com.example.fit5046test0.ui.PainDataEntry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PDEViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PDEViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pain data entry fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}