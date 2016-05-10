package com.igo.ucpr.igo.Networking;

import com.igo.ucpr.igo.Modelos.imagenes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;


/**
 * Interfaz para realizar peteciones a la api Rest
 * Created by viktor on 22/04/15.
 */
public interface HttpService {

    @POST("/login/")
    Call<HttpResponse> login(
            @Body imagenes imagen
    );




}

