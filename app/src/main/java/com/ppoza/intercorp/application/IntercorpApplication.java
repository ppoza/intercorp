package com.ppoza.intercorp.application;

import androidx.multidex.MultiDexApplication;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ppoza.intercorp.config.Constants;
import com.ppoza.intercorp.data.datasource.UserFirebaseDataSource;
import com.ppoza.intercorp.data.repository.UserRepository;
import com.ppoza.intercorp.interactors.CreateUserUseCase;
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
        resolveDependencies();
    }

    private void resolveDependencies() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersReferences = database.getReference(Constants.USERS_PATH);
        UserFirebaseDataSource userFirebaseDataSource = new UserFirebaseDataSource(firebaseAuth, usersReferences);
        UserRepository userRepository = new UserRepository(userFirebaseDataSource);

        Interactors interactors = new Interactors(
                new LoginUseCase(firebaseAuth),
                new LogoutUseCase(firebaseAuth, LoginManager.getInstance()),
                new IsLoggedUseCase(userRepository),
                new GetUserUseCase(userRepository),
                new CreateUserUseCase(userRepository)
        );

        IntercorpViewModelFactory.getInstance().inject(interactors);
    }
}
