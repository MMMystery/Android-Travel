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

public class ActListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView lv_all;
    private ArrayList<ActInfo> list = new ArrayList<ActInfo>();
    private ActInfo actInfo;
    private ActAdapter actAdapter;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_list);


        Bundle bundle = this.getIntent().getExtras();
        String title  = bundle.getString("title");
        String address  = bundle.getString("address");
        String num  = bundle.getString("num");
        String time  = bundle.getString("time");
        String content  = bundle.getString("content");
        Uri uri  = Uri.parse(bundle.getString("uri"));

        ActInfo actInfo = new ActInfo();
        actInfo.setActTitle(title);
        actInfo.setActAdress(address);
        actInfo.setActNum(num);
        actInfo.setActTime(time);
        actInfo.setActContent(content);
        actInfo.setImageUri(uri);

        list.add(actInfo);

        initView();

    }


    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        lv_all = (ListView) findViewById(R.id.actList_lv_all);
        lv_all.setOnItemClickListener(this);
        topBar_bt_right.setVisibility(View.GONE);
        topBar_tv_title.setText("活动列表");
        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actAdapter = new ActAdapter(this,list);
        lv_all.setAdapter(actAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ActListActivity.this,ActDetailsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("title", list.get(position).getActTitle());
        bundle.putString("address", list.get(position).getActAdress());
        bundle.putString("num", list.get(position).getActNum());
        bundle.putString("time", list.get(position).getActTime());
        bundle.putString("content", list.get(position).getActContent());
        bundle.putString("uri", String.valueOf(list.get(position).getImageUri()));

        intent.putExtras(bundle);
        startActivity(intent);
    }

}
