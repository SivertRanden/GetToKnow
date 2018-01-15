package oblig1.dat153.gettoknow.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.utility.ImageAdapter;

public class PictureGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_gallery);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new ImageAdapter(this));
    }
}
