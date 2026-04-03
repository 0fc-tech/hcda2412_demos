package com.example.mod5test

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class PasswordFieldShowHideTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun show() {
        //set le composant à tester
        composeTestRule.setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                PasswordField()
            }
        }
        composeTestRule
            .onNodeWithTag(TEST_TAG_TEXTFIELD_PWD)
            .performTextInput("Hello World")
        composeTestRule
            .onNodeWithContentDescription("Montrer mot de passe")
            .performClick()
        composeTestRule
            .onNodeWithTag(TEST_TAG_TEXTFIELD_PWD)
            .assert(hasText("Hello World"))
        composeTestRule
            .onNodeWithContentDescription("Cacher mot de passe")
            .assertIsDisplayed()
    }
}
