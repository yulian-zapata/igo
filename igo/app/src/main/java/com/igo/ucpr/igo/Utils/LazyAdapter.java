package com.igo.ucpr.igo.Utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.igo.ucpr.igo.R;
import com.igo.ucpr.igo.imageutils.ImageLoader;

/**
 * Created by hash on 5/17/16.
 */
public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private String[] data;
    private static LayoutInflater inflater = null;
    public ImageLoader imageLoader;

    public LazyAdapter(Activity a, String[] d) {
        activity = a;
        data = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null)
            view = inflater.inflate(R.layout.row_listview_item, null);


        TextView text = (TextView) view.findViewById(R.id.text);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        text.setText("item " + position);
        imageLoader.DisplayImage(data[position], image);
        return view;
    }
}
