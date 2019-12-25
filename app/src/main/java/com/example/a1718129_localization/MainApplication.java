package com.example.a1718129_localization;

import android.app.Application;
import android.content.Context;

import com.example.a1718129_localization.Helper.LocaleHelper;

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
