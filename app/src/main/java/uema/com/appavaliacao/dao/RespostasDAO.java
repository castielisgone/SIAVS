package uema.com.appavaliacao.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import uema.com.appavaliacao.modelo.Respostas;


public class RespostasDAO extends SQLiteOpenHelper {

    public RespostasDAO(Context context) {
        super(context, "Avaliacao", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TABELAREAL (id INTEGER PRIMARY KEY, resposta1 TEXT NOT NULL, resposta2 TEXT NOT NULL, resposta3 TEXT NOT NULL," +
                "resposta4 TEXT NOT NULL, resposta5 TEXT NOT NULL, resposta6 TEXT NOT NULL, resposta7 TEXT NOT NULL, resposta8 TEXT NOT NULL," +
                "resposta9 TEXT NOT NULL, resposta10 TEXT NOT NULL)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS TABELAREAL";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Respostas resposta) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosResposta(resposta);
        dados.put("resposta1", (String) resposta.getResposta1());
        dados.put("resposta2", (String) resposta.getResposta2());
        dados.put("resposta3", (String) resposta.getResposta3());
        dados.put("resposta4", (String)resposta.getResposta4());
        dados.put("resposta5", (String)resposta.getResposta5());
        dados.put("resposta6", (String)resposta.getResposta6());
        dados.put("resposta7",(String)resposta.getResposta7());
        dados.put("resposta8", (String)resposta.getResposta8());
        dados.put("resposta9", (String)resposta.getResposta9());
        dados.put("resposta10", (String)resposta.getResposta10());
        System.out.println("CHAMOU");
        db.insert("TABELAREAL", null, dados);

    }

    @NonNull
    private ContentValues pegaDadosResposta(Respostas resposta) {
        ContentValues dados = new ContentValues();
        dados.put("resposta1", (String) resposta.getResposta1());
        dados.put("resposta2", (String) resposta.getResposta2());
        dados.put("resposta3", (String) resposta.getResposta3());
        dados.put("resposta4", (String)resposta.getResposta4());
        dados.put("resposta5", (String)resposta.getResposta5());
        dados.put("resposta6", (String)resposta.getResposta6());
        dados.put("resposta7",(String)resposta.getResposta7());
        dados.put("resposta8", (String)resposta.getResposta8());
        dados.put("resposta9", (String)resposta.getResposta9());
        dados.put("resposta10", (String)resposta.getResposta10());

        return dados;
    }

    public List<Respostas> buscaRespostas() {
        String parametroTeste = "Ruim";
        //String sql = "SELECT * FROM TABELAREAL WHERE resposta1 LIKE '%"+parametroTeste+"%';";
        String sql = "SELECT * FROM TABELAREAL;";
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(sql, null);

        List<Respostas> respostas = new ArrayList<>();
        while(c.moveToNext()){
            Respostas resposta = new Respostas();
            resposta.setId(c.getLong(c.getColumnIndex("id")));
            resposta.setResposta1(c.getString(c.getColumnIndex("resposta1")));
            resposta.setResposta2(c.getString(c.getColumnIndex("resposta2")));
            resposta.setResposta3(c.getString(c.getColumnIndex("resposta3")));
            resposta.setResposta4(c.getString(c.getColumnIndex("resposta4")));
            resposta.setResposta5(c.getString(c.getColumnIndex("resposta5")));
            resposta.setResposta6(c.getString(c.getColumnIndex("resposta6")));
            resposta.setResposta7(c.getString(c.getColumnIndex("resposta7")));
            resposta.setResposta8(c.getString(c.getColumnIndex("resposta8")));
            resposta.setResposta9(c.getString(c.getColumnIndex("resposta9")));
            resposta.setResposta10(c.getString(c.getColumnIndex("resposta10")));

            respostas.add(resposta);
        }


        c.close();
        return respostas;
    }

    /*public void deleta(Respostas aluno) {

        SQLiteDatabase db = getWritableDatabase();
        String[] params = {String.valueOf(aluno.getId())};
        db.delete("Alunos", "id = ?", params);
    }*/

   /* public void altera(Respostas aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosResposta(aluno);

        String[] params = {String.valueOf(aluno.getId())};
        db.update("Alunos", dados, "id = ?", params);
    }*/



}
