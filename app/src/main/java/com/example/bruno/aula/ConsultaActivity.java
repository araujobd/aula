package com.example.bruno.aula;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ConsultaActivity extends ListActivity {

  private String [] lista = {"Ubuntu", "Debian", "Neon", "Manjaro", "Antergos", "Arch", "Hydrogen",
      "OpenSuse", "Mint", "Deepin"};


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
    setListAdapter(adaptador);
  }

  @Override
  protected void onListItemClick(ListView l, View v, int position, long id) {
    Toast.makeText(this, "Item selecionado: " + getListView().getItemAtPosition(position), Toast.LENGTH_SHORT).show();
  }
}
