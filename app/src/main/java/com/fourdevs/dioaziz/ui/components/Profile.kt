package com.fourdevs.dioaziz.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.utils.Constants

@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = Constants.KEY_HOME_NAME,
            fontSize = 32.sp,
            color = Color(0xFFF4CE14)
        )

        Text(
            text = Constants.KEY_HOME_NAME,
            fontSize = 24.sp,
            color = Color.White
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp)

        ) {
            Text(
                text = Constants.KEY_DES,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = 10.dp, end = 2.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = Constants.KEY_HOME_NAME,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }

        Button(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, color = Color.Black),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.wrapContentSize(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4CE14))
        ) {
            Text(text = "Click", color = Color.Black)
        }
    }
}