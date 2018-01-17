package oblig1.dat153.gettoknow.activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;
import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.utility.ImageAdapter;

public class LearningMode extends AppCompatActivity {

    private int score;
    private int guesses;
    private Random randomGenerator;
    private ImageAdapter adapter;
    private PersonCollection people;
    String currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_mode);
        randomGenerator = new Random();
        adapter = new ImageAdapter(this);
        people = new PersonCollection(this);
        score = 0;
        guesses = 0;

        setRandomImage();

    }

    public void guess(View view){
        EditText editText = findViewById(R.id.guessedName);
        String guessedName = editText.getText().toString().toLowerCase();
        String correctName = people.getPerson(currentImage).getFirstName().toLowerCase();
        if(guessedName.equals(correctName)){
            score++;
            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG).show();
        }
        guesses++;
        editText.setText("");
        setRandomImage();
    }

    private void setRandomImage(){
        ImageView imageView = findViewById(R.id.learningModeImageView);
        int index = randomGenerator.nextInt(adapter.getImages().size());
        currentImage = people.getPeople().get(index).getPictureFileName();
        imageView.setImageResource(adapter.getImages().get(index));
    }
}
