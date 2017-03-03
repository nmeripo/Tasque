package com.project.todolist.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.project.todolist.database.DatabaseHelper;
import com.project.todolist.models.Reminder;
import com.project.todolist.utils.NotificationUtil;

public class NagReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DatabaseHelper database = DatabaseHelper.getInstance(context);
        int reminderId = intent.getIntExtra("NOTIFICATION_ID", 0);
        if (reminderId != 0 && database.isNotificationPresent(reminderId)) {
            Reminder reminder = database.getNotification(reminderId);
            NotificationUtil.createNotification(context, reminder);
        }
        database.close();
    }
}