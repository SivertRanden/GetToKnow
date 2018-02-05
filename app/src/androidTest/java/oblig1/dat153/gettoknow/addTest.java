package oblig1.dat153.gettoknow;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import oblig1.dat153.gettoknow.activities.AddPeople;
import oblig1.dat153.gettoknow.model.PersonCollection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Created by AndroidMaker on 05-Feb-18.
 */

@RunWith(AndroidJUnit4.class)
public class addTest {

    @Rule
    public ActivityTestRule<AddPeople> addPeopleTestRule = new ActivityTestRule<AddPeople>(AddPeople.class);

    @Test
    public void listIncrease() {
        int sizeBefore = PersonCollection.people.size();
        onView(withId(R.id.firstName)).perform(typeText("Test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.lastName)).perform(typeText("Testson"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.addPerson)).perform(click());
        assertEquals(sizeBefore+1, PersonCollection.people.size());
    }

    @Test
    public void validationTest() {
        int sizeBefore = PersonCollection.people.size();

        //Validation on firstname
        onView(withId(R.id.firstName)).perform(typeText("Test9"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.lastName)).perform(typeText("Testson"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.addPerson)).perform(click());
        assertEquals(sizeBefore, PersonCollection.people.size());

        //Validation on lastname
        onView(withId(R.id.firstName)).perform(clearText());
        onView(withId(R.id.firstName)).perform(typeText("Test"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.lastName)).perform(clearText());
        onView(withId(R.id.lastName)).perform(typeText("Testson9"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.addPerson)).perform(click());
        assertEquals(sizeBefore, PersonCollection.people.size());

        //Check if person is added after
        onView(withId(R.id.lastName)).perform(clearText());
        onView(withId(R.id.lastName)).perform(typeText("Testson"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.addPerson)).perform(click());
        assertEquals(sizeBefore+1, PersonCollection.people.size());
    }

}
