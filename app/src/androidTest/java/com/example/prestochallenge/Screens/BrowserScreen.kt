package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.globalTimeout
import org.junit.Assert

class BrowserScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val searchGoogle = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/search_box_text"))
    val termsAccept = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/terms_accept"))
    val rejectSignIn = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/negative_button"))

    init {
        Assert.assertTrue("Unable to launch browser", termsAccept.waitForExists(globalTimeout))
    }

    fun termsAcceptClick(){
        termsAccept.clickAndWaitForNewWindow()
    }

    fun rejectSignInClick(){
        rejectSignIn.clickAndWaitForNewWindow()
    }

    fun clearTextView() {
        searchGoogle.clearTextField()
    }

    fun setText(text: String) {
        searchGoogle.setText(text)
    }

    fun enter() {
        uiDevice.pressEnter()
    }
}