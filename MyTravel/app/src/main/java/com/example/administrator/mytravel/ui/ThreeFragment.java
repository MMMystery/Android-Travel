package com.example.administrator.mytravel.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.util.SPUtils;

public class ThreeFragment extends Fragment {

    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private ImageView iv_img2;
    private TextView tv_one;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        tv_one = (TextView) view.findViewById(R.id.center_tv_one);

        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) view.findViewById(R.id.topbar_btn_left);
        iv_img2 = (ImageView) view.findViewById(R.id.center_iv_img2);
        topBar_tv_title.setText("个人中心");
        tv_one.setText(String.valueOf(SPUtils.get(getActivity(),"username","小包子")));

        topBar_bt_left.setVisibility(View.GONE);
        topBar_bt_right.setVisibility(View.GONE);
    }

}
