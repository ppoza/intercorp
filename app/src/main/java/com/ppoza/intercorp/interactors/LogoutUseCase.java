package com.ppoza.intercorp.interactors;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class LogoutUseCase {

    private final FirebaseAuth mFirebaseAuth;
    private LoginManager mLoginManager;

    public LogoutUseCase(FirebaseAuth firebaseAuth, LoginManager loginManager) {
        this.mFirebaseAuth = firebaseAuth;
        this.mLoginManager = loginManager;
    }

    public void execute(DataResponseCallback callback) {
        mFirebaseAuth.addAuthStateListener( firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() == null){
                callback.onSuccess(null);
            }  else {
                callback.onError();
            }
        });

        mFirebaseAuth.signOut();
        mLoginManager.logOut();
    }

}
