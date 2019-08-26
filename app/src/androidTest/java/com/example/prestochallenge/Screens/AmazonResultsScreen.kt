package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.action.ViewActions
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.globalTimeout
import org.junit.Assert.assertTrue

class AmazonResultsScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val resultListUi = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/nav-search-keywords"))
    val resultItem = uiDevice.findObject(UiSelector().resourceId("com.example.admin.findrepo:id/repoTextView"))

    fun waitForResults() {
        resultItem.waitForExists(globalTimeout)
    }

    fun repoResultsClickAtPosition() {
        searchResultsList.atPosition(0).perform(ViewActions.click())
    }

    fun correctResultsRetrieved() {
        Assert.assertTrue(
            uiDevice.findObject(resultItem.selector.textContains(repoNameSubstring.toLowerCase())).waitForExists(
                globalTimeout
            )
        )
    }

    fun chromeOpened() {
        Assert.assertTrue(chrome.waitForExists(globalTimeout))

    }
}