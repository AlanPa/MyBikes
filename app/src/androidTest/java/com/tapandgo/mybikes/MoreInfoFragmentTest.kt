package com.tapandgo.mybikes


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MoreInfoFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun moreInfoFragmentTest() {
        val textView = onView(
            allOf(
                withId(R.id.station_name_field), withText("111-DIDEROT"),
                withParent(withParent(withId(R.id.nav_host_fragment_activity_main))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("111-DIDEROT")))

        val textView2 = onView(
            allOf(
                withId(R.id.more_info_address_field),
                withText("Avenue de la Vendée - Face à l'Espace Diderot - REZÉ"),
                withParent(withParent(withId(R.id.nav_host_fragment_activity_main))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Avenue de la Vendée - Face à l'Espace Diderot - REZÉ")))
    }
}
