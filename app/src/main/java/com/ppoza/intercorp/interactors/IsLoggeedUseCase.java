package com.ppoza.intercorp.interactors;

import com.ppoza.intercorp.data.repository.UserRepository;


public class IsLoggeedUseCase {

    private UserRepository userRepository;

    public IsLoggeedUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.isLogged();
    }

}
