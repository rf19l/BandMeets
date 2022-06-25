package com.rf.bandmeets.login.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import com.rf.bandmeets.R
import com.rf.bandmeets.core.ui.UiTextUtils
import com.rf.bandmeets.core.ui.components.BandMeetsButtonPrimary
import com.rf.bandmeets.core.ui.components.BandMeetsSpinner
import com.rf.bandmeets.core.ui.components.BandMeetsTextField
import com.rf.bandmeets.core.ui.getString
import com.rf.bandmeets.core.ui.theme.BandMeetsTheme
import com.rf.bandmeets.core.ui.theme.Purple200
import com.rf.bandmeets.login.domain.model.Credentials
import com.rf.bandmeets.login.domain.model.Email
import com.rf.bandmeets.login.domain.model.Password


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
        Box(
            modifier = Modifier
                .padding(
                start = 10.dp,
                end = 10.dp
            )
            ,
        ) {
            LoginInputColumn(
                viewState = viewState,
                onEmailChanged = onEmailChanged,
                onPasswordChanged = onPasswordChanged,
                onLoginClicked = onLoginClicked,
                onSignUpClicked = onSignUpClicked,
            )
            if (viewState is LoginViewState.Submitting) {
                val manager = LocalFocusManager.current
                manager.clearFocus(true)
                BandMeetsSpinner(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                        .fillMaxSize(.5f)
                //TODO fix alignment
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
                ?.emailInputErrorMessage
                ?.getString(),
            //?.getString(this.context),
            enabled = viewState.inputsEnabled,
        )
        Spacer(modifier = Modifier.height(12.dp))

        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LoginViewState.Active)
                ?.passwordInputErrorMessage?.getString(),
            enabled = viewState.inputsEnabled,
            onLoginClicked = onLoginClicked
        )
        if (viewState is LoginViewState.SubmissionError) {
            Text(
                text = viewState.errorMessage.getString(),
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
    val localFocus = LocalFocusManager.current
    BandMeetsTextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.email),
        errorMessage = errorMessage,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext ={
                localFocus.moveFocus(FocusDirection.Next)
            }
        )
    )
}

@Composable
fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean,
    onLoginClicked: () -> Unit
) {
    BandMeetsTextField(
        text = text,
        onTextChanged = onTextChanged,
        labelText = stringResource(R.string.password),
        errorMessage = errorMessage,
        visualTransformation = PasswordVisualTransformation(
            mask ='*',
        ),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go
        ),
        keyboardActions = KeyboardActions(
            onGo = {
                onLoginClicked()
            }
        )

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
fun PreviewAppLogo() {
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

class LoginViewStateProvider : PreviewParameterProvider<LoginViewState> {

    override val values: Sequence<LoginViewState>
        get() {
            val activeCredentials = Credentials(
                Email("testy@mctestface.com"),
                Password("Hunter2"),
            )

            return sequenceOf(
                LoginViewState.Initial,
                LoginViewState.Active(activeCredentials),
                LoginViewState.Submitting(activeCredentials),
                LoginViewState.SubmissionError(
                    credentials = activeCredentials,
                    errorMessage = UiTextUtils.StringText("Something went wrong."),
                ),
                LoginViewState.Active(
                    credentials = activeCredentials,
                    emailInputErrorMessage = UiTextUtils.StringText("Please enter an email."),
                    passwordInputErrorMessage = UiTextUtils.StringText("Please enter a password"),
                ),
            )
        }
}