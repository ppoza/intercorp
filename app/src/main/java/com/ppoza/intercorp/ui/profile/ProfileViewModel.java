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

    private MutableLiveData<DataResponse> mCreateUserResponseLiveData = new MutableLiveData();
    public final LiveData<DataResponse> createUserResponseLiveData = mCreateUserResponseLiveData;

    private MutableLiveData<DataResponse> mLogoutResponseLiveData = new MutableLiveData();
    public final LiveData<DataResponse> logoutResponseLiveData = mLogoutResponseLiveData;

    public User user = new User();

    public ProfileViewModel(Interactors interactors) {
        this.mInteractors = interactors;
    }

    public boolean isLogged() {
        return mInteractors.getIsLoggedUseCase().execute();
    }

    public void requestUser() {
        mUserLiveData.postValue(DataResponse.loading());
        mInteractors.getGetUserUseCase().execute(new DataResponseCallback<User>() {
            @Override
            public void onSuccess(User user) {
                if(user == null) {
                    mUserLiveData.postValue(DataResponse.notFound());
                } else {
                    ProfileViewModel.this.user = user;
                    mUserLiveData.postValue(DataResponse.success());
                }
            }

            @Override
            public void onError() {
                mUserLiveData.postValue(DataResponse.error(R.string.error_login));
            }
        });
    }

    public void createUser() {
        if(userIsInvalid()){
            mCreateUserResponseLiveData.postValue(DataResponse.error(R.string.fill_all_fields));
            return;
        }
        mUserLiveData.postValue(DataResponse.loading());
        mInteractors.getCreateUserUseCase().execute(user, new DataResponseCallback<User>() {
            @Override
            public void onSuccess(User user) {
                mUserLiveData.postValue(DataResponse.success());
                mCreateUserResponseLiveData.postValue(DataResponse.success(R.string.user_created));
            }

            @Override
            public void onError() {
                mCreateUserResponseLiveData.postValue(DataResponse.error(R.string.error_login));
            }
        });
    }

    private boolean userIsInvalid() {
        return user.age == 0 ||
                user.lastName == null || user.lastName.isEmpty() ||
                user.name == null || user.name.isEmpty() ||
                user.birthDate == 0;
    }

    public void logout() {
        mLogoutResponseLiveData.postValue(DataResponse.loading());
        mInteractors.getLogoutUseCase().execute(new DataResponseCallback<User>() {
            @Override
            public void onSuccess(User user) {
                mLogoutResponseLiveData.postValue(DataResponse.success(null));
            }

            @Override
            public void onError() {
                mLogoutResponseLiveData.postValue(DataResponse.error(R.string.error_logout));
            }
        });
    }
}
