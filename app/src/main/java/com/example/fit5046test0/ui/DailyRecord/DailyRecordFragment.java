package com.example.fit5046test0.ui.DailyRecord;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fit5046test0.R;

public class DailyRecordFragment extends Fragment {

    private DailyRecordViewModel dailyRecordViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dailyRecordViewModel =
                new ViewModelProvider(this).get(DailyRecordViewModel.class);
        View root = inflater.inflate(R.layout.fragment_daily_record, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        dailyRecordViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}