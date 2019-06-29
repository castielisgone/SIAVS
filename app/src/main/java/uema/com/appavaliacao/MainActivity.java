package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Optional;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.Respostas;

public class MainActivity extends AppCompatActivity {

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String verificarErros =  addListenerOnButton();
        if(verificarErros.equals(null)){
            Button novoAluno = (Button) findViewById(R.id.btnEnviar);
            novoAluno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, tela_inicio.class);
                    startActivity(intent);
                    //finish();
                }
            });
        }
        else{

        }

        Button voltar = (Button) findViewById(R.id.btnSair);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tela_inicio.class);
                startActivity(intent);
            }
        });


    }

    public void chamaInserir(Respostas resposta){

        //Criação da classe de acesso aos dados(DAO)
        RespostasDAO respostasDao = new RespostasDAO(this);
        //Em seguida, passa-se o objeto Resposta por parâmetro
        respostasDao.insere(resposta);
    }

    public String addListenerOnButton( ) {
        Button btnSalvar = (Button) findViewById(R.id.btnEnviar);
        String  erro = "";
        btnSalvar.setOnClickListener(new View.OnClickListener() {

            private int selectedId;

            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radGrp1);
                RadioButton radio;

                //Recupera o id do radioGroup que está selecionado no RadioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId != 0 && selectedId != -1){
                    // Recupera o radiobutton que estiver selecionado no RadioGroup em questão

                    radio = (RadioButton) findViewById(selectedId);
                    System.out.println(radio.getText());
                    //Criação do objeto Pergunta, a fim de associar à pergunta enviada da View
                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão
                    Respostas resposta = new Respostas();
                    resposta.setResposta1(radio.getText());
                    chamaInserir(resposta);


                    Toast.makeText(MainActivity.this, radio.getText(), Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this,
                            "Selecione uma alternativa pra questão 1", Toast.LENGTH_SHORT).show();
                }


            }

        });

        return erro;

    }




}
