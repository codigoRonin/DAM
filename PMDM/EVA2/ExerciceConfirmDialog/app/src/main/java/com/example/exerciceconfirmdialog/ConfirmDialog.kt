package com.example.exerciceconfirmdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun MyConfimationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                MyTitleDialog("Phone ringtone")
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp), color = Color.LightGray
                )
                var name by rememberSaveable { mutableStateOf("None") }
                MyRadioButtonList(name = name, onItemSelected = { name = it })
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp), color = Color.LightGray
                )

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}



@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "None", onClick = { onItemSelected("None") })
        Text(text = "None")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "Callisto", onClick = { onItemSelected("Callisto") })
        Text(text = "Callisto")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "Ganymede", onClick = { onItemSelected("Ganymede") })
        Text(text = "Ganymede")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "Luna", onClick = { onItemSelected("Luna") })
        Text(text = "Luna")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "Oberon", onClick = { onItemSelected("Oberon") })
        Text(text = "Oberon")

    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == "Photos", onClick = { onItemSelected("Photos") })
        Text(text = "Photos")
    }

}
// Le paso además del título un modifier el cual inicializo y asi si no le pongo modifier me pone
// el que inicializado por defecto.
@Composable
fun MyTitleDialog(title: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}

