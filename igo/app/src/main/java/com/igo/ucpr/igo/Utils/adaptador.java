package com.igo.ucpr.igo.Utils;

import android.app.Activity;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Callback;

import com.igo.ucpr.igo.Networking.HttpResponse;
import com.igo.ucpr.igo.Networking.HttpService;
import com.igo.ucpr.igo.Networking.Servicio;
import com.igo.ucpr.igo.R;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Frank on 22/04/2016.
 */
public class adaptador extends BaseExpandableListAdapter {
    private final SparseArray<GrupoDeItems> grupos;
    public LayoutInflater inflater;
    public Activity activity;
    TextView textvw = null;
    HttpService service = Servicio.createService(HttpService.class);

    // Constructor
    public adaptador(Activity act, SparseArray<GrupoDeItems> grupos) {
        activity = act;
        this.grupos = grupos;
        inflater = act.getLayoutInflater();
    }

    public void getAllImages() {
        Call<HttpResponse> call = service.obtenerImagenes();
        call.enqueue(callback());
    }

    public Callback callback() {
        return new Callback<HttpResponse>() {

            @Override
            public void onResponse(Call<HttpResponse> call, Response<HttpResponse> response) {
                if (response.isSuccessful()) {
                    HttpResponse respuesta = response.body();
                    Log.e("Adaptador", "" + respuesta);
                }
            }

            @Override
            public void onFailure(Call<HttpResponse> call, Throwable t) {
                Log.e("AdaptadorError", ""+t.getCause());
            }
        };

    }

    // Nos devuelve los datos asociados a un subitem en base
    // a la posición
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return grupos.get(groupPosition).children.get(childPosition);
    }

    // Devuelve el id de un item o subitem en base a la
    // posición de item y subitem
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }


    // En base a la posición del item y de subitem nos devuelve
    // el objeto view correspondiente y el layout para los subitems
    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String children = (String) getChild(groupPosition, childPosition);
        TextView textvw = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.subitems_layout, null);
        }
        textvw = (TextView) convertView.findViewById(R.id.textView1);
        textvw.setText(children);
        switch (groupPosition) {
            case 0:
                switch (childPosition) {
                    case 0:
                        textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l21, 0, 0, 0);
                        break;
                    case 1:
                        textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l12, 0, 0, 0);
                        break;

                }
                break;
            case 1:
                switch (childPosition) {
                    case 0:
                        textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l13, 0, 0, 0);
                        break;
                    case 1:
                        textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l22, 0, 0, 0);
                        break;
                    case 2:
                        textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l20, 0, 0, 0);
                        break;
                }
                break;
            case 2:
                textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l27, 0, 0, 0);

                break;
            case 3:
                textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l11, 0, 0, 0);
                break;
            case 4:
                textvw.setCompoundDrawablesWithIntrinsicBounds(R.drawable.l23, 0, 0, 0);
                break;
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, children + "" + groupPosition + " " + childPosition, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    // Nos devuelve la cantidad de subitems que tiene un ítem
    @Override
    public int getChildrenCount(int groupPosition) {
        return grupos.get(groupPosition).children.size();
    }

    //Los datos de un ítem especificado por groupPosition
    @Override
    public Object getGroup(int groupPosition) {
        return grupos.get(groupPosition);
    }

    //La cantidad de ítem que tenemos definidos
    @Override
    public int getGroupCount() {
        return grupos.size();
    }

    //Método que se invoca al contraer un ítem
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    //Método que se invoca al expandir un ítem
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    //Devuelve el id de un ítem
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    //Obtenemos el layout para los ítems
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.items_layout, null);
        }
        /*GrupoDeItems grupo = (GrupoDeItems) getGroup(groupPosition);
        ((RelativeLayout) convertView).setText(grupo.string);
        ((RelativeLayout) convertView).setChecked(isExpanded);*/
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //Nos informa si es seleccionable o no un ítem o subitem
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}




