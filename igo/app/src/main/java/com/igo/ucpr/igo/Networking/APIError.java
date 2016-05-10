package com.igo.ucpr.igo.Networking;

/**
 * clase pojo, para el manejo de errores
 * Created by hash on 3/6/16.
 */
public class APIError {

    private int code;
    private String message;

    public APIError() {
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}