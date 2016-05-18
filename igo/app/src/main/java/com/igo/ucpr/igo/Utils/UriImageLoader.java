package com.igo.ucpr.igo.Utils;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.net.URL;
import java.util.HashMap;

public class UriImageLoader {

    private static HashMap<String, Bitmap> images = new HashMap<String, Bitmap>();
    public static final String TAG = UriImageLoader.class.getName();

    public static void setImageFromUrl(final String urlString, final ImageView imageView, final Activity activity) {

        (new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    Bitmap tbmp;
                    if (images.containsKey(urlString))
                        tbmp = images.get(urlString);
                    else {
                        tbmp = BitmapFactory.decodeStream(url
                                .openConnection().getInputStream());
                        images.put(urlString, tbmp);
                    }
                    Log.e(TAG, "Bandera 1");
                    final Bitmap bmp = tbmp;
                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                imageView.setImageBitmap(bmp);
                            } catch (Exception e) {
                                Log.e(TAG, "Error setting image", e);
                            }
                        }
                    });
                } catch (Exception e) {
                    Log.e(TAG, "Image URL Error:" + urlString);
                }
            }
        })).start();
    }
}
