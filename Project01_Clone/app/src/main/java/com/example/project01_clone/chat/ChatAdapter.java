package com.example.project01_clone.chat;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<ChatDTO> list;
    Context context;

    public ChatAdapter(LayoutInflater inflater, ArrayList<ChatDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_chat, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override   // Binding, bind ↔ 어떤 화면에 보이는 요소와 화면에 보이지 않는 데이터가 연결이 되었는가
                // ViewHolder(데이터 한 칸을 저장해놓은 DTO 화면에 보이는 요소) ↔ ArrayList 의 데이터
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.imgv_chat_profile.setImageResource(list.get(i).getImgRes());
        h.tv_chat_name.setText(list.get(i).getName());
        h.tv_chat_msg.setText(list.get(i).getMsg());
        h.tv_chatdate.setText(list.get(i).getDate());

        final int idx = i;
        // 한칸에 있는 리니어 레이아웃 클릭 시 어떤 처리를 하겠다.
        h.ln_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면 전환 → 채팅 액티비티
                Log.d("로그", "onClick: 클릭됨");
                Context con_temp = v.getContext();

                Intent intent = new Intent(context, ChattingActivity.class);
                intent.putExtra("dto", list.get(idx));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_chat_profile;
        TextView tv_chat_name, tv_chat_msg, tv_chatdate;
        LinearLayout ln_chat;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_chat_profile = v.findViewById(R.id.imgv_chat_profile);
            tv_chat_name = v.findViewById(R.id.tv_chat_name);
            tv_chat_msg = v.findViewById(R.id.tv_chat_msg);
            tv_chatdate = v.findViewById(R.id.tv_chatdate);
            ln_chat = v.findViewById(R.id.ln_chat);
        }
    }
}
