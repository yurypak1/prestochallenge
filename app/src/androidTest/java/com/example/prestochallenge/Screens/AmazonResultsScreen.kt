package com.example.prestochallenge.Screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiScrollable
import android.support.test.uiautomator.UiSelector
import com.example.prestochallenge.globalTimeout
import org.junit.Assert.assertTrue

class AmazonResultsScreen {
    protected val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    val resultList = UiScrollable(UiSelector().resourceId("com.android.chrome:id/search"))
    val resultItem = uiDevice.findObject(UiSelector().className("android.widget.View"))



//    fun addItemToBasket(text: String){
//        var index = 0
//        val count = resultList.childCount
//    do {
//
//        resultItemAddToBasket(text)
//        UiDevice.pressBack()
//
//        index++
//    }
//    while (index < count)
//    }

    fun resultItemAddToBasket(text:String){
        resultList.setAsVerticalList().scrollTextIntoView(text)
        resultList.click()
    }

    fun scrollDown(swipes: Int) {
        resultList.setAsVerticalList().scrollForward(swipes)
    }

    fun waitForResults() {
        resultItem.waitForExists(globalTimeout)
    }

    fun repoResultsClickAtPosition() {
        //resultItem.atPosition(0).perform(ViewActions.click())
    }

}