package com.example.bruno.aula;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

  private EditText ed_usuario, ed_senha;
  private Button bt_salvar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    configurarTela();
    recuperar();
  }

  private void configurarTela() {
    ed_usuario = (EditText) findViewById(R.id.ed_usuario);
    ed_senha = (EditText) findViewById(R.id.ed_senha);
    bt_salvar = (Button) findViewById(R.id.bt_salvar);

    bt_salvar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        salvar();
        LoginActivity.this.finish();
      }
    });
  }

  private void salvar() {
    SharedPreferences preferences = getPreferences(Activity.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    editor.putString("usuario", ed_usuario.getText().toString());
    editor.putString("senha", ed_senha.getText().toString());

    editor.commit();
  }

  private void recuperar() {
    SharedPreferences preferences = getPreferences(Activity.MODE_PRIVATE);

    ed_usuario.setText(preferences.getString("usuario", ""));
    ed_senha.setText(preferences.getString("senha", ""));
  }
}
