package com.example.reflexmaster.viewModel

import androidx.lifecycle.ViewModel

/**
 * ViewModel pre triedu Semafor, uchováva boolean premennu bolUzOtoceny počas celého životného cyklu aplikácie
 */

class SemaforViewModel: ViewModel() {
    private var _bolUzOtoceny = false
    val bolUzOtoceny: Boolean
        get() = _bolUzOtoceny

    fun zmenStav() {
        _bolUzOtoceny = true
    }
}