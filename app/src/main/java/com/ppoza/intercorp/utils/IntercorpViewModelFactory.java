package com.ppoza.intercorp.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ppoza.intercorp.interactors.Interactors;
import com.ppoza.intercorp.ui.login.LoginViewModel;
import com.ppoza.intercorp.ui.profile.ProfileViewModel;

public class IntercorpViewModelFactory implements ViewModelProvider.Factory {

    private static IntercorpViewModelFactory instance;

    public static IntercorpViewModelFactory getInstance() {
        if(instance == null) {
            instance = new IntercorpViewModelFactory();
        }
        return instance;
    }

    private Interactors interactors;

    private IntercorpViewModelFactory() {}

    public void inject(Interactors interactors) {
        this.interactors = interactors;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == ProfileViewModel.class) {
            return (T) new ProfileViewModel(interactors);
        } else if(modelClass == LoginViewModel.class) {
            return (T) new LoginViewModel(interactors);
        }
        return null;
    }
}



