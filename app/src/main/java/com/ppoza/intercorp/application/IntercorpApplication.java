package com.ppoza.intercorp.application;

import androidx.multidex.MultiDexApplication;

import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.interactors.Interactors;
import com.ppoza.intercorp.interactors.LoginCaseUse;
import com.ppoza.intercorp.interactors.LogoutUseCase;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class IntercorpApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Interactors interactors = new Interactors(
                new LoginCaseUse(firebaseAuth),
                new LogoutUseCase(firebaseAuth)
        );

        IntercorpViewModelFactory.getInstance().inject(interactors);

    }
}
