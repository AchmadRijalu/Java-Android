package com.example.week1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.data;

public class MainActivity extends AppCompatActivity implements editListener, deleteListener {

    private RecyclerView recyclerview_recyclerview;
    private FloatingActionButton float_button;
    private Adapter adapter;
    private static ArrayList<data>listuser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerview_recyclerview = findViewById(R.id.recyclerview_recyclerview);
        float_button = findViewById(R.id.float_button);
        listuser = new ArrayList<data>();
        adapter = new Adapter(listuser, this, this);

        float_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Form.class);
                intent.putExtra("action", 26);
                startActivityForResult(intent, 1);


            }
        });

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerview_recyclerview.setLayoutManager(manager);
        recyclerview_recyclerview.setAdapter(adapter);

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == 100){
                data databaru = data.getParcelableExtra("userbaru");
                listuser.add(databaru);
                adapter.notifyDataSetChanged();

            }

        }
    }

    @Override
    public void OnDelete(int position) {


    }

    @Override
    public void OnEdit(int position) {
        String nama = listuser.get(position).getNama();
        String umur = listuser.get(position).getUmur();
        String alamat = listuser.get(position).getAlamat();
        data dapat = new data(nama,umur,alamat);
        Intent intent = new Intent(getBaseContext(), readUser.class);
        intent.putExtra("user", dapat);
        startActivity(intent);
    }
}