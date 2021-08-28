package com.ppoza.intercorp.ui.profile;

import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.interactors.Interactors;

public class ProfileViewModel extends ViewModel {

    private Interactors mInteractors;

    public ProfileViewModel(Interactors interactors) {
        this.mInteractors = interactors;
    }

    public boolean isLogged() {
        return mInteractors.getIsLoggeedUseCase().execute();
    }

    public void logout() {
        mInteractors.getLogoutUseCase().execute();
    }
}
