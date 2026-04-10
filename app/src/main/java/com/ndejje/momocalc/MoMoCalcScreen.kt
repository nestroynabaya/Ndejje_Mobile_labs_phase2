package com.ndejje.momocalc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource

@Composable
fun MoMoCalcScreen(modifier: Modifier = Modifier) {
    // ... state declarations unchanged ...
    var amountInput by remember { mutableStateOf("") }

    val numericAmount = amountInput.toDoubleOrNull()
    val isError = amountInput.isNotEmpty() && numericAmount == null
    val fee = (numericAmount ?: 0.0) * 0.03
    val formattedFee = "UGX %,.0f".format(fee)

    Column(
        modifier = modifier             // ← receives innerPadding from Scaffold
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.screen_padding)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ... content unchanged ...

        Text(
            text = stringResource(R.string.app_title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier.height(
                dimensionResource(R.dimen.spacing_large)
            )
        )

        HoistedAmountInput(
            amount = amountInput,
            onAmountChange = { amountInput = it },
            isError = isError,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(
                dimensionResource(R.dimen.spacing_medium)
            )
        )

        Text(
            text = stringResource(R.string.fee_label, formattedFee),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

    @Preview(showBackground = true)
    @Composable
    fun MoMoCalcPreview() {
        MaterialTheme { MoMoCalcScreen() }
    }


