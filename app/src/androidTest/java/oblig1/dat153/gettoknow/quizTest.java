package oblig1.dat153.gettoknow;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import oblig1.dat153.gettoknow.activities.LearningMode;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Created by AndroidMaker on 05-Feb-18.
 */

public class quizTest {

    @Rule
    public ActivityTestRule<LearningMode> addPeopleTestRule = new ActivityTestRule<LearningMode>(LearningMode.class);



}
