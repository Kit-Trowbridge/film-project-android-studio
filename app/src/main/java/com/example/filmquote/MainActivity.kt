package com.example.filmquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmquote.ui.theme.FilmQuoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilmQuoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), // is this necessary? without it, text not vertically aligned
                    color = MaterialTheme.colorScheme.background
                ) {
                    FilmCard(
                        quote = "\"Yeah, well, you know, that's just, like, your opinion, man.\"",
                        title = "The Big Lebowski"
                    )
                }
            }
        }
    }
}

@Composable
fun FilmCard(quote: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(all = 30.dp)
    ) {
        Text(
            text = quote,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(
            Modifier.height(25.dp)
        )
        Text(
            text = title,
            fontSize = 30.sp,
            modifier = Modifier
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmCard(
        quote = "\"Yeah, well, you know, that's just, like, your opinion, man.\"",
        title = "The Big Lebowski"
    )
}