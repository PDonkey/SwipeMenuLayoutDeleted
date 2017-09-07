package com.swipemenulayoutdeleted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.swipemenulayoutdeleted.data.DataBean;
import com.swipemenulayoutdeleted.data.Datas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecycleAdapter recycleAdapter;
    private List<DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list= Datas.getDatas();
        recycleAdapter = new RecycleAdapter(MainActivity.this,list);
        recyclerView.setAdapter(recycleAdapter);
    }
}
