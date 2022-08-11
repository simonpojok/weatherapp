object UiModule {
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    private const val hiltLifeCycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifeCycleViewModel}"
    private const val workRuntime = "androidx.work:work-runtime-ktx:2.7.1"
    private const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
    private const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    private const val kotlinCoroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.5.2"
    private const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    private const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
    private const val okHttp = "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
    private const val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
    private const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    private const val lifecycleReactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.4.0"
    private const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
    private const val hiltWork = "androidx.hilt:hilt-work:1.0.0"
    private const val roomKtx = "androidx.room:room-ktx:2.4.2"
    private const val roomRuntime = "androidx.room:room-runtime:2.4.1"
    private const val kotlinCoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    private const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"

    // Test
    private const val junitJunit = "junit:junit:${Versions.junitJunit}"

    // Android test
    private const val junitExt = "androidx.test.ext:junit:1.1.3"
    private const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"

    // Kapt
    private const val roomCompiler = "androidx.room:room-compiler:2.4.1"
    private const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    private const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:2.4.0"
    private const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}"

    val uiImplementationLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(lifecycleRuntimeKtx)
        add(hiltLifeCycleViewModel)
        add(workRuntime)
        add(kotlinCoroutinesCore)
        add(kotlinCoroutinesPlayServices)
        add(lifecycleRuntime)
        add(converterGson)
        add(loggingInterceptor)
        add(roomKtx)
        add(kotlinCoroutineAndroid)
        add(roomRuntime)
        add(hiltWork)
        add(hiltAndroid)
        add(kotlinxCoroutinesAndroid)
        add(lifecycleViewModel)
        add(lifecycleExtension)
        add(lifecycleReactiveStreams)
        add(fragment)
        add(navigationFragment)
        add(navigationUi)
    }

    val uiTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitJunit)
    }

    val uiAndroidTestImplementationLibraries = arrayListOf<String>().apply {
        add(junitExt)
        add(espressoCore)
    }

    val uiKaptImplementationLibraries = arrayListOf<String>().apply {
        add(hiltAndroidCompiler)
        add(roomCompiler)
        add(hiltCompiler)
        add(lifecycleCompiler)
    }
}
