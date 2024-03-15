package com.example.belajarcompose.ui.modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.belajarcompose.R

@Composable
fun ButtonWithText(text:String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_700)),
        modifier = modifier.padding(4.dp)
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}
@Composable
fun Weight() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Row {
            ButtonWithText("1f", Modifier.weight(1f))
            ButtonWithText("1f", Modifier.weight(1f))
            ButtonWithText("1f", Modifier.weight(3f))
        }
        Row {
            ButtonWithText("1fjqwejqwopejpqwoe", Modifier.weight(5f, true))
            ButtonWithText("2f", Modifier.weight(2f, true))
            ButtonWithText("3", Modifier.weight(3f, true))
        }
        Row {
            ButtonWithText("1f", Modifier.weight(1f))
            ButtonWithText("2f", Modifier.weight(2f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("1", Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ButtonWithTextPreview() {
    Weight()
}
