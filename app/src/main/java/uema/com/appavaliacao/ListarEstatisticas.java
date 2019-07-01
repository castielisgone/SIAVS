package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.ImagemLista;
import uema.com.appavaliacao.modelo.ListaAdaptativa;
import uema.com.appavaliacao.modelo.Respostas;

public class ListarEstatisticas extends AppCompatActivity {

    //Lista que conterá as imagens
    List<ImagemLista> lista;
    //O List View
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dados);
        //Instancia um objeto de acesso a dados, passando o contexto
        RespostasDAO dao = new RespostasDAO(this);
        //Recupera o resultado vindo da pesquisa do banco de dados
        List<Respostas> respostas = dao.buscaRespostas();

        //Baseado na quantidade de respostas médias, ruins  e boas do usuário, conta-se
        // a quantidade de cada uma, para o cálculo da porcentagem, mais abaixo no código

        int quantidadeBom = 0, quantidadeMedio = 0, quantidadeRuim = 0;
        //Para o índice começando de 0, até o tamanho da lista de respostas retornada do banco,
        //verifica as respostas e vai contando a quantidade de cada subitem(Bom, ruim, médio) para incrementar as variáveis
        for(int i = 0; i<respostas.size();i++){

            if(respostas.get(i).getResposta1().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta1().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta1().equals("Bom")){

                quantidadeBom++;
            }

            if(respostas.get(i).getResposta2().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta2().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta2().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta3().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta3().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta3().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta4().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta4().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta4().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta5().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta5().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta5().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta5().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta6().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta6().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta6().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta7().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta7().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta7().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta8().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta8().equals("Bom")){

                quantidadeBom++;
            }

            if(respostas.get(i).getResposta9().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta9().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta9().equals("Bom")){

                quantidadeBom++;
            }
            if(respostas.get(i).getResposta10().equals("Ruim")){

                quantidadeRuim++;
            }

            if(respostas.get(i).getResposta10().equals("Médio")){
                quantidadeMedio++;

            }

            if(respostas.get(i).getResposta10().equals("Bom")){

                quantidadeBom++;
            }


        }

        //Inicializa os objetos e algumas declarações de variáveis para auxílio do cálculo da porcentagem de respostas da avaliação do usuário
        lista = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lista_respostas);

        float porcentagemRuim;
        float porcentagemMedia;
        float porcentagemBom;

        //Se houver avaliação no banco, calcula a porcentagem de respostas para cada subtipo

        if(quantidadeBom != 0 && quantidadeMedio != 0 && quantidadeRuim != 0){
            porcentagemRuim = ((1.0f*quantidadeRuim)/(quantidadeRuim + quantidadeMedio + quantidadeBom))*100;
            porcentagemMedia = ((1.0f*quantidadeMedio)/(quantidadeRuim + quantidadeMedio + quantidadeBom))*100;
            porcentagemBom = ((1.0f*quantidadeBom)/(quantidadeRuim + quantidadeMedio + quantidadeBom))*100;

        }
        else{
            porcentagemBom = 0;
            porcentagemMedia =0;
            porcentagemRuim =0;
        }



        //Adição dos valores às respectivas figuras, com sua porcentagem
        lista.add(new ImagemLista(R.drawable.sad, "Ruim:"+" "+ porcentagemRuim +" %"));
        lista.add(new ImagemLista(R.drawable.confused, "Médio:"+ " "+ porcentagemMedia+" %"));
        lista.add(new ImagemLista(R.drawable.happy, "Bom:"+ " "+ porcentagemBom+" %"));



        //Criando um objeto da minha lista que conterá as imagens, passando a Activity, o layout respectivo e a lista de figuras
        ListaAdaptativa adapter = new ListaAdaptativa(this, R.layout.activity_tela_dados, lista);

        //Setando o listView apara a minha lista adaptativa
        listView.setAdapter(adapter);



    }

//Método para acionar a função de 'Voltar' do sistema operacional, para mandar a Intent direcionar para a Tela Inicial
    @Override
    public void onBackPressed()
    {
        //Intent para voltar pra Activity da tela principal

        super.onBackPressed();
        Intent intent = new Intent(ListarEstatisticas.this, TelaInicio.class);
        intent.putExtra("ACTIVITY_LISTAGEM", 3);
        startActivity(intent);
        finish();
    }
}
