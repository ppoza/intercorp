package com.ppoza.intercorp.application;

import androidx.multidex.MultiDexApplication;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.data.datasource.UserFirebaseDataSource;
import com.ppoza.intercorp.data.repository.UserRepository;
import com.ppoza.intercorp.interactors.GetUserUseCase;
import com.ppoza.intercorp.interactors.IsLoggedUseCase;
import com.ppoza.intercorp.interactors.Interactors;
import com.ppoza.intercorp.interactors.LoginUseCase;
import com.ppoza.intercorp.interactors.LogoutUseCase;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class IntercorpApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        resolveDependeencies();
    }

    private void resolveDependeencies() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        UserFirebaseDataSource userFirebaseDataSource = new UserFirebaseDataSource(firebaseAuth);
        UserRepository userRepository = new UserRepository(userFirebaseDataSource);

        Interactors interactors = new Interactors(
                new LoginUseCase(firebaseAuth),
                new LogoutUseCase(firebaseAuth, LoginManager.getInstance()),
                new IsLoggedUseCase(userRepository),
                new GetUserUseCase(userRepository)
        );

        IntercorpViewModelFactory.getInstance().inject(interactors);
    }
}
