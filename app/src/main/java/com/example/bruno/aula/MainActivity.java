package com.example.bruno.aula;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

  private RelativeLayout layout;
  private Button button, bt_lista, bt_login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActionBar bar = getSupportActionBar();
    bar.setTitle("Tela Inicial");
    bar.setSubtitle("Splash");

    layout = (RelativeLayout) findViewById(R.id.layout);
    button = (Button) findViewById(R.id.bt_consulta);
    bt_lista = (Button) findViewById(R.id.bt_list);
    bt_login = (Button) findViewById(R.id.bt_login);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, ConsultaActivity.class));
      }
    });

    bt_lista.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, ListaActivity.class));
      }
    });

    bt_login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    switch (id) {
      case R.id.sobre:
        mensagemSobre();
        return true;
      case R.id.sair:
        sair();
        return true;
      case R.id.compartihar:
        compartilharApp();
        return true;
      case R.id.site:
        abrirSite();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBackPressed() {
    sair();
  }

  private void sair() {
    new AlertDialog.Builder(this)
        .setMessage("Deseja realmente sair?")
        .setCancelable(false)
        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            MainActivity.this.finish();
          }
        })
        .setNegativeButton("Não", null)
        .show();
  }

  public void abrirSite() {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.xandroid.com.br"));
    startActivity(browserIntent);
  }

  public void compartilharApp() {
    Intent sendIntent = new Intent();

    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.putExtra(Intent.EXTRA_TEXT, "Subtitulo");
    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Titulo");
    sendIntent.setType("text/plain");

    startActivity(Intent.createChooser(sendIntent,"Compartilhar"));
  }

  private void mensagemSobre() {
    AlertDialog alert = new AlertDialog.Builder(this).create();
    alert.setTitle(getString(R.string.app_name));
    alert.setMessage(getString(R.string.menu_sobre));
    alert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener(){

      @Override
      public void onClick(DialogInterface dialogInterface, int i) {

      }
    });

    alert.setIcon(R.mipmap.ic_launcher);
    alert.show();
  }

}
