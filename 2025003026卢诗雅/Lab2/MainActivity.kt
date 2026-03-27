package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White
                ) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val bottomBg = Color.White
    val accentColor = Color(0xFFFF69B4)
    val textColor = Color(0xFF555555)

    Column(modifier = modifier.fillMaxSize()) {
        // 上半部分：背景
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
        ) {
            // 背景图（铺满）
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "顶部背景",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // 铺满裁剪，不变形
            )

            // 上面的内容：头像 + 名字 + 职位
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CardTop(
                    name = "卢诗雅",
                    title = "Android 开发工程师",
                    accentColor = accentColor,
                    textColor = textColor
                )
            }
        }

        // 下半部分
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(bottomBg),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CardBottom(
                phone = "+86 138-8738-6676",
                email = "2110131725@qq.com",
                handle = "@balaba",
                accentColor = accentColor,
                textColor = textColor
            )
        }
    }
}

// 上半部分内容：头像 + 姓名 + 职位
@Composable
fun CardTop(
    name: String,
    title: String,
    accentColor: Color,
    textColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "头像",
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = name,
            color = textColor,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = title,
            color = accentColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

// 下半部分内容：联系方式
@Composable
fun CardBottom(
    phone: String,
    email: String,
    handle: String,
    accentColor: Color,
    textColor: Color
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        ContactRow(iconRes = R.drawable.phone, info = phone, accentColor, textColor)
        Divider(color = accentColor.copy(alpha = 0.5f), thickness = 1.dp)
        ContactRow(iconRes = R.drawable.email, info = email, accentColor, textColor)
        Divider(color = accentColor.copy(alpha = 0.5f), thickness = 1.dp)
        ContactRow(iconRes = R.drawable.share, info = handle, accentColor, textColor)
        Divider(color = accentColor.copy(alpha = 0.5f), thickness = 1.dp)
    }
}

@Composable
fun ContactRow(
    iconRes: Int,
    info: String,
    accentColor: Color,
    textColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp, horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp),
            colorFilter = ColorFilter.tint(accentColor)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = info,
            color = textColor,
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme { BusinessCard() }
}