package com.joinservice.joinservice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joinservice.joinservice.maps.MapsFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import basica.Categoria;
import basica.Servico;
import basica.Usuario;

public class ServicoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Servico servico;

    TextView descricaoServico, prazoServico, dataServico, usuarioServico;

    private FragmentManager fragmentManager;

    public ServicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServicoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServicoFragment newInstance(String param1, String param2) {
        ServicoFragment fragment = new ServicoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        if (getArguments() != null) {
            servico = (Servico) getArguments().getSerializable("SERVICO");
        }else{
            servico = new Servico();
        }

        fragmentManager = getActivity().getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putDouble("LONGITUDE", Double.parseDouble(servico.getLongitude()));
        args.putDouble("LATITUDE", Double.parseDouble(servico.getLatitude()));
        fragment.setArguments(args);

        transaction.add(R.id.frameLayoutContainerMapServico, fragment, "MapsFragment" );

        transaction.commitAllowingStateLoss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_servico, container, false);

        descricaoServico = (TextView) view.findViewById(R.id.textViewDescricaoFragmentServico);
        descricaoServico.setText(servico.getDescricao());

        prazoServico = (TextView) view.findViewById(R.id.textViewPrazoFragmentServico);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        prazoServico.setText(dateFormat.format(servico.getDataInsercao())); //+ " - " + servico.getPrazo());

        usuarioServico = (TextView) view.findViewById(R.id.textViewUsuarioFragmentServico);
        usuarioServico.setText(servico.getUsuario().getNome());

        return view;
    }
}
