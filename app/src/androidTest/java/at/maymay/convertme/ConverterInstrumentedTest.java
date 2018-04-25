package at.maymay.convertme;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.maymay.convertme.application.core.Converter;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ConverterInstrumentedTest {
    @Rule
    public ActivityTestRule<Converter> myActivityRule = new ActivityTestRule<>(Converter.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("at.maymay.convertme", appContext.getPackageName());
    }

    @Test
    public void test_add_new_conversion() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_weight)).perform(click());
        onView(withId(R.id.ptxt_input)).check(matches(isDisplayed()));
        onView(withId(R.id.ptxt_result)).check(matches(isDisplayed()));
        onView(withId(R.id.input_unit)).check(matches(isDisplayed()));
        onView(withId(R.id.output_unit)).check(matches(isDisplayed()));
    }

    @Test
    public void test_inputField() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());
        onView(withId(R.id.ptxt_input)).perform(typeText("567"));
        onView(withText("567")).check(matches(isDisplayed()));
    }

    @Test
    public void test_btn_convert() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());
        onView(withId(R.id.ptxt_input)).perform(typeText("10"));
        onView(withId(R.id.ptxt_result)).check(matches(withText("10.0")));
    }
}
