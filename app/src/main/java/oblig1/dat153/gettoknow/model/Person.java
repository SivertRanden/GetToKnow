package oblig1.dat153.gettoknow.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;

/**
 * Created by siver on 15.01.2018.
 */

public class Person {
    private String firstName;
    private String lastName;
    private Uri imagePath;
    private Bitmap bitmap;

    public Person(String firstName, String lastName, String imagePath){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.imagePath = Uri.parse(imagePath);
    }

    public Person(String firstName, String lastName, Bitmap bitmap){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.bitmap = bitmap;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Uri getimagePath() {
        return imagePath;
    }

    public void setImagePath(Uri imagePath) {
        this.imagePath = imagePath;
    }

    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap(){
        return bitmap;
    }
}
