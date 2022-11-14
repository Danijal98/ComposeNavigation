package com.example.nestednavigationbottombardemo.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.nestednavigationbottombardemo.BaseViewModel
import kotlinx.coroutines.delay

@Composable
fun ScreenContent(
    viewModel: BaseViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    name: String, onClick: () -> Unit,
) {
    LaunchedEffect(viewModel) {
        while (true) {
            viewModel.updateData()
            delay(500)
        }
    }
    val value = viewModel.data.collectAsState().value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = name,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = value.toString()
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = viewModel.toString()
        )
    }
}