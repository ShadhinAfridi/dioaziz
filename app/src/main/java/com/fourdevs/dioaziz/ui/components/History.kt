package com.fourdevs.dioaziz.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.theme.Green80
import com.fourdevs.dioaziz.ui.theme.Purple40
import com.fourdevs.dioaziz.viewmodels.MainViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun History(viewModel: MainViewModel) {
    val filledFormList by viewModel.filledFormList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllPassportData()
    }
    if(filledFormList.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "দুঃখিত, কিছুই পাওয়া যায়নি",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

    LazyColumn {
        // Group the list by endDate
        val groupedItems = filledFormList.groupBy { it.endDate }

        // Iterate over the grouped items
        groupedItems.forEach { (date, forms) ->

            // Show sticky header for each unique date
            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .background(color = Purple40)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = date,  // Use the unique date for the header
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }

            // Iterate over forms that have the same endDate
            forms.forEach { formData ->
                item {
                    ListItem(
                        drawableResId = R.drawable.ic_check,
                        color = Green80,
                        pvrNo = formData.pvrNo,
                        name = formData.applicantName
                    )
                }
            }
        }
    }
}