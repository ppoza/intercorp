package com.ppoza.intercorp.ui.profile;

import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.interactors.LogoutUseCase;

public class ProfileViewModel extends ViewModel {

    private LogoutUseCase logoutUseCase;

    public ProfileViewModel(LogoutUseCase logoutUseCase) {
        this.logoutUseCase = logoutUseCase;
    }
}
