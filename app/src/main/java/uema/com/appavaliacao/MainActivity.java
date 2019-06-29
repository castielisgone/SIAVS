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


     public String addListenerOnButton( ) {
        Button btnSalvar = (Button) findViewById(R.id.btnEnviar);
        String  erro = "";
        btnSalvar.setOnClickListener(new View.OnClickListener() {

            private int selectedId;

            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radGrp1);
                RadioButton radio;
                boolean valido = true;

                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId != 0 && selectedId != -1){
                    // find the radiobutton by returned id

                    radio = (RadioButton) findViewById(selectedId);
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
