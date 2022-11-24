package com.example.quickmathsafeargs.viewmodel

import com.example.quickmathsafeargs.repo.RepositoryImpl
import com.example.quickmathsafeargs.utilTest.CoroutinesTestExtension
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

internal class MathViewModelTest {
    @RegisterExtension
    private val coroutinesTestExtension = CoroutinesTestExtension()
    private val repo = mockk<RepositoryImpl>()

    @Test
    @DisplayName("Testing viewmodel for initial lists to load")
    fun testViewModel() = runTest(coroutinesTestExtension.dispatcher) {
        // Given
        val expr = "2+2"
        val answer = "4"

        coEvery { repo.evaluateExpression(expr) } coAnswers { answer }

        val vm = MathViewModel(repo)

        // Then
        assertTrue(true)
        vm.evaluateExpression(expr)

        val result = vm.result.value
        assertEquals(result, answer)
    }
}
