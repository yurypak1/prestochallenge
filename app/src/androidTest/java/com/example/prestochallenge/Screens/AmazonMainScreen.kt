package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.searchInput

class AmazonMainScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val search = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))
    fun clearTextView() {
        search.clearTextField()
    }

    fun setText(text: String) {
        search.setText(searchInput)
    }

}