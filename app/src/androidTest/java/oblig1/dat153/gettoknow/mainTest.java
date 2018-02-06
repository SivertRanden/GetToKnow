package oblig1.dat153.gettoknow;

import android.app.Activity;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.Iterator;

import oblig1.dat153.gettoknow.activities.MainActivity;
import oblig1.dat153.gettoknow.model.Person;
import oblig1.dat153.gettoknow.model.PersonCollection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by AndroidMaker on 05-Feb-18.
 */

@RunWith(AndroidJUnit4.class)
public class mainTest {

    @Rule
    public ActivityTestRule<MainActivity> addPeopleTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //Adding and removing a person to ensure the list is not empty
    @Test
    public void activitySwap() {
        PersonCollection.people.add(new Person("Test", "test", ""));
        onView(withId(R.id.button1)).perform(click());
        assertEquals(getActivityInstance().getLocalClassName(), "activities.ListNames");
        pressBack();
        onView(withId(R.id.button2)).perform(click());
        assertEquals(getActivityInstance().getLocalClassName(), "activities.PictureGallery");
        pressBack();
        onView(withId(R.id.button3)).perform(click());
        assertEquals(getActivityInstance().getLocalClassName(), "activities.LearningMode");
        pressBack();
        onView(withId(R.id.button4)).perform(click());
        assertEquals(getActivityInstance().getLocalClassName(), "activities.AddPeople");
        PersonCollection.people.remove(PersonCollection.people.size()-1);
    }

    @Test
    public void testStartQuizWithEmptyList(){
        PersonCollection.people.clear();
        onView(withId(R.id.button3)).perform(click());
        assertEquals(getActivityInstance().getLocalClassName(), "activities.MainActivity");
    }

    private Activity getActivityInstance(){
        final Activity[] currentActivity = {null};

        getInstrumentation().runOnMainSync(new Runnable(){
            public void run(){
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }


}
