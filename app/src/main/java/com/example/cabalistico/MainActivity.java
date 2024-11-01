package com.example.cabalistico;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText editTextNombre;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        textViewResultado = findViewById(R.id.textViewResultado);

        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                int numeroCabalistico = calcularNumeroCabalístico(nombre);
                textViewResultado.setText("El número cabalístico de " + nombre + " es " + numeroCabalistico + ".");
            }
        });
    }

    public int calcularNumeroCabalístico(String nombre) {

        int resultado = 0;
        String abecedario = getResources().getString(R.string.abecedario);
        String numeros = getResources().getString(R.string.numeros);

        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);
            int indice = abecedario.indexOf(letra);
            if (indice != -1) {
                resultado += Character.getNumericValue(numeros.charAt(indice));
            }
        }

        while (resultado > 9) {
            int suma = 0;
            while (resultado > 0) {
                suma += resultado % 10;
                resultado /= 10;
            }
            resultado = suma;
        }

        return resultado;
    }
}


