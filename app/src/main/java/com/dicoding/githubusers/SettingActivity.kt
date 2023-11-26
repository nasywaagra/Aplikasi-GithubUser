package com.dicoding.githubusers

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingActivity : AppCompatActivity() {

    private lateinit var switchTheme: SwitchMaterial
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewModel: SettingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        switchTheme = findViewById(R.id.switchTheme)
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        viewModel = ViewModelProvider(
            this,
            SettingViewModelFactory(sharedPreferences)
        ).get(SettingViewModel::class.java)

        val isDarkModeEnabled = viewModel.isDarkModeEnabled()
        switchTheme.isChecked = isDarkModeEnabled

        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDarkModeEnabled(isChecked)
            recreate()
        }
    }
}
