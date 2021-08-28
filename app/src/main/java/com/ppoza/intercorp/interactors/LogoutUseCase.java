package com.ppoza.intercorp.interactors;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutUseCase {

    private FirebaseAuth mFirebaseAuth;

    public LogoutUseCase(FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
    }

    public void execute() {
        mFirebaseAuth.signOut();
    }

}
