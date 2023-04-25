package com.badorek.luemon_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentFight extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fight, container, false);

        TextView txtLog = view.findViewById(R.id.txtFigthLog);
        txtLog.setMovementMethod(new ScrollingMovementMethod());
        if (getArguments() != null) {
            String logText = getArguments().getString("fightData");
            txtLog.setText(logText);
        }



        return view;
    }
}