package com.joinservice.joinservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaCadastro extends AppCompatActivity {

    private static final String[] ESTADOS = new String[]{
            "AC", "AL", "AP", "AM", "BA", "CE", "DF",
            "ES", "GO", "MA", "MT", "MS", "MG", "PA",
            "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
            "RO", "RR", "SC", "SP", "SE", "TO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}



