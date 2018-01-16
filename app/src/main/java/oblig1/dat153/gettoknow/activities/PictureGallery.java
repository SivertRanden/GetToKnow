package oblig1.dat153.gettoknow.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.utility.ImageAdapter;

public class PictureGallery extends AppCompatActivity {

    private PersonCollection people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_gallery);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        people = new PersonCollection(this);

        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("Test onclick image", "" + people.getPeople().get(position));
                Toast.makeText(getApplicationContext(), "" + people.getPeople().get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
