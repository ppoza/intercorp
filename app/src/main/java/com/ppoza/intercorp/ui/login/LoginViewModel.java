package com.ppoza.intercorp.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.ppoza.intercorp.R;
import com.ppoza.intercorp.model.DataResponse;

import java.util.List;

public class LoginViewModel extends ViewModel {

    public final CallbackManager callbackManager = CallbackManager.Factory.create();
    public final List<String> permissions = List.of("email", "public_profile");
    public FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            mLoginResultLiveData.postValue(DataResponse.success(loginResult, R.string.success));
        }

        @Override
        public void onCancel() {
            mLoginResultLiveData.postValue(DataResponse.error(null, R.string.login_cancel_by_user));
        }

        @Override
        public void onError(FacebookException error) {
            mLoginResultLiveData.postValue(DataResponse.error(null, R.string.error_login));
        }
    };

    private MutableLiveData<DataResponse> mLoginResultLiveData = new MutableLiveData();
    public final LiveData<DataResponse> loginResultLiveData = mLoginResultLiveData;

}