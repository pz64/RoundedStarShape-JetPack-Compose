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

class PolygonShape(sides: Int) : Shape {

    private companion object {
        const val TWOPI = 2 * PI
    }

    private val STEPCOUNT = (TWOPI) / sides

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(Path().apply {

        val r = min(size.height, size.width) * .5f

        val xCenter = size.width * .5f
        val yCenter = size.height * .5f

        moveTo(xCenter, yCenter)

        var step = 0.0

        while (step <= TWOPI) {
            val x = r * cos(step)
            val y = r * sin(step)
            lineTo((x + xCenter).toFloat(), (y + yCenter).toFloat())

            step += STEPCOUNT
        }

        val x = r * cos(step)
        val y = r * sin(step)
        lineTo((x + xCenter).toFloat(), (y + yCenter).toFloat())
    })
}
