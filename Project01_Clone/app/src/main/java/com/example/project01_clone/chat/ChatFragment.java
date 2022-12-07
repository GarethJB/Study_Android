package com.example.project01_clone.chat;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;
import com.example.project01_clone.friendlist.FriendDTO;

import java.util.ArrayList;
import java.util.Random;

public class ChatFragment extends Fragment {
    RecyclerView recv_chat_frag;
    ArrayList<ChatDTO> list = new ArrayList<>();
    int[] imgArr = {
            R.drawable.profile_img1,
            R.drawable.profile_img2,
            R.drawable.profile_img3,
            R.drawable.profile_img4,
            R.drawable.profile_img5,
            R.drawable.profile_img6,
            R.drawable.profile_img7,
            R.drawable.profile_img8
    };


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        for (int i = 0; i <= 30; i++) {
            list.add(new ChatDTO(imgArr[new Random().nextInt(imgArr.length)], "친구" + (i+1), "대화" + (i+1), "오후 11:34"));
        }
        ArrayList<?> list2 = new ArrayList<>();


        ChatAdapter adapter = new ChatAdapter(inflater, list, getContext());
        recv_chat_frag = v.findViewById(R.id.recv_chat_frag);
        recv_chat_frag.setAdapter(adapter); // 리사이클러뷰 ↔ 어댑터 연결



        recv_chat_frag.setLayoutManager(CommonMethod.getManager(getContext()));

        //RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        //recv_chat_frag.setLayoutManager(manager);


        return v;
    }
}