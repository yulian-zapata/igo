package com.igo.ucpr.igo.Networking;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Generador de servicios para la comunicacion  con la api rest
 * Created by hash on 3/10/16.
 */
public class ServiceGenerator {

    private static final String API_BASE_URL = "http://placego-rest.herokuapp.com/";
    private static final HttpLoggingInterceptor logging = new HttpLoggingInterceptor().
            setLevel(HttpLoggingInterceptor.Level.BODY);
    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    /**
     * crea el servicio retrofit para la comunicacion
     *
     * @param serviceClass objeto interface
     * @param authToken    token del usuario
     * @return retrofit service
     */
    public static <S> S createService(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("token", authToken)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }
        httpClient.addInterceptor(logging);
        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

    /**
     * retorna un objeto retrofit service
     *
     * @return Retrofit
     */
    public static Retrofit getRretrofit() {
        return builder.build();
    }
}
