package com.appspot.afnf4199ga.twawm.app;

import android.app.Application;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;

import com.appspot.afnf4199ga.twawm.Const;
import com.appspot.afnf4199ga.utils.MyUncaughtExceptionHandler;

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // UncaughtExceptionHandler初期化
        MyUncaughtExceptionHandler.init(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Logger.v("MainApp onConfigurationChanged");

        Intent intent = new Intent(Const.INTENT_WD_STYLE_CHANGED, null, this, DefaultWidgetProvider.class);

        AppWidgetManager appWidgetMgr = AppWidgetManager.getInstance(this);
        ComponentName cm = new ComponentName(this, DefaultWidgetProvider.class);
        int[] appWidgetIds = appWidgetMgr.getAppWidgetIds(cm);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        sendBroadcast(intent);
    }
}
