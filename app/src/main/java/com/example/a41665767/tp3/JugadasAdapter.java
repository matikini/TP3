package com.example.a41665767.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 41665767 on 5/7/2016.
 */
public class JugadasAdapter extends BaseAdapter {
    ArrayList<Jugada> listajug;
    Context context;

    public JugadasAdapter(Context context, ArrayList<Jugada> listajug) {
        this.context = context;
        this.listajug = listajug;
    }
    @Override
    public int getCount() {
        return listajug.size();
    }

    @Override
    public Object getItem(int i) {
        return listajug.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
        }

        TextView usernameTV = (TextView)view.findViewById(R.id.username);
        TextView jugadaTV = (TextView)view.findViewById(R.id.clicks);
        TextView secuenciaTV = (TextView)view.findViewById(R.id.secuencia);

        Jugada j = listajug.get(i);
        usernameTV.setText(j.getUsername());
        secuenciaTV.setText(j.getSecuencia());
        jugadaTV.setText(String.valueOf(j.getClicks()));
        return view;
    }
}
