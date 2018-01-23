package oblig1.dat153.gettoknow.activities;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;
import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.utility.ImageAdapter;
import oblig1.dat153.gettoknow.utility.Util;

public class LearningMode extends AppCompatActivity {

    private int score;
    private int guesses;
    private ImageAdapter adapter;
    private Person currentPerson;
    private ArrayList<Person> randomList;
    private Animation fadeIn;
    private Animation fadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_mode);
        score = 0;
        guesses = 0;
        randomList = PersonCollection.people;
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        Collections.shuffle(randomList);
        adapter = new ImageAdapter(this, randomList);
        setRandomImage();
    }

    public void guess(View view){
        EditText editText = findViewById(R.id.guessedName);
        String guessedName = editText.getText().toString().toLowerCase();
        String correctName = currentPerson.getFirstName().toLowerCase();
        if(guessedName.equals(correctName)){
            score++;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
        }
        guesses++;
        editText.setText("");
        if(guesses != 0 && guesses < randomList.size()){
            setRandomImage();
        }else{
            showFinishDialog();
        }
    }

    private void setRandomImage(){
        ImageView imageView = findViewById(R.id.learningModeImageView);
        currentPerson = randomList.get(guesses);
        Bitmap bitmap = currentPerson.getBitmap();
        try{
            bitmap = Util.decodeBitmap(this, PersonCollection.people.get(guesses).getimagePath());
        }catch(Exception e){
            e.printStackTrace();
        }
        if(guesses == 0){
            imageView.setImageBitmap(bitmap);
        }else {
            imageView.setAnimation(fadeOut);
            imageView.setImageBitmap(bitmap);
            imageView.setAnimation(fadeIn);
        }
    }

    public void showFinishDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your score: " + score + "/" + guesses);
        builder.setCancelable(true);
        builder.setPositiveButton(
                "OK!",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog scoreAlert = builder.create();
        scoreAlert.show();
    }
}
