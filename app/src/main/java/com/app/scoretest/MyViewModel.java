package com.app.scoretest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private int aBack;
    private int bBack;
    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle) {
        this.handle = handle;
        // 初始化备份变量
        aBack = handle.getLiveData("aTeamScore").getValue() != null ?
                (int) handle.getLiveData("aTeamScore").getValue() : 0;
        bBack = handle.getLiveData("bTeamScore").getValue() != null ?
                (int) handle.getLiveData("bTeamScore").getValue() : 0;
    }

    public MutableLiveData<Integer> getaTeamScore() {
        if (!handle.contains("aTeamScore")) {
            handle.set("aTeamScore", 0);
        }
        return handle.getLiveData("aTeamScore");
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (!handle.contains("bTeamScore")) {
            handle.set("bTeamScore", 0);
        }
        return handle.getLiveData("bTeamScore");
    }

    public void addATeamScore(int score) {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(getaTeamScore().getValue() + score);
    }

    public void addBTeamScore(int score) {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getbTeamScore().setValue(getbTeamScore().getValue() + score);
    }

    public void reset() {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(0);
        getbTeamScore().setValue(0);
    }

    public void undo() {
        getaTeamScore().setValue(aBack);
        getbTeamScore().setValue(bBack);
    }
}
