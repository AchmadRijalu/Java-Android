package com.example.week1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

        final int position= getIntent().getIntExtra("position",0);

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
//        final String position= intent.getStringExtra("position");
//
//        Toast.makeText(this,String.valueOf(intent.getIntExtra("index", 0)),Toast.LENGTH_SHORT).show();
        get_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Form.class);
                Toast.makeText(getBaseContext(), "position = " + position, Toast.LENGTH_SHORT).show();
                intent.putExtra("position", position);
                intent.putExtra("user", user);
                intent.putExtra("action", 25);
                startActivity(intent);

            }
        });

        get_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(readUser.this);
                builder.setMessage("Apakah anda yakin mau menghapus? " + user.getNama()).setPositiveButton("Yakin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), user.getNama(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(),MainActivity.class);
//                        intent.putExtra("position", position);
                        MainActivity.listuser.remove(position);
                        Toast.makeText(getBaseContext(), "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        MainActivity.adapter.notifyDataSetChanged();
                        finish();
                    }
                }).setNegativeButton("Enggak", null);

                AlertDialog alert = builder.create();
                alert.show();




            }
        });
    }
}