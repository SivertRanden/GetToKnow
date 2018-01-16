package oblig1.dat153.gettoknow.activities;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


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

        final ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>
                (this, android.R.layout.simple_list_item_1, people.getPeople());
        listView.setAdapter(arrayAdapter);

        //Adding onclick listener to all elements in the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ViewImage.class);
                i.putExtra("pos", position);
                startActivity(i);
            }
        });
    }
}
