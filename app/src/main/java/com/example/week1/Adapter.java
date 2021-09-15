package com.example.week1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.data;

public class Adapter extends RecyclerView.Adapter<Adapter.DataViewHolder> {

    private ArrayList<data> listdata;
    protected  editListener edit;
    protected  deleteListener delete;

    public Adapter(ArrayList<data> listdata, editListener edit, deleteListener delete){
        this.listdata = listdata;
        this.edit = edit;
        this.delete = delete;
    }

    @NonNull
    @Override

    public Adapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_input,parent, false);
        return new DataViewHolder(view,edit,delete);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.DataViewHolder holder, int position) {
            holder.nama_value.setText(listdata.get(position).getNama());
            holder.umur_value.setText(listdata.get(position).getUmur());
            holder.alamat_value.setText(listdata.get(position).getAlamat());

        }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
    public class DataViewHolder extends RecyclerView.ViewHolder{
        private TextView nama_value, umur_value , alamat_value;
        private Button card_button;

        public DataViewHolder(@NonNull View itemView, editListener edit, deleteListener delete) {
            super(itemView);
            nama_value = itemView.findViewById(R.id.nama_value);
            umur_value = itemView.findViewById(R.id.umur_value);
            alamat_value = itemView.findViewById(R.id.alamat_value);
            card_button = itemView.findViewById(R.id.card_button);



            card_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edit.OnEdit(getAdapterPosition());

//                    Intent intent = new Intent(v.getContext(), readUser.class);
//                    intent.putExtra("nama", nama_value.getText());
//                    intent.putExtra("umur", umur_value.getText());
//                    intent.putExtra("alamat", alamat_value.getText());
//
//                    for (int i = 0; i<listdata.size(); i++){
//                        if(listdata.get(i).getNama().equalsIgnoreCase(nama_value.getText().toString().trim())) {
//                            intent.putExtra("index", i);
//                            break;
//                        }
//
//                    }
//                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
