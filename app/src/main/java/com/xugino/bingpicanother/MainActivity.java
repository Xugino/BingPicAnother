package com.xugino.bingpicanother;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    List<Map<String,Object>> mList;
    DataResource data;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        mList=new ArrayList<>();
        data=new DataResource();
        mAdapter=new MyAdapter(MainActivity.this,mList,data);
        mListView=(ListView)this.findViewById(R.id.list);
        mListView.setAdapter(mAdapter);
    }

    private void initData(){
        mList.addAll(data.getData());
        mAdapter.notifyDataSetChanged();
    }

}
