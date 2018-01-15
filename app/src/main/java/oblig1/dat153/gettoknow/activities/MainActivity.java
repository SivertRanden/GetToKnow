package oblig1.dat153.gettoknow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import oblig1.dat153.gettoknow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1Action(View view){
        Log.d("1","Button 1 clicked");
        startActivity(new Intent(this, ListNames.class));
    }

    public void button2Action(View view){
        Log.d("2", "Button 2 clicked");
        startActivity(new Intent(this, PictureGallery.class));
    }

    public void button3Action(View view){
        Log.d("3", "Button 3 clicked");
        startActivity(new Intent(this, LearningMode.class));
    }
}
