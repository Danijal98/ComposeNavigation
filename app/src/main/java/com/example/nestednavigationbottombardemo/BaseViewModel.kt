package com.example.nestednavigationbottombardemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseViewModel : ViewModel() {

    var value = 0

    val data = MutableStateFlow(value)

    fun updateData() {
        data.value = ++value
    }
}

class HomeViewModel: BaseViewModel()
class ProfileViewModel: BaseViewModel()
class SettingsViewModel: BaseViewModel()