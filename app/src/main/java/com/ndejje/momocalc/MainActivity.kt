package com.ndejje.momocalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import java.util.Locale

// ============ MAIN ACTIVITY ============
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var amountInput by remember { mutableStateOf("") }
                val numericAmount = amountInput.toDoubleOrNull()
                val isError = amountInput.isNotEmpty() && numericAmount == null
                val fee = (numericAmount ?: 0.0) * 0.03
                val formattedFee = "UGX %,.0f".format(Locale.US, fee)

                HoistedAmountInput(
                    amount = amountInput,
                    onAmountChange = { amountInput = it },
                    isError = isError
                )
            }
        }
    }
}

// ============ BROKEN INPUT ============
@Composable
fun BrokenInput() {
    var amount by remember { mutableStateOf("") }
    TextField(
        value = amount,
        onValueChange = { amount = it },
        label = {
            Text(stringResource(id = R.string.enter_amount))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BrokenInputPreview() {
    MaterialTheme {
        BrokenInput()
    }
}

// ============ INTERNAL STATE INPUT ============
@Composable
fun InternalStateInput() {
    var amount by remember { mutableStateOf(value = "50000") }
    TextField(
        value = amount,
        onValueChange = { amount = it },
        label = {
            Text(stringResource(id = R.string.enter_amount))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun InternalStateInputPreview() {
    InternalStateInput()
}

// ============ HOISTED AMOUNT INPUT ============
@Composable
fun HoistedAmountInput(
    amount: String,
    onAmountChange: (String) -> Unit,
    isError: Boolean = false
) {
    Column {
        TextField(
            value = amount,
            onValueChange = onAmountChange,
            label = {
                Text(stringResource(id = R.string.enter_amount))
            },
            supportingText = {
                if (isError) {
                    Text(
                        text = stringResource(id = R.string.error_numbers_only),
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmptyInput() {
    HoistedAmountInput(amount = "", onAmountChange = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewFilled() {
    HoistedAmountInput(amount = "50000", onAmountChange = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewError() {
    HoistedAmountInput(amount = "alex", onAmountChange = {}, isError = true)
}