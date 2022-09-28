package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTujuan, edtJarak;
    Spinner spnBbm;
    TextView txtJarak, txtTujuan, txtBiaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent(){
        edtTujuan = findViewById(R.id.edtTujuan);
        edtJarak = findViewById(R.id.edtJarak);
        spnBbm = findViewById(R.id.spnBbm);
        txtJarak = findViewById(R.id.txtJarak);
        txtTujuan = findViewById(R.id.txtTujuan);
        txtBiaya = findViewById(R.id.txtBiaya);

        ArrayList<BBM> list_bbm = new ArrayList<>();
        list_bbm.add(new BBM("Pertalite", 7500));
        list_bbm.add(new BBM("Pertamax", 10000));
        list_bbm.add(new BBM("Solar", 5500));
        list_bbm.add(new BBM("Dex-Lite", 6000));

        ArrayAdapter<BBM> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_bbm);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBbm.setAdapter(arrayAdapter);
    }

    public void hitungBBM(View v){
        double liter = Double.parseDouble(edtJarak.getText().toString()) / 2.5;
        int harga = ((BBM)spnBbm.getSelectedItem()).getHarga();
        int biaya = (int)liter*harga;

        txtTujuan.setText("Tujuan : "+edtTujuan.getText());
        txtJarak.setText("Jarak : "+edtJarak.getText()+" KM memerlukan "+liter+" ltr BBM");
        txtBiaya.setText("Biaya : "+biaya);
    }
}