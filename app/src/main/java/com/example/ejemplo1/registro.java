package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private Button btnRegistrar2;
    private TextView textRut, textNombre;
    private EditText editRut, editNombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editNombre = (EditText)findViewById(R.id.editNombre);
        editRut = (EditText)findViewById(R.id.editRut);
        textNombre = (TextView) findViewById(R.id.textNombre);
        textRut = (TextView) findViewById(R.id.textRut);
        btnRegistrar2 = findViewById(R.id.btnRegistrar2);

        cargarPreferencias();
    }








    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nombre=preferences.getString("nombre","No existe la informacion");
        String pass=preferences.getString("pass","No existe la informacion");
        editNombre.setText(nombre);
        editRut.setText(pass);
    }

    private void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String nombre = editNombre.getText().toString();
        String pass = editRut.getText().toString();
         SharedPreferences.Editor editor = preferences.edit();
         editor.putString("nombre",nombre);
         editor.putString("pass",pass);
         editNombre.setText(nombre);
         editRut.setText(pass);
         editor.commit();
    }
}