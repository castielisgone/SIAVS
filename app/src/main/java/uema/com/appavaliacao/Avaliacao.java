package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import uema.com.appavaliacao.dao.RespostasDAO;
import uema.com.appavaliacao.modelo.Respostas;

public class Avaliacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Chamada da função que faz validação e chamada do banco de dados
        addListenerOnButton();

        //Recuperação do id do botão de 'Sair', para voltar para a Activity da Tela Inicial
        Button voltar = (Button) findViewById(R.id.btnSair);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uso da intent para transição entre as Activitys de Avaliação e a Tela Inicial
                Intent intent = new Intent(Avaliacao.this, TelaInicio.class);
                startActivity(intent);
            }
        });


    }

    //Método que chama o inserir respostas no Banco
    public void chamaInserir(Respostas resposta){

        //Criação da classe de acesso aos dados(DAO)

        RespostasDAO respostasDao = new RespostasDAO(this);
        //Em seguida, passa-se o objeto Resposta por parâmetro
        respostasDao.insere(resposta);
    }

    public void addListenerOnButton( ) {
        //Recupera o id do botão de 'Enviar'
        Button btnSalvar = (Button) findViewById(R.id.btnEnviar);
        String erro = "";
        btnSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Recuperação de todos os 10 radiogroups, a fim de recuperar qual RadioButton está selecionado em cada um
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

                //Criação do objeto que conterá as respostas
                Respostas resposta = new Respostas();

                //Recupera o id do radioGroup que está selecionado em cada um dos 10 radioGroups, através do método
                //getCheckedRadioButtonId(), que retorna qual dos radioButton está selecionado atualmente
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

                //Em seguida, é feita uma pequena lógica para validação. A variável 'valido' começa com true, por padrão, pois
                //espera-se que tudo dê certo. Caso o radioButton não estiver selecionado, ou seja for igual de 0 e igual
                //a -1, ele seta o valido igual a false para exibir mensagem de validação

                if (selectedId != 0 && selectedId != -1) {
                    // Recupera o radiobutton que estiver selecionado no RadioGroup em questão

                    radio = (RadioButton) findViewById(selectedId);

                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão

                    resposta.setResposta1(radio.getText());

                }
                else{
                    valido = false;
                }

                if (segundoSelectId != 0 && segundoSelectId != -1) {

                    segundoRadio = (RadioButton) findViewById(segundoSelectId);
                    System.out.println(segundoRadio.getText());

                    //Após isso, seta com o texto recuperado a partir do radiobutton em questão
                    resposta.setResposta2(segundoRadio.getText());

                }
                else{
                    valido = false;
                }
                if (terceiroSelectId != 0 && terceiroSelectId != -1) {

                    terceiroRadio = (RadioButton) findViewById(terceiroSelectId);

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

                //Se estiver válido nosso modelo,
                if(valido){
                    //Chama o método de inserir a resposta no banco de dados
                    chamaInserir(resposta);
                    //Intent que transitará entre a Activity de avaliação e a Tela Inicial
                    Intent intent = new Intent(Avaliacao.this, TelaInicio.class);
                    Toast.makeText(Avaliacao.this, "Avaliação realizada com sucesso!", Toast.LENGTH_SHORT).show();
                    //Parâmetro extra auxiliar para a Activity Tela Inicial ter um Bundle e realizar uma validação específica no botão de 'Iniciar Avaliação'
                    intent.putExtra("ACTIVITY_OK", 1);
                    intent.putExtra("VALIDO" , 2);
                    startActivity(intent);


                    finish();

                }
                else{
                    Toast.makeText(Avaliacao.this, "Por favor, verifique se todos os campos foram marcados", Toast.LENGTH_SHORT).show();
                }



            }

        });


    }




}
