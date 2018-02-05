package oblig1.dat153.gettoknow;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import oblig1.dat153.gettoknow.activities.LearningMode;
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

public class quizTest {

    @Rule
    public ActivityTestRule<LearningMode> learningModeTestRule = new ActivityTestRule<LearningMode>(LearningMode.class);

    @Test
    public void testCorrectGuess(){
        int scoreBefore = learningModeTestRule.getActivity().getScore();
        String correctName = learningModeTestRule.getActivity().getCurrentPerson().getFirstName();
        onView(withId(R.id.guessedName)).perform(typeText(correctName));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.guessButton)).perform(click());
        assertEquals(++scoreBefore, learningModeTestRule.getActivity().getScore());
    }

    @Test
    public void testEntireCorrectQuiz(){
        int maxPossibleScore = PersonCollection.people.size();
        String correctName;
        for(int i = 0; i < maxPossibleScore; i++){
            correctName = learningModeTestRule.getActivity().getCurrentPerson().getFirstName();
            onView(withId(R.id.guessedName)).perform(typeText(correctName));
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.guessButton)).perform(click());
        }
        assertEquals(maxPossibleScore, learningModeTestRule.getActivity().getScore());
    }

    @Test
    public void testEntireQuizWithWrongGuesses(){
        int maxPossibleScore = PersonCollection.people.size();
        String correctName;
        for(int i = 0; i < maxPossibleScore; i++){
            correctName = learningModeTestRule.getActivity().getCurrentPerson().getFirstName();
            if(i%2 == 0) {
                onView(withId(R.id.guessedName)).perform(typeText(correctName));
            }else{
                onView(withId(R.id.guessedName)).perform(typeText("Wrong"));
            }
            Espresso.closeSoftKeyboard();
            onView(withId(R.id.guessButton)).perform(click());
        }
        assertEquals(maxPossibleScore/2, learningModeTestRule.getActivity().getScore());
    }

    @Test
    public void testQuizValidation() {
        //Test with wrong input
        int scoreBefore = learningModeTestRule.getActivity().getScore();
        String correctName = learningModeTestRule.getActivity().getCurrentPerson().getFirstName();
        onView(withId(R.id.guessedName)).perform(typeText(correctName + 9));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.guessButton)).perform(click());
        assertEquals(scoreBefore, learningModeTestRule.getActivity().getScore());

        //Retype the name and check if correct
        onView(withId(R.id.guessedName)).perform(clearText());
        onView(withId(R.id.guessedName)).perform(typeText(correctName));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.guessButton)).perform(click());
        assertEquals(scoreBefore+1, learningModeTestRule.getActivity().getScore());
    }

}
