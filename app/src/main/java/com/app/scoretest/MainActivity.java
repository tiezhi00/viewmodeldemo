package com.app.scoretest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.app.scoretest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //初始化ViewModel
        myViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory()).get(MyViewModel.class);
        //观察数据变化
        myViewModel.getaTeamScore().observe(this, integer -> {
            binding.tvScoreA.setText(String.valueOf(integer));
        });
        myViewModel.getbTeamScore().observe(this, integer -> {
            binding.tvScoreB.setText(String.valueOf(integer));
        });
        //设置点击事件
        binding.btnAdd1A.setOnClickListener(view -> {
            myViewModel.addATeamScore(1);
        });
        binding.btnAdd2A.setOnClickListener(view -> {
            myViewModel.addATeamScore(2);
        });
        binding.btnAdd3A.setOnClickListener(view -> {
            myViewModel.addATeamScore(3);
        });
        binding.btnAdd1B.setOnClickListener(view -> {
            myViewModel.addBTeamScore(1);
        });
        binding.btnAdd2B.setOnClickListener(view -> {
            myViewModel.addBTeamScore(2);
        });
        binding.btnAdd3B.setOnClickListener(view -> {
            myViewModel.addBTeamScore(3);
        });
        binding.ivReset.setOnClickListener(view -> {
            myViewModel.reset();
        });
        binding.ivUndo.setOnClickListener(view -> {
            myViewModel.undo();
        });


    }
}