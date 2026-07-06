package com.example.oza_idgaf.Home.Pertemuan14.utils

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationHelper {

    private const val CHANNEL_ID = "reminder_channel_id"
    private const val CHANNEL_NAME = "Reminder Notifications"
    private const val NOTIFICATION_ID = 1001

    fun showNotification(
        context: Context,
        title: String,
        message: String,
        intent: Intent
    ) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH // Memaksa notifikasi muncul melayang (Heads-up)
            ).apply {
                description = "Channel untuk menerima pengingat aplikasi"
                enableLights(true)
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            System.currentTimeMillis().toInt(), // Menggunakan ID unik berbasis waktu agar tidak tertimpa
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_dialog_info) // Menggunakan ikon bawaan sistem android yang aman
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // Prioritas tinggi untuk Android jadul di bawah Oreo
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Notifikasi otomatis hilang setelah di-klik

        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}