package com.mnrf.ejajan.view.main.parent.ui.student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnrf.ejajan.data.model.AllergyModel
import com.mnrf.ejajan.data.model.SpendingModel
import com.mnrf.ejajan.data.pref.UserPreference
import com.mnrf.ejajan.data.repository.ConstraintRepository
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: ConstraintRepository
) : ViewModel() {
    private val _allergyList = MutableLiveData<List<AllergyModel>>()
    val allergyList: LiveData<List<AllergyModel>> get() = _allergyList

    private val _spendingList = MutableLiveData<List<SpendingModel>>()
    val spendingList: LiveData<List<SpendingModel>> get() = _spendingList

    fun loadAllergies(parentUid: String) {
        repository.getAllergies(parentUid, { allergies ->
            _allergyList.value = allergies
        }, { e ->
            Log.e("StudentViewModel", "Failed to load allergies: ${e.message}")
        })
    }

    fun loadSpending(parentUid: String) {
        repository.getSpending(parentUid, { spending ->
            _spendingList.value = spending
        }, { e ->
            Log.e("StudentViewModel", "Failed to load spending: ${e.message}")
        })
    }
}