package com.example.administrator.mytravel.ui;

import android.net.Uri;

/**
 * Created by Administrator on 2016/4/10.
 */
public class StrategyInfo {
    private String strategyTitle;
    private String strategyContent;
    private Uri imageUri;

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }



}
