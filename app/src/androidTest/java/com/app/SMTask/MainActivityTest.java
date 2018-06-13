package com.app.SMTask;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.app.extrasTest.TestUtils.withRecyclerView;

/*
 * Created by Yash on 13/6/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest
{
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDataonRcyclv()
    {
        checkRcyclvItemContentTitle();
        clickOnRcyclvItem();

    }

    public void checkRcyclvItemContentTitle()
    {
        onView(withId(R.id.dataRcylv)).perform(RecyclerViewActions.scrollToPosition(3));
        onView(withRecyclerView(R.id.dataRcylv).atPositionOnView(3, R.id.titleTxt)).check(matches(withText(R.string.testContentTitle)));
    }

    public void clickOnRcyclvItem()
    {
        onView(withId(R.id.dataRcylv)).perform(RecyclerViewActions.actionOnItemAtPosition(4,click()));
    }
}
