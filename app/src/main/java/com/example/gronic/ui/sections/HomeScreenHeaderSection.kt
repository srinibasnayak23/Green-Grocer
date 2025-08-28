package com.example.gronic.ui.sections

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gronic.R

@Composable
fun HomeScreenHeader(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onLogoutClick: () -> Unit,
    onChangeImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Dropdown state
    var expanded by remember { mutableStateOf(false) }
    var profileImage by remember { mutableStateOf<Bitmap?>(null) }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap != null) {
            profileImage = bitmap
        }
    }

    Column(modifier = modifier) {
        // Greeting Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Hey 😊",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    "Let's search your grocery food.",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White
                    )
                )
            }

            // Profile + Dropdown
            Box {
                Surface(
                    modifier = Modifier
                        .size(42.dp)
                        .clickable { expanded = true }, // Open dropdown
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    if (profileImage != null) {
                        Image(
                            bitmap = profileImage!!.asImageBitmap(),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.profile_img),
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape)
                        )
                    }
//                    Image(
//                        painter = painterResource(id = R.drawable.profile_img),
//                        contentDescription = "Profile",
//                        modifier = Modifier.size(26.dp)
//                    )
                }

                // Dropdown menu
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Change Image") },
                        onClick = {
                            expanded = false
                            cameraLauncher.launch(null)
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Logout") },
                        onClick = {
                            expanded = false
                            onLogoutClick()
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Search bar
        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("Search your daily grocery food ...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                cursorColor = MaterialTheme.colorScheme.primary
            )
        )
    }
}


