package com.rayauxey.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rayauxey.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App( modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier.padding(16.dp)) {
        MainCard(modifier = Modifier.padding(bottom = 200.dp))
        ContactCard(
            handle = stringResource(R.string.handle),
            email = stringResource(R.string.email)
        )
    }
}

@Composable
fun MainCard(modifier: Modifier = Modifier, name: String = stringResource(R.string.full_name), title: String = stringResource(R.string.title)) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier.width(100.dp)
        )
        Text(text = name, fontSize = 52.sp, color = Color.White, textAlign = TextAlign.Center)
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color(0xFF00DF83))

    }
}

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    phone: String = "+254722000000",
    handle: String = "@handle",
    email: String = "example@gmail.com"
) {
    Column(modifier = modifier.padding(start = 16.dp, bottom = 16.dp)) {
        Contact(icon = Icons.Rounded.Call, text = phone)
        Contact(icon = Icons.Rounded.Share, text = handle)
        Contact(icon = Icons.Rounded.Email, text = email)
    }
}

@Composable
fun Contact(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF00DF83))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = text, color = Color.White, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF003043)
    ) {
        App()
    }
}