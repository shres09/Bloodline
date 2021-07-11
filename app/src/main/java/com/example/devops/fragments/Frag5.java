package com.example.devops.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.devops.R;
import com.example.devops.Static.FAQ;
import com.example.devops.Vets.Vets;


public class Frag5 extends Fragment {

    private View v;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Frag5() {

    }


    public static Frag5 newInstance(String param1, String param2) {
        Frag5 fragment = new Frag5();
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
        v = inflater.inflate(R.layout.fragment_frag5, container, false);
        configureImage();
        return v;
    }

        private void configureImage(){
            ImageButton call = v.findViewById(R.id.call);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9956789650"));
                    startActivity(intent);
                }
            });

            ImageButton mail = v.findViewById(R.id.email);
            mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.putExtra(emailIntent.EXTRA_EMAIL, Uri.parse("mailto:shresta0912@gmail,com"));
                    emailIntent.setType("Text/Plain");
                    startActivity(emailIntent);
                }
            });

            ImageButton faq = v.findViewById(R.id.faq);
            faq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), FAQ.class);
                    startActivity(intent);
                }
            });

        }
}