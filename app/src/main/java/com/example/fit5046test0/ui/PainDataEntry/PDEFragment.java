package com.example.fit5046test0.ui.PainDataEntry;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fit5046test0.R;
import com.example.fit5046test0.databinding.FragmentPdeBinding;
import com.example.fit5046test0.room.PainRecord;
import com.example.fit5046test0.ui.viewModel.SharedViewModel;

import java.util.List;

public class PDEFragment extends Fragment {

    private SharedViewModel viewModel;
    private FragmentPdeBinding binding;
    //private RadioGroup radioGroup;

    // data of the pain, store to database later
    private int painIntensity;
    private String locationOfPain;
    private int mood;
    private int goal;

    public PDEFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //pdeViewModel = new ViewModelProvider(this).get(PDEViewModel.class);
        //View root = inflater.inflate(R.layout.fragment_pde, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        pdeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        binding = FragmentPdeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        //spinner
        //pain location
        binding.pdePainLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] locations = getResources().getStringArray(R.array.location_list);
                locationOfPain = locations[position];
            }
        });


        //radio button
        //mood level
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.pde_moods);
        binding.pdeMoods.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0: // very low
                        painIntensity =1;
                        break;
                    case 1: // low
                        painIntensity =2;
                        break;
                    case 2: // average
                        painIntensity =3;
                        break;
                    case 3: // high
                        painIntensity =4;
                        break;
                    case 4: // very high
                        painIntensity =5;
                        break;
                    default: // nothing selected
                        // Do nothing.
                        break;
                }
            }
        });
        //radioGroup.clearCheck();




        // save button
        binding.pdeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }




}