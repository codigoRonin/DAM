@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.examen_1eva

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopCenter))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "LOGIN",
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            modifier = modifier.padding(12.dp)
        )
        Image(
            painter = painterResource(R.drawable.logo_tubalcain),
            contentDescription = "Logo Tubalcain",
            modifier = Modifier.size(150.dp)
        )
    }

}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var show by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        UserName(email = email, onTextChange = { email = it })
        Spacer(modifier = Modifier.height(16.dp))
        UserPassword(password = password, onTextChange = { password = it })
        Spacer(modifier = Modifier.height(32.dp))
        LoginButton(
            show = show,
            Modifier.align(Alignment.CenterHorizontally)
        ) {
            show = !show
            if (!show) {
                email = ""
                password = ""
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CheckLogin(show, email, password, Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun LoginButton(
    show: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(if (!show) "LOGIN" else "LIMPIAR")
    }
}

@Composable
fun CheckLogin(show: Boolean, email: String, password: String, modifier: Modifier) {
    if (show) {
        if (email == "ADMIN" && password == "1234")
            Text(text = "Usuario Loguedo correctamente", modifier = modifier)
        else
            Text(text = "Usuario o contraseña incorrecta", modifier = modifier)
    }
}

@Composable
fun UserName(email: String, onTextChange: (String) -> Unit) {

    OutlinedTextField(
        value = email,
        onValueChange = { onTextChange(it) },
        label = { Text("Nombre de usuario") },
        placeholder = { Text("Introduce tu E-mail") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black, focusedLabelColor = Color.Black
        ),
        leadingIcon = {
            Icon(
                Icons.Outlined.Email,
                contentDescription = "Email"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun UserPassword(password: String, onTextChange: (String) -> Unit) {

    OutlinedTextField(
        value = password,
        onValueChange = { onTextChange(it) },
        label = { Text("Contraseña") },
        placeholder = { Text("Introduce contraseña") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black, focusedLabelColor = Color.Black
        ),
        leadingIcon = {
            Icon(
                Icons.Outlined.Lock,
                contentDescription = "Email"
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun Footer(modifier: Modifier) {
    Text(
        text = "Copyright IES Tubalcaín - 2023",
        fontWeight = FontWeight.Light,
        fontSize = 18.sp,
        modifier = modifier.padding(bottom = 12.dp)
    )
}