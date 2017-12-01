package com.satman.satya.unittesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by satya on 01-12-2017.
 */
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity =null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SecondActivity.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();

    }

    @Test
    public void testLaunchOfSecondActivityOnButtonClick(){

        assertNotNull(mActivity.findViewById(R.id.btnGoTo));

        onView(withId(R.id.btnGoTo)).perform(click());

        Activity secondActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);

        assertNotNull(secondActivity);

        secondActivity.finish();

    }

    @After
    public void tearDown() throws Exception {

        mActivity= null;
    }

}



























