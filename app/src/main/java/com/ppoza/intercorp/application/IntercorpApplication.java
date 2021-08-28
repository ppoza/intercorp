package com.ppoza.intercorp.application;

import androidx.multidex.MultiDexApplication;

import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.data.datasource.UserFirebaseDataSource;
import com.ppoza.intercorp.data.repository.UserRepository;
import com.ppoza.intercorp.interactors.IsLoggeedUseCase;
import com.ppoza.intercorp.interactors.Interactors;
import com.ppoza.intercorp.interactors.LoginUseCase;
import com.ppoza.intercorp.interactors.LogoutUseCase;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class IntercorpApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        UserFirebaseDataSource userFirebaseDataSource = new UserFirebaseDataSource(firebaseAuth);

        Interactors interactors = new Interactors(
                new LoginUseCase(firebaseAuth),
                new LogoutUseCase(firebaseAuth),
                new IsLoggeedUseCase(new UserRepository(userFirebaseDataSource))
        );

        IntercorpViewModelFactory.getInstance().inject(interactors);

    }
}
