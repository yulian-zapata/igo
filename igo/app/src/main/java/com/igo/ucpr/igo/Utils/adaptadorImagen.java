package com.igo.ucpr.igo.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.igo.ucpr.igo.Activitys.JsonImagenParser;
import com.igo.ucpr.igo.R;

import java.util.List;

/**
 * Created by Frank on 05/05/2016.
 */
public class adaptadorImagen extends ArrayAdapter{

    public adaptadorImagen(Context context, List objects)
    {
        super(context,0,objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=convertView;
        if (null==convertView)
        {
           v = inflater.inflate
                   (R.layout.activity_json_imagen, parent,false);

       }

        TextView nameImagen= (TextView)v.findViewById(R.id.name);
        TextView descImagen =(TextView)v.findViewById(R.id.description);
        ImageView pathImagen =(ImageView)v.findViewById(R.id.path);

        JsonImagenParser.Imagen item = (JsonImagenParser.Imagen) getItem(position);

        nameImagen.setText(item.getName());
       descImagen.setText(item.getDescription());
        pathImagen.setImageResource(convertirRutaEnId(item.getPath()));
        return v;
    }

    private int convertirRutaEnId(String nombre)
    {
        Context context=getContext();
        return context.getResources().getIdentifier(nombre,"drawable",context.getPackageName());
    }


}
