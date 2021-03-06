package com.ppoza.intercorp.model;

import com.ppoza.intercorp.R;

public class DataResponse<T> {

    final ResponseType responseType;
    final int message;
    final T data;

    public static <T> DataResponse success(T data, int message) {
        return new DataResponse(ResponseType.SUCCESS, data, message);
    }

    public static <T> DataResponse success() {
        return new DataResponse(ResponseType.SUCCESS, null, R.string.success);
    }

    public static <T> DataResponse success(T data) {
        return new DataResponse(ResponseType.SUCCESS, data, R.string.success);
    }

    public static <T> DataResponse success(int message) {
        return new DataResponse(ResponseType.SUCCESS, null, message);
    }

    public static <T> DataResponse error(int message) {
        return new DataResponse(ResponseType.ERROR, null, message);
    }

    public static <T> DataResponse loading() {
        return new DataResponse(ResponseType.LOADING, null, R.string.loading);
    }

    public static <T> DataResponse notFound() {
        return new DataResponse(ResponseType.NOT_FOUND, null, R.string.loading);
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


    public boolean isSuccess() {
        return responseType == ResponseType.SUCCESS;
    }

    public boolean isLoading() {
        return responseType == ResponseType.LOADING;
    }

    public boolean isNotFound() {
        return responseType == ResponseType.NOT_FOUND;
    }
}
