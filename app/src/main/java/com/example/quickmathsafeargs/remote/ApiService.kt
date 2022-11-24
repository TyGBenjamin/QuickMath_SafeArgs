package com.example.quickmathsafeargs.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Defines the endpoints we need for our [MathService].
 *
 * @constructor Create new instance of [MathService]
 */
interface ApiService {

    @GET(".")
    suspend fun evaluateExpression(@Query("expr") expr: String): String
}
