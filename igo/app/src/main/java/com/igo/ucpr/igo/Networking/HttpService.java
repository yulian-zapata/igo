package com.igo.ucpr.igo.Networking;

import com.igo.ucpr.igo.Modelos.usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Interfaz para realizar peteciones a la api Rest
 * Created by viktor on 22/04/15.
 */
public interface HttpService {

    @GET("/image")
    Call<HttpResponse> obtenerImagenes(

    );


    @POST("/login")
    Call<Void> Login(
            @Body usuario usuario
    );

    @POST("/signup")
    Call<Void> Create(
            @Body usuario usuario
    );
}

