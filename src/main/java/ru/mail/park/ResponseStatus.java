package ru.mail.park;

/**
 * Created by kirrok on 12.10.16.
 */
public class ResponseStatus {

    public static final byte CODE_OK = 0;
    public static final byte CODE_NOT_FOUND = 1;
    public static final byte CODE_INVALID_REQUEST = 2;
    public static final byte CODE_INCORRECT_REQUEST = 3;
    public static final byte CODE_UNKNOWN_ERROR = 4;
    public static final byte CODE_USER_ALREADY_EXISTS = 5;

    public static final String MESSAGE_OK = "OK";
    public static final String MESSAGE_NOT_FOUND = "запрашиваемый объект не найден";
    public static final String MESSAGE_INVALID_REQUEST = "невалидный запрос";
    public static final String MESSAGE_INCORRECT_REQUEST = "некорректный запрос";
    public static final String MESSAGE_UNKNOWN_ERROR = "неизвестная ошибка";
    public static final String MESSAGE_USER_ALREADY_EXISTS = "такой юзер уже существует";

}
