package com.example.firebasecloudmessage

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

interface PushHandler {
    fun handle(message: PushMessage)
}

@AndroidEntryPoint
class MyFirebaseMessagingService : FirebaseMessagingService() {

    @Inject lateinit var pushHandler: dagger.Lazy<PushHandler>
    @Inject lateinit var pushMessageMapper: dagger.Lazy<PushMessageMapper>

    override fun onNewToken(token: String) {
        Log.d("FCM", "Token: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val mapped = pushMessageMapper.get().map(message)
        pushHandler.get().handle(mapped)
    }
}

