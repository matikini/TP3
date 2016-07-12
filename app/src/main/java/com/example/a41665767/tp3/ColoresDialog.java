package com.example.a41665767.tp3;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by 41665767 on 12/7/2016.
 */
public class ColoresDialog extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_colores, container);

        ArrayAdapter<String> colorAdapter;
        final MainActivity mainActivity = (MainActivity) getActivity(); // Politicamente incorrecto
        final Button btnOK = (Button) view.findViewById(R.id.btnOK);
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = spinner.getSelectedItemPosition();
                ((MainActivity) getActivity()).setColor(color);
                Log.d("Click","OK");
                dismiss();
            }
        });
        ArrayList<String> colores = new ArrayList<>();
        colores.add("Rojo");
        colores.add("Azul");
        colores.add("Verde");


        colorAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, colores);
        colorAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(colorAdapter);
        getDialog().setTitle("Seleccione el color");
        return view;
    }
}
