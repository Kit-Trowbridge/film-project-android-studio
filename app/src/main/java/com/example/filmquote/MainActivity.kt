package com.example.filmquote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmquote.ui.theme.Cornflower
import com.example.filmquote.ui.theme.DarkShadow
import com.example.filmquote.ui.theme.FilmQuoteTheme
import com.example.filmquote.ui.theme.GradientColors

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
    Box(
        contentAlignment = Alignment.Center, // aligns self in screen context
    ){
        FilmImage(
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxSize()
        )
        Column(
            modifier = modifier
                .padding(all = 30.dp)
                .align(alignment = Alignment.Center)
        ) {
            Text(
                text = quote,
                style = MaterialTheme.typography.titleLarge.merge(
                    TextStyle(
                        brush = Brush.linearGradient(
                            colors = GradientColors
                        ),
                        shadow = Shadow(
                            color = DarkShadow, offset = Offset(15.0f, 15.0f), blurRadius = 15f
                        )
                    )
                ),
                fontStyle = FontStyle.Italic
            )
            Spacer(
                Modifier.height(25.dp)
            )
            Text(
                text = title,
                fontSize = 30.sp,
                color = Cornflower,
                modifier = Modifier
                    .align(alignment = Alignment.End)
            )
            Spacer(
                Modifier.height(25.dp)
            )
            ElevatedButton(
                onClick = {
                    println("Button was clicked")
                }
            ) {
                Text(text = stringResource(R.string.button_label))
            }

        }
    }


}

@Composable
fun FilmImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bl)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun FilmCardPreview() {
    FilmCard(
        quote = "\"Yeah, well, you know, that's just, like, your opinion, man.\"",
        title = "The Big Lebowski"
    )
}