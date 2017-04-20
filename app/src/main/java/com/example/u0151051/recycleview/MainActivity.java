package com.example.u0151051.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//RecylerView使用步驟
//Step1:RecylerView元件在「android.support.v7.widget」套件下，應用程式需要使用RecylerView元件，必須加入需要的設定。
//Step2:開啟「Gradle Scripts -> build.gradle (Module: app)」，在「dependencies」區塊加入需要的設定： compile 'com.android.support:recyclerview-v7:23.0.+'
//Step3:加入上列的設定後，選擇功能表「Tools -> Android -> Sync Project with Gradle Files」，讓Android Studio執行相關的設定。
//在xml畫面區加入RecylerView,並在xml檔手動加入RecylerView的id
//創造一個自己的 MyAdapter繼承RecyclerView.Adapter,在覆寫RecyclerView.Adapter的三個方法
public class MainActivity extends AppCompatActivity {
    RecyclerView recycleListView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            findview();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    void findview() {
        recycleListView = (RecyclerView) findViewById(R.id.list_view);
        ArrayList<String> myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(Integer.toString(i));
        }
            myAdapter = new MyAdapter(myDataset);

        //初始化 recycleListView
        //使用 LinearLayoutManager 來畫出類似 ListView 的功能。可以另外指定 GridLayouManager 或是 StaggeredGridLayoutManager 來畫出不同的外觀
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleListView.setLayoutManager(linearLayoutManager);
        recycleListView.setAdapter(myAdapter);
    }

    //  創造一個自己的 MyAdapter繼承RecyclerView.Adapter,在覆寫RecyclerView.Adapter的三個方法
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        List<String> mydata;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv1;

            public ViewHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) findViewById(R.id.textView2);
            }
        }

        MyAdapter(List<String> data) {
            mydata = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tv1.setText(mydata.get(position));
        }

        @Override
        public int getItemCount() {
            return mydata.size();
        }
    }
}
