package com.example.project01_clone.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;
import com.google.android.material.tabs.TabLayout;


public class ViewFragment extends Fragment {
    TabLayout tab_layout;
    RecyclerView recv_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view, container, false);

        tab_layout = v.findViewById(R.id.tab_layout);
        
        tab_layout.addTab(tab_layout.newTab().setText("My뷰").setId(1));
        tab_layout.addTab(tab_layout.newTab().setText("발견").setId(2));
        tab_layout.addTab(tab_layout.newTab().setText("카카오TV").setId(3));
        tab_layout.addTab(tab_layout.newTab().setText("코로나").setId(4));
        tab_layout.addTab(tab_layout.newTab().setText("잔여백신").setId(5));

        recv_view = v.findViewById(R.id.recv_view);
        // adopter 나 모양 직접 구현

        tab_layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getId() == 1) {
                    ViewAdapter adapter = new ViewAdapter(inflater, getContext());
                    recv_view.setAdapter(adapter);
                    recv_view.setLayoutManager(CommonMethod.getManager(getContext()));
                }else if (tab.getId() == 2) {
                    ViewAdapter2 adapter = new ViewAdapter2(inflater);
                    recv_view.setAdapter(adapter);
                    recv_view.setLayoutManager(CommonMethod.getManager(getContext()));
                }else if (tab.getId() == 3) {
                    ViewAdapter3 adapter = new ViewAdapter3(inflater);
                    recv_view.setAdapter(adapter);
                    recv_view.setLayoutManager(CommonMethod.getManager(getContext()));
                }

                Log.d("로그", "onTabSelected: " + tab.getPosition());
                // id를 부여하지 않았다면 탭이 가지고 있는 글자 또는 포지션으로 구분


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        



        return v;
    }
}