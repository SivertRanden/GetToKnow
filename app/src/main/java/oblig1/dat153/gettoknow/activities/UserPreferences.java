package oblig1.dat153.gettoknow.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import oblig1.dat153.gettoknow.R;

/**
 * Created by siver on 29.01.2018.
 */

public class UserPreferences extends android.preference.PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(android.R.id.content, new UserPreferencesFragment());
        transaction.commit();
    }

    public static class UserPreferencesFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            PreferenceManager manager = getPreferenceManager();
            manager.setSharedPreferencesName("userprefs");
            addPreferencesFromResource(R.xml.userprefs);
        }
    }
}
