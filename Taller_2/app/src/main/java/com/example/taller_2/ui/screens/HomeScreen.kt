package com.example.taller_2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    // Fondo blanco, contenido centrado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Botón "Abrir Cámara"
            Button(
                onClick = { /* Acción para abrir cámara */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2D4379), // Azul oscuro
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50), // Esquinas redondeadas
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp)
            ) {
                Text("Abrir Cámara")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.PhotoCamera, contentDescription = "Ícono cámara")
            }

            // Botón "Abrir Mapa"
            Button(
                onClick = { /* Acción para abrir mapa */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF5F6FA), // Color claro
                    contentColor = Color(0xFF2D4379)    // Mismo azul oscuro
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(200.dp)
                    .height(48.dp)
            ) {
                Text("Abrir Mapa")
                Spacer(modifier = Modifier.width(8.dp))
                Icon(Icons.Default.Map, contentDescription = "Ícono mapa")
            }
        }
    }
}


@Preview
@Composable
fun Prev(){
    HomeScreen()
}

