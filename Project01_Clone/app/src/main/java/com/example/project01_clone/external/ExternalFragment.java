package com.example.project01_clone.external;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project01_clone.R;


public class ExternalFragment extends Fragment {
    ImageView imgv1, imgv2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_external, container, false);
        imgv1 = v.findViewById(R.id.imgv1);
        imgv2 = v.findViewById(R.id.imgv2);
        Glide.with(this).load("https://img.theqoo.net/img/gpRit.png").into(imgv1);
        Glide.with(this).load("https://dispatch.cdnser.be/cms-content/uploads/2021/08/16/8726a7ae-8885-4f17-b3ef-379dbd78c5b5.gif").into(imgv2);

        return v;
    }
}