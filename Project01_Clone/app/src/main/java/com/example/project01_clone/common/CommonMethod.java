package com.example.project01_clone.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {
    // 매번 화면에서 Layout 매니저를 직접 만드는 행위가 불편
    // 재사용이 가능한 메소드 하나를 이용해서 코드를 줄여보고자 한다
    // 레이아웃매니저를 리턴하는 메소드를 CommonMethod에 정의 해보고
    // Fragment 에서 호출해서 사용해보기

    public static LinearLayoutManager getManager(Context context) {
        LinearLayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        return manager;
    }
}
