package com.app.countriesinfo.ui.screens.utils

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberMockAnimatedVisibilityScope(): AnimatedVisibilityScope {
    val transition = updateTransition(targetState = EnterExitState.Visible, label = "Mock Transition")
    return remember {
        object : AnimatedVisibilityScope {
            override val transition: Transition<EnterExitState>
                get() = transition

        }
    }
}