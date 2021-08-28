package com.ppoza.intercorp.model;

import com.ppoza.intercorp.R;

public class DataResponse<T> {

    ResponseType responseType;
    int message;
    T data;

    public static <T> DataResponse success(T data, int message) {
        return new DataResponse(ResponseType.SUCCESS, data, message);
    }

    public static <T> DataResponse success(T data) {
        return new DataResponse(ResponseType.SUCCESS, data, R.string.success);
    }

    public static <T> DataResponse error(int message) {
        return new DataResponse(ResponseType.ERROR, null, message);
    }

    public static <T> DataResponse error() {
        return new DataResponse(ResponseType.ERROR, null, R.string.error);
    }

    public static <T> DataResponse loading() {
        return new DataResponse(ResponseType.LOADING, null, R.string.loading);
    }

    private DataResponse(ResponseType responseType, T data, int message) {
        this.responseType = responseType;
        this.data = data;
        this.message = message;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public int getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean isLoading() {
        return responseType == ResponseType.LOADING;
    }
}
