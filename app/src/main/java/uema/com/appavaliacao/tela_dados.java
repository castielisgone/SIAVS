package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.ImagemLista;
import uema.com.appavaliacao.modelo.ListaAdaptativa;
import uema.com.appavaliacao.modelo.Respostas;

public class tela_dados extends AppCompatActivity {

    private ListView listaRespostas;
    //a List of type hero for holding list items
    List<ImagemLista> heroList;
    //the listview
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados);

        // ListView listaRespostas = (ListView) findViewById(R.id.lista_respostas);
        //String[] alunos = {"Daniel", "Ronaldo","Jeferson","Felipe"};

        RespostasDAO dao = new RespostasDAO(this);
        List<Respostas> alunos = dao.buscaRespostas();
        int quantidadeBom = 0, quantidadeMedio = 0, quantidadeRuim = 0;
        for(int i = 0; i<alunos.size();i++){

            if(alunos.get(i).getResposta1().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta1().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta1().equals("Bom")){

                quantidadeBom++;
            }

            if(alunos.get(i).getResposta2().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta2().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta2().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta3().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta3().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta3().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta4().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta4().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta4().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta5().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta5().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta5().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta5().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta6().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta6().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta6().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta7().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta7().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta7().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta8().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta8().equals("Bom")){

                quantidadeBom++;
            }

            if(alunos.get(i).getResposta9().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta9().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta9().equals("Bom")){

                quantidadeBom++;
            }
            if(alunos.get(i).getResposta10().equals("Ruim")){

                quantidadeRuim++;
            }

            if(alunos.get(i).getResposta10().equals("Médio")){
                quantidadeMedio++;

            }

            if(alunos.get(i).getResposta10().equals("Bom")){

                quantidadeBom++;
            }


        }

        //initializing objects
        heroList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lista_respostas);

        float porcentagemRuim = (quantidadeRuim/(quantidadeBom + quantidadeMedio + quantidadeBom))*100;
        //adding some values to our list
        heroList.add(new ImagemLista(R.drawable.sad, "Ruim:"+" "+ quantidadeRuim));
        heroList.add(new ImagemLista(R.drawable.confused, "Médio:"+ " "+ quantidadeMedio));
        heroList.add(new ImagemLista(R.drawable.happy, "Bom:"+ " "+ quantidadeBom));


        //creating the adapter
        ListaAdaptativa adapter = new ListaAdaptativa(this, R.layout.activity_tela_dados, heroList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);



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

    /*@Override
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

    }*/

}
