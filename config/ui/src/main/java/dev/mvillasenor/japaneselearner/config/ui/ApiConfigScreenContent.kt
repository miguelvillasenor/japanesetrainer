package dev.mvillasenor.japaneselearner.config.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.ApiConfigScreenContent(
    apiKey: String,
    onApiKeyUpdated: (String) -> Unit,
    onApiKeySaved: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = R.string.config_ui_app_config_apy_key_instructions),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    TextField(
        value = apiKey,
        onValueChange = { onApiKeyUpdated(it) },
        label = {
            Text(text = stringResource(id = R.string.config_ui_app_config_api_key_label))
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onApiKeySaved()
            }),
        visualTransformation = PasswordVisualTransformation()
    )

    Spacer(modifier = Modifier.weight(1f))

    Button(
        onClick = onApiKeySaved,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(text = stringResource(id = R.string.config_ui_app_config_save_button_label))
    }
}