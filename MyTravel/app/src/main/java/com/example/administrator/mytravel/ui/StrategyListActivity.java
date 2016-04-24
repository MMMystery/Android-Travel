package com.example.administrator.mytravel.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;

import java.util.ArrayList;

public class StrategyListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lv_all;
    private ArrayList<StrategyInfo> list = new ArrayList<StrategyInfo>();
    private StrategyInfo strategyInfo;
    private StrategyAdapter strategyAdapter;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_list);


        Bundle bundle = this.getIntent().getExtras();
        String title  = bundle.getString("title");
        String content  = bundle.getString("content");
        Uri uri  = Uri.parse(bundle.getString("uri"));

        StrategyInfo strategyInfo = new StrategyInfo();
        strategyInfo.setStrategyTitle(title);
        strategyInfo.setStrategyContent(content);
        strategyInfo.setImageUri(uri);

        list.add(strategyInfo);

        initView();

    }


    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        lv_all = (ListView) findViewById(R.id.strategyList_lv_all);
        lv_all.setOnItemClickListener(this);
        topBar_bt_right.setVisibility(View.GONE);
        topBar_tv_title.setText("攻略列表");
        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        strategyAdapter = new StrategyAdapter(this,list);
        lv_all.setAdapter(strategyAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(StrategyListActivity.this,StrategyDetailsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("title", list.get(position).getStrategyTitle());
        bundle.putString("content", list.get(position).getStrategyContent());
        bundle.putString("uri", String.valueOf(list.get(position).getImageUri()));

        intent.putExtras(bundle);
        startActivity(intent);
    }

}
