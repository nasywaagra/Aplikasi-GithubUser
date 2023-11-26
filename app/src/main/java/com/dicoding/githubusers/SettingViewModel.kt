package com.dicoding.githubusers
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel

class SettingViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    fun isDarkModeEnabled(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    }
    fun setDarkModeEnabled(enabled: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("dark_mode", enabled)
        editor.apply()
    }
}