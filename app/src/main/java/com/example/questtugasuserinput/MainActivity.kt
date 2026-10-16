package com.example.questtugasuserinput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.questtugasuserinput.ui.theme.QuestTugasUserInputTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTugasUserInputTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.bg_scaffold)
                ) {
                    // Menampilkan Form Biodata dengan Box yang mengapung di atas Scaffold
                    BiodataScreen()
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BiodataAppPreview() {
    QuestTugasUserInputTheme {
        BiodataScreen()
    }
}

