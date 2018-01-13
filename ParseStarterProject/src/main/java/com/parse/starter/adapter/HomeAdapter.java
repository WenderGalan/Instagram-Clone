package com.parse.starter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.parse.ParseObject;
import com.parse.starter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Wender Galan Gamer on 13/01/2018.
 */

public class HomeAdapter extends ArrayAdapter<ParseObject> {

    private Context context;
    private ArrayList<ParseObject> postagens;

    public HomeAdapter(Context c, ArrayList<ParseObject> objects) {
        super(c, 0, objects);
        this.context = c;
        this.postagens = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        /**
         * Verifica se nao existe o objeto view criado, pois a view utilizada no cache do android
         * e fica na variavel convertView
         * **/

        if (view == null){
            //inicializa o objeto para monstagens do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            //monta a view a partir do xml
            view = inflater.inflate(R.layout.lista_postagem, parent, false);
        }

        //verifica se existe postagens

        if (postagens.size() > 0){
            //recupera os componentes da tela
            ImageView imagemPostagem = (ImageView) view.findViewById(R.id.image_lista_postagem);

            ParseObject parseObject = postagens.get(position);

            Picasso.with(context).load( parseObject.getParseFile("imagem").getUrl()).fit().into(imagemPostagem);

        }

        return view;

    }
}
