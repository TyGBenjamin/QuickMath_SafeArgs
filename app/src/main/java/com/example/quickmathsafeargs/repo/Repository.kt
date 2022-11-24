package com.example.quickmathsafeargs.repo

/**
 * Repository to evaluate math expressions.
 *
 * @constructor Create new [MathRepo]
 */
interface Repository {
    /**
     * Evaluates mathematical expression passed in.
     *
     * @param expr mathematical expression to be evaluated
     * @return evaluation from mathematical expression
     */
    suspend fun evaluateExpression(expr: String): String
}
