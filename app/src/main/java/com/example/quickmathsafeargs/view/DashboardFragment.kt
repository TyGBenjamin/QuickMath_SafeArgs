package com.example.quickmathsafeargs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.quickmathsafeargs.ui.theme.QuickMathSafeArgsTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Dashboard fragment entry point displays initial screen for user.
 *
 * @constructor Create empty Dashboard fragment
 */
@AndroidEntryPoint
class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // requireActivity()
        return ComposeView(requireActivity()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                QuickMathSafeArgsTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier.padding(2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            var input: String by remember {
                                mutableStateOf("")
                            }
                            Column() {
                                TextField(value = input, onValueChange = { input = it })

                                Button(
                                    onClick = {
                                        println(input)
                                        navigateToOperator(
                                            fragment = this@DashboardFragment,
                                            input = input
                                        )
                                    },
                                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                ) {
                                    Text(text = "Input")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun navigateToOperator(fragment: DashboardFragment, input: String) {
    val action = DashboardFragmentDirections.actionDashboardFragmentToOperatorFragment(input)
    findNavController(fragment).navigate(action)
}
