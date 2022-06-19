package com.rf.bandmeets.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.components.BandMeetsButtonPrimary
import com.rf.bandmeets.core.ui.components.BandMeetsTextField
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme
import com.rf.bandmeets.core.ui.theme.Purple200


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
        ) { values ->
            LoginInputColumn(
                viewState = viewState,
                onEmailChanged = onEmailChanged,
                onPasswordChanged = onPasswordChanged,
                onLoginClicked = onLoginClicked,
                onSignUpClicked = onSignUpClicked,
                contentPadding = values
            )
            if (viewState is LoginViewState.Submitting) {
                Material3CircularProgressIndicator(
                    modifier = Modifier
                        .wrapContentSize()
                )
            }

        }
    }
}

@Composable
fun Material3CircularProgressIndicator(modifier: Any) {
    //TODO

}

@Composable
private fun LoginInputColumn(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(
        dimensionResource(id = R.dimen.screen_padding)
    ),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = contentPadding.calculateStartPadding(LocalLayoutDirection.current),
                end = contentPadding.calculateEndPadding(LocalLayoutDirection.current),
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(contentPadding.calculateTopPadding()))

        AppLogo(modifier = Modifier.padding(vertical = 88.dp))
        Spacer(Modifier.height(16.dp))

        EmailInput(
            text = viewState.credentials.email.value,
            onTextChanged = onEmailChanged,
            errorMessage = (viewState as? LoginViewState.Active)
                ?.emailInputErrorMessage,
            //?.getString(this.context),
            enabled = viewState.inputsEnabled,
        )
        Spacer(modifier = Modifier.height(12.dp))

        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LoginViewState.Active)
                ?.passwordInputErrorMessage,
            //?.getString(),
            enabled = viewState.inputsEnabled,
        )
        if (viewState is LoginViewState.SubmissionError) {
            Text(
                text = viewState.errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .padding(top = 12.dp),
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        LoginButton(
            onClick = onLoginClicked,
            enabled = viewState.inputsEnabled,
        )

        Spacer(modifier = Modifier.height(48.dp))

        SignUpButton(
            onClick = onSignUpClicked,
            enabled = viewState.inputsEnabled,
        )
        Spacer(modifier = Modifier.height(contentPadding.calculateBottomPadding()))
    }
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean,
) {
    BandMeetsTextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.email),
        errorMessage = errorMessage,
        enabled = enabled,
    )
}

@Composable
fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean,
) {
    BandMeetsTextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.password),
        errorMessage = errorMessage,
        visualTransformation = PasswordVisualTransformation(
            '-',
        ),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
    )
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    BandMeetsButtonPrimary(
        text = stringResource(R.string.log_in),
        onClick = onClick,
        enabled = enabled,
    )
}

@Composable
private fun AppLogo(
    modifier: Modifier = Modifier
) {
    BandMeetsTheme {
        Image(
            painterResource(id = R.drawable.ic_trumpet),
            contentDescription = stringResource(R.string.app_logo_content_description),
            modifier = modifier
                .fillMaxWidth(.7f),
            colorFilter = ColorFilter.tint(
                color = Purple200,
            ),
        )
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
fun PreviewAppLogo(){
    AppLogo()
}
@Composable
private fun SignUpButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    BandMeetsButtonPrimary(
        text = stringResource(R.string.sign_up),
        onClick = onClick,
        enabled = enabled,
    )
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    group = "enabled",
)
@Composable
fun LoginPreview() {
    LoginContent(
        viewState = LoginViewState.Initial,
        onEmailChanged = {},
        onPasswordChanged = {},
        onLoginClicked = { }) {

    }
}