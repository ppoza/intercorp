package com.ppoza.intercorp.ui.model;

public class Response<T> {

    ResponseType responseType;
    int message;
    T data;

    public static <T> Response success(T data, int message) {
        return new Response(ResponseType.SUCCESS, data, message);
    }

    public static <T> Response error(T data, int message) {
        return new Response(ResponseType.ERROR, data, message);
    }

    public static <T> Response loading(T data, int message) {
        return new Response(ResponseType.LOADING, data, message);
    }

    private Response(ResponseType responseType, T data, int message) {
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
