package oblig1.dat153.gettoknow.activities;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import oblig1.dat153.gettoknow.R;

public class Profile extends AppCompatActivity {

    private String imagePath = "";
    private final String FILENAME = "profile.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences prefs = this.getSharedPreferences("userprefs", MODE_PRIVATE);
        String firstname = prefs.getString("firstname", "");
        String lastname = prefs.getString("lastname", "");
        TextView profileName = findViewById(R.id.profileTextView);
        profileName.setText(firstname + " " + lastname);


        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        imagePath = cw.getDir("imageDir", Context.MODE_PRIVATE).getAbsolutePath();
        loadImageFromStorage();
    }

    public void imageButtonAction(View view){
        Intent pickFromGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickFromGallery.setType("image/*");
        startActivityForResult(pickFromGallery, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode == RESULT_OK){
            try{
                Uri imageUri = intent.getData();
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                saveToInternalStorage(selectedImage);
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

    private void saveToInternalStorage(Bitmap image){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        File path = new File(directory, FILENAME);

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(path);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        imagePath = directory.getAbsolutePath();
        loadImageFromStorage();
    }

    private void loadImageFromStorage(){
        Button btn = findViewById(R.id.profilePictureButton);
        try{
            File f = new File(imagePath, FILENAME);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView imageView = findViewById(R.id.profilePictureView);
            imageView.setImageBitmap(b);
            btn.setText(R.string.change_picture_button_text);
        }catch(FileNotFoundException e){
            e.printStackTrace();
            btn.setText(R.string.add_picture_button_text);
        }
    }
}
