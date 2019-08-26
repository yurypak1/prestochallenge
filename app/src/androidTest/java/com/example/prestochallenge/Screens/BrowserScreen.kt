package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.baseUrl
import com.example.prestochallenge.globalTimeout
import org.junit.Assert

class BrowserScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val urlBar = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))
    //pressEnter()

    init {
        Assert.assertTrue("Unable to launch browser", urlBar.waitForExists(globalTimeout))
    }

        fun clearTextView() {
            urlBar.clearTextField()
        }

        fun setText(text: String) {
            urlBar.setText(baseUrl)
        }
}