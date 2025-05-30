package com.example.firebasecloudmessage

import com.google.firebase.messaging.RemoteMessage
import jakarta.inject.Inject

class PushMessageMapper @Inject constructor() {
    fun map(message: RemoteMessage): PushMessage {
        val data = message.data
        return PushMessage(
            title = data["title"],
            body = data["body"],
            deeplink = data["deeplink"],
            type = data["type"]
        )
    }
}
