package com.example.pmd_lecturafichero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button botonGuardar;
    Button botonRecuperar;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        botonRecuperar = (Button) findViewById(R.id.botonRecuperar);
        textView = (TextView) findViewById(R.id.txVDato1);
        editText = (EditText) findViewById(R.id.dato1edit);


        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStreamWriter miFichero = null;
                try {
                    miFichero = new OutputStreamWriter(openFileOutput("Fichero.txt", Context.MODE_PRIVATE));
                    miFichero.write(String.valueOf(editText.getText()));
                    miFichero.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        botonRecuperar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                BufferedReader miFichero = null;
                try {
                    miFichero = new BufferedReader(new InputStreamReader(openFileInput("Fichero.txt")));
                    String texto = miFichero.readLine();
                    miFichero.close();
                    textView.setText(texto);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}