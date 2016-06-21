package com.example.a41665767.tp3;

/**
 * Created by 41665767 on 11/5/2016.
 */

    import android.os.Bundle;
    import android.support.v4.app.DialogFragment;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.EditText;

    /**
     * Created by Leandro on 6/9/2016.
     */
    public class fragment_user_name extends DialogFragment {

        public fragment_user_name() {
            // Empty constructor required for DialogFragment
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_user_name, container);

            final Principal mainActivity  = (Principal) getActivity(); // Politicamente incorrecto
            final EditText userName = (EditText) view.findViewById(R.id.txt_your_name);
            userName.setText(mainActivity.getUserName());

            Button b = (Button) view.findViewById(R.id.confirmar);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Click","OK");
                    mainActivity.setUserName(userName.getText().toString());
                    dismiss();
                }
            });
            getDialog().setTitle("Ingrese nombre de usuario");

            return view;
        }

    }
