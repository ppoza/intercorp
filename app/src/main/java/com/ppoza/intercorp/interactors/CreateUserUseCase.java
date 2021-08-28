package com.ppoza.intercorp.interactors;

import com.ppoza.intercorp.data.repository.UserRepository;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class CreateUserUseCase {

    private final UserRepository mUserRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public void execute(User user, DataResponseCallback<User> dataResponseCallback) {
        mUserRepository.createUser(user, dataResponseCallback);
    }

}
