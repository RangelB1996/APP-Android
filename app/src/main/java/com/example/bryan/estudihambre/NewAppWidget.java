package com.example.bryan.estudihambre;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context,intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            Intent intentTareas = new Intent(context, Tareas.class);
            Intent intentCalculadora = new Intent(context, calculadora.class);
            Intent intentLibros = new Intent(context, biblioteca.class);
            Intent intentBuscar = new Intent(context, busqueda.class);

            PendingIntent pendingIntentTareas = PendingIntent.getActivity(context, 0, intentTareas, 0);
            PendingIntent pendingIntentCalculadora = PendingIntent.getActivity(context, 0, intentCalculadora, 0);
            PendingIntent pendingIntentLibros = PendingIntent.getActivity(context, 0, intentLibros, 0);
            PendingIntent pendingIntentBuscar = PendingIntent.getActivity(context, 0, intentBuscar, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

            views.setOnClickPendingIntent(R.id.image_view_tarea, pendingIntentTareas);
            views.setOnClickPendingIntent(R.id.image_view_calculadora, pendingIntentCalculadora);
            views.setOnClickPendingIntent(R.id.image_view_libros, pendingIntentLibros);
            views.setOnClickPendingIntent(R.id.image_view_buscars, pendingIntentBuscar);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

}

