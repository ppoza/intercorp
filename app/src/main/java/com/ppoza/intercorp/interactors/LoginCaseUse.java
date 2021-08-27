package com.ppoza.intercorp.interactors;

import com.facebook.AccessToken;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.ppoza.intercorp.utils.CallbackDataResponse;

public class LoginCaseUse {

    private FirebaseAuth firebaseAuth;

    public LoginCaseUse(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public void execute(AccessToken token, CallbackDataResponse callback) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        callback.onError();
                    }
                });
    }

}
