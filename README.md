# 🤖 AI ChatBot Using Google Gemini API (Android App)

## 📱 Overview

This Android application is a smart chatbot that interacts with users using Google's **Gemini API**. Built using **Kotlin** and following the **MVVM (Model-View-ViewModel)** architecture, the app features:
- A professional **Splash Screen**
- Real-time AI responses via Gemini
- A clean and intuitive chat interface
- Fast performance with async networking
- Modular and scalable design

---

## 🚀 Features

- ⚡ Splash screen with logo on launch
- 🧠 Real-time interaction with Gemini AI API
- ✉️ Message history with timestamps
- 📡 Handles API loading states
- 🔒 Secure communication over HTTPS
- 📲 Compatible with Android 8.0 (API 26) and up

---

## 🧱 Project Structure
ChatAi/
├── README.md
├── build.gradle
├── screenshots/
│   ├── splash.png
│   └── chat.png
├── app/
│   ├── build.gradle
│   └── src/
│       └── main/
│           ├── java/com/example/chatai/
│           │   ├── SplashActivity.kt
│           │   ├── MainActivity.kt
│           │   ├── viewmodel/
│           │   │   └── ChatViewModel.kt
│           │   ├── model/
│           │   │   └── MessageModel.kt
│           │   └── util/
│           │       └── Constants.kt
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml
│               │   └── activity_splash.xml
│               ├── drawable/
│               │   └── logo.png
│               └── values/
│                   ├── strings.xml
│                   └── styles.xml


## 🛠️ Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM
- **API:** [Google Gemini API](https://ai.google.dev)
- **UI:** XML layouts / Jetpack Compose (if used)
- **IDE:** Android Studio
- **Network:** Retrofit / HttpURLConnection

---

## 🔑 Setup & Configuration

1. **Clone the Repository**
   ```bash
   git clone https://github.com/siefer2005/Ai-Chat-Bot

---

 🧪Testing
✅ Unit tests for ViewModel logic

✅ UI tests for splash screen, message rendering

✅ Manual testing on multiple Android versions

✅ Tested with and without network connection

---

📄 License
This project is licensed under the MIT License.

👥 Authors
Animesh Ansh Yadav

📬 Contact
Have questions? Reach out to us at spidypotter2020@gmail.com

