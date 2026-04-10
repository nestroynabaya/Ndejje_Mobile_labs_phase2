package com.ndejje.momocalc

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HoistedAmountInput(
    amount: String,                   // State flows IN
    onAmountChange: (String) -> Unit, // Events flow OUT
    isError: Boolean = false
) {
    Column {
        TextField(
            value = amount,
            onValueChange = onAmountChange,
            isError = isError,
            label = { Text(stringResource(R.string.enter_amount)) }
        )
        if (isError) {
            Text(
                text = stringResource(R.string.error_numbers_only),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

// ── Previews ────────────────────────────────────────────

@Preview(showBackground = true, name = "Empty State")
@Composable
fun PreviewEmpty() {
    HoistedAmountInput(amount = "", onAmountChange = {})
}

@Preview(showBackground = true, name = "Filled State")
@Composable
fun PreviewFilled() {
    HoistedAmountInput(amount = "50000", onAmountChange = {})
}

@Preview(showBackground = true, name = "Error State")
@Composable
fun PreviewError() {
    HoistedAmountInput(amount = "abc", onAmountChange = {}, isError = true)
}