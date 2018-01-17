package oblig1.dat153.gettoknow.utility;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;

/**
 * Created by SivertRanden on 15.01.2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private PersonCollection people;
    private ArrayList<Integer> images;

    public ImageAdapter(Context context){
        this.context = context;
        images = new ArrayList<Integer>();
        people = new PersonCollection(context);

        for(Person p : people.getPeople()){
            //Because the xml file only contains filename for image, we need to get the id of the actual drawable file
            //and use that to get the actual image and add to the images arraylist
            images.add(context.getResources().getIdentifier(p.getPictureFileName(), "drawable", context.getPackageName()));
        }
    }

    public ArrayList<Integer> getImages(){
        return images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * This gets the view of the actual image so that we can use this in gridview and imageview
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
        return imageView;
    }
}
