package com.mnrf.ejajan.view.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mnrf.ejajan.data.UserRepository
import com.mnrf.ejajan.di.Injection
import com.mnrf.ejajan.view.login.LoginParentMerchantViewModel
import com.mnrf.ejajan.view.main.parent.ParentViewModel
import com.mnrf.ejajan.view.main.parent.ui.setting.Setting2ViewModel
import com.mnrf.ejajan.view.splash.SplashViewModel

class ViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginParentMerchantViewModel::class.java) -> {
                LoginParentMerchantViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ParentViewModel::class.java) -> {
                ParentViewModel(repository) as T
            }
            modelClass.isAssignableFrom(Setting2ViewModel::class.java) -> {
                Setting2ViewModel(repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}