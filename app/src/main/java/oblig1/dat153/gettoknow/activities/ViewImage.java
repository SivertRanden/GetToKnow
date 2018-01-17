package oblig1.dat153.gettoknow.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.utility.ImageAdapter;

public class ViewImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i = getIntent();

        //ListNames sends position in the arraylist of the person you clicked, use this to show correct image
        int pos = i.getExtras().getInt("pos");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(adapter.getImages().get(pos));
    }
}
