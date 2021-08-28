package com.ppoza.intercorp.data.datasource;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class UserFirebaseDataSource implements UserDataSource {

    private FirebaseAuth mFirebaseAuth;

    public UserFirebaseDataSource(FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
    }

    @Override
    public boolean isLogged() {
        return mFirebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void getUser(DataResponseCallback<User> callback) {
        FirebaseUser firebaseUser =  mFirebaseAuth.getCurrentUser();

        callback.onSuccess(new User(
                firebaseUser.getEmail(),
                firebaseUser.getDisplayName()
        ));


    }
}
