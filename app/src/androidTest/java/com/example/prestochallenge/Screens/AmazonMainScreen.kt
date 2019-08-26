package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.globalTimeout
import org.junit.Assert

class AmazonMainScreen {

    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    //val searchField = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/nav-search-keywords"))
    val searchAmazon = uiDevice.findObject(UiSelector().className("android.widget.EditText"))
    val searchButton = uiDevice.findObject(UiSelector().className("android.widget.Button").instance(1))
    val resultContainer = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/bottom_sheet_snackbar_container"))

            init {
        Assert.assertTrue("Amazon was not opened", resultContainer.waitForExists(globalTimeout))
    }

    fun clickOnPage(){
        resultContainer.clickTopLeft()
    }

    fun clearSearch() {
        searchAmazon.clearTextField()
    }

    fun inputText(text: String) {
        searchAmazon.setText(text)
    }
    fun tapSearchButton() {
        searchButton.clickAndWaitForNewWindow()
        //uiDevice.pressEnter()
    }
}