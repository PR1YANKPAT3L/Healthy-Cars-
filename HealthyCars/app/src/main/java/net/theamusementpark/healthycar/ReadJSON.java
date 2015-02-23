package net.theamusementpark.healthycar;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class ReadJSON
{
    // GLOBAL VARIABLES
    protected AssetManager manager;
    protected JSONObject object;
    public static JSONArray array;
    protected InputStream stream;
    protected String jsonData = null;
    public static String[] carStat;
    public static String[] carFind;
    public static ArrayList<String> modelArr, makeArr, yearArr;
    public static ArrayList<Integer> carsIndex;
    final protected String fileName = "cars.json";
    public static JSONObject carsObject;
    public static int indexes = 0;

    public static int idToDetail;

    private static String TAG_MODELYEAR = "modelYear";
    private static String TAG_MAKE = "make";
    private static String TAG_MODEL = "model";
    private static String TAG_VEHICLECLASS = "vehicleClass";
    private static String TAG_ENGINESIZE = "engineSize";
    private static String TAG_CYLINDERS = "cylinders";
    private static String TAG_TRANSMISSION = "transmission";
    private static String TAG_FUELTYPE = "fuelType";
    private static String TAG_FUELCONSUMPTIONCITY = "fuelConsumptionCity";
    private static String TAG_FUELCONSUMPTIONHWY = "fuelConsumptionHwy";
    private static String TAG_FUELCONSUMPTIONCOMB1 = "fuelConsumptionComb1";
    private static String TAG_FUELCONSUMPTIONCOMB2 = "fuelConsumptionComb2";
    private static String TAG_CO2EMISSION = "co2Emissions";

    public static String dModelYear, dMake, dModel, dVehicleClass, dEngineSize, dCylinders, dTransmission, dFuelType, dFuelConCity, dFuelConHwy, dFuelConComb1, dFuelConComb2, dEmm;

    /*
    @method ReadJSON
    @params Context myContext
    @return none
     */
    public ReadJSON(Context myContext)
    {
        this.manager = myContext.getAssets();
    }

    /*
    @method readFromAsset
    @params none
    @return String jsonData
     */
    private String readFromAsset()
    {
        // Use Try/Catch Block to Capture IOException
        try
        {
            // Open File Stream
            stream = manager.open(fileName);
            // Read the stream size
            int size = stream.available();

            // Contruct buffer
            byte[] buffer = new byte[size];

            // Read into buffer
            stream.read(buffer);

            // Close the stream
            stream.close();

            // Read the data
            jsonData = new String(buffer, "UTF-8");
        }
        catch (IOException ie)
        {
            ie.printStackTrace();
        }


        // return the string data
        return jsonData;
    }

    /*
    @method loadData
    @params none
    @return none
     */
    public void loadData()
    {
        // Use try/Catch block to catch JSONException
        try
        {
            // Crease new JSONObject
            object = new JSONObject(readFromAsset());

            // Construct JSONArray
            array = object.getJSONArray("cars");

            // Calculate the length of the array
            int size = array.length();

            // Construct new String varibles
            carStat = new String[array.length()];
            carFind = new String[array.length()];

            // Loop through each of the JSON Data-set
            for (int i = 0; i < array.length(); i++)
            {
                // Construct new Cars object
                Cars aCar = new Cars();

                // Get JSON Object
                carsObject = array.getJSONObject(i);

                // Read individual JSON names and assign it to the aCar object
                aCar.fuelType = carsObject.getString(TAG_FUELTYPE);
                aCar.modelYear = carsObject.getString(TAG_MODELYEAR);
                aCar.make = carsObject.getString(TAG_MAKE);
                aCar.model = carsObject.getString(TAG_MODEL);
                aCar.vehicleClass = carsObject.getString(TAG_VEHICLECLASS);
                aCar.engineSize = carsObject.getString(TAG_ENGINESIZE);
                aCar.cylinders = carsObject.getString(TAG_CYLINDERS);
                aCar.transmission = carsObject.getString(TAG_TRANSMISSION);
                aCar.fuelConsumptionCity = carsObject.getString(TAG_FUELCONSUMPTIONCITY);
                aCar.fuelConsumptionHwy = carsObject.getString(TAG_FUELCONSUMPTIONHWY);
                aCar.fuelConsumptionComb1 = carsObject.getString(TAG_FUELCONSUMPTIONCOMB1);
                aCar.fuelConsumptionComb2 = carsObject.getString(TAG_FUELCONSUMPTIONCOMB2);
                aCar.co2Emissions = carsObject.getString(TAG_CO2EMISSION);

                carStat[i] = aCar.toString();
                carFind[i] = aCar.toString2();

            }
        }
        catch (JSONException ex)
        {
            // Catch any JSONException
            ex.printStackTrace();
        }
    }

    /*
    @method filterJSON
    @params
    |-> String make
    |-> String vehicleClass
    |-> String fuelType
    |-> String transmission
    @return none
     */
    public static void filterJSON(String make, String vehicleClas, String fuelType, String tramsission) {
        // Use try/Catch block to capture JSONException
        try
        {
            // Construct 4 different ArrayLists for Listing the cars
            modelArr = new ArrayList<>();
            makeArr = new ArrayList<>();
            yearArr = new ArrayList<>();
            carsIndex = new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {
                carsObject = array.getJSONObject(i);
                if (carsObject.getString("make").contains(make) && carsObject.getString("vehicleClass").contains(vehicleClas) && carsObject.getString("fuelType").contains(fuelType) && carsObject.getString("transmission").contains(tramsission)) {

                    modelArr.add(carsObject.getString("model"));
                    makeArr.add(carsObject.getString(("make")));
                    yearArr.add(carsObject.getString("modelYear"));
                    carsIndex.add(i);

                    indexes++;
                }
            }
        }
        catch(JSONException ex)
        {
            ex.printStackTrace();
        }
    }

    /*
    @method loadData
    @params int id: id of the selected car from the listview
    @return none
     */
    public static void displayDetails(int id) {
        try
        {
            for (int i = 0; i < array.length(); i++) {
                carsObject = array.getJSONObject(i);
                if(i == id) {
                    dModelYear = carsObject.getString("modelYear");
                    dMake = carsObject.getString("make");
                    dModel = carsObject.getString("model");
                    dVehicleClass = carsObject.getString("vehicleClass");
                    dEngineSize = carsObject.getString("engineSize");
                    dCylinders = carsObject.getString("cylinders");
                    dTransmission = carsObject.getString("transmission");
                    dFuelType = carsObject.getString("fuelType");
                    dFuelConCity = carsObject.getString("fuelConsumptionCity");
                    dFuelConHwy = carsObject.getString("fuelConsumptionHwy");
                    dFuelConComb1 = carsObject.getString("fuelConsumptionComb1");
                    dFuelConComb2 = carsObject.getString("fuelConsumptionComb2");
                    dEmm = carsObject.getString("co2Emissions");
                }
            }
        }
        catch(JSONException ex)
        {
            ex.printStackTrace();
        }
    }
}