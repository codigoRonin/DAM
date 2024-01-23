package com.example.exercicecards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.LocalActivity
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CardTicket() {
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Ticket()
    }
}
@Composable
fun Ticket() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Blue)
                .padding(top = 8.dp, bottom =8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ENTRADA",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(96.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.qr),
                    contentDescription = "Código QR"
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Valido hasta  blaalalla",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Icon(
                        imageVector = Icons.Default.EventAvailable,
                        modifier = Modifier.size(16.dp), contentDescription = "Date Icon"
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    //FECHA VALIDEZ
                    Text(
                        text = "Validez: 01/01/2024 - 31/01/2024",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                   Row {
                    Icon(
                        imageVector = Icons.Default.LocalActivity,
                        modifier = Modifier.size(16.dp), contentDescription = "nº de pases"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Nº de pases: 6 ",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        modifier = Modifier.size(16.dp), contentDescription = "Location Icon"
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Calle abajo sin número",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}
