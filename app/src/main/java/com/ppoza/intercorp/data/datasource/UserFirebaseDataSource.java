package com.ppoza.intercorp.data.datasource;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class UserFirebaseDataSource implements UserDataSource {

    private final FirebaseAuth mFirebaseAuth;
    private final DatabaseReference mUsersReferences;

    public UserFirebaseDataSource(FirebaseAuth firebaseAuth, DatabaseReference usersReferences) {
        this.mFirebaseAuth = firebaseAuth;
        this.mUsersReferences = usersReferences;
    }

    @Override
    public boolean isLogged() {
        return mFirebaseAuth.getCurrentUser() != null;
    }

    @Override
    public void getUser(DataResponseCallback<User> callback) {
        FirebaseUser firebaseUser =  mFirebaseAuth.getCurrentUser();

        this.mUsersReferences.child(firebaseUser.getUid()).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                User user = task.getResult().getValue(User.class);
                if(user == null) {
                    callback.onSuccess(null);
                } else {
                    callback.onSuccess(user);
                }
            }  else {
                callback.onSuccess(null);
            }
        });
    }

    @Override
    public void createUser(User user, DataResponseCallback<User> callback) {
        FirebaseUser firebaseUser =  mFirebaseAuth.getCurrentUser();
        this.mUsersReferences.child(firebaseUser.getUid()).setValue(user).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess(null);
            }  else {
                callback.onError();
            }
        });
    }
}
