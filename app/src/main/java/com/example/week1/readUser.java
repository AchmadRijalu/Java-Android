package com.example.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import model.data;

public class readUser extends AppCompatActivity {

    private TextView get_nama , get_umur , get_alamat;
    private Button get_edit, get_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_user);

        get_nama = findViewById(R.id.get_nama);
        get_umur = findViewById(R.id.get_umur);
        get_alamat = findViewById(R.id.get_alamat);

        get_edit = findViewById(R.id.get_edit);
        get_delete = findViewById(R.id.get_delete);

        data user = getIntent().getParcelableExtra("user");
        get_nama.setText(user.getNama());
        get_umur.setText(user.getUmur());
        get_alamat.setText(user.getAlamat());


//        Intent intent = getIntent();
//
//        Toast.makeText(this,String.valueOf(intent.getIntExtra("index", 0)),Toast.LENGTH_SHORT).show();
        get_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Form.class);
                intent.putExtra("action", 25);
                startActivity(intent);

            }
        });
    }
}