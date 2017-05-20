package com.example.bruno.aula;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class ListaActivity extends AppCompatActivity {

  private ListView listView;
  private RelativeLayout layout;

  private AdapterLivro adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista);

    layout = (RelativeLayout) findViewById(R.id.layout);

    configurarLista();
  }

  private void configurarLista() {
    adapter = new AdapterLivro(this, new DAO().getLivros());
    listView = (ListView) findViewById(R.id.list_view);

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Livro livroSelecionado = (Livro) adapterView.getItemAtPosition(i);
        Snackbar.make(view,livroSelecionado.getTitulo() + "\n" + livroSelecionado.getAutor(), Snackbar.LENGTH_LONG).show();
      }
    });
  }

  private void mostrarMensagem(String mensagem) {
    Snackbar.make(layout, mensagem, Snackbar.LENGTH_LONG).show();
  }
}
