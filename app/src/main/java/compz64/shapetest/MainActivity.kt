package compz64.shapetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pz64.compose_polygonshape.PolygonShape
import com.pz64.compose_polygonshape.RoundedStarShape
import compz64.shapetest.ui.theme.ComposePolygonsTheme

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
            .padding(16.dp)
            .verticalScroll(rememberScrollState(), enabled = true)
    ) {
        Column{

            var sides by remember { mutableStateOf(3f) }
            var depth by remember { mutableStateOf(0.09f) }
            var iteration by remember { mutableStateOf(360f) }

            /****
             */
            val roundedStarShape = RoundedStarShape(
                sides = sides.toInt(),
                depth = depth.toDouble(),
                iterations = iteration.toInt()
            )


            Text(text = "RoundedStarShape", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.size(16.dp))

            Surface(
                shape = roundedStarShape,
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Surface(color = Color(0xff4DB6AC), modifier = Modifier.size(200.dp)) {

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


            Spacer(modifier = Modifier.size(42.dp))

            Text(text = "Polygon", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.size(16.dp))

            var polySides by remember { mutableStateOf(3f) }


            val polygonShape = PolygonShape(sides = polySides.toInt())

            Surface(
                shape = polygonShape,
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Surface(color = Color(0xff4DB6AC), modifier = Modifier.size(200.dp)) {

                }
            }

            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Sides: ${polySides.toInt()}")
            Slider(
                value = polySides, onValueChange = { polySides = it },
                valueRange = 3f..103f,
                steps = 100
            )
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