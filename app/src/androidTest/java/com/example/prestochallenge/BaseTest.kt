package com.example.prestochallenge

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until
import android.util.Log
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before

open class BaseTest {
    protected lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        killApp()
        clearAppData()
        launchApp()
    }

    fun killApp() = executeShellCommand("am force-stop " + appPackage)

    fun executeShellCommand(command: String) {
        val stdOut = uiDevice.executeShellCommand(command)
        Log.i("Test", command + ": " + stdOut)
    }

    fun clearAppData() = executeShellCommand("pm clear " + appPackage)

    protected fun launchApp() {
        uiDevice.pressHome()

        val launcherPackage = uiDevice.launcherPackageName
        Assert.assertThat(launcherPackage, CoreMatchers.notNullValue())
        uiDevice.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            globalTimeout
        )

        Log.i("Test", "launching the app")

        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager
            .getLaunchIntentForPackage(appPackage)
        Assert.assertThat(
            "Application is not installed or disabled (Package not found or cannot be launched)",
            intent,
            CoreMatchers.notNullValue()
        )

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)

        uiDevice.wait(
            Until.hasObject(By.pkg(appPackage).depth(0)),
            globalTimeout
        )
        }
}