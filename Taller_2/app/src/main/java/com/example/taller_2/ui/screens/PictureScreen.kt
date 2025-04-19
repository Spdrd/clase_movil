package com.example.taller_2.ui.screens

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil3.compose.AsyncImage
import androidx.compose.ui.viewinterop.AndroidView


@Composable
fun PictureScreen() {
    var mediaUri by remember { mutableStateOf<Uri?>(null) }
    var tempVideoUri by remember { mutableStateOf<Uri?>(null) }
    var isPhotoSelected by remember { mutableStateOf(true) }

    val context = LocalContext.current

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted -> /* noop */ }

    val takePhotoLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap?.let {
            val path = MediaStore.Images.Media.insertImage(context.contentResolver, it, "captured_image", null)
            mediaUri = Uri.parse(path)
        }
    }

    val takeVideoLauncher = rememberLauncherForActivityResult(ActivityResultContracts.CaptureVideo()) { success ->
        if (success) {
            mediaUri = tempVideoUri // Solo si el video fue grabado exitosamente
        } else {
            tempVideoUri = null
        }
    }

    val selectFromGalleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            mediaUri = uri
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Switch
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Foto")
            Switch(
                checked = !isPhotoSelected,
                onCheckedChange = { isPhotoSelected = !it },
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text("Video")
        }

        // Vista previa
        Box(
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFDDFDB6)),
            contentAlignment = Alignment.Center
        ) {
            mediaUri?.let { uri ->
                if (isPhotoSelected) {
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    key(mediaUri) {
                        AndroidView(
                            factory = {
                                VideoView(it).apply {
                                    setVideoURI(mediaUri)
                                    setOnPreparedListener { mp ->
                                        mp.isLooping = true
                                        start()
                                    }
                                    setOnErrorListener { _, _, _ -> true }
                                }
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            } ?: Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(80.dp)
            )
        }

        // Botones
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // Boton Camara
            Button(
                onClick = {
                    val permission = Manifest.permission.CAMERA
                    if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
                        if (isPhotoSelected) {
                            takePhotoLauncher.launch(null)
                        } else {
                            val uri = createVideoUri(context)
                            tempVideoUri = uri
                            takeVideoLauncher.launch(tempVideoUri!!)
                        }
                    } else {
                        permissionLauncher.launch(permission)
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF223C7A)),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(if (isPhotoSelected) "Tomar Foto" else "Grabar Video", color = Color.White)
            }

            Button(
                onClick = {
                    selectFromGalleryLauncher.launch(
                        if (isPhotoSelected) "image/*" else "video/*"
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF223C7A)),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(if (isPhotoSelected) "Seleccionar Foto" else "Seleccionar Video", color = Color.White)
            }
        }
    }
}

fun createVideoUri(context: Context): Uri? {
    val resolver = context.contentResolver
    val videoCollection = MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)

    val newVideo = ContentValues().apply {
        put(MediaStore.Video.Media.DISPLAY_NAME, "video_${System.currentTimeMillis()}.mp4")
        put(MediaStore.Video.Media.MIME_TYPE, "video/mp4")
        put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/TuApp")
    }

    return resolver.insert(videoCollection, newVideo)
}


@Preview
@Composable
fun PictureScreenPrev() {
    PictureScreen()
}
