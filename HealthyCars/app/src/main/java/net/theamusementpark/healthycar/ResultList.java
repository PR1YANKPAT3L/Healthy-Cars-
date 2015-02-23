package net.theamusementpark.healthycar;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by SiL3NTK0D3R on 2/21/2015.
 */
public class ResultList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] make;
    private final String[] model;
    private final int[] year;

    public ResultList(Activity context, String[] make, String[] model, int[] year) {
        super(context, R.layout.list_row, make);

        this.context = context;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_row, null, true);

        TextView makeLbl = (TextView) rowView.findViewById(R.id.makeText);

        makeLbl.setText(make[pos] + ", " + model[pos] + ", " + year[pos]);

        return rowView;
    }
}
