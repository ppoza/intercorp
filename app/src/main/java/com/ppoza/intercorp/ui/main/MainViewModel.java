package com.ppoza.intercorp.ui.main;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.model.ActivityRequestResult;


public class MainViewModel extends ViewModel {

    private final MutableLiveData<ActivityRequestResult> mActivityResultLiveData = new MutableLiveData();
    public final LiveData<ActivityRequestResult> activityResultLiveData = mActivityResultLiveData;

    void setActivityResult(int requestCode, int resultCode, Intent data) {
        mActivityResultLiveData.postValue(new ActivityRequestResult(requestCode, resultCode, data));
    }

}