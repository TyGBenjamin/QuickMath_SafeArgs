package com.example.quickmathsafeargs.repo

import com.example.quickmathsafeargs.remote.ApiService
import javax.inject.Inject

/**
 * Repository impl retrieves data from api.
 *
 * @property apiService
 * @constructor Create empty Repository impl
 */
class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun evaluateExpression(expr: String): String {
        return apiService.evaluateExpression(expr)
    }
}
