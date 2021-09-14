package com.example.week1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import model.data;
import model.loading;

public class Form extends AppCompatActivity {

    private TextInputLayout set_nama , set_umur , set_alamat;
    private Button set_button;
    private int isEdit;
    private TextView set_judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        set_nama = findViewById(R.id.set_nama);
        set_umur = findViewById(R.id.set_umur);
        set_alamat = findViewById(R.id.set_alamat);
        set_button = findViewById(R.id.set_button);
        set_judul = findViewById(R.id.set_judul);
//        Intent intent = getIntent();
//        String action = intent.getStringExtra("action");
//
//        if(action.equalsIgnoreCase("edit")){
//            set_button.setText("Edit Data");
//        }

        Intent intent = getIntent();
        isEdit = intent.getIntExtra("action", 0);
        if(isEdit == 25){
            set_button.setText("Edit data");
            set_judul.setText("Edit Data");



        }else if(isEdit == 26){
            set_button.setText("Tambah Data");

            set_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loading load = new loading(Form.this);
                    String nama = set_nama.getEditText().getText().toString().trim();
                    String umur = set_umur.getEditText().getText().toString().trim();
                    String alamat = set_alamat.getEditText().getText().toString().trim();
                    data user = new data(nama,umur,alamat);
                    Intent intent = new Intent();
                    load.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            load.dismissDialog();
                            intent.putExtra("userbaru", user);
                            setResult(100,intent);
                            finish();
                        }
                    },2000);
                }
            });
        }



    }


}