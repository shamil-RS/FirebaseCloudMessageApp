package com.example.firebasecloudmessage

import android.Manifest
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class DefaultPushHandler @Inject constructor(
    private val notificationFactory: NotificationFactory,
    @ApplicationContext private val context: Context
) : PushHandler {
    override fun handle(message: PushMessage) {

        val notification = notificationFactory.createNotification(context, message)

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
            == PackageManager.PERMISSION_GRANTED) {
            NotificationManagerCompat.from(context).notify(1001, notification)
        }
    }
}

class NotificationFactory @Inject constructor(
    private val deeplinkParser: DeeplinkParser
) {
    fun createNotification(context: Context, message: PushMessage): Notification {
        val parsedDeeplink = deeplinkParser.parse(message.deeplink)

        val intent = Intent(context, MainActivity::class.java).apply {
            // Добавляем данные из распарсенной ссылки в интент
            putExtra("deeplink_data", parsedDeeplink.destination)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, "default_notification_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(message.title)
            .setContentText(message.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        return builder.build()
    }
}

