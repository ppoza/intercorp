package com.ppoza.intercorp.interactors;

import com.ppoza.intercorp.data.repository.UserRepository;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class GetUserUseCase {

    private UserRepository mUserRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public void execute(DataResponseCallback<User> dataResponseCallback) {
        mUserRepository.getUser(dataResponseCallback);
    }

}
