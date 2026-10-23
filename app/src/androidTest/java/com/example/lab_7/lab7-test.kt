package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

        @Test
        fun home_to_drivers_screen() {
            // verify home screen to driver screen
            composeTestRule
                .onNodeWithTag("driversButton")
                .performClick()

            // verify driver's screen
            composeTestRule
                .onNodeWithText("FormulaZero Drivers")
                .assertExists()

            // verify that we can add at least one driver, and if that driver is displayed
            composeTestRule
                .onNodeWithTag("driverInput")
                .performTextInput("John FormulaZero")

            composeTestRule
                .onNodeWithTag("addDriverButton")
                .performClick()

            composeTestRule
                .onNodeWithText("John FormulaZero")
                .assertExists()

            // verify that you can clear the drivers from the list
            composeTestRule
                .onNodeWithTag("clearDrivers")
                .performClick()

            composeTestRule
                .onNodeWithText("John FormulaZero")
                .assertDoesNotExist()

            // verify that the back button takes you back to the home screen
            composeTestRule
                .onNodeWithTag("homeButton")
                .performClick()

            composeTestRule
                .onNodeWithText("FormulaZero Home")
                .assertExists()
        }
    }
