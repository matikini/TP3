package com.example.a41665767.tp3;


        import android.content.ContentValues;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Toast;

        import java.util.ArrayList;


public class FirstFragment extends Fragment implements View.OnClickListener {
    GameButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public int cantclicks;
    public String secuencia;
    public String user;
    public ArrayList<Jugada> listajug;
    MainActivity act;
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true); // to show actionbar icon calling onCreateOptionsMenu
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_first, container, false);
        b1 = (GameButton) v.findViewById(R.id.Btn1);
        b1.setOnClickListener(this);
        b2 = (GameButton) v.findViewById(R.id.Btn2);
        b2.setOnClickListener(this);
        b3 = (GameButton) v.findViewById(R.id.Btn3);
        b3.setOnClickListener(this);
        b4 = (GameButton) v.findViewById(R.id.Btn4);
        b4.setOnClickListener(this);
        b5 = (GameButton) v.findViewById(R.id.Btn5);
        b5.setOnClickListener(this);
        b6 = (GameButton) v.findViewById(R.id.Btn6);
        b6.setOnClickListener(this);
        b7 = (GameButton) v.findViewById(R.id.Btn7);
        b7.setOnClickListener(this);
        b8 = (GameButton) v.findViewById(R.id.Btn8);
        b8.setOnClickListener(this);
        b9 = (GameButton) v.findViewById(R.id.Btn9);
        b9.setOnClickListener(this);
        act = (MainActivity) getActivity();
        listajug = act.getJugadas();
        user = act.getUserName();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.first,menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn1:
                b1.flip();
                b2.flip();
                b4.flip();
                secuencia += "1, ";
                cantclicks++;
                break;
            case R.id.Btn2:
                b1.flip();
                b2.flip();
                b3.flip();
                b5.flip();
                secuencia += "2, ";
                cantclicks++;
                break;
            case R.id.Btn3:
                b2.flip();
                b3.flip();
                b6.flip();
                secuencia += "3, ";
                cantclicks++;
                break;
            case R.id.Btn4:
                b1.flip();
                b4.flip();
                b5.flip();
                b7.flip();
                secuencia += "4, ";
                cantclicks++;
                break;
            case R.id.Btn5:
                b2.flip();
                b4.flip();
                b5.flip();
                b6.flip();
                b8.flip();
                secuencia += "5, ";
                cantclicks++;
                break;
            case R.id.Btn6:
                b3.flip();
                b5.flip();
                b6.flip();
                b9.flip();
                secuencia += "6, ";
                cantclicks++;
                break;
            case R.id.Btn7:
                b4.flip();
                b7.flip();
                b8.flip();
                secuencia += "7, ";
                cantclicks++;
                break;
            case R.id.Btn8:
                b5.flip();
                b7.flip();
                b8.flip();
                b9.flip();
                secuencia += "8, ";
                cantclicks++;
                break;
            case R.id.Btn9:
                b6.flip();
                b8.flip();
                b9.flip();
                secuencia += "9, ";
                cantclicks++;
                break;
        }

        if (b1.isChecked() && b2.isChecked() && b3.isChecked() && b4.isChecked() && b5.isChecked() && b6.isChecked()
                && b7.isChecked() && b8.isChecked() && b9.isChecked()) {
            Log.d(" GANASTE", "IIIIIIII");
            Toast.makeText(getActivity(), "GANASTE IIIIIIII",
                    Toast.LENGTH_SHORT).show();
            Jugada nuevajug = new Jugada(user,secuencia,cantclicks);
            listajug.add(nuevajug);
            SQLiteDatabase baseD = act.getBasedatos();
            ContentValues nuevoRegistro;

            nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", user);
            nuevoRegistro.put("secuencia", secuencia);
            nuevoRegistro.put("cantmov", cantclicks);
            baseD.insert("jugadas", null, nuevoRegistro);
        }
        if (!b1.isChecked() && !b2.isChecked() && !b3.isChecked() && !b4.isChecked() && !b5.isChecked() && !b6.isChecked() && !b7.isChecked() && !b8.isChecked() && !b9.isChecked())
        {
            Log.d("GANASTE", "TURBINA");
            Toast.makeText(getActivity(), "GANASTE TURBINA",
                    Toast.LENGTH_SHORT).show();
            Jugada nuevajug = new Jugada(user,secuencia,cantclicks);
            listajug.add(nuevajug);
            SQLiteDatabase baseD = act.getBasedatos();
            ContentValues nuevoRegistro;

            nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", user);
            nuevoRegistro.put("secuencia", secuencia);
            nuevoRegistro.put("cantmov", cantclicks);
            baseD.insert("jugadas", null, nuevoRegistro);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
                Log.d("Replay", "ison");
                secuencia="";
                cantclicks=0;
                b1.reset();
                b2.reset();
                b3.reset();
                b4.reset();
                b5.reset();
                b6.reset();
                b7.reset();
                b8.reset();
                b9.reset();
                break;
        }
        return true;
    }
}

