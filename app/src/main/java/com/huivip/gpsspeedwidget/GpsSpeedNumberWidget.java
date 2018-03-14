package com.huivip.gpsspeedwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.huivip.gpsspeedwidget.utils.PrefUtils;


/**
 * @author sunlaihui
 */
public class GpsSpeedNumberWidget extends AppWidgetProvider {
    @Override
    public void onReceive(Context context, Intent paramIntent) {
        super.onReceive(context, paramIntent);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.speednumberwidget);
        Intent service = new Intent(context, GpsSpeedService.class);
        views.setOnClickPendingIntent(R.id.number_widget, PendingIntent.getService(context, 0,
                service, 0));
        if(paramIntent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)){
            boolean start = PrefUtils.isEnableAutoStart(context);
            if(start && PrefUtils.isWidgetActived(context)) {
                context.startService(service);
            }
        }

        ComponentName localComponentName = new ComponentName(context, GpsSpeedNumberWidget.class);
        AppWidgetManager.getInstance(context).updateAppWidget(localComponentName, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
/*        super.onUpdate(context, appWidgetManager, appWidgetIds);*/
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        PrefUtils.setWidgetActived(context,false);
        context.stopService(new Intent(context,GpsSpeedService.class));
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d("huivip","Widget Enabled");
        PrefUtils.setWidgetActived(context,true);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.d("huivip","Widget Disabled");
        PrefUtils.setWidgetActived(context,false);
    }

}