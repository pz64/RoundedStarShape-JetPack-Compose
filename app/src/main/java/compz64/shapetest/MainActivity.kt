package compz64.shapetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pz64.shape.PolygonShape
import com.pz64.shape.RoundedStarShape
import compz64.shapetest.ui.theme.ComposePolygonsTheme
import kotlin.math.PI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePolygonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), enabled = true)
    ) {
        Column(
            Modifier
                .background(color = MaterialTheme.colors.primary)
                .padding(8.dp)
        ) {


            RoundedStarShapeCard()

            Spacer(modifier = Modifier.size(16.dp))

            PolygonShapeCard()

            Spacer(modifier = Modifier.size(16.dp))

        }


    }
}

@Composable
private fun RoundedStarShapeCard() {
    Surface(shape = RoundedCornerShape(32.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {

            var sides by remember { mutableStateOf(3f) }
            var depth by remember { mutableStateOf(0.09f) }
            var iteration by remember { mutableStateOf(360f) }
            var rotation by remember { mutableStateOf(0f) }


            val roundedStarShape = RoundedStarShape(
                sides = sides.toInt(),
                curve = depth.toDouble(),
                rotationDegree = rotation,
                iterations = iteration.toInt()
            )


            Text(text = "Rounded star shape", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.size(16.dp))

            Surface(
                shape = roundedStarShape,
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(0x70205C47))
                        .size(160.dp),
                    contentAlignment = Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon),
                        contentDescription = "",
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Sides: ${sides.toInt()}")
            Slider(
                value = sides, onValueChange = { sides = it },
                valueRange = 3f..28f,
                steps = 25
            )

            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Depth: $depth")
            Slider(
                value = depth, onValueChange = { depth = it },
                valueRange = 0.0f..1.0f,
            )

            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Iterations: ${iteration.toInt()}")
            Slider(
                value = iteration, onValueChange = { iteration = it },
                valueRange = 3f..360f,
                steps = 357
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Rotation: $rotation")
            Slider(
                value = rotation.toFloat(), onValueChange = { rotation = it },
                valueRange = 0.0f..360f,
            )
        }

    }
}

@Composable
private fun PolygonShapeCard() {
    Surface(shape = RoundedCornerShape(32.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Polygon shape", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.size(16.dp))

            var polySides by remember { mutableStateOf(3f) }
            var rotation by remember { mutableStateOf(0f) }


            val polygonShape = PolygonShape(sides = polySides.toInt(), rotationDegree = rotation)

            Surface(
                shape = polygonShape,
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(0x70205C47))
                        .size(160.dp),
                    contentAlignment = Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_2),
                        contentDescription = "",
                        modifier = Modifier.size(56.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Sides: ${polySides.toInt()}")
            Slider(
                value = polySides, onValueChange = { polySides = it },
                valueRange = 3f..103f,
                steps = 100
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Rotation: $rotation")
            Slider(
                value = rotation.toFloat(), onValueChange = { rotation = it },
                valueRange = 0.0f..360f,
            )
        }

    }
}

@Composable
@Preview
fun RoundedStarShapeCardPreview() {
    ComposePolygonsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            RoundedStarShapeCard()
        }
    }
}


@Composable
@Preview
fun PolygonShapeCardPreview() {
    ComposePolygonsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            PolygonShapeCard()
        }
    }
}

@Composable
@Preview
fun ScreenPreview() {
    ComposePolygonsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Screen()
        }
    }
}