package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.starter.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editLoginUsuario;
    private EditText editLoginSenha;
    private Button botaoLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLoginUsuario = (EditText) findViewById(R.id.edit_login_usuario);
        editLoginSenha = (EditText) findViewById(R.id.edit_login_senha);
        botaoLogar = (Button) findViewById(R.id.button_logar);

        //ParseUser.logOut();

        //verifica se o usuario esta logado
        verificarUsuarioLogado();

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editLoginUsuario.getText().toString();
                String senha = editLoginSenha.getText().toString();

                verificarLogin(usuario, senha);
            }
        });





    }

    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

    private void verificarUsuarioLogado(){
        if (ParseUser.getCurrentUser() != null){
            //Enviar usuario para tela principal
            abrirTelaPrincipal();
        }else{

        }
    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void verificarLogin(String usuario, String senha){
        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null){//sucesso no login
                    Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_LONG).show();
                    abrirTelaPrincipal();
                }else{//erro ao logar

                    /**
                     * TEM QUE TRATAR OS ERROS AQUI COM A CLASSE PARSE ERROS!
                     * **/
                    Toast.makeText(LoginActivity.this, "Erro ao realizar o login! " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
