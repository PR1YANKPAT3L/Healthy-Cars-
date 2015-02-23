package net.theamusementpark.healthycar;

import java.util.HashMap;
import java.util.Map;

/*
 @author The Amusement Park
 @event CODE 2015
 @class FilterObj
 @description This class contains all the filter values
 */
public class FilterObj {

    // GLOBAL VARIABLES
    static public Map<String, String> transmission, fuel, mClass, make;

    /*
    @method FilterObj
    @params none
    @return none
     */
    public FilterObj() {

        // Define the Make of the Cars
        make = new HashMap<String, String>();
        make.put("Acura", "ACURA");
        make.put("Audi", "AUDI");
        make.put("BMW", "BMW");
        make.put("Buick", "BUICK");
        make.put("Cadillac", "CADILLAC");
        make.put("Chervolet", "CHERVOLET");
        make.put("Chrysler", "CHRYSLER");
        make.put("Deawoo", "DAEWOO");
        make.put("Dodge", "DODGE");
        make.put("Ford", "FORD");
        make.put("GMC", "GMC");
        make.put("Honda", "HONDA");
        make.put("Hyundai", "HYUNDAI");
        make.put("Infinity", "INFINITY");
        make.put("Isuzu", "ISUZU");
        make.put("Jaguar", "HAGUAR");
        make.put("Jeep", "JEEP");
        make.put("Kai", "KAI");
        make.put("Land Rover", "LAND ROVER");
        make.put("Lexus", "LEXUS");
        make.put("Lincoln", "LINCOLN");
        make.put("Mazda", "MAZDA");
        make.put("Mercedes - Benz", "MERCEDES-BENZ");
        make.put("Nissan", "NISSAN");
        make.put("Oldsmobile", "OLDSMOBILE");
        make.put("Pontiac", "PONTIAC");
        make.put("Saab", "SAAB");
        make.put("Saturn", "SATURN");
        make.put("Subaru", "SUBARU");
        make.put("Toyota", "TOYOTA");
        make.put("Suzuki", "SUZUKI");
        make.put("Volkswagen", "VOLKSWAGEN");
        make.put("Volvo", "VOLVO");

        // Define the class of the cars
        mClass = new HashMap<String, String>();
        mClass.put("Compact", "COMPACT");
        mClass.put("Mid-Size", "MID-SIZE");
        mClass.put("Subcompact", "SUBCOMPACT");
        mClass.put("Station Wagon - Mid-Size", "STATION WAGON - MID-SIZE");
        mClass.put("Minicompact", "MINICOMPACT");
        mClass.put("Two-Seater", "TWO-SEATER");
        mClass.put("Station Wagon - Small", "STATION WAGON - SMALL");
        mClass.put("Full-Size", "FULL-SIZE");
        mClass.put("SUV", "SUV");
        mClass.put("Van - Cargo", "VAN - CARGO");
        mClass.put("Van - Passenger", "VAN - PASSENGER");
        mClass.put("Pickup Truck - Standard", "PICKUP TRUCK - STANDARD");
        mClass.put("Pickup Truck - Small", "PICKUP TRUCK - SMALL");
        mClass.put("Minivan", "MINIVAN");
        mClass.put("Station Wagon - Small", "STATION WAGON - SMALL");
        mClass.put("Full-Size", "FULL-SIZE");

        // Define the Fuel Type of the cars
        fuel = new HashMap<String, String>();
        fuel.put("Regular Gasoline", "X");
        fuel.put("Premium Gasoline", "Z");
        fuel.put("Diesel", "D");
        fuel.put("Ethanol (E85)", "E");
        fuel.put("Natural Gas", "N");

        // Define the transmission of the cars
        transmission = new HashMap<String, String>();
        transmission.put("Automatic", "A");
        transmission.put("Manual", "M");
    }

    /*
    @method getTransmission
    @params String key
    @return String
     */
    public String getTransmission(String key) {
        return transmission.get(key);
    }

    /*
    @method getTransmission
    @params String key
    @return String
     */
    public String getFuel(String key) {
        return fuel.get(key);
    }

    /*
    @method getTransmission
    @params String key
    @return String
     */
    public String getClass(String key) {
        return mClass.get(key);
    }

    /*
    @method getTransmission
    @params String key
    @return String
     */
    public String getMake(String key) {
        return make.get(key);
    }
}
