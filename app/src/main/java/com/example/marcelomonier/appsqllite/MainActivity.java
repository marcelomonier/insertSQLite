package com.example.marcelomonier.appsqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDb;

    EditText txt_nome, txt_sobrenome, txt_profissao;

    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataBaseHelper(this);

        txt_nome = (EditText) findViewById(R.id.editText3);
        txt_sobrenome = (EditText) findViewById(R.id.editText2);
        txt_profissao = (EditText) findViewById(R.id.editText);

        btnEnviar = (Button) findViewById(R.id.button);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickMe();
            }
        });

    }

    public void ClickMe(){

        String nome = txt_nome.getText().toString();
        String sobrenome = txt_sobrenome.getText().toString();
        String profissao = txt_profissao.getText().toString();

        Boolean result = myDb.insertData(nome, sobrenome, profissao);

        if (result == true){
            Toast.makeText(this, "Dados inseridos com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro ao inserir dados", Toast.LENGTH_SHORT).show();
        }



    }



}
