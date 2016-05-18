package com.igo.ucpr.igo.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.igo.ucpr.igo.R;
import com.igo.ucpr.igo.Utils.LazyAdapter;

public class ImageListActivity extends AppCompatActivity {
    ListView list;
    LazyAdapter adapter;

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
            "https://si0.twimg.com/profile_images/2053165008/ac-new_bigger.jpg",
            "http://www.dromobox.com/archivos/2015/08/android-logo.jpg",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGdVJpRnJqLU5ReEk",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGb1RaZVhmUndoVXM",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGbTQ5ck45ZE52d1E",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGNWpvTm1XYnhKZEE",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGbmdIWWtSVmFCVjQ",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGSDNUaGZreERMaHM",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGSGd4eFREbVZEV00",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGdDBGQ1FtN2xTWFU",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGOWNoNzl1Rk52dTQ",
            "https://drive.google.com/open?id=0B2ZhOfSVGhYGNVlRemFlZzBnNlE",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Sasso_lungo_da_passo_pordoi.jpg/270px-Sasso_lungo_da_passo_pordoi.jpg"
    };
}
