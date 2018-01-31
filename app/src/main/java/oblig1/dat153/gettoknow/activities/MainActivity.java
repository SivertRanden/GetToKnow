package oblig1.dat153.gettoknow.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import oblig1.dat153.gettoknow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = this.getSharedPreferences("userprefs", MODE_PRIVATE);
        if(!prefs.contains("firstname")){
            startActivity(new Intent(this, UserPreferences.class));
        }
    }

    //Starter ListNames
    public void button1Action(View view){
        startActivity(new Intent(this, ListNames.class));
    }

    //Starter PictureGallery
    public void button2Action(View view){
        startActivity(new Intent(this, PictureGallery.class));
    }

    //Starter LearningMode
    public void button3Action(View view){
        startActivity(new Intent(this, LearningMode.class));
    }

    //Starter AddPeople
    public void button4Action(View view) {
        startActivity(new Intent ( this, AddPeople.class));
    }

    //Starter Profile
    public void profileButtonAction(View view){
        startActivity(new Intent(this, Profile.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_activity_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_profile){
            startActivity(new Intent(this, Profile.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
