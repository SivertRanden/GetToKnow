package oblig1.dat153.gettoknow;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by siver on 15.01.2018.
 */

public class PersonCollection extends AppCompatActivity {
    ArrayList<Person> people;

    public PersonCollection(){
        people = new ArrayList();
        try{
            people = readPeopleFromXml();
        }catch(Exception e){
            Log.e("xml", "Could not import people from xml", e);

        }
    }

    private ArrayList<Person> readPeopleFromXml() throws XmlPullParserException, IOException {
        XmlResourceParser peopleXml = getResources().getXml(R.xml.people);
        ArrayList<Person> listFromXml = new ArrayList<>();

        int eventType = -1;
        while(eventType != peopleXml.END_DOCUMENT){
            if(eventType == XmlResourceParser.START_TAG){
                String stringName = peopleXml.getName();
                if(stringName.equals("person")){
                    String firstName = peopleXml.getAttributeValue(null, "firstName");
                    String lastName = peopleXml.getAttributeValue(null, "lastName");
                    String picture = peopleXml.getAttributeValue(null, "picture");
                    listFromXml.add(new Person(firstName, lastName, picture));
                }
            }
            eventType = peopleXml.next();
        }
        return listFromXml;
    }
}
