package com.ppoza.intercorp.utils;

public interface DataResponseCallback<T> {

    void onSuccess(T data);
    void onError();

}
