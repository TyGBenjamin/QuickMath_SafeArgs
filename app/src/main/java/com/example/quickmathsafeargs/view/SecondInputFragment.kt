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
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quickmathsafeargs.viewmodel.MathViewModel
import com.example.quickmathsafeargs.R
import com.example.quickmathsafeargs.ui.theme.QuickMathSafeArgsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Second input fragment where teh second number is registered form the user.
 *
 * @constructor Create empty Second input fragment
 */
@AndroidEntryPoint
class SecondInputFragment : Fragment() {
   val args: SecondInputFragmentArgs by navArgs()
    val viewModel by activityViewModels<MathViewModel>()

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
                            var inputB: String by remember {
                                mutableStateOf("")
                            }
                            Column() {
                                Text(text = "${args.input}${args.operator}")
                                TextField(value = inputB, onValueChange = { inputB = it })
                                Button(onClick = {
                                    lifecycleScope.launch {
                                        viewModel.evaluateExpression(
                                            "${args.input}${args.operator}$inputB"
                                        )
                                    }
                                    findNavController().navigate(R.id.resultFragment)
                                }) {
                                    Text(text = "Input second number")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
