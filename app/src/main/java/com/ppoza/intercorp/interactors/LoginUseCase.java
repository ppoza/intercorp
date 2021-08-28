package com.ppoza.intercorp.interactors;

import com.facebook.AccessToken;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class LoginUseCase {

    private final FirebaseAuth mFirebaseAuth;

    public LoginUseCase(FirebaseAuth firebaseAuth) {
        this.mFirebaseAuth = firebaseAuth;
    }

    public void execute(AccessToken token, DataResponseCallback<AuthResult> callback) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess(task.getResult());
                    } else {
                        callback.onError();
                    }
                });
    }

}
