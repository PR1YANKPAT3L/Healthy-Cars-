package net.theamusementpark.healthycar;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/*
 @author The Amusement Park
 @event CODE 2015
 @class DetailsActivity
 @description This activity contains all the details of the cars
 */
public class DetailsActivity extends Activity {

    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ReadJSON.displayDetails(ReadJSON.indexes);
        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Details: "+ ReadJSON.dMake + " </font>"));

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Year: " + ReadJSON.dModelYear,
                "Make: " + ReadJSON.dMake,
                "Model: " + ReadJSON.dModel,
                "Class: " + ReadJSON.dVehicleClass,
                "Engine Size: " + ReadJSON.dEngineSize,
                "Cylinders: " + ReadJSON.dCylinders,
                "Transmission: " + ReadJSON.dTransmission,
                "Fuel Type: " + ReadJSON.dFuelType,
                "Fuel Consumption in city (L/100 Km): " + ReadJSON.dFuelConCity,
                "Fuel Consumption in Highway (L/100 Km): " + ReadJSON.dFuelConHwy,
                "Fuel Consumption (L/100 Km): " + ReadJSON.dFuelConComb1,
                "Fuel Consumption (MPG): " + ReadJSON.dFuelConComb2,
                "CO2 Emission: " + ReadJSON.dEmm + " G/Km"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }

        });
    }
}
