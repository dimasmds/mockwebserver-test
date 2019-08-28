package com.riotfallen.mockwebservertest.ui.movie

import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.riotfallen.mockwebservertest.R
import com.riotfallen.mockwebservertest.utils.Constant
import com.riotfallen.mockwebservertest.utils.createResponse
import com.riotfallen.mockwebservertest.utils.isDisplayed
import com.riotfallen.mockwebservertest.utils.typeText
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieActivityTest {

    @Rule
    @JvmField
    var activityRule  = ActivityTestRule(MovieActivity::class.java)

    private lateinit var mockResponseSuccess: MockResponse
    private lateinit var mockResponseEmpty: MockResponse
    private lateinit var mockResponseError: MockResponse

    private val mockWebServer = MockWebServer()
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setup(){
        mockWebServer.start()
        Constant.baseUrl = mockWebServer.url("/").toString()

        mockResponseSuccess = context.createResponse(localResponsePath =  "response_success.json", responseCode = 200)
        mockResponseEmpty = context.createResponse(localResponsePath =  "response_empty.json", responseCode = 200)
        mockResponseError = context.createResponse(responseCode = 500)
    }

    @After
    fun done() {
        mockWebServer.shutdown()
    }

    @Test
    fun test_search_should_be_success() {
        mockWebServer.enqueue(mockResponseSuccess)
    }
}