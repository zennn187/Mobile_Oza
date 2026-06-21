package com.example.oza_idgaf.utils

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

object ReminderHelper {

    @SuppressLint("ScheduleExactAlarm")
    fun setReminder(
        context: Context,
        secondsDelay: Int,
        title: String,
        message: String,
        targetActivity: Class<*>
    ) {
        val triggerTimeInMillis = System.currentTimeMillis() + (secondsDelay * 1000)

        val intent = Intent(context, ReminderReceiver::class.java).apply {
            putExtra("title", title)
            putExtra("message", message)
            putExtra("target_activity", targetActivity.name)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            triggerTimeInMillis,
            pendingIntent
        )
    }
}