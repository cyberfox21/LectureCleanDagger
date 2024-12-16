package com.example.androidcourse.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcourse.domain.usecase.GetShopListUseCase
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author t.shkolnik
 */
class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return creators[modelClass]?.get() as? T
            ?: throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}

