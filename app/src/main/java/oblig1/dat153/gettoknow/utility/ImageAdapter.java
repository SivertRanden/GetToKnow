package oblig1.dat153.gettoknow.utility;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
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

    public ImageAdapter(Context context, ArrayList<Person> people){
        this.context = context;
    }

    @Override
    public int getCount() {
        return PersonCollection.people.size();
    }

    @Override
    public Object getItem(int position) {
        return PersonCollection.people.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * This gets the view of the actual image so that we can use this in gridview and imageview...
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        Bitmap bitmap = PersonCollection.people.get(position).getBitmap();
        if(bitmap == null) {
            try {
                bitmap = Util.decodeBitmap(context, PersonCollection.people.get(position).getimagePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
        return imageView;
    }
}
