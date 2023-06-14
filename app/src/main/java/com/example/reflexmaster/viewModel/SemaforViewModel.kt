package com.example.reflexmaster.viewModel

import androidx.lifecycle.ViewModel


class SemaforViewModel: ViewModel() {
    private var _bolUzOtoceny = false
    val bolUzOtoceny: Boolean
        get() = _bolUzOtoceny

    fun zmenStav() {
        _bolUzOtoceny = true
    }
}