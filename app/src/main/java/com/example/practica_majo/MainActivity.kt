package com.example.practica_majo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_majo.ui.theme.Practica_majoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }


    }
}
@Composable
fun App() {
    var uno by remember { mutableStateOf("") }
    var dos by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var focusRequester = remember { mutableStateOf("") }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8D9F3))
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logosuma),
                contentDescription = "Logo Calculadora",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "OPERATIONS",
                fontSize = 20.sp,
                color = Color(0xFF3700B3)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = uno,
            onValueChange = { uno = it },
            label = { Text("Ingrese numero uno: ") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        OutlinedTextField(
            value = dos,
            onValueChange = { dos = it },
            label = { Text("ingrese numero dos: ") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val a = uno.toDoubleOrNull()
                    val b = dos.toDoubleOrNull()

                    if (a != null && b != null) {
                        resultado = (a + b).toString()

                        uno = ""
                        dos = ""
                    }
                }
            ) {
                Text("+")
            }

            Button(
                onClick = {
                    val a = uno.toDoubleOrNull()
                    val b = dos.toDoubleOrNull()
                    if (a != null && b != null) {
                        resultado = (a - b).toString()
                        uno = " "
                        dos = " "
                    }
                }) {
                Text("-")
            }

            Button(
                onClick = {
                    val a = uno.toDoubleOrNull()
                    val b = dos.toDoubleOrNull()
                    if (a != null && b != null) {
                        resultado = (a * b).toString()
                        uno = ""
                        dos = ""
                    }
                }) {
                Text("x")
            }
            Button(
                onClick = {
                    val a = uno.toDoubleOrNull()
                    val b = dos.toDoubleOrNull()
                    if (a != null && b != null) {
                        resultado = if (b != 0.0) {
                            (a / b).toString()
                        } else {
                            "Error: Div entre 0"
                        }
                        uno = ""
                        dos = ""
                    }
                }
            ) {
                Text("/")
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "El resultado es: $resultado",
            fontSize = 18.sp,
            color = Color(0xFF3700B3)

        )
    }
}

@Preview
@Composable
fun Vista(){
    App()
}
