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

//Para utilizar o SQLITE, extende-se a classe SQLiteOpenHelper

public class RespostasDAO extends SQLiteOpenHelper {

    //Construtor da classe de acesso a dados, recebendo o contexto
    public RespostasDAO(Context context) {
        super(context, "Avaliacao", null, 1);
    }

    //Ao criar, cria-se a tabela com uma chave primária, e as respostas não nulas
    @Override
    public void onCreate(SQLiteDatabase db) {
        //String SQL de criação da tabela
        String sql = "CREATE TABLE TABELAREAL (id INTEGER PRIMARY KEY, resposta1 TEXT NOT NULL, resposta2 TEXT NOT NULL, resposta3 TEXT NOT NULL," +
                "resposta4 TEXT NOT NULL, resposta5 TEXT NOT NULL, resposta6 TEXT NOT NULL, resposta7 TEXT NOT NULL, resposta8 TEXT NOT NULL," +
                "resposta9 TEXT NOT NULL, resposta10 TEXT NOT NULL)";

        //Execução do comando SQL
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS TABELAREAL";
        db.execSQL(sql);
        onCreate(db);
    }

    //Função que insere a Avaliação, com suas respostas, no banco

    public void insere(Respostas resposta) {
        //Recebe como parâmetro um objeto que conterá todas as respostas
        SQLiteDatabase db = getWritableDatabase();
        //contentValues, para recuperar os dados e oinserir no banco
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

    //Método que retorna o contentValues da Avaliação, para inserção no banco
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

    //Método que pesquisa na tabela

    public List<Respostas> buscaRespostas() {

        //Pesquisa SQL de seleção, na tabela específica
        String sql = "SELECT * FROM TABELAREAL;";
        SQLiteDatabase db = getReadableDatabase();

        //Executa a query
        Cursor c = db.rawQuery(sql, null);

        //Instanciação de uma Lista que armazenará os valores a serem retornados
        List<Respostas> respostas = new ArrayList<>();
        //Enquanto ouver objetos no banco de dados, o cursor apontará para o próximo
        while(c.moveToNext()){
            //Recuperação das respostas da Avaliação em questão
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

            //Adição da Avaliação na Lista
            respostas.add(resposta);
        }

        //Fechando transação e retornando a Lista para onde for chamado
        c.close();
        return respostas;
    }




}
