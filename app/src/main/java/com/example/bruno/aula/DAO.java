package com.example.bruno.aula;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 16/05/17.
 */

public class DAO {

  private ArrayList<Livro> livros;

  public DAO() {
    livros = new ArrayList<Livro>();
  }

  public ArrayList<Livro> getLivros() {
    livros.clear();

    livros.add(new Livro("Android", "Alexandre"));
    livros.add(new Livro("Daltonismo", "Cainan"));
    livros.add(new Livro("JSF", "Cristóvão JSF"));
    livros.add(new Livro("O Invisível", "Arthur"));

    return livros;
  }
}
