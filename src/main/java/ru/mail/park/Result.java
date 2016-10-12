package ru.mail.park;

import com.google.gson.JsonObject;

/**
 * Created by kirrok on 12.10.16.
 */
public final class Result<T> {
    private final int code;
    private final T response;

    public Result(int code, T response) {
        this.code = code;
        this.response = response;
    }

    public int getcode() {
        return code;
    }

    public T getResponse() {
        return response;
    }

}