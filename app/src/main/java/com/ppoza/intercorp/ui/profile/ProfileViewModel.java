package com.ppoza.intercorp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.R;
import com.ppoza.intercorp.interactors.Interactors;
import com.ppoza.intercorp.model.DataResponse;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class ProfileViewModel extends ViewModel {

    private final Interactors mInteractors;

    private MutableLiveData<DataResponse<User>> mUserLiveData = new MutableLiveData();
    public final LiveData<DataResponse<User>> userLiveData = mUserLiveData;

    public ProfileViewModel(Interactors interactors) {
        this.mInteractors = interactors;
    }

    public boolean isLogged() {
        return mInteractors.getIsLoggedUseCase().execute();
    }

    public void logout() {
        mInteractors.getLogoutUseCase().execute();
    }

    public void requestUser() {
        mUserLiveData.postValue(DataResponse.loading());
        mInteractors.getGetUserUseCase().execute(new DataResponseCallback<User>() {
            @Override
            public void onSuccess(User user) {
                mUserLiveData.postValue(DataResponse.success(user));
            }

            @Override
            public void onError() {
                mUserLiveData.postValue(DataResponse.error(R.string.error_login));
            }
        });
    }

}
