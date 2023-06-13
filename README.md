# Hilt-MVVM-Retrofit-Architecture
The "Hilt-MVVM-Retrofit-Architecture" repository is an Android project that demonstrates the integration of MVVM, Hilt for dependency injection, and Retrofit for network requests, providing a modular and testable codebase for Android applications.
Hilt-MVVM-Retrofit-Architecture

This is a sample app which uses HILT as dependency Injection in MVVM pattern.
It also uses Retrofit for network communication and Parcelize the Model Class.

Understanding Hilt (Dagger)

To understand Dagger we have to understand the 4 major annotations,

Module

Component

Provides

Inject

To understand it better in a basic way, think module as a provider of dependency and consider an activity or any other class as a consumer. Now to provide dependency from provider to consumer we have a bridge between them, in Dagger, Component work as that specific bridge.
A module is a class and we annotate it with @Module for Dagger to understand it as Module.

A component is an interface, which is annotated with @Component and takes modules in it. (But now, this annotation is not required in Dagger-Hilt)

Provides are annotation which is used in Module class to provide dependency and,

Inject is an annotation that is used to define a dependency inside the consumer.
![inject](https://github.com/bishal559/Hilt-MVVM-Retrofit-Architecture/assets/65449966/bc9b6be7-ce52-4478-93a1-ccaf4daaaa85)

Add dependency in project

Hilt

    implementation 'com.google.dagger:hilt-android:2.28-alpha'
    kapt 'com.google.dagger:hilt-android-compiler:2.28-alpha'
    implementation 'androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01'
    kapt 'androidx.hilt:hilt-compiler:1.0.0-alpha01'
Network

    implementation "com.squareup.retrofit2:converter-gson:2.6.2"
    implementation "com.squareup.retrofit2:retrofit:2.8.1"
    implementation "com.squareup.okhttp3:okhttp:4.7.2"
    implementation "com.squareup.okhttp3:logging-interceptor:4.7.2"
Coroutine

    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.6"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6"
The app has following packages:

model: It contains all the data accessing and manipulating components.
module: It contains the files required by Dagger
ui: View classes along with their corresponding ViewModel.
network: It contains all helper classes for network call.
utils: Utility classes.
