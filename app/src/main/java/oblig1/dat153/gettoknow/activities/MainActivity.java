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
}
