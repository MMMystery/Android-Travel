package com.example.administrator.mytravel.ui;

import android.net.Uri;

/**
 * Created by Administrator on 2016/4/10.
 */
public class ActInfo {
    private String actTitle;
    private String actAdress;
    private String actNum;
    private String actTime;
    private String actContent;
    private Uri imageUri;

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }

    public String getActAdress() {
        return actAdress;
    }

    public void setActAdress(String actAdress) {
        this.actAdress = actAdress;
    }

    public String getActNum() {
        return actNum;
    }

    public void setActNum(String actNum) {
        this.actNum = actNum;
    }

    public String getActTime() {
        return actTime;
    }

    public void setActTime(String actTime) {
        this.actTime = actTime;
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent;
    }
}
