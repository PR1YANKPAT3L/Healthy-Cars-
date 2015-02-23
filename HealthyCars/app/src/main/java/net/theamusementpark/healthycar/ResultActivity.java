package net.theamusementpark.healthycar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class ResultActivity extends Activity {

    //String make1, make2, make3, make4, make5;
    //String model1, model2, model3, model4, model5;
    //int year1, year2, year3, year4, year5;

    protected int[] carzIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Filter Results</font>"));

        String[] make = new String[ReadJSON.indexes];

        String[] model = new String[ReadJSON.indexes];

        int[] year = new int[ReadJSON.indexes];
        carzIndex = new int[ReadJSON.indexes];

        for(int i = 0; i < ReadJSON.indexes;i++)
        {
            make[i] = ReadJSON.makeArr.get(i);
            model[i] = ReadJSON.modelArr.get(i);
            year[i] = Integer.parseInt(ReadJSON.yearArr.get(i));
            carzIndex[i] = ReadJSON.carsIndex.get(i);
        }

        ListView resultList = (ListView) findViewById(R.id.resultsList);
        TextView filterResultText = (TextView) findViewById(R.id.filterResultText);
        filterResultText.setText("Filter Results: " + ReadJSON.indexes + " Results Returned");
        ResultList adapter = new ResultList(ResultActivity.this, make, model, year);

        resultList.setAdapter(adapter);
        resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ResultActivity.this, DetailsActivity.class);
                ReadJSON.idToDetail = carzIndex[position];
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
