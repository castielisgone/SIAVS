package uema.com.appavaliacao.modelo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uema.com.appavaliacao.R;



//Extende de ArrayAdapter para adaptar nossa listView como queremos
public class ListaAdaptativa extends ArrayAdapter<ImagemLista> {

    //Lista com as imagens dos rostos
    List<ImagemLista> lista;

    //Contexto da activity
    Context contexto;

    //Layout
    int caminhoLayout;

    //Inicializa o construtor, recebendo o contexto da activity, o layout e a lista que será adaptada no ImageView
    public ListaAdaptativa(Context contexto, int caminhoLayout, List<ImagemLista> lista) {
        super(contexto, caminhoLayout, lista);
        this.contexto = contexto;
        this.caminhoLayout = caminhoLayout;
        this.lista = lista;
    }

    //this will return the ListView Item as a View
    //Retorna um item do listView como um objeto View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Para recuperar a view do XML para nosso listitem, usa-se o LayoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(contexto);

        //Recuperando a view, passando o layout
        View view = layoutInflater.inflate(caminhoLayout, null, false);


        //Recuperando a view dos elementos da lista direto da View
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);

        //Recuperando a posição da Imagem
        ImagemLista imagem = lista.get(position);

        //Dimensionando através do método setImageDrawable, recebendo a Activity da listagem, e as imagens e o texto(Ruim, bom ou médio)
        imageView.setImageDrawable(contexto.getResources().getDrawable(imagem.getImagem()));
        textViewName.setText(imagem.getName());


        return view;
    }

}