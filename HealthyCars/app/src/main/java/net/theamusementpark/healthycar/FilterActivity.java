package net.theamusementpark.healthycar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Collection;

/*
 @author The Amusement Park
 @event CODE 2015
 @class FilterActivity
 @description This Activity contains the Filter Options
 */
public class FilterActivity extends Activity {

    Spinner makeSpinner, classSpinner, fuelTypeSpinner, transmissionSpinner;
    String makeStr, classStr, fuelTypeStr, transmissionStr;
    FilterObj fo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Filter </font>"));
        fo = new FilterObj();

        makeSpinner = (Spinner) findViewById(R.id.makeSpinner);
        Collection<String> makeVals = FilterObj.make.keySet();
        String[] makeArray = makeVals.toArray(new String[makeVals.size()]);
        ArrayAdapter<CharSequence> makeAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, makeArray);
        makeSpinner.setAdapter(makeAdapter);

        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        Collection<String> classVals = FilterObj.mClass.keySet();
        String[] classArray = classVals.toArray(new String[classVals.size()]);
        ArrayAdapter<CharSequence> classAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, classArray);
        classSpinner.setAdapter(classAdapter);

        fuelTypeSpinner = (Spinner) findViewById(R.id.fueltypeSpinner);
        Collection<String> fuelVals = FilterObj.fuel.keySet();
        String[] fuelArray = fuelVals.toArray(new String[fuelVals.size()]);
        ArrayAdapter<CharSequence> fuelAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, fuelArray);
        fuelTypeSpinner.setAdapter(fuelAdapter);

        transmissionSpinner = (Spinner) findViewById(R.id.transmissionSpinner);
        Collection<String> trsVals = FilterObj.transmission.keySet();
        String[] trsArray = trsVals.toArray(new String[trsVals.size()]);
        ArrayAdapter<CharSequence> trsAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, trsArray);
        transmissionSpinner.setAdapter(trsAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    public void openListAct(View view) {
        Intent intent = new Intent(this, ResultActivity.class);

        makeStr = fo.getMake(makeSpinner.getSelectedItem().toString());
        classStr = fo.getClass(classSpinner.getSelectedItem().toString());
        fuelTypeStr = fo.getFuel(fuelTypeSpinner.getSelectedItem().toString());
        transmissionStr = fo.getTransmission(transmissionSpinner.getSelectedItem().toString());

        ReadJSON.indexes = 0;
        ReadJSON.filterJSON(makeStr, classStr, fuelTypeStr, transmissionStr);
        startActivity(intent);
    }
}
