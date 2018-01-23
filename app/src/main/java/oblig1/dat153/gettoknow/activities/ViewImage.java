package oblig1.dat153.gettoknow.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.utility.ImageAdapter;
import oblig1.dat153.gettoknow.utility.Util;

public class ViewImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        Intent i = getIntent();

        //ListNames sends position in the arraylist of the person you clicked, use this to show correct image
        int pos = i.getExtras().getInt("pos");
        ImageAdapter adapter = new ImageAdapter(this, PersonCollection.people);

        ImageView imageView = findViewById(R.id.imageView);

        Bitmap bitmap = PersonCollection.people.get(pos).getBitmap();
        if(bitmap == null) {
            try {
                bitmap = Util.decodeBitmap(this, PersonCollection.people.get(pos).getimagePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        imageView.setImageBitmap(bitmap);
    }
}
