package com.example.administrator.mytravel.ui;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mytravel.R;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.squareup.picasso.Picasso;

import java.io.File;

public class OneFragment extends Fragment {
    private static final String IMAGE_FILE_NAME = "avatarImage.jpg";//拍完照的照片都給它定為這個名字
    private static int CAMERA_REQUEST_CODE = 1;
    private static int GALLERY_REQUEST_CODE = 2;

    private EditText et_one,et_two,et_three,et_four,et_five;
    private TextView topBar_tv_title;
    private Button topBar_bt_right;
    private Button topBar_bt_left;
    private ImageView iv_img;

    private Uri imageUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        et_one = (EditText) view.findViewById(R.id.act_et_one);
        et_two = (EditText) view.findViewById(R.id.act_et_two);
        et_three = (EditText) view.findViewById(R.id.act_et_three);
        et_four = (EditText) view.findViewById(R.id.act_et_four);
        et_five = (EditText) view.findViewById(R.id.act_et_five);
        topBar_tv_title = (TextView) view.findViewById(R.id.topbar_tv_title);
        topBar_bt_right = (Button) view.findViewById(R.id.topbar_btn_right);
        topBar_bt_left = (Button) view.findViewById(R.id.topbar_btn_left);
        iv_img = (ImageView) view.findViewById(R.id.act_iv_img);
        topBar_tv_title.setText("发起活动");

        topBar_bt_left.setVisibility(View.GONE);
        topBar_bt_right.setBackgroundResource(R.drawable.yes);



        topBar_bt_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActListActivity.class);
                //每次点击给添加一组数据

                Bundle bundle = new Bundle();
                bundle.putString("title", et_one.getText().toString());
                bundle.putString("address", et_two.getText().toString());
                bundle.putString("num", et_three.getText().toString());
                bundle.putString("time", et_four.getText().toString());
                bundle.putString("content", et_five.getText().toString());
                bundle.putString("uri", String.valueOf(imageUri));
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });

        iv_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] stringItems = {"拍照", "相册"};
                final ActionSheetDialog dialog = new ActionSheetDialog(getActivity(), stringItems, null);
                dialog.isTitleShow(false)
                        .show();

                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {

                        switch (position) {
                            case 0:
                                //从相机
                                Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                takeIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME)));
                                startActivityForResult(takeIntent, CAMERA_REQUEST_CODE);
                                break;
                            case 1:
                                //从相册
                                Intent intent = new Intent(Intent.ACTION_PICK, null);
                                intent.setDataAndType(
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");//引号里面是image/*
                                startActivityForResult(intent, GALLERY_REQUEST_CODE);
                                break;

                        }
                        dialog.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:// 拍照修改头像
                if (resultCode == Activity.RESULT_OK) {
                    if (!Environment.getExternalStorageState().equals(
                            Environment.MEDIA_MOUNTED)) {
                        Toast.makeText(getActivity(), "SD不可用", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    File file = new File(Environment.getExternalStorageDirectory() + "/" + IMAGE_FILE_NAME);

                     imageUri = Uri.fromFile(file);
                    Picasso.with(getActivity()).load(imageUri).into(iv_img);

                }
                break;
            case 2:// 本地相册修改头像
                if (resultCode == Activity.RESULT_OK) {
                    if (!Environment.getExternalStorageState().equals(
                            Environment.MEDIA_MOUNTED)) {
                        Toast.makeText(getActivity(), "SD不可用", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    imageUri = data.getData();
                    Picasso.with(getActivity()).load(imageUri).into(iv_img);
                }

                break;

            default:
                break;
        }
    }

}
