package com.ppoza.intercorp.interactors;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutUseCase {

    private FirebaseAuth firebaseAuth;

    public LogoutUseCase(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public void execute() {
        firebaseAuth.signOut();
    }

}
