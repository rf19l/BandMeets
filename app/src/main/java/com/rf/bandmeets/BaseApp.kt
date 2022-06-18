package com.rf.bandmeets

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp: Application() {

    companion object{
        var mAppCreated = false
        var didCheckUpdate =false
    }
/*

    @Inject
    var userRepository: UserRepository? = null

    @Inject
    var preferencesRepository: PreferencesRepository? = null

    @Inject
    var lifecycleListener: BandMeetsLifecycleObserver? = null

    @Inject
    var mRemoteConfig: RemoteConfig? = null

    private val mCurrentActivity: WeakReference<Activity>? = null
    private lateinit var INSTANCE: com.rf.bandmeets.BaseApp

    override fun onCreate() {
        INSTANCE = this
        super.onCreate()
        didCheckUpdate = false
        val sharedPref = getSharedPreferences(Constants.DEFAULT_SHARED_PREFS, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(Constants.IS_IN_STORE, Constants.LOCATION_STATUS_UNKNOWN)
        editor.putBoolean(Constants.SHOW_GIFT_CARD_POPUP_PER_SESSION, true)
        editor.apply()
        com.shockoe.publix.PublixApplication.mIsAtStoreNotificationShown = false
        com.shockoe.publix.PublixApplication.mAppCreated = true
        FirebaseMessaging.getInstance().setAutoInitEnabled(true)
        configureRealm()
        configureLogging()
        configureSalesForceSdk()

        // initialize foresee
        ForeSee.start(this)

        // always want to be included in survey pool if not stable
        if (!BuildConfig.BUILD_TYPE.equals("release")) {
            ForeSee.setSkipPoolingCheck(true)
        }
        updateRemoteConfig()
        configureLifecycleListener()
        configureAkamaiBotManager()
        configureAppCenter()
        setupRxJavaGlobalErrorHandlers()
        */
}