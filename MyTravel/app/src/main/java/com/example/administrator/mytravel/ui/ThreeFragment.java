package com.example.administrator.mytravel.ui;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mytravel.R;

public class ThreeFragment extends Fragment {
    private static final String IMAGE_FILE_NAME = "avatarImage.jpg";//拍完照的照片都給它定為這個名字
    private static int CAMERA_REQUEST_CODE = 1;
    private static int GALLERY_REQUEST_CODE = 2;

    private EditText et_two,et_three;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private ImageView iv_img;

    private Uri imageUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

        et_two = (EditText) view.findViewById(R.id.act_et_two);
        et_three = (EditText) view.findViewById(R.id.act_et_three);

        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) view.findViewById(R.id.topbar_btn_left);
        iv_img = (ImageView) view.findViewById(R.id.act_iv_img);
        topBar_tv_title.setText("个人中心");

        topBar_bt_left.setVisibility(View.GONE);
        topBar_bt_right.setVisibility(View.GONE);
    }

}
