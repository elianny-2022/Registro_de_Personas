package com.example.registrodepersonas.ui.RegistroPersona

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.registrodepersonas.R


@Composable
fun Registro(){
    Box(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .padding(30.dp)){
        RegistroPersona(Modifier.align(Alignment.Center))
    }
}

@Composable
fun RegistroPersona(modifier: Modifier) {
     Card(
         elevation = 16.dp
     ) {
         Column(modifier = modifier) {
             Titulo(Modifier.align(Alignment.CenterHorizontally))
             Spacer(modifier = Modifier.padding(16.dp))
             NombrePersona()
             Spacer(modifier = Modifier.padding(4.dp),)
             TelefonoPersona()
             Spacer(modifier = Modifier.padding(8.dp))
             CelularPersona()
             Spacer(modifier = Modifier.padding(4.dp))
             EmailPersona()
             Spacer(modifier = Modifier.padding(8.dp))
             DireccionPersona()
             Spacer(modifier = Modifier.padding(4.dp))
             FechaNacimiento()
             Spacer(modifier = Modifier.padding(8.dp))
             SeleccionOcupacion()
             Spacer(modifier = Modifier.padding(4.dp))
             GuardarButton(Modifier.align(Alignment.CenterHorizontally))
             Spacer(modifier = Modifier.padding(16.dp))
         }
     }
}

@Composable
fun GuardarButton(modifier: Modifier) {
    OutlinedButton(
        onClick = { },
        contentPadding = PaddingValues(
            start = 50.dp,
            top = 20.dp,
            end = 60.dp,
            bottom = 16.dp
        ),

        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color(0xFF6C3BC4)
        ),
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = "Agregar" )
        //Icon(Icons.Default.Add, contentDescription = "Agregar", modifier = Modifier.size(ButtonDefaults.IconSize))
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Guardar", fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            color = Color.White)
    }
}

@Composable
fun FechaNacimiento() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp
    ) {
            OutlinedTextField(
                value = text, onValueChange = {text = it},
                modifier = Modifier.fillMaxWidth(),
                enabled = false,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {

                            }
                            .size(30.dp, 30.dp),
                        tint = MaterialTheme.colors.onSurface
                    )
                },
                label = {
                    Text("Fecha de nacimiento",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1.merge(),
                        color = Color(0xFF6B6060)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF857C7C),
                    backgroundColor = Color(0xFFFFFFF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )


    }
}

@Composable
fun SeleccionOcupacion() {
    val ocupaciones = listOf("Ingenieria en Sistemas", "Contable", "Medico", "Alabañil", "Profesor")
    var ocupacionSeleccionada by remember {mutableStateOf( "") }
    var expandido by remember { mutableStateOf(false) }

   Column(modifier = Modifier.fillMaxWidth()) {
       Surface(
           modifier = Modifier.padding(16.dp),
           border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
           contentColor = Color.Blue,
           elevation = 8.dp
       ) {
           OutlinedTextField(
               label = {
                   Text(
                       "Selecciona ocupacion",
                       fontStyle = FontStyle.Italic,
                       fontWeight = FontWeight.Bold,
                       style = MaterialTheme.typography.body1.merge(),
                       color = Color(0xFF6B6060)
                   )
               },
               trailingIcon = {
                   Icon(
                       imageVector = Icons.Default.ArrowDropDown,
                       contentDescription = null
                   )
               },
               value = ocupacionSeleccionada,
               onValueChange = { ocupacionSeleccionada = it },
               readOnly = true, enabled = false,
               modifier = Modifier
                   .clickable {
                       expandido = true
                       Log.e("tag", "expandio")
                   }
                   .fillMaxWidth()
           )
           DropdownMenu(
               expanded = expandido,
               onDismissRequest = { expandido = false },
               modifier = Modifier.fillMaxWidth()
           ) {
               ocupaciones.forEach { item ->
                   DropdownMenuItem(onClick = {
                       expandido = false
                       ocupacionSeleccionada = item
                   }) {
                       Text(text = item)

                   }
               }
           }
       }
   }

}

@Composable
fun DireccionPersona() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp
    ) {
        OutlinedTextField(
            value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Direccion",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.merge(),
                color = Color(0xFF6B6060)
            )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF857C7C),
                backgroundColor = Color(0xFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun EmailPersona() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp
    ) {
        OutlinedTextField(
            value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.merge(),
                color = Color(0xFF6B6060)
            )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF857C7C),
                backgroundColor = Color(0xFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun CelularPersona() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp
    ) {
        OutlinedTextField(
            value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Celular",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.merge(),
                color = Color(0xFF6B6060)
            )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF857C7C),
                backgroundColor = Color(0xFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun TelefonoPersona() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp
    ) {
        OutlinedTextField(
            value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Telefono",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.merge(),
                color = Color(0xFF6B6060)
            )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF857C7C),
                backgroundColor = Color(0xFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun NombrePersona() {
    var text by remember {
        mutableStateOf("") }
    Surface(
        modifier = Modifier.padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFB8B4B4)),
        contentColor = Color.Blue,
        elevation = 8.dp,
    ) {
        OutlinedTextField(
            value = text, onValueChange = {text = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body1.merge(),
                color = Color(0xFF6B6060)
            )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF857C7C),
                backgroundColor = Color(0xFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun Titulo(modifier: Modifier) {
    Text("Registro de Personas",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        modifier = modifier)
}
