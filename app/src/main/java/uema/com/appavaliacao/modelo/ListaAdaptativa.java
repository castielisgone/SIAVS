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


//we need to extend the ArrayAdapter class as we are building an adapter
public class ListaAdaptativa extends ArrayAdapter<ImagemLista> {

    //the list values in the List of type hero
    List<ImagemLista> heroList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public ListaAdaptativa(Context context, int resource, List<ImagemLista> lista) {
        super(context, resource, lista);
        this.context = context;
        this.resource = resource;
        this.heroList = lista;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        //TextView segundoTextView = view.findViewById(R.id.segundoTextView);

        //getting the hero of the specified position
        ImagemLista imagem = heroList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(imagem.getImagem()));
        textViewName.setText(imagem.getName());

        //finally returning the view
        return view;
    }

}