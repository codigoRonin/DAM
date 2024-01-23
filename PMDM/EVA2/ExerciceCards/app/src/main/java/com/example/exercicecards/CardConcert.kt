package com.example.exercicecards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterial3Api
@Composable
fun CardConcert() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
    //    elevation = CardDefaults.cardElevation(10.dp),
    //    border = BorderStroke(1.dp, Color.White),
    //    colors = CardDefaults.cardColors(Color.White),
    ) {
        Concert()
    }
}

@ExperimentalMaterial3Api
@Composable
fun Concert() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2.0f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.acdc),
            contentDescription = "Imagen Concierto",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        color = Color.Black.copy(alpha = 0.5f), // Cambia la opacidad para ajustar la oscuridad
                        blendMode = BlendMode.SrcOver
                    )
                }
        )

        // CAJA STOCK RESTANTE
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .background(color = Color.Red, shape = RoundedCornerShape(8.dp))
                .padding(6.dp)
        ) {
            Text(
                text = "QUEDAN(3)",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
        }

        // Textos (Título y Dirección) sobre la imagen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Concierto de AC/DC",
                style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = " Calle La Voz S/N ",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
                Text(
                    text = "Tarazona",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "23/03/2024",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            //FILA DE PRECIO Y FAVORITOS
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Red
                            // color = Color.Green.copy(alpha = 0.5f), // Fondo verde claro con opacidad
                            //  shape = RoundedCornerShape(16.dp) // Bordes redondeados
                        )

                ) {
                    Text(
                        text = "  GRATIS  ",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White
                        ),
                        //   modifier = Modifier .padding(8.dp), // Espaciado dentro del Box
                    )
                }
                Icon(
                    Icons.Outlined.ExpandCircleDown,
                    "Arrow ",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                BadgedBox(
                    modifier = Modifier,
                    badge = {
                        Badge(
                            contentColor = Color.White,
                            containerColor = Color.Black.copy(alpha = 0.5f)
                        ) {
                            Text(text = "3")
                        }
                    },
                    content = {

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Like publication",
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color.Red
                        )
                    }
                )
            }
        }
    }
}