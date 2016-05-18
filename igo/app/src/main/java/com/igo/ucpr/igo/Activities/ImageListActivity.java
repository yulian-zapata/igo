package com.igo.ucpr.igo.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.JsonElement;
import com.igo.ucpr.igo.Networking.HttpResponse;
import com.igo.ucpr.igo.R;
import com.igo.ucpr.igo.Utils.LazyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageListActivity extends AppCompatActivity {
    ListView list;
    LazyAdapter adapter;
    public static final List<String> Image = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);


        list = (ListView) findViewById(R.id.listView1);
        adapter = new LazyAdapter(this, imageUrls);
        list.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        list.setAdapter(null);
        super.onDestroy();
    }

    private String imageUrls[] = {
            "http://www.dromobox.com/archivos/2015/08/android-logo.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Sasso_lungo_da_passo_pordoi.jpg/270px-Sasso_lungo_da_passo_pordoi.jpg"
    };


    public static Callback<HttpResponse> callback() {
        return new Callback<HttpResponse>() {

            @Override
            public void onResponse(Call<HttpResponse> call, Response<HttpResponse> response) {
                if (response.isSuccessful()) {
                    HttpResponse respuesta = response.body();
                    CargaImagenes(respuesta.data[0]);
                }
            }

            @Override
            public void onFailure(Call<HttpResponse> call, Throwable t) {
                Log.e("AdaptadorError", "" + t.getCause());
            }
        };

    }

    public static void CargaImagenes(JsonElement array) {
        for (int i = 0; i < array.getAsJsonArray().size(); i++) {
            JsonElement image = array.getAsJsonArray().get(i);
            Log.e("ID ", " " + image.getAsJsonObject().get("name"));
            Log.e("ID ", " " + image.getAsJsonObject().get("path"));
            Image.add(i, image.getAsJsonObject().get("path").toString());
        }
    }
}
