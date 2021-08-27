package com.ppoza.intercorp.ui;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.ui.model.ActivityResult;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ActivityResult> mActivityResultLiveData = new MutableLiveData();
    public final LiveData<ActivityResult> activityResultLiveData = mActivityResultLiveData;

    void setActivityResult(int requestCode, int resultCode, Intent data) {
        mActivityResultLiveData.postValue(new ActivityResult(requestCode, resultCode, data));
    }

}