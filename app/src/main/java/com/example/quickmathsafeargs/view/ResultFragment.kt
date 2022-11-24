package com.example.quickmathsafeargs.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.quickmathsafeargs.R
import com.example.quickmathsafeargs.ui.theme.QuickMathSafeArgsTheme
import com.example.quickmathsafeargs.viewmodel.MathViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Result fragment displays result retrieved from api.
 *
 * @constructor Create empty Result fragment
 */
@AndroidEntryPoint
class ResultFragment : Fragment() {
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
                            Column() {
                                Text(
                                    text = context.getString(R.string.resultShwon),
                                    modifier = Modifier.padding(
                                        vertical = 20.dp
                                    )
                                )
                                val result = viewModel.result.collectAsState().value
                                Text(text = "= $result")
                                Row() {
                                    Button(onClick = {
                                        findNavController().popBackStack(R.id.dashboardFragment, false)
                                    }) {
                                        Text(text = "Home")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
