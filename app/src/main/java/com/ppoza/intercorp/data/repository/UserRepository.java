package com.ppoza.intercorp.data.repository;

import com.ppoza.intercorp.data.datasource.UserDataSource;
import com.ppoza.intercorp.model.User;

public class UserRepository {

    private UserDataSource dataSource;

    public UserRepository(UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLogged() {
        return dataSource.isLogged();
    }

}
