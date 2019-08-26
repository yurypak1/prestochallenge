package com.example.prestochallenge

import android.support.test.runner.AndroidJUnit4
import com.example.prestochallenge.Screens.AmazonMainScreen
import com.example.prestochallenge.Screens.BrowserScreen
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class AcceptanceTests: BaseTest() {

    @Test
    fun searchHeadphones() {
        val browserScreen = BrowserScreen()
        browserScreen.termsAcceptClick()
        browserScreen.rejectSignInClick()
        browserScreen.clearTextView()
        browserScreen.setText(baseUrl)
        browserScreen.enter()
        val amazonMainScreen = AmazonMainScreen()
        amazonMainScreen.clickOnPage()
        amazonMainScreen.inputText(searchInput)
        amazonMainScreen.tapSearchButton()
//        val amazonResultsScreen = AmazonResultsScreen()
//        amazonResultsScreen.resultItemAddToBasket("Best Seller  status-badge")
    }

}