package uema.com.appavaliacao;


import android.widget.RadioButton;

import uema.com.appavaliacao.modelo.Respostas;

public class FormularioHelper {

    private final RadioButton ruim1;
    private final RadioButton medio1;
    private final RadioButton bom1;

    private final RadioButton ruim2;
    private final RadioButton medio2;
    private final RadioButton bom2;

    private final RadioButton ruim3;
    private final RadioButton medio3;
    private final RadioButton bom3;

 /*   private final RadioButton ruim4;
    private final RadioButton medio4;
    private final RadioButton bom4;*/


    private Respostas respostas;

    public FormularioHelper(MainActivity activity){
        ruim1 = (RadioButton) activity.findViewById(R.id.btnRuim1);
        medio1 = (RadioButton) activity.findViewById(R.id.btnMed1);
        bom1 = (RadioButton) activity.findViewById(R.id.btnBom1);

        ruim2 = (RadioButton) activity.findViewById(R.id.btnRuim2);
        medio2 = (RadioButton) activity.findViewById(R.id.btnMed2);
        bom2 = (RadioButton) activity.findViewById(R.id.btnBom2);

        ruim3 = (RadioButton) activity.findViewById(R.id.btnRuim3);
        medio3 = (RadioButton) activity.findViewById(R.id.btnMed3);
        bom3 = (RadioButton) activity.findViewById(R.id.btnBom3);

        respostas = new Respostas();
    }

    public Respostas pegaRespostas() {
        respostas.setResposta1(ruim1.getText().toString());
        respostas.setResposta1(medio1.getText().toString());
        respostas.setResposta1(bom1.getText().toString());

        respostas.setResposta2(ruim2.getText().toString());
        respostas.setResposta2(medio2.getText().toString());
        respostas.setResposta2(bom2.getText().toString());

        respostas.setResposta3(ruim3.getText().toString());
        respostas.setResposta3(medio3.getText().toString());
        respostas.setResposta3(bom3.getText().toString());


        return respostas;
    }

    public void preencheFormulario(Respostas respostas) {


        ruim1.setText(respostas.getResposta1());
        medio1.setText(respostas.getResposta1());
        bom1.setText(respostas.getResposta1());

        ruim2.setText(respostas.getResposta2());
        medio2.setText(respostas.getResposta2());
        bom2.setText(respostas.getResposta2());

        ruim3.setText(respostas.getResposta3());
        medio3.setText(respostas.getResposta3());
        bom3.setText(respostas.getResposta3());


        this.respostas = respostas;
    }
}
