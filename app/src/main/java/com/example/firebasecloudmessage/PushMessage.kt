package com.example.firebasecloudmessage

data class PushMessage(
    val title: String?,
    val body: String?,
    val deeplink: String?,
    val type: String?
)
