package com.hode.recyclerview.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hode.recyclerview.R;
import com.hode.recyclerview.models.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = this.listaFilmes.get(position);

        holder.textTitulo.setText(filme.getTitulo());
        holder.textAno.setText(filme.getAno());
        holder.textGenero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return this.listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitulo;
        private TextView textAno;
        private TextView textGenero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.textTitulo);
            textAno = itemView.findViewById(R.id.textAno);
            textGenero = itemView.findViewById(R.id.textGenero);

        }
    }

}
