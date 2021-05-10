package com.example.fit5046test0.ui.PainDataEntry;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fit5046test0.MainActivity;
import com.example.fit5046test0.R;
import com.example.fit5046test0.databinding.FragmentPdeBinding;
import com.example.fit5046test0.room.PainRecord;
import com.example.fit5046test0.ui.viewModel.SharedViewModel;
import com.google.android.material.slider.Slider;

import java.util.Date;
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

        //Slider
        //pain level
        binding.pdePainLevel.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                painIntensity = (int) value;
            }
        });


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

        binding.pdeMoods.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find view by id
//                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.pde_moods);
//                View radioButton = radioGroup.findViewById(checkedId);
//                int index = radioGroup.indexOfChild(radioButton);
//                switch (index) {
//                    case 0: // very low
//                        painIntensity =1;
//                        break;
//                    case 1: // low
//                        painIntensity =2;
//                        break;
//                    case 2: // average
//                        painIntensity =3;
//                        break;
//                    case 3: // high
//                        painIntensity =4;
//                        break;
//                    case 4: // very high
//                        painIntensity =5;
//                        break;
//                    default: // nothing selected
//                        // Do nothing.
//                        break;
//                }
                //good version
                switch (checkedId) {
                    case R.id.pde_mood1: // very low
                        painIntensity =1;
                        break;
                    case R.id.pde_mood2: // low
                        painIntensity =2;
                        break;
                    case R.id.pde_mood3: // average
                        painIntensity =3;
                        break;
                    case R.id.pde_mood4: // high
                        painIntensity =4;
                        break;
                    case R.id.pde_mood5: // very high
                        painIntensity =5;
                        break;
                    default: // nothing selected
                        painIntensity =0;
                        break;
                }


            }
        });
        //radioGroup.clearCheck();

        //steps goal
        binding.pdeGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                goal = 0;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                goal = (int)Integer.parseInt(s.toString());
            }
        });




        // save button
        binding.pdeSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(painIntensity == 0 || locationOfPain.isEmpty()||mood == 0||goal == 0){
                    Toast.makeText(getContext(),"Please enter all the content!",Toast.LENGTH_SHORT).show();
                }else{
                    MainActivity activity = (MainActivity) getActivity();
                    PainRecord painRecord = new PainRecord(painIntensity,locationOfPain,mood,goal, new Date(),activity.getEmailOfUser());

                }

            }
        });

        //edit button
        binding.pdeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    public int getPainIntensity() {
        return painIntensity;
    }

    public void setPainIntensity(int painIntensity) {
        this.painIntensity = painIntensity;
    }

    public String getLocationOfPain() {
        return locationOfPain;
    }

    public void setLocationOfPain(String locationOfPain) {
        this.locationOfPain = locationOfPain;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}