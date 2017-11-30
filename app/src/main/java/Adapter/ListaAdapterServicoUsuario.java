package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joinservice.joinservice.R;

import java.util.ArrayList;
import java.util.Date;

import basica.Servico;
import basica.ServicoUsuario;

/**
 * Created by bruno.barbosa on 30/11/2017.
 */

public class ListaAdapterServicoUsuario extends ArrayAdapter<ServicoUsuario> {

    private Context context;
    private ArrayList<ServicoUsuario> lista;

    public ListaAdapterServicoUsuario(Context context, ArrayList<ServicoUsuario> lista) {
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ServicoUsuario servicoUsuarioPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.servicousuario, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewServicoUsuario);
        //imageView.setImageResource(servicoPosicao.get);

        TextView textViewNome = (TextView) convertView.findViewById(R.id.textViewServicoUsuarioNome);
        textViewNome.setText(servicoUsuarioPosicao.getUsuario().getNome());

        TextView textViewValorOfertado = (TextView) convertView.findViewById(R.id.textViewServicoUsuarioValorOfertado);
        textViewValorOfertado.setText("R$: " + servicoUsuarioPosicao.getValorOfertado());

        TextView textViewDescricao = (TextView) convertView.findViewById(R.id.textViewServicoUsuarioDescricao);
        textViewDescricao.setText(servicoUsuarioPosicao.getDescricao());

        TextView textViewTempo = (TextView) convertView.findViewById(R.id.textViewServicoUsuarioData);
        Date date = new Date();
        int qtdDias = (date.compareTo(servicoUsuarioPosicao.getDataOferta()) - 1);
        String texto;
        if (qtdDias > 1) {
            texto = "Ofertado há " + Integer.toString(qtdDias) + " dias atrás";
        }else{
            texto = "Ofertado hoje";
        }

        textViewTempo.setText(texto);

        return convertView;
    }
}