package com.example.belajarcompose.ui.modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.belajarcompose.R

@Composable
fun ModifierElement() {
    Row {
        Box{
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Foto",
                modifier = Modifier
                    .padding(6.dp)
                    .border(10.dp, Color.Red, CircleShape)
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Status",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 5.dp, y = 5.dp),
                tint = Color.Blue
                )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = "Rafly Ade Kusuma",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = "Online",
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ModifierElementPreview() {
    ModifierElement()
}