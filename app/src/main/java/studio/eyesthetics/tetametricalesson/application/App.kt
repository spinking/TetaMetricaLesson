package studio.eyesthetics.tetametricalesson.application

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import studio.eyesthetics.tetametricalesson.BuildConfig

class App : Application() {
    lateinit var firebaseAnalytics: FirebaseAnalytics

    companion object {
        lateinit var instance: App
            private set
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(instance)
        firebaseAnalytics = Firebase.analytics

        val config = YandexMetricaConfig.newConfigBuilder(BuildConfig.APP_METRICA_KEY).build()
        YandexMetrica.activate(instance, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}