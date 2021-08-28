package com.ppoza.intercorp.interactors;

import com.ppoza.intercorp.data.repository.UserRepository;


public class IsLoggedUseCase {

    private UserRepository userRepository;

    public IsLoggedUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean execute() {
        return userRepository.isLogged();
    }

}
