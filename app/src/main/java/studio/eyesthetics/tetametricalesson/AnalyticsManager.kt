package studio.eyesthetics.tetametricalesson

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.yandex.metrica.YandexMetrica
import studio.eyesthetics.tetametricalesson.application.App

object AnalyticsManager : IAnalyticsManager {

    override fun sendEvent(eventName: String) {
        App.instance.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.VALUE, eventName)
        }
        YandexMetrica.reportEvent(eventName)
    }

    override fun selectUserId(id: String) {
        App.instance.firebaseAnalytics.setUserId(id)
        YandexMetrica.setUserProfileID(id)
    }
}

interface IAnalyticsManager {
    fun sendEvent(eventName: String)
    fun selectUserId(id: String)
}