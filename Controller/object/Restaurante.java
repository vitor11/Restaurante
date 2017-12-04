package telalogin.telalogin.object;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

import fatec.telalogin.R;

/**
 * Created by vitor on 19/09/2017.
 */
public class Restaurante extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] descricao;
    private final String[] texto;
    private final String[] imagem;

    public Restaurante(Activity context, String[] descricao, String[] imagem, String[] texto) {
        super(context, R.layout.list_single, texto);
        this.context = context;
        this.descricao = descricao;
        this.imagem = imagem;
        this.texto = texto;
    }

    public String[] getImageId() {
        return imagem;
    }

    public String[] getDescricao() {
        return descricao;
    }

    public String[] getTexto() {
        return texto;
    }

    @Override
    public Activity getContext() {
        return context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        TextView txtDesc = (TextView) rowView.findViewById(R.id.desc);
        txtDesc.setText(descricao[position]);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(texto[position]);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        Picasso.with(context).load(imagem[position]).into(imageView);

        return rowView;
    }

}
