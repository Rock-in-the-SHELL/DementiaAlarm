package com.example.dementiaalarm

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class TestScreen {
    companion object {
        @Composable
        fun testScreen(onClickButton: ()->Unit = {}) {
            Column {
                Text(text = "It is TestScreen now !!!")
                Button(onClick = onClickButton) {
                    Text(text = "Go to MainActivity")
                }
            }
        }
    }
}