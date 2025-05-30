FirebaseCloudMessageApp

Простое приложение для отправки и получения уведомлений с использованием Firebase Cloud Messaging (облачного решения от Google) с соблюдением принципа, описанного в данном руководстве - https://apptractor.ru/info/articles/bolshinstvo-prilozheniy-dlya-android-narushayut-eto-pravilo-chistogo-koda.html

## Технологии

- Kotlin
- Android SDK
- Firebase Cloud Messaging (облачный сервис Google для отправки push-уведомлений и сообщений на устройства)
- Hilt (для внедрения зависимостей)

Настройка проекта Firebase

Откройте Android Studio
Строго следовать след. шагам:

1. Открываем TopBar Android Studio и находим раздел Tools
   
![2025-05-30_17-03-20](https://github.com/user-attachments/assets/a1c79392-4b90-4e16-be7f-c1a6851b3b75)

2. Откроется набор инструментов от Google Firebase
   
![2025-05-30_17-03-51](https://github.com/user-attachments/assets/72887b8b-b057-473e-9b74-5acb1d86c9c4)

3. Необходимо выбрать "Cloud Storage for Firebase"
   
![2025-05-30_17-04-43](https://github.com/user-attachments/assets/af37b25e-e3d4-4643-9c8a-0f18794286d6)

4. Следовать инструкциям 1 и 2, так же ознакмиться с остальными шагами
   
![2025-05-30_17-05-42](https://github.com/user-attachments/assets/305da31d-4b01-46a6-baf1-591f59218b7a)

### Необходимые разрешения

Убедитесь, что в вашем `AndroidManifest.xml` есть необходимые разрешения и сервис:

```
<action android:name="com.google.firebase.MESSAGING_EVENT"/>
<action android:name="com.google.firebase.INSTANCE_ID_EVENT" />
```

Перед отправкой необходимо получить текущий регистрационный токен - https://firebase.google.com/docs/cloud-messaging/android/first-message?authuser=0&_gl=1*iesgeg*_ga*MTE1NDgwNjM5My4xNzQ4NTU2OTc3*_ga_CW55HF8NVT*czE3NDg1NjEwMjYkbzIkZzEkdDE3NDg1NjI0MjUkajYwJGwwJGgw&hl=ru#retrieve-the-current-registration-token

📬 Отправка уведомлений через Firebase Console
1. Перейдите в ваш проект на Firebase Console.
2. В левом боковом меню найдите All Products.
3. Найдите Cloud Messaging.
4. Нажмите на кнопку New Campaign.
5. Заполните заголовок, текст и другие параметры уведомления.
6. После заполнения нажмите Review.
