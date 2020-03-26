package com.hode.recyclerview.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hode.recyclerview.R;
import com.hode.recyclerview.adapters.Adapter;
import com.hode.recyclerview.classes.RecyclerItemClickListener;
import com.hode.recyclerview.models.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Filme filme;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //listagem de itens
        this.criarFilmes();

        //configurar adapter
        Adapter adapter = new Adapter(this.listaFilmes);

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "Item selecionado: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {

        this.listaFilmes.add(new Filme("Homem Aranha - De volta ao lar", "2017", "Aventura"));
        this.listaFilmes.add(new Filme("Mulher Maravilha", "2017", "Fantasia"));
        this.listaFilmes.add(new Filme("Liga da Justiça", "2017", "Ficção"));
        this.listaFilmes.add(new Filme("Capitão América - Guerra Civíl", "2017", "Aventura/Ficção"));
        this.listaFilmes.add(new Filme("It: A Coisa", "2017", "Drama/Terror"));
        this.listaFilmes.add(new Filme("Pica-Pau: O Filme", "2017", "Comédia/Animação"));
        this.listaFilmes.add(new Filme("A Múmia", "2017", "Terror"));
        this.listaFilmes.add(new Filme("A Bela e a Fera", "2017", "Romance"));
        this.listaFilmes.add(new Filme("Meu Malvado Favorito 3", "2017", "Animação"));
        this.listaFilmes.add(new Filme("Carros 3", "2017", "Animação"));

    }


}
