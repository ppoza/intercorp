package com.ppoza.intercorp.data.repository;

import com.ppoza.intercorp.data.datasource.UserDataSource;
import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public class UserRepository {

    private UserDataSource dataSource;

    public UserRepository(UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLogged() {
        return dataSource.isLogged();
    }

    public void getUser(DataResponseCallback<User> dataResponseCallback) {
        dataSource.getUser(dataResponseCallback);
    }

}
