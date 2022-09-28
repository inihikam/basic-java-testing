package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTujuan, edtJarak;
    Spinner spnBbm, spnVeh;
    TextView txtJarak, txtTujuan, txtBiaya, txtVehicle;

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
        spnVeh = findViewById(R.id.spnVeh);
        txtJarak = findViewById(R.id.txtJarak);
        txtTujuan = findViewById(R.id.txtTujuan);
        txtBiaya = findViewById(R.id.txtBiaya);
        txtVehicle = findViewById(R.id.txtVehicle);

        ArrayList<BBM> list_bbm = new ArrayList<>();
        list_bbm.add(new BBM("Pertalite", 7500));
        list_bbm.add(new BBM("Pertamax", 10000));
        list_bbm.add(new BBM("Solar", 5500));
        list_bbm.add(new BBM("Dex-Lite", 6000));

        ArrayAdapter<BBM> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_bbm);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBbm.setAdapter(arrayAdapter);

        ArrayList<Kendaraan> list_veh = new ArrayList<>();
        list_veh.add(new Kendaraan("Honda Brio", 4));
        list_veh.add(new Kendaraan("Hyundai Creta", 3.5));
        list_veh.add(new Kendaraan("Alphard", 2));

        ArrayAdapter<Kendaraan> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_veh);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnVeh.setAdapter(arrayAdapter1);

    }

    public void hitungBBM(View v){
        Kendaraan veh = (Kendaraan)spnVeh.getSelectedItem();
        double liter = Double.parseDouble(edtJarak.getText().toString()) / veh.getLtr();
        int harga = ((BBM)spnBbm.getSelectedItem()).getHarga();
        int biaya = (int)liter*harga;

        txtTujuan.setText("Tujuan : "+edtTujuan.getText());
        txtJarak.setText("Jarak : "+edtJarak.getText()+" KM memerlukan "+liter+" ltr BBM");
        txtVehicle.setText("Kendaraan : "+veh.getNama());
        txtBiaya.setText("Biaya : Rp. "+biaya);
    }
}