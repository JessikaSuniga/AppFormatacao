package com.example.appformatacao;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private TextView textField;
    private EditText edtText;
    private SeekBar skbTamanhoLetra;
    private ImageButton btnEnviar;
    private CheckBox ckbNegrito;
    private CheckBox ckbItalico;
    private CheckBox ckbMaiusculo;
    private RadioButton rdbAzul;
    private RadioButton rdbVermelho;
    private RadioButton rdbVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = findViewById(R.id.textView);
        edtText = findViewById(R.id.edtTexto);
        skbTamanhoLetra = findViewById(R.id.seekBarTamanho);
        btnEnviar = findViewById(R.id.btnEnviar);
        ckbNegrito = findViewById(R.id.negrito);
        ckbItalico = findViewById(R.id.italico);
        ckbMaiusculo = findViewById(R.id.maiusculo);
        rdbAzul = findViewById(R.id.azul);
        rdbVermelho = findViewById(R.id.vermelho);
        rdbVerde = findViewById(R.id.verde);

        btnEnviar.setOnClickListener(this);
        skbTamanhoLetra.setOnSeekBarChangeListener(this);
        ckbNegrito.setOnCheckedChangeListener(this);
        ckbItalico.setOnCheckedChangeListener(this);
        ckbMaiusculo.setOnCheckedChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        textField.setTextSize(progress + 12);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnEnviar) {
            String aux = "";
            aux = aux.concat(textField.getText().toString() + " " + edtText.getText().toString());


            textField.setText(aux);
            edtText.getText().clear();

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (ckbNegrito.isChecked()) {
            textField.setTypeface(null, Typeface.BOLD);
        }
        if (ckbItalico.isChecked()) {
            textField.setTypeface(null, Typeface.ITALIC);
        }
        if (ckbMaiusculo.isChecked()) {
            textField.setText(textField.getText().toString().toUpperCase());
        } else {
            textField.setText(textField.getText().toString().toLowerCase());
        }

        if (ckbNegrito.isChecked() && ckbItalico.isChecked()) {
            textField.setTypeface(null, Typeface.BOLD_ITALIC);
        }

        if (rdbAzul.isChecked()) {
            rdbVermelho.setChecked(false);
            rdbVerde.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#000080"));
        }
        if (rdbVermelho.isChecked()) {
            rdbAzul.setChecked(false);
            rdbVerde.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#800000"));
        }
        if (rdbVerde.isChecked()) {
            rdbAzul.setChecked(false);
            rdbVermelho.setChecked(false);
            textField.setTextColor(Color.parseColor("#808080"));
            textField.setTextColor(Color.parseColor("#008000"));
        }


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
