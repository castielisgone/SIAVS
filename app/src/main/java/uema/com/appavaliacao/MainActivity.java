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

public class MainActivity extends AppCompatActivity {


    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botão para salvar os dados
        Button btnSalvar = (Button) findViewById(R.id.btnEnviar);
        //btnSalvar.setOnClickListener(new View.OnClickListener() {

         /*   //irá verificar se os campos estão vazio
            public String validar(){
                String texto_erros="";
                RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radBtn1);
                String valorRadio =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

                if (valorRadio.equals("")){
                    texto_erros = "Campo nome é obrigatório\n";
                    valorRadio.setError("Este campo é obrigatório");
                }
                // pros outros valores

                return texto_erros;
            }
            //ira salvar os dados
            @Override
            public void onClick(View view) {
                String erros = validar();
                if (erros.equals("")) {
                    //Se não houver erros, retorna o texto pra activiry que deu tudo certo, senão, retorna o erro com o Toast
                    Toast.makeText(MainActivity.this, "Cadastro realizado", Toast.LENGTH_SHORT).show();//serve para cliar a mensagem que aparece rapidamente
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Verifique os erros: "+erros, Toast.LENGTH_SHORT).show();//Detectado erros
                }
            }

        });*/

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
}
