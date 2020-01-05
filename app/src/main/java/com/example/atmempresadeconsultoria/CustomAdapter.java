package com.example.atmempresadeconsultoria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolderTarefa> {
    private List<String> lista;

    public CustomAdapter(List<String> lista){
        this.lista = lista;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolderTarefa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.activity_sqlite, parent, false);

        ViewHolderTarefa holderTarefa = new ViewHolderTarefa(view);
        return holderTarefa;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolderTarefa holder, int position) {
        if ((lista != null) && (lista.size() > 0)){
            lista.add(holder.etTarefa.getText().toString());
        }

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolderTarefa extends RecyclerView.ViewHolder{
        public EditText etTarefa;

        public ViewHolderTarefa(@NonNull View itemView) {
            super(itemView);
            etTarefa = (EditText) itemView.findViewById(R.id.etTarefa);

        }
    }
}
