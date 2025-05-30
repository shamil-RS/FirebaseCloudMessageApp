package com.example.firebasecloudmessage

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providePushMessageMapper(): PushMessageMapper {
        return PushMessageMapper()
    }

    @Provides
    fun providePushHandler(
        notificationFactory: NotificationFactory,
        @ApplicationContext context: Context
    ): PushHandler {
        return DefaultPushHandler(notificationFactory, context)
    }

    @Provides
    fun provideNotificationFactory(deeplinkParser: DeeplinkParser): NotificationFactory {
        return NotificationFactory(deeplinkParser)
    }

    @Provides
    fun provideDeeplinkParser(): DeeplinkParser {
        return DefaultDeeplinkParser()
    }
}
