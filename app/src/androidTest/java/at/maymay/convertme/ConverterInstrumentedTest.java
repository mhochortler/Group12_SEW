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
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
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
        onView(withId(R.id.edittext_conversion_left)).check(matches(isDisplayed()));
        onView(withId(R.id.edittext_conversion_right)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_conversion_left)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_conversion_right)).check(matches(isDisplayed()));
    }

    @Test
    public void test_inputField_left() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("567"));
        onView(withText("567")).check(matches(isDisplayed()));
    }

    @Test
    public void test_inputField_right() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());
        onView(withId(R.id.edittext_conversion_right)).perform(typeText("567"));
        onView(withText("567")).check(matches(isDisplayed()));
    }

    @Test
    public void test_implicit_conversion_lenght() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("10.93613")));
    }

    @Test
    public void test_implicit_conversion_temperature() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_temperature)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("50")));
    }

    @Test
    public void test_implicit_conversion_weight() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_weight)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("22.04624")));
    }

    @Test
    public void test_implicit_conversion_speed() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_speed)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("6.21371")));
    }

    @Test
    public void test_implicit_conversion_volume() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_volume)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("2.641722")));
    }

    @Test
    public void test_implicit_conversion_currency() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_currency)).perform(click());
        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText(containsString("."))));
    }

    @Test
    public void test_spinner_conversion_right() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_conversion_right)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("ft"))).perform(click());
        onView(withId(R.id.spinner_conversion_right)).check(matches(withSpinnerText(containsString("ft"))));
    }

    @Test
    public void test_spinner_conversion_left() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_conversion_left)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("mile"))).perform(click());
        onView(withId(R.id.spinner_conversion_left)).check(matches(withSpinnerText(containsString("mile"))));
    }

    @Test
    public void test_spinner_profile_right() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_profil_right)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Austria"))).perform(click());
        onView(withId(R.id.spinner_profil_right)).check(matches(withSpinnerText(containsString("Austria"))));
    }

    @Test
    public void test_spinner_profile_left() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_profil_left)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("United States"))).perform(click());
        onView(withId(R.id.spinner_profil_left)).check(matches(withSpinnerText(containsString("United States"))));
    }

    @Test
    public void test_change_profile_right() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_profil_right)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Austria"))).perform(click());

        onView(withId(R.id.spinner_conversion_right)).check(matches(withSpinnerText(containsString("m"))));
    }

    @Test
    public void test_change_profile_left() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.spinner_profil_left)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("United States"))).perform(click());

        onView(withId(R.id.spinner_conversion_left)).check(matches(withSpinnerText(containsString("yd"))));
    }

    @Test
    public void test_change_unit_left() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("10.93613")));

        onView(withId(R.id.spinner_conversion_left)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("ft"))).perform(click());

        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("3.333333")));
    }

    @Test
    public void test_change_unit_right() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.edittext_conversion_left)).perform(typeText("10"));
        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("10.93613")));

        onView(withId(R.id.spinner_conversion_right)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("ft"))).perform(click());

        onView(withId(R.id.edittext_conversion_right)).check(matches(withText("32.8084")));
    }

    @Test
    public void test_delete_mode() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.fab_delete)).perform(click());
        onView(withId(R.id.btn_delete)).perform(click());

        onView(withId(R.id.edittext_conversion_left)).check(doesNotExist());
        onView(withId(R.id.edittext_conversion_right)).check(doesNotExist());
        onView(withId(R.id.spinner_conversion_left)).check(doesNotExist());
        onView(withId(R.id.spinner_conversion_right)).check(doesNotExist());
    }

    @Test
    public void test_delete_mode_toogle() throws Exception {
        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.fab_delete)).perform(click());
        onView(withId(R.id.btn_delete)).perform(click());
        onView(withId(R.id.fab_delete)).perform(click());

        onView(withId(R.id.btn_fabtoolbar)).perform(click());
        onView(withId(R.id.btn_length)).perform(click());

        onView(withId(R.id.fab_delete)).perform(click());
        onView(withId(R.id.fab_delete)).perform(click());

        onView(withId(R.id.edittext_conversion_left)).check(matches(isDisplayed()));
        onView(withId(R.id.edittext_conversion_right)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_conversion_left)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_conversion_right)).check(matches(isDisplayed()));
    }

}
