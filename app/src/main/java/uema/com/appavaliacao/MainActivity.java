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

import java.util.ArrayList;
import java.util.Optional;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.Respostas;

public class MainActivity extends AppCompatActivity {
    private FormularioHelper helper;
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new FormularioHelper(this);
         addListenerOnButton();



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

    public void addListenerOnButton( ) {
        Button btnSalvar = (Button) findViewById(R.id.btnEnviar);
        String erro = "";
        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // ArrayList<Integer> listaIds = new ArrayList<Integer>();
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radGrp1);
                RadioButton radio;

                String erros = null;
                boolean valido = true;

                RadioGroup segundoRadioGrout = (RadioGroup) findViewById(R.id.radGrp2);
                RadioButton segundoRadio;

                RadioGroup terceiroRadioGroup = (RadioGroup) findViewById(R.id.radGrp3);
                RadioButton terceiroRadio;

                RadioGroup quartoRadioGroup = (RadioGroup) findViewById(R.id.radGrp4);
                RadioButton quartoRadio;

                RadioGroup quintoRadioGroup = (RadioGroup) findViewById(R.id.radGrp5);
                RadioButton quintoRadio;

                RadioGroup sextoRadioGroup = (RadioGroup) findViewById(R.id.radGrp6);
                RadioButton sextoRadio;

                RadioGroup setimoRadioGroup = (RadioGroup) findViewById(R.id.radGrp7);
                RadioButton setimoRadio;

                RadioGroup oitavoRadioGroup = (RadioGroup) findViewById(R.id.radGrp8);
                RadioButton oitavoRadio;

                RadioGroup nonoRadioGroup = (RadioGroup) findViewById(R.id.radGrp9);
                RadioButton nonoRadio;

                RadioGroup decimoRadioGroup = (RadioGroup) findViewById(R.id.radGrp10);
                RadioButton decimooRadio;

                Respostas resposta = new Respostas();

                //Recupera o id do radioGroup que está selecionado no RadioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();
                int segundoSelectId = segundoRadioGrout.getCheckedRadioButtonId();
                int terceiroSelectId = terceiroRadioGroup.getCheckedRadioButtonId();
                int quartoSelectId = quartoRadioGroup.getCheckedRadioButtonId();
                int quintoSelectId = quintoRadioGroup.getCheckedRadioButtonId();
                int sextoSelectId = sextoRadioGroup.getCheckedRadioButtonId();
                int setimoSelectId = setimoRadioGroup.getCheckedRadioButtonId();
                int oitavoSelectId = oitavoRadioGroup.getCheckedRadioButtonId();
                int nonoSelectId = nonoRadioGroup.getCheckedRadioButtonId();
                int decimoSelectId = decimoRadioGroup.getCheckedRadioButtonId();

                if (selectedId != 0 && selectedId != -1) {
                    // Recupera o radiobutton que estiver selecionado no RadioGroup em questão

                    radio = (RadioButton) findViewById(selectedId);

                    //Criação do objeto Pergunta, a fim de associar à pergunta enviada da View
                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão

                    resposta.setResposta1(radio.getText());

                }
                else{
                    valido = false;
                }

                if (segundoSelectId != 0 && segundoSelectId != -1) {

                    segundoRadio = (RadioButton) findViewById(segundoSelectId);
                    System.out.println(segundoRadio.getText());
                    //Criação do objeto Pergunta, a fim de associar à pergunta enviada da View
                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão
                    resposta.setResposta2(segundoRadio.getText());

                }
                else{
                    valido = false;
                }
                if (terceiroSelectId != 0 && terceiroSelectId != -1) {

                    terceiroRadio = (RadioButton) findViewById(terceiroSelectId);

                    //Criação do objeto Pergunta, a fim de associar à pergunta enviada da View
                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão

                    resposta.setResposta3(terceiroRadio.getText());
                }
                else{
                    valido = false;
                }

                if (quartoSelectId != 0 && quartoSelectId != -1) {

                    quartoRadio = (RadioButton) findViewById(quartoSelectId);
                    resposta.setResposta4(quartoRadio.getText());
                }
                else{
                    valido = false;
                }
                if (quintoSelectId != 0 && quintoSelectId != -1) {
                    quintoRadio = (RadioButton) findViewById(quintoSelectId);
                    resposta.setResposta5(quintoRadio.getText());
                }else{
                    valido = false;
                }

                if (sextoSelectId != 0 && sextoSelectId != -1) {
                    sextoRadio = (RadioButton) findViewById(sextoSelectId);
                    resposta.setResposta6(sextoRadio.getText());
                }else{
                    valido = false;
                }
                if (setimoSelectId != 0 && setimoSelectId != -1) {
                    setimoRadio = (RadioButton) findViewById(setimoSelectId);
                    resposta.setResposta7(setimoRadio.getText());
                }else{
                    valido = false;
                }

                if (oitavoSelectId != 0 && oitavoSelectId != -1) {
                    oitavoRadio = (RadioButton) findViewById(oitavoSelectId);
                    resposta.setResposta8(oitavoRadio.getText());
                }else{
                    valido = false;
                }

                if (nonoSelectId != 0 && nonoSelectId != -1) {
                    nonoRadio = (RadioButton) findViewById(nonoSelectId);
                    resposta.setResposta9(nonoRadio.getText());
                }else{
                    valido = false;
                }

                if (decimoSelectId != 0 && decimoSelectId != -1) {
                    decimooRadio = (RadioButton) findViewById(decimoSelectId);
                    resposta.setResposta10(decimooRadio.getText());
                }else{
                    valido = false;
                }


                if(valido){
                    chamaInserir(resposta);
                    Intent intent = new Intent(MainActivity.this, tela_inicio.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Por favor, verifique se todos os campos foram marcados", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }




}
