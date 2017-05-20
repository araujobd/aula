package com.example.bruno.aula;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 16/05/17.
 */

public class AdapterLivro  extends ArrayAdapter<Livro> {

  private final Context context;
  private final ArrayList<Livro> livros;

  public AdapterLivro(Context context, ArrayList<Livro> livros) {
    super(context, R.layout.item_listview, livros);
    this.context = context;
    this.livros = livros;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View linha = inflater.inflate(R.layout.item_listview, parent, false);

    TextView titulo = (TextView) linha.findViewById(R.id.tv_titulo);
    TextView autor = (TextView) linha.findViewById(R.id.tv_descricao);

    titulo.setText(livros.get(position).getTitulo());
    autor.setText(livros.get(position).getAutor());

    return linha;
  }
}
