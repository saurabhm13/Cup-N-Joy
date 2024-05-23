package com.example.cupnjoy.presentation.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class CustomCurvedShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val curveRadius = with(density) { 60.dp.toPx() }
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width - curveRadius, 0f)
            quadraticBezierTo(
                size.width, 0f,
                size.width, curveRadius
            )
            lineTo(size.width, size.height - curveRadius)
            quadraticBezierTo(
                size.width, size.height,
                size.width - curveRadius, size.height
            )
            lineTo(0f, size.height)
            close()
        }
        return Outline.Generic(path)
    }
}