package oblig1.dat153.gettoknow.activities;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oblig1.dat153.gettoknow.model.PersonCollection;
import oblig1.dat153.gettoknow.R;
import oblig1.dat153.gettoknow.model.Person;

public class ListNames extends AppCompatActivity {

    private PersonCollection people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_names);

        //Getting the listview from layout
        final ListView listView = (ListView) findViewById(R.id.listView);

        people = new PersonCollection(this);
        ArrayList<String> names = new ArrayList<String>();
        for(Person p : people.getPeople()){
            names.add(p.getFirstName() + " " + p.getLastName());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(arrayAdapter);
    }

    //Gets all people from xml and returns a list of people
    private List<String> getPeople(XmlResourceParser people) throws XmlPullParserException, IOException {
        List<String> peopleList = new ArrayList<String>();

        int eventType = -1;
        while(eventType != people.END_DOCUMENT){
            if(eventType == XmlResourceParser.START_TAG){
                String stringName = people.getName();
                if(stringName.equals("person")){
                    String name = people.getAttributeValue(null, "firstName") + " " + people.getAttributeValue(null, "lastName");
                    peopleList.add(name);
                }
            }
            eventType = people.next();
        }
        return peopleList;
    }
}
