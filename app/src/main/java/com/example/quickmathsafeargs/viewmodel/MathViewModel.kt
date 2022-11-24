package com.example.quickmathsafeargs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickmathsafeargs.repo.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Math view model responsible for retrieving data from repo.
 *
 * @property repo
 * @constructor Create empty Math view model
 */
@HiltViewModel
class MathViewModel @Inject constructor(private val repo: RepositoryImpl) : ViewModel() {
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> get() = _result

    /**
     * Evaluate expression takes in a string that represents an expression i.e "2+2" or "4/2".
     *
     * @param expr
     */
    suspend fun evaluateExpression(expr: String) {
        viewModelScope.launch {
            _result.value = repo.evaluateExpression(expr)
            println("THIS IS VALUE OF FLOW ${repo.evaluateExpression(expr)}")
        }
    }
}
