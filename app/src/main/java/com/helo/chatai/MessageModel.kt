package com.helo.chatai

import androidx.core.app.NotificationCompat.MessagingStyle.Message

data class MessageModel(
    val message: String,
    val role : String,
    var isAnimationFinished: Boolean = false
)
