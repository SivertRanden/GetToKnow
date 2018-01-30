package oblig1.dat153.gettoknow.model;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;

/**
 * Created by siver on 15.01.2018.
 */

public class PersonCollection extends AppCompatActivity {

    public static ArrayList<Person> people = init();

    public static ArrayList<Person> init(){
        people = new ArrayList<Person>();
//        people.add(new Person("Sivert", "Randen", "android.resource://oblig1.dat153.gettoknow/drawable/image2"));
//        people.add(new Person("Darri", "Nökkvason", "android.resource://oblig1.dat153.gettoknow/drawable/image1"));
//        people.add(new Person("Bentein", "Thomassen", "android.resource://oblig1.dat153.gettoknow/drawable/bentein"));
//        people.add(new Person("Volker", "Stoltz", "android.resource://oblig1.dat153.gettoknow/drawable/image3"));
        return people;
    }

    public ArrayList<Person> getPeople(){
        return people;
    }
    public Person getPerson(String image){
        Person person = null;
        for(Person p : people){
            if(p.getimagePath().equals(image)){
                person = p;
            }
        }
        return person;
    }

    /**
     * Reads the xml file and puts the people into the arraylist
     */
//    private ArrayList<Person> readPeopleFromXml() throws XmlPullParserException, IOException {
//        XmlResourceParser peopleXml = context.getResources().getXml(R.xml.people);
//        ArrayList<Person> listFromXml = new ArrayList<Person>();
//
//        int eventType = -1;
//        while (eventType != peopleXml.END_DOCUMENT) {
//            if (eventType == XmlResourceParser.START_TAG) {
//                String stringName = peopleXml.getName();
//                if (stringName.equals("person")) {
//                    String firstName = peopleXml.getAttributeValue(null, "firstName");
//                    String lastName = peopleXml.getAttributeValue(null, "lastName");
//                    String picture = peopleXml.getAttributeValue(null, "picture");
//                    listFromXml.add(new Person(firstName, lastName, picture));
//                }
//            }
//            eventType = peopleXml.next();
//        }
//        return listFromXml;
//    }
}
