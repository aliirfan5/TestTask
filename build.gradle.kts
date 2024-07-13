buildscript {
//    val composeVersion by extra("1.3.0")
//    val hiltVersion by extra("1.8.0")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath(libs.kotlin.gradle.plugin)
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}