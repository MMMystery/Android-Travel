package com.example.administrator.mytravel.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.squareup.picasso.Picasso;

public class StrategyDetailsActivity extends AppCompatActivity {
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private StrategyInfo strategyInfo;
    private TextView tv_title;

    private TextView tv_content;
    private ImageView detail_iv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy_details);


        initView();
    }

    private void initView() {
        topBar_tv_title = (TextView) findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) findViewById(R.id.topbar_btn_left);
        tv_title = (TextView) findViewById(R.id.strategydetail_tv_title);

        tv_content = (TextView) findViewById(R.id.strategydetail_tv_content);
        detail_iv_img = (ImageView) findViewById(R.id.detail_iv_img);

        topBar_tv_title.setText("攻略详情");
        topBar_bt_right.setVisibility(View.GONE);

        topBar_bt_left.setBackgroundResource(R.drawable.back);
        topBar_bt_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        String title  = bundle.getString("title");
        String address  = bundle.getString("address");
        String num  = bundle.getString("num");
        String time  = bundle.getString("time");
        String content  = bundle.getString("content");
        Uri uri  = Uri.parse(bundle.getString("uri"));

        tv_title.setText(title);
        tv_content.setText(content);
        Picasso.with(this).load(uri).into(detail_iv_img);
    }
}
