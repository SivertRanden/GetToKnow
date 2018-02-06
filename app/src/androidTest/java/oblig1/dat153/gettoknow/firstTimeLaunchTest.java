package oblig1.dat153.gettoknow;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import oblig1.dat153.gettoknow.activities.MainActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by siver on 06.02.2018.
 */

public class firstTimeLaunchTest {

    @Rule
    public ActivityTestRule<MainActivity> addPeopleTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //Requires clean install
    @Test
    public void testFirstTimeStartPreferences(){
        assertEquals(addPeopleTestRule.getActivity().getLocalClassName(), "activities.UserPreferences");
    }
}
