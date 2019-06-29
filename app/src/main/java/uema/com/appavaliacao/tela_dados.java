package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.Respostas;

public class tela_dados extends AppCompatActivity {


    private ListView listaRespostas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados);

        ListView listaRespostas = (ListView) findViewById(R.id.lista_respostas);
        //String[] alunos = {"Daniel", "Ronaldo","Jeferson","Felipe"};


        Button voltar = (Button) findViewById(R.id.btnVoltar2);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_dados.this, tela_inicio.class);
                startActivity(intent);
                //finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {

        RespostasDAO dao = new RespostasDAO(this);
        List<Respostas> alunos = dao.buscaRespostas();
        dao.close();
        ArrayAdapter<Respostas> adapter=
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alunos);
        listaRespostas.setAdapter(adapter);

    }

}
