package com.example.devops.fragments;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.devops.Profile.LoginActivity;
import com.example.devops.R;
import com.example.devops.SearchBanks.Search;
import com.example.devops.Static.Camp;
import com.example.devops.Static.Drive;
import com.example.devops.Static.Funds;
import com.example.devops.Static.InfoDesk;
import com.example.devops.Static.Procedure;
import com.example.devops.Static.Request;
import com.example.devops.Vets.Vets;


public class Frag1 extends Fragment {

    private View v;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Frag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag1 newInstance(String param1, String param2) {
        Frag1 fragment = new Frag1();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_frag1, container, false);
        configureImageButton();
        return v;
    }

    private void configureImageButton() {

        ImageButton blood = (ImageButton) v.findViewById(R.id.bloodbank);
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Search.class);
                startActivity(intent);

            }
        });

        ImageButton request = (ImageButton) v.findViewById(R.id.request);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Request.class);
                startActivity(intent);

            }
        });
        ImageButton vets = (ImageButton) v.findViewById(R.id.vets);
        vets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Vets.class);
                startActivity(intent);

            }
        });
        ImageButton funds = (ImageButton) v.findViewById(R.id.funds);
        funds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Funds.class);
                startActivity(intent);

            }
        });
        ImageButton info= (ImageButton) v.findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InfoDesk.class);
                startActivity(intent);

            }
        });
        ImageButton proc= (ImageButton) v.findViewById(R.id.procedure);
        proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Procedure.class);
                startActivity(intent);

            }
        });
        ImageButton camp = (ImageButton) v.findViewById(R.id.camp);
        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Camp.class);
                startActivity(intent);

            }
        });
        ImageButton drive = (ImageButton) v.findViewById(R.id.drive);
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Drive.class);
                startActivity(intent);

            }
        });


    }
}