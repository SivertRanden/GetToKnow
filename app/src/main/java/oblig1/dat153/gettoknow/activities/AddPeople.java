package oblig1.dat153.gettoknow.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;

public class AddPeople extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);
    }

    public void addImageButtonClicked(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setPositiveButton(
                "Camera",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePicture, 0);
                    }
                });
        builder.setNegativeButton(
                "Gallery",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        Intent pickFromGallery = new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(pickFromGallery, 1);
                    }
                });
        AlertDialog scoreAlert = builder.create();
        scoreAlert.show();
    }

    public void completeButtonClicked(View view){
        EditText firstNameField = findViewById(R.id.firstName);
        EditText lastNameField = findViewById(R.id.lastName);

        String firstname = firstNameField.getText().toString();
        String lastname = lastNameField.getText().toString();
        Person p = new Person(firstname, lastname, "image1");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent){
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                }
            break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                }
            break;
        }
    }
}
