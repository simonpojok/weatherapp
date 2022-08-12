package me.simonpojok.weatherapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import dagger.hilt.android.AndroidEntryPoint
import me.simonpojok.weatherapp.common.LOADING_INDICATOR_BUNDLE_KEY
import me.simonpojok.weatherapp.common.LOADING_INDICATOR_REQUEST_KEY

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val loadingIndicator: View get() = findViewById(R.id.main_activity_progress_indicator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.setFragmentResultListener(
            LOADING_INDICATOR_REQUEST_KEY,
            this
        ) { _, bundle ->
            val result = bundle.getBoolean(LOADING_INDICATOR_BUNDLE_KEY, false)
            loadingIndicator.isVisible = result
        }
    }
}
