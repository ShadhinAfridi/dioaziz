package com.fourdevs.dioaziz.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.theme.Green80
import com.fourdevs.dioaziz.ui.theme.Pink80
import com.fourdevs.dioaziz.utils.Constants

@Composable
fun ErrorMessage(label: String) {
    Text(
        text = label,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.labelSmall
    )
}

@Composable
fun CustomInputField(
    text: String,
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    localFocusManager: FocusManager,
    isError: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onNext: (KeyboardActionScope.() -> Unit) = {
        localFocusManager.moveFocus(FocusDirection.Down)
    },
    readOnly: Boolean = false,
    supportingText: (@Composable () -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions(onNext = onNext)
) {
    Column(modifier = modifier.padding(horizontal = 20.dp, vertical = 5.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            label = {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            readOnly = readOnly,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            prefix = prefix,
            suffix = suffix,
            visualTransformation = visualTransformation,
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            isError = isError,
            placeholder = {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            textStyle = MaterialTheme.typography.bodyLarge
        )
        // Place supportingText below with separate padding
        if (supportingText != null) {
            Spacer(modifier = Modifier.height(0.dp)) // Add space if needed
            supportingText()
        }
    }
}


@Composable
fun Divider(
    title: String,
    onClick: (Boolean) -> Unit,
    isClicked: Boolean,
    isError: Boolean = false
) {
    ElevatedCard(
        onClick = { onClick(!isClicked) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isClicked && !isError) MaterialTheme.colorScheme.primary
            else if (isError) MaterialTheme.colorScheme.error
            else MaterialTheme.colorScheme.primaryContainer,
            contentColor = if (isClicked && !isError) MaterialTheme.colorScheme.onPrimary
            else if (isError) MaterialTheme.colorScheme.onError
            else MaterialTheme.colorScheme.onPrimaryContainer,
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, 10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
            )
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(1f)
            )
            Icon(
                imageVector = if (isClicked)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Dropdown",
                modifier = Modifier.size(36.dp),
                tint = if (isClicked) MaterialTheme.colorScheme.onPrimary
                else if (isError) MaterialTheme.colorScheme.onError
                else MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}

@Composable
fun ColumnDropDown(
    isClicked: Boolean,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Column(
        modifier = if (isClicked)
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .animateContentSize()
        else
            Modifier
                .fillMaxWidth()
                .animateContentSize()
                .height(0.dp),
        content = content
    )
}

@Composable
fun HomeCard(
    onClick: () -> Unit,
    imageVector: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color
) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = text,
                modifier = Modifier
                    .size(62.dp)
                    .padding(top = 10.dp),
            )
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp)
            .padding(top = 8.dp, start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun ListItem(
    drawableResId: Int,
    color: Color,
    pvrNo: String,
    name: String
) {
    ElevatedCard(
        onClick = {},
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(color = color, shape = RoundedCornerShape(100))
            ) {
                Icon(
                    painter = painterResource(id = drawableResId),
                    contentDescription = "List Item",
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = Constants.KEY_PVR_NO_BN + " : " + pvrNo,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = Constants.KEY_NAME_BN + " : " + name,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "List Item",
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .size(48.dp)
                    .padding(10.dp)
            )


        }
    }
}

@Composable
fun CustomCheckbox(
    checkedState: Boolean,
    text: String,
    onValueChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = onValueChange,
                role = Role.Checkbox
            )
            .padding(horizontal = 30.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
        )

        Checkbox(
            checked = checkedState,
            onCheckedChange = null, // null recommended for accessibility with screensavers
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    datePickerState: DatePickerState,
    confirmEnabled: Boolean,
    onConfirmClick: () -> Unit,
    onCancelClick: () -> Unit,
    pickedDate: (Long) -> Unit
) {
    if (openDialog) {
        DatePickerDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                TextButton(
                    onClick = onConfirmClick,
                    enabled = confirmEnabled
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = onCancelClick) { Text("Cancel") }
            }
        ) {
            DatePicker(state = datePickerState)

            datePickerState.selectedDateMillis?.let {
                pickedDate(it)
            }
        }
    }
}

@Composable
fun CustomProgressIndicator() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        LinearProgressIndicator(
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun CustomDropDownItem(
    list : List<String>,
    onClick: (String) -> Unit,
) {
    if(list.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            list.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    },
                    onClick = {
                        onClick(item)
                    },
                )
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomProgressIndicatorPreview() {
    CustomProgressIndicator()
}


@Preview
@Composable
fun CustomCheckboxPreview() {
    CustomCheckbox(checkedState = true, text = Constants.KEY_SAME_ADDRESS_BN) {

    }
}


@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(
        text = Constants.KEY_SAVE_BN,
        onClick = {}
    )
}


@Preview
@Composable
fun HomeCardPreview() {
    HomeCard(
        onClick = { /*TODO*/ },
        imageVector = Icons.Filled.Settings,
        text = Constants.KEY_HISTORY_BN,
        containerColor = Green80
    )
}

@Preview
@Composable
fun DividerPreview() {
    Divider(
        title = Constants.KEY_TITLE_IDENTIFY_ONE_INFO_BN,
        onClick = { isClicked ->
            // Handle the click event here
            if (isClicked) {
                println("Divider clicked!")
            } else {
                println("Divider not clicked!")
            }
        },
        isClicked = true
    )
}

@Preview
@Composable
fun CustomInputFieldPreview() {
    CustomInputField(
        text = Constants.KEY_MOBILE_NO_BN,
        value = "",
        onChange = {},
        localFocusManager = LocalFocusManager.current,
        isError = false
    )
}

@Preview
@Composable
fun ErrorMessagePreview() {
    ErrorMessage(label = Constants.KEY_MOBILE_NO_BN)
}

@Preview
@Composable
fun ListItemPendingPreview() {
    ListItem(
        drawableResId = R.drawable.ic_hourglass_bottom,
        color = Pink80,
        pvrNo = "৮৯০৭৩",
        name = "আফ্রিদী হাসান স্বাধীন"
    )
}

@Preview
@Composable
fun ListItemDonePreview() {
    ListItem(
        drawableResId = R.drawable.ic_check,
        color = Green80,
        pvrNo = "৮৯০৭৩",
        name = "আফ্রিদী হাসান স্বাধীন"
    )
}