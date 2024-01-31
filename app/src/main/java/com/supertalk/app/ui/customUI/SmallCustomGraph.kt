package com.supertalk.app.ui.customUI

import android.graphics.PointF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp

@Composable
fun SmallCustomGraph(
    modifier : Modifier,
    xValues: List<Int>,
    yValues: List<Int>,
    points: List<Float>,
    paddingSpace: Dp,
    verticalStep: Int
) {

    val controlPoints1 = mutableListOf<PointF>()
    val controlPoints2 = mutableListOf<PointF>()
    val coordinates = mutableListOf<PointF>()

    val color: Color = if(points.last()>points.first()) Color.Green else Color.Red

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            val xAxisSpace = (size.width - paddingSpace.toPx()) / xValues.size
            val yAxisSpace = size.height / yValues.size

            /** placing points */
            coordinates.add(PointF(0f,size.height - (yAxisSpace * (points.first()/verticalStep.toFloat()))))
            for (i in points.indices) {
                val x1 = xAxisSpace * xValues[i]
                val y1 = size.height - (yAxisSpace * (points[i]/verticalStep.toFloat()))
                coordinates.add(PointF(x1,y1))
                if(i == points.indices.last){
                    drawCircle(
                        color = color,
                        radius = 7f,
                        center = Offset(x1,y1)
                    )
                } else {
                    drawCircle(
                        color = Color.Transparent,
                        radius = 7f,
                        center = Offset(x1,y1)
                    )
                }
            }

            for (i in 1 until coordinates.size) {
                controlPoints1.add(PointF((coordinates[i].x + coordinates[i - 1].x) / 2, coordinates[i - 1].y))
                controlPoints2.add(PointF((coordinates[i].x + coordinates[i - 1].x) / 2, coordinates[i].y))
            }

            /** drawing the path */
            val stroke = Path().apply {
                reset()
                moveTo(coordinates.first().x, coordinates.first().y)
                for (i in 0 until coordinates.size - 1) {
                    cubicTo(
                        controlPoints1[i].x,controlPoints1[i].y,
                        controlPoints2[i].x,controlPoints2[i].y,
                        coordinates[i + 1].x,coordinates[i + 1].y
                    )
                }
            }

            drawPath(
                stroke,
                color = color,
                style = Stroke(
                    width = 5f,
                    cap = StrokeCap.Round
                )
            )

            val stroke0 = Path().apply {
                reset()
                moveTo(0f, coordinates.last().y)
                cubicTo(
                    0f,coordinates.last().y,
                    0f,coordinates.last().y,
                    coordinates.last().x,coordinates.last().y
                )
            }

            drawPath(
                stroke0,
                color = Color(0xFFDBDBDB),
                style = Stroke(
                    width = 1f,
                    cap = StrokeCap.Round
                )
            )
        }
    }
}