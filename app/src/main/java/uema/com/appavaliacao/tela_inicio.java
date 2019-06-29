package uema.com.appavaliacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tela_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);


        Button avaliacao = (Button) findViewById(R.id.btnIniciar);
        avaliacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tela_inicio.this, MainActivity.class);
                startActivity(intent);
                //finish();
            }
        });



    }


}
