package com.ndejje.momocalc.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp
import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.ndejje.momocalc.MoMoCalcScreen
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding

val MoMoShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),   // chips, tooltips
    small      = RoundedCornerShape(8.dp),   // TextField, buttons
    medium     = RoundedCornerShape(16.dp),  // cards, dialogs
    large      = RoundedCornerShape(24.dp),  // bottom sheets
    extraLarge = RoundedCornerShape(28.dp)   // FABs, hero containers
)

@Preview(name = "Fee Card – Light", showBackground = true)
@Preview(
    name = "Fee Card – Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewFeeCard() {
    MoMoAppTheme {
        Surface(modifier = Modifier.padding(16.dp)) {
            MoMoCalcScreen()
        }
    }
}

