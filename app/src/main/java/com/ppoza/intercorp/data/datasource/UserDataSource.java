package com.ppoza.intercorp.data.datasource;

import com.ppoza.intercorp.model.User;
import com.ppoza.intercorp.utils.DataResponseCallback;

public interface UserDataSource {

    boolean isLogged();
    void getUser(DataResponseCallback<User> dataResponseCallback);
    void createUser(User user, DataResponseCallback<User> dataResponseCallback);
}
