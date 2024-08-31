package com.fourdevs.dioaziz.ui.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.nav.AppScreen
import com.fourdevs.dioaziz.ui.theme.Cyan40
import com.fourdevs.dioaziz.utils.Constants
import com.fourdevs.dioaziz.viewmodels.MainViewModel


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun ShareScreen(navController: NavHostController, viewModel: MainViewModel) {

    val filePath by viewModel.filePath.collectAsState()
    val imageBitmap by viewModel.imageBitmap.collectAsState()

    Log.d("Afridi-Screen", filePath)

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        imageBitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            CustomIconButton(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(end = 5.dp),
                icon = painterResource(id = R.drawable.ic_file),
                text = Constants.KEY_VIEW_BN,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                viewModel.openPdfFile(filePath)
            }

            CustomIconButton(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(start = 5.dp),
                icon = painterResource(id = R.drawable.ic_share),
                text = Constants.KEY_SHARE_BN,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Cyan40,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
            ) {
                viewModel.sharePdfFile(filePath)
            }
        }

        CustomIconButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 5.dp),
            icon = painterResource(id = R.drawable.ic_add_new),
            text = Constants.KEY_ADD_NEW_BN,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
        ) {
            viewModel.resetAllValues()
            navController.navigate(AppScreen.Application.route) {
                popUpTo(AppScreen.Application.route) { inclusive = true }
            }
        }

        CustomIconButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 5.dp),
            icon = painterResource(id = R.drawable.ic_home),
            text = Constants.KEY_HOME_BN,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
        ) {
            viewModel.resetAllValues()
            navController.navigate(AppScreen.MainNav.route) {
                popUpTo(AppScreen.MainNav.route) { inclusive = true }
            }
        }
    }
}


@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    icon: Painter,
    text: String,
    onClick: () -> Unit

) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Icon(painter = icon, contentDescription = "")
            Text(text = text, modifier = Modifier.padding(start = 10.dp))
        }
    }
}