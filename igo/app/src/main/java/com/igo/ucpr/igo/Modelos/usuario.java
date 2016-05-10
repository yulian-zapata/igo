package com.igo.ucpr.igo.Modelos;

/**
 * Created by Frank on 09/05/2016.
 */
public class usuario {
    String username;
    String email;
    String password;

    public usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public usuario(String email, String password,String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
