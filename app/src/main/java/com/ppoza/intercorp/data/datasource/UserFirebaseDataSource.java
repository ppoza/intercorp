package com.ppoza.intercorp.data.datasource;

import com.google.firebase.auth.FirebaseAuth;

public class UserFirebaseDataSource implements UserDataSource {

    private FirebaseAuth mFirebaseAuth;

    public UserFirebaseDataSource(FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
    }

    @Override
    public boolean isLogged() {
        return mFirebaseAuth.getCurrentUser() != null;
    }
}
