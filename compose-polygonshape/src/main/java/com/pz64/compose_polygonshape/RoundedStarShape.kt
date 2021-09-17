package com.pz64.compose_polygonshape

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class RoundedStarShape(
    private val sides: Int,
    private val depth: Double = 0.09,
    iterations: Int = 360
) : Shape {

    private companion object {
        const val TWOPI = 2 * PI
    }

    private val steps = (TWOPI) / min(iterations, 360)

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(Path().apply {


        val r = min(size.height, size.width) * 0.4 * mapRange(1.0, 0.0, 0.5, 1.0, depth)

        val xCenter = size.width * .5f
        val yCenter = size.height * .5f

        moveTo(xCenter, yCenter)

        var t = 0.0

        while (t <= TWOPI) {
            val x = r * (cos(t) * (1 + depth * cos(sides * t)))
            val y = r * (sin(t) * (1 + depth * cos(sides * t)))
            lineTo((x + xCenter).toFloat(), (y + yCenter).toFloat())

            t += steps
        }

        val x = r * (cos(t) * (1 + depth * cos(sides * t)))
        val y = r * (sin(t) * (1 + depth * cos(sides * t)))
        lineTo((x + xCenter).toFloat(), (y + yCenter).toFloat())


    })
    private fun mapRange(a: Double, b: Double, c: Double, d: Double, x: Double): Double {
        return (x - a) / (b - a) * (d - c) + c
    }
}

