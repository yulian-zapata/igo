package com.igo.ucpr.igo.Activities.dummy;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.igo.ucpr.igo.Networking.HttpResponse;
import com.igo.ucpr.igo.Networking.HttpService;
import com.igo.ucpr.igo.Networking.Servicio;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {
    static HttpService service = Servicio.createService(HttpService.class);
    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;
    private static List<String> Image = new ArrayList<String>();

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static void getAllImages() {
        Call<HttpResponse> call = service.obtenerImagenes();
        call.enqueue(callback());
    }

    public static Callback<HttpResponse> callback() {
        return new Callback<HttpResponse>() {

            @Override
            public void onResponse(Call<HttpResponse> call, Response<HttpResponse> response) {
                if (response.isSuccessful()) {
                    HttpResponse respuesta = response.body();
                    CargaImagenes(respuesta.data[0]);
                    // Log.e("Adaptador", "" + respuesta.data[0].getAsJsonArray());
                    // CargaImagenes( respuesta.data[0].getAsJsonArray());
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