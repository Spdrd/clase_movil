package com.example.preparcial_1_1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.ui.platform.LocalUriHandler
import com.example.preparcial_1_1.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val localUriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Imagen central (logo Android)
        Image(
            painter = painterResource(id = R.drawable.ic_android), // reemplaza con tu recurso
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(150.dp)
        )

        // Campo de texto (Nombre)
        var userName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        // Dropdown (Grado)
        var expanded by remember { mutableStateOf(false) }
        var selectedGrade by remember { mutableStateOf("Primaria") }
        val gradeOptions = listOf("Primaria", "Secundaria", "Universidad")

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedGrade,
                onValueChange = {},
                readOnly = true,
                label = { Text("Grado") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                gradeOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedGrade = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Botones al final
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { localUriHandler.openUri("https://www.javeriana.edu.co/inicio") }) {
                Text("Página web")
            }
            Button(onClick = { /* Acción Pantalla 2 */ }) {
                Text("Pantalla 2")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
