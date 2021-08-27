package com.ppoza.intercorp.model;

public class DataResponse<T> {

    ResponseType responseType;
    int message;
    T data;

    public static <T> DataResponse success(T data, int message) {
        return new DataResponse(ResponseType.SUCCESS, data, message);
    }

    public static <T> DataResponse error(T data, int message) {
        return new DataResponse(ResponseType.ERROR, data, message);
    }

    public static <T> DataResponse loading(T data, int message) {
        return new DataResponse(ResponseType.LOADING, data, message);
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
}
