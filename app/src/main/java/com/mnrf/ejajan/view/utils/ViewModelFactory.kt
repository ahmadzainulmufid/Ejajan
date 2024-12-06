package com.mnrf.ejajan.view.utils

import com.mnrf.ejajan.view.main.merchant.ui.menu.MenuMerchantViewModel
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mnrf.ejajan.data.repository.UserRepository
import com.mnrf.ejajan.di.Injection
import com.mnrf.ejajan.view.login.LoginParentMerchantViewModel
import com.mnrf.ejajan.view.login.LoginStudentViewModel
import com.mnrf.ejajan.view.main.merchant.ui.menu.add.MerchantAddMenuViewModel
import com.mnrf.ejajan.view.main.merchant.ui.menu.detail.DetailMenuViewModel
import com.mnrf.ejajan.view.main.merchant.ui.setting.SettingViewModel
import com.mnrf.ejajan.view.main.parent.ParentViewModel
import com.mnrf.ejajan.view.main.parent.ui.home.HomeViewModel
import com.mnrf.ejajan.view.main.parent.ui.setting.Setting2ViewModel
import com.mnrf.ejajan.view.main.parent.ui.topup.TopUpViewModel
import com.mnrf.ejajan.view.main.student.StudentViewModel
import com.mnrf.ejajan.view.main.student.menu.MenuStudentViewModel
import com.mnrf.ejajan.view.splash.SplashViewModel

class ViewModelFactory(
    private val repository: UserRepository,
    private val appContext: Context // Add appContext parameter
) : ViewModelProvider.NewInstanceFactory() {

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
            modelClass.isAssignableFrom(SettingViewModel::class.java) -> {
                SettingViewModel(repository, appContext) as T
            }
            modelClass.isAssignableFrom(MerchantAddMenuViewModel::class.java) -> {
                MerchantAddMenuViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MenuMerchantViewModel::class.java) -> {
                MenuMerchantViewModel(repository) as T
            }
            modelClass.isAssignableFrom(DetailMenuViewModel::class.java) -> {
                DetailMenuViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginStudentViewModel::class.java) -> {
                LoginStudentViewModel(repository) as T
            }
            modelClass.isAssignableFrom(StudentViewModel::class.java) -> {
                StudentViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MenuStudentViewModel::class.java) -> {
                MenuStudentViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(TopUpViewModel::class.java) -> {
                TopUpViewModel(repository) as T
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
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context), context)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}