package uema.com.appavaliacao;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicio extends AppCompatActivity {
    //Método que cria a Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        //Caso receba o parãmetro vindo da transação efetivada da Activity de Avaliação, some com o botão, pois
        //pode-se apenas uma avaliação por celular
        Bundle instancia = getIntent().getExtras();
        //Se existir o objeto Bundler enviado pela intent por putExtra
        if (instancia != null) {

            //Verifica se existem mais de 1 parâmetro(ACTIVITY_OK e VALIDO), para identificar que é da Activity Avaliação

            if (instancia.size() != 1) {

                    Button botao = (Button) findViewById(R.id.btnIniciar);
                    botao.setVisibility(View.GONE);

            }
            //Senão, está vindo de outra Activity, a da 'Ver Estatítiscas"
            else{

                Button botao = (Button) findViewById(R.id.btnIniciar);
                botao.setVisibility(View.GONE);
            }

        }

        //Recuperação do id do botão de 'Iniciar Avaliação', para então chamar a tela de Avaliação, por meio da Intent
        final Button avaliacao = (Button) findViewById(R.id.btnIniciar);
        avaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent que fará intermédio entre a Activity da Tela Inicial com a Activity de Avaliação
                Intent intent = new Intent(TelaInicio.this, Avaliacao.class);
                startActivity(intent);
                finish();
            }
        });

        //Recuperação do id do Botão de 'Ver estatísticas', para chamar a Activity que contém a Listagem das estatísticas da Avaliação do funcionário
        Button listadados = (Button) findViewById(R.id.btnListar);
        listadados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent responsável pela mediação da 'Tela Início' com a Activity de Listagem de estatísticas da sua avaliação
                Intent intent = new Intent(TelaInicio.this, ListarEstatisticas.class);
                startActivity(intent);
                finish();
            }
        });

        //Rwcuperação do id do botão de "Sair", para sair do aplicativo
        Button sair = (Button) findViewById(R.id.btnSair);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Finalização do app
                moveTaskToBack(true);
                finish();
            }
        });


    }


}
