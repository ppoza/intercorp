package com.ppoza.intercorp.ui.profile;

import androidx.lifecycle.ViewModel;

import com.ppoza.intercorp.interactors.Interactors;

public class ProfileViewModel extends ViewModel {

    private Interactors interactors;

    public ProfileViewModel(Interactors interactors) {
        this.interactors = interactors;
    }
}
