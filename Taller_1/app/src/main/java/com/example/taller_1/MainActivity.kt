@file:OptIn(ExperimentalFoundationApi::class)

package com.example.taller_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.taller_1.model.Company
import com.example.taller_1.model.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

val users = listOf(
    User(1, "Juan", "Pérez", Company("Tecnología", "Google", "Ingeniero de Software"), "https://example.com/juan.jpg", "Gómez", 28, "Male", "juan@example.com", "+57 3001234567"),
    User(2, "María", "García", Company("Marketing", "Meta", "Especialista en Redes Sociales"), "https://example.com/maria.jpg", "López", 25, "Female", "maria@example.com", "+57 3012345678"),
    User(3, "Carlos", "Martínez", Company("Ventas", "Amazon", "Gerente de Cuentas"), "https://example.com/carlos.jpg", "Rodríguez", 32, "Male", "carlos@example.com", "+57 3209876543"),
    User(4, "Ana", "Fernández", Company("Recursos Humanos", "Microsoft", "Reclutadora"), "https://example.com/ana.jpg", "Sánchez", 27, "Female", "ana@example.com", "+57 3156789012"),
    User(5, "Pedro", "Torres", Company("Desarrollo", "Apple", "Desarrollador iOS"), "https://example.com/pedro.jpg", "Jiménez", 30, "Male", "pedro@example.com", "+57 3187654321"),
    User(6, "Sofía", "Ramírez", Company("Diseño", "Adobe", "Diseñadora UX"), "https://example.com/sofia.jpg", "Castro", 26, "Female", "sofia@example.com", "+57 3198765432"),
    User(7, "Luis", "Hernández", Company("Seguridad", "IBM", "Analista de Seguridad"), "https://example.com/luis.jpg", "Ortiz", 35, "Male", "luis@example.com", "+57 3123456789"),
    User(8, "Elena", "Morales", Company("Legal", "Tesla", "Abogada Corporativa"), "https://example.com/elena.jpg", "Ríos", 29, "Female", "elena@example.com", "+57 3112233445"),
    User(9, "Miguel", "Díaz", Company("Finanzas", "Goldman Sachs", "Asesor Financiero"), "https://example.com/miguel.jpg", "Vargas", 31, "Male", "miguel@example.com", "+57 3145566778"),
    User(10, "Camila", "Suárez", Company("Producción", "Disney", "Productora de Contenidos"), "https://example.com/camila.jpg", "Luna", 24, "Female", "camila@example.com", "+57 3166677889"),
    User(11, "Fernando", "Cruz", Company("Logística", "DHL", "Coordinador Logístico"), "https://example.com/fernando.jpg", "Pérez", 40, "Male", "fernando@example.com", "+57 3178899001"),
    User(12, "Laura", "Mendoza", Company("Medicina", "Pfizer", "Investigadora Biomédica"), "https://example.com/laura.jpg", "Aguilar", 33, "Female", "laura@example.com", "+57 3223344556"),
    User(13, "Andrés", "Paredes", Company("Automotriz", "Ford", "Ingeniero Mecánico"), "https://example.com/andres.jpg", "Quintero", 28, "Male", "andres@example.com", "+57 3234455667"),
    User(14, "Verónica", "Gómez", Company("Educación", "Harvard", "Profesora Universitaria"), "https://example.com/veronica.jpg", "Figueroa", 26, "Female", "veronica@example.com", "+57 3245566778"),
    User(15, "Javier", "Vargas", Company("Construcción", "Cemex", "Arquitecto"), "https://example.com/javier.jpg", "Delgado", 34, "Male", "javier@example.com", "+57 3256677889"),
    User(16, "Natalia", "Ortega", Company("Turismo", "Airbnb", "Gerente de Operaciones"), "https://example.com/natalia.jpg", "Romero", 29, "Female", "natalia@example.com", "+57 3267788990"),
    User(17, "Ricardo", "Peña", Company("Entretenimiento", "Netflix", "Director Creativo"), "https://example.com/ricardo.jpg", "Castaño", 32, "Male", "ricardo@example.com", "+57 3278899001"),
    User(18, "Daniela", "Serrano", Company("Alimentos", "Nestlé", "Nutricionista"), "https://example.com/daniela.jpg", "Campos", 27, "Female", "daniela@example.com", "+57 3289900112"),
    User(19, "Esteban", "Navarro", Company("Transporte", "Uber", "Gerente de Proyectos"), "https://example.com/esteban.jpg", "Blanco", 36, "Male", "esteban@example.com", "+57 3290011223"),
    User(20, "Patricia", "Ríos", Company("Moda", "Zara", "Diseñadora de Moda"), "https://example.com/patricia.jpg", "Fuentes", 30, "Female", "patricia@example.com", "+57 3301122334")
)

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
}



@Composable
fun MainScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn {
            stickyHeader {
                Surface(
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Header(users = users)
                }
            }
            items(users){
                user -> UserListItem(user = user, onClick = {})
            }
        }
    }
}

@Composable
fun UserListItem(user: User, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick) // Aquí agregamos el onClick para la acción sobre el item de usuario
    ) {
        ListItem(
            modifier = Modifier.padding(5.dp),
            leadingContent = {
                /*
                AsyncImage(
                    model = user.image,
                    contentDescription = null,
                    modifier = Modifier.size(85.dp)
                        .clip(CircleShape)
                )
                */
            },
            headlineContent = {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold)
            },
            supportingContent = {
                Text(
                    text = "${user.lastName} - ${user.company.name}",
                    style = MaterialTheme.typography.bodyMedium)
            },
            trailingContent = {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.Gray)
            }
        )
        HorizontalDivider(thickness = 1.dp)
    }
}

@Composable
fun Header (users: List<User>) {
    Text(
        text = "Total de usuarios: ${users.size}",
        modifier = Modifier
            .fillMaxWidth().padding(16.dp).statusBarsPadding(),
        style = MaterialTheme.typography.headlineSmall
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme{
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            MainScreen()
        }
    }
}