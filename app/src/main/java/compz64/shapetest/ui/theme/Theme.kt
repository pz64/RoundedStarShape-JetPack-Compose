package compz64.shapetest.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val colors = lightColors(
    primary = Color(0xFF61947E),
    primaryVariant = Color(0xFF739E8B),
    secondary = Color(0xFF4D8094),
    )

@Composable
fun ComposePolygonsTheme(
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}